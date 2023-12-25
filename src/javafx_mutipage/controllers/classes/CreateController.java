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
import java.util.ResourceBundle;

public class CreateController {
    public TextField ipClassName;
    public TextField ipRoom;




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
            cd.create(new Classes(null,name,room));
            gotoClasses(null);
        }catch (Exception e){
            e.getMessage();
        }
    }
}
