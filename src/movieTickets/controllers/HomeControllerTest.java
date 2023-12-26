package movieTickets.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import movieTickets.dao.MoviesDAO;
import movieTickets.entity.MovieSeats;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeControllerTest implements Initializable {

    public Text title;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<MovieSeats> ls = FXCollections.observableArrayList();
        try{
            MoviesDAO md = new MoviesDAO();
            ls.addAll(md.list());

        }catch (Exception e){
            e.getMessage();
        }
    }
}
