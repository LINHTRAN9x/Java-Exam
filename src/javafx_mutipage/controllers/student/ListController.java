package javafx_mutipage.controllers.student;

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
import javafx_mutipage.dao.StudentDAO;
import javafx_mutipage.database.Connector;
import javafx_mutipage.entity.Classes;
import javafx_mutipage.entity.Student;
import javafx_mutipage.enums.DAOType;
import javafx_mutipage.factory.DAOFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

public class ListController implements Initializable {
    public TableView<Student> tbView;
    public TableColumn<Student,String> tcName;
    public TableColumn<Student,String> tcEmail;
    public TableColumn<Student,String> tcTel;
    public TableColumn<Student,String> tcAddress;
    public TableColumn<Student, LocalDate> tcDob;
    public TableColumn<Student, Button> tcEdit;
    public TableColumn<Student, Button> tcDelete;
    public TextField txtSearch;


    public void addNewStudent(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass()
                .getResource("../../fxml/student/addnewstudent/addNewStudent.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcName.setCellValueFactory(new PropertyValueFactory<Student,String>("fullName"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
        tcTel.setCellValueFactory(new PropertyValueFactory<Student,String>("telephone"));
        tcAddress.setCellValueFactory(new PropertyValueFactory<Student,String>("address"));
        tcDob.setCellValueFactory(new PropertyValueFactory<Student,LocalDate>("dob"));
        tcEdit.setCellValueFactory(new PropertyValueFactory<Student,Button>("btnEdit"));
        tcDelete.setCellValueFactory(new PropertyValueFactory<Student,Button>("btnDelete"));

        //get data from database:

        ObservableList<Student> ls = FXCollections.observableArrayList();
        try {
            StudentDAO sd = (StudentDAO) DAOFactory.getDaoInstance(DAOType.STUDENT); //Factory design pattern.
//            ArrayList<Student> listSV = sd.list();
            ls.addAll(sd.list());


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
        ObservableList<Student> ls = FXCollections.observableArrayList();
        try{
            int txt = Integer.parseInt(txtSearch.getText());
            StudentDAO cd = new StudentDAO();
            ls.addAll(cd.findOne(txt));
        }catch (Exception e){
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Khong tim thay student!");
            al.show();
        }finally {
            tbView.setItems(ls);
        }
    }
}
