package javafx_mutipage.controllers.classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx_mutipage.Main;
import javafx_mutipage.dao.ClassDAO;
import javafx_mutipage.database.Connector;
import javafx_mutipage.entity.Classes;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class EditController implements Initializable {
    public TextField ipClassName;
    public TextField ipRoom;

    public static Classes editClasses;


    public void gotoClasses(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../fxml/classes/listClass.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }

    public void submit(ActionEvent actionEvent) {
        ObservableList<Classes> ls = FXCollections.observableArrayList();
        try{
            String name = ipClassName.getText();
            String room = ipRoom.getText();

            ClassDAO cd = new ClassDAO();
            cd.update(new Classes(editClasses.getId(),name,room));
            gotoClasses(null);
        }catch (Exception e){
            e.getMessage();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Classes> ls = FXCollections.observableArrayList();

        try {
            ClassDAO cd = new ClassDAO();
            ls.addAll(cd.list());

            ///
            ipClassName.setText(editClasses.getClassName());
            ipRoom.setText(editClasses.getRoom());

        }catch (Exception e){

        }
    }
}
