package movieTickets.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import movieTickets.entity.MovieSeats;
import movieTickets.dao.MoviesDAO;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    public TableView<MovieSeats> tbView;
    public TableColumn<MovieSeats,String> tcMovie;
    public TableColumn<MovieSeats,String> tcGenre;
    public TableColumn<MovieSeats, LocalDate> tcRd;
    public TableColumn<MovieSeats,Integer> tcDuration;

    public TableColumn<MovieSeats, Button> tcBuy;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcMovie.setCellValueFactory(new PropertyValueFactory<MovieSeats,String>("movieTitle"));
        tcGenre.setCellValueFactory(new PropertyValueFactory<MovieSeats,String>("genre"));
        tcRd.setCellValueFactory(new PropertyValueFactory<MovieSeats,LocalDate>("rd"));
        tcDuration.setCellValueFactory(new PropertyValueFactory<MovieSeats,Integer>("duration"));
        tcBuy.setCellValueFactory(new PropertyValueFactory<MovieSeats,Button>("btnBuy"));

        ObservableList<MovieSeats> om = FXCollections.observableArrayList();
        //

        try {
            MoviesDAO sd = new MoviesDAO();
            om.addAll(sd.list());

        }catch (Exception e){
            e.getMessage();
        }finally {
            tbView.setItems(om);
        }



    }
}
