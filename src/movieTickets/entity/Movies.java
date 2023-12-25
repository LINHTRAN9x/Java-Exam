package movieTickets.entity;

import java.sql.PreparedStatement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import movieTickets.Main;
import movieTickets.controllers.SeatSelectionController;
import movieTickets.database.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Movies {
    private int movieId;
    private String movieTitle;
    private String genre;
    private LocalDate rd;
    private int duration;

    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    private Button btnBuy;
    private List<ShowTime> showTimes;

    public List<ShowTime> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(List<ShowTime> showTimes) {
        this.showTimes = showTimes;
    }

    public Button getBtnBuy() {
        return btnBuy;
    }

    public void setBtnBuy(Button btnBuy) {
        this.btnBuy = btnBuy;
    }

    public Movies(int movieId, String movieTitle, String genre, LocalDate rd, int duration,String imagePath) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.genre = genre;
        this.rd = rd;
        this.duration = duration;
        this.imagePath = imagePath;
        this.showTimes = new ArrayList<>();


        this.btnBuy = new Button("Buy ticket");
        this.btnBuy.setOnAction(event -> {
            try{
                SeatSelectionController.dataMovie = this;
                this.showTimes = loadShowTimesFromDatabase(this.movieId);
                Parent root = FXMLLoader.load(getClass().getResource("../fxml/seatSelection.fxml"));
                Main.rootStage.setScene(new Scene(root,1280,832));
            }catch (Exception e){
                e.printStackTrace();
            }finally {

            }
        });
    }

    public List<ShowTime> loadShowTimesFromDatabase(int movieId) {
        List<ShowTime> showTimes = new ArrayList<>();

        String sql = "SELECT * FROM showtimes WHERE movie_id = ?";
        try {
            Connector connect = Connector.get_Instance();
            PreparedStatement preparedStatement = connect.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, movieId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int showtimeId = resultSet.getInt("showtime_id");
                int theaterId = resultSet.getInt("theater_id");
                LocalDateTime startTime = resultSet.getTimestamp("start_time").toLocalDateTime();
                LocalDateTime endTime = resultSet.getTimestamp("end_time").toLocalDateTime();

                ShowTime showTime = new ShowTime(showtimeId,startTime, endTime);
                showTimes.add(showTime);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return showTimes;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getRd() {
        return rd;
    }

    public void setRd(LocalDate rd) {
        this.rd = rd;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
