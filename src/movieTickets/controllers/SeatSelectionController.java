package movieTickets.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import movieTickets.Main;
import movieTickets.entity.Movies;
import movieTickets.entity.ShowTime;
import movieTickets.database.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class SeatSelectionController {

    public TableView<ShowTime> tbView;
    public TableColumn<ShowTime,LocalDateTime> tcSTime;
    public TableColumn<ShowTime,LocalDateTime> tcETime;
    public TextField txtSt;
    public TextField txtEt;
    public TextArea seatPosition;
    public Text txtMovieName;
    public ImageView imgView;
    @FXML
    private GridPane gridPane;
    private List<Integer> selectedSeats = new ArrayList<>();

    public static Movies dataMovie;

    private boolean[] seatStatus = new boolean[56];

    @FXML
    private void initialize() {
        // Khởi tạo sơ đồ ghế khi tải FXML
//        initSeatGrid();
        Movies selectedMovie = dataMovie;

        if (selectedMovie != null) {
            ObservableList<ShowTime> ob = FXCollections.observableArrayList(selectedMovie.getShowTimes());
            tcSTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
            tcETime.setCellValueFactory(new PropertyValueFactory<>("endTime"));
            tbView.setItems(ob);

            tbView.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1) {
                    ShowTime selectedShowTime = tbView.getSelectionModel().getSelectedItem();
                    if (selectedShowTime != null) {
                        initSeatGrid(selectedShowTime);
                        LocalDateTime showStartTime = selectedShowTime.getStartTime();
                        LocalDateTime showEndTime = selectedShowTime.getEndTime();
                        //
                        txtSt.setText(String.valueOf(LocalDateTime.parse(showStartTime.toString())));
                        txtEt.setText(String.valueOf(LocalDateTime.parse(showEndTime.toString())));
                        txtMovieName.setText(dataMovie.getMovieTitle());
//                        setImageToImageView(dataMovie.getImagePath());
                        imgView.setImage(new Image("file:" + dataMovie.getImagePath()));

                    }
                }
            });
        }



    }

//    private void setImageToImageView(String imagePath) {
//        System.out.println(imagePath);
//        try {
//            Image image = new Image("file:"+ imagePath);
//            System.out.println(image);
//            imgView.setImage(image);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Handle the exception (e.g., log it, show an error message)
//        }
//    }


    private void initSeatGrid(ShowTime showtimeId) {
        gridPane.getChildren().clear();
        Connector connection = Connector.get_Instance();
        String sql = "SELECT seat_number, availability_status FROM seats WHERE theater_id = 1 AND showtime_id = ?";
        try {
            PreparedStatement preparedStatement = connection.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, showtimeId.getShowtimeId());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int seatNumber = resultSet.getInt("seat_number");
                int status = resultSet.getInt("availability_status");
                // Tính toán dòng và cột dựa trên số ghế
                int row = (seatNumber - 1) / 10;  // 10 cột
                int col = (seatNumber - 1) % 10;

                Button button = new Button("" + seatNumber);
                button.setMinSize(35, 35);
                button.setId(String.valueOf(seatNumber));

                if (status == 0) {
                    seatStatus[seatNumber] = true;
                    button.setStyle("-fx-background-color: #D73F0F; -fx-text-fill: #fff;-fx-font-weight: 700 ");
                } else {
                    button.setStyle("-fx-background-color: #D9D9D9; -fx-font-weight: 600");
                }
                button.setOnAction(event -> handleSeatSelection(button, seatNumber,showtimeId));

                gridPane.add(button, col, row);
            }
        } catch (SQLException e) {
            showAlert(e.getMessage());
        }
    }


    private void handleSeatSelection(Button seatButton, int seatNumber,ShowTime showTimeId) {
        if (!seatStatus[seatNumber]) {
            if (!selectedSeats.contains(seatNumber)) {
                // Chọn ghế mới
                seatPosition.setText(seatPosition.getText() + seatNumber + ", ");
                selectedSeats.add(seatNumber);
                seatButton.setStyle("-fx-background-color: #D73F0F; -fx-font-weight: 700;-fx-text-fill: #fff");
                updateSeatStatusInDatabase(seatNumber, 0, showTimeId.getShowtimeId());
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("seat a ready booked!");
                alert.show();
            }
//            else {
//                // Hủy chọn ghế
//                selectedSeats.remove(Integer.valueOf(seatNumber));
//                seatButton.setStyle("-fx-background-color: #D9D9D9;");
//                updateSeatStatusInDatabase(seatNumber, 1, showTimeId.getShowtimeId());
//            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("seat a ready booked!");
            alert.show();
        }



    }
    private void updateSeatStatusInDatabase(int seatNumber, int status,int showTimeId) {
        Connector connection = Connector.get_Instance();
        String updateQuery = "UPDATE seats SET availability_status = ? WHERE seat_number = ? and showtime_id = ?";
        try {
            PreparedStatement preparedStatement = connection.getConn().prepareStatement(updateQuery);
            preparedStatement.setInt(1, status);
            preparedStatement.setInt(2, seatNumber);
            preparedStatement.setInt(3,showTimeId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(message);
        alert.show();
    }

    public void backHome(ActionEvent actionEvent) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("../fxml/home.fxml"));
        Main.rootStage.setScene(new Scene(root,1280,832));
    }



}
