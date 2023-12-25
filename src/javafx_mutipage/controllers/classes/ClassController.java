package javafx_mutipage.controllers.classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx_mutipage.Main;
import javafx_mutipage.dao.ClassDAO;
import javafx_mutipage.database.Connector;
import javafx_mutipage.entity.Classes;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ClassController implements Initializable {

    public TableView<Classes> tbView;
    public TableColumn<Classes,String> tcName;
    public TableColumn<Classes,String> tcRoom;
    public TableColumn<Classes, Button> tcEdit;
    public TableColumn<Classes,Button> tcDelete;
    public TextField txtSearch;

    public void addNewClass(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../fxml/classes/createClass/createClass.fxml"));
        Main.rootStage.setScene(new Scene(root,800,600));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcName.setCellValueFactory(new PropertyValueFactory<Classes,String>("className"));
        tcRoom.setCellValueFactory(new PropertyValueFactory<Classes,String>("room"));
        tcEdit.setCellValueFactory(new PropertyValueFactory<Classes,Button>("editBtn"));
        tcDelete.setCellValueFactory(new PropertyValueFactory<Classes,Button>("deleteBtn"));

        ObservableList<Classes> ls = FXCollections.observableArrayList();
        try{
            ClassDAO cs = new ClassDAO();
            ls.addAll(cs.list());

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }finally {
            tbView.setItems(ls);
        }
    }

    public void backToHome(ActionEvent actionEvent) throws Exception {
            Parent root = FXMLLoader.load(getClass()
                    .getResource("../../fxml/home.fxml"));
            Main.rootStage.setScene(new Scene(root, 800, 600));
    }

    public void btnSearch(ActionEvent actionEvent) {
        ObservableList<Classes> ls = FXCollections.observableArrayList();
        try{
            int txt = Integer.parseInt(txtSearch.getText());
            ClassDAO cd = new ClassDAO();
            ls.addAll(cd.findOne(txt));
        }catch (Exception e){
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Khong tim thay class!");
            al.show();
        }finally {
            tbView.setItems(ls);
        }

    }
}
