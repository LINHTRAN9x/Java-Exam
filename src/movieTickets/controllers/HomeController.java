package movieTickets.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import movieTickets.entity.Movies;
import movieTickets.dao.SeatsDAO;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    public TableView<Movies> tbView;
    public TableColumn<Movies,String> tcMovie;
    public TableColumn<Movies,String> tcGenre;
    public TableColumn<Movies, LocalDate> tcRd;
    public TableColumn<Movies,Integer> tcDuration;

    public TableColumn<Movies, Button> tcBuy;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcMovie.setCellValueFactory(new PropertyValueFactory<Movies,String>("movieTitle"));
        tcGenre.setCellValueFactory(new PropertyValueFactory<Movies,String>("genre"));
        tcRd.setCellValueFactory(new PropertyValueFactory<Movies,LocalDate>("rd"));
        tcDuration.setCellValueFactory(new PropertyValueFactory<Movies,Integer>("duration"));
        tcBuy.setCellValueFactory(new PropertyValueFactory<Movies,Button>("btnBuy"));

        ObservableList<Movies> om = FXCollections.observableArrayList();
        //

        try {
            SeatsDAO sd = new SeatsDAO();
            om.addAll(sd.list());

        }catch (Exception e){
            e.getMessage();
        }finally {
            tbView.setItems(om);
        }



    }
}
