package javafx_mutipage.controllers.student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx_mutipage.dao.StudentDAO;
import javafx_mutipage.entity.Student;
import javafx_mutipage.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx_mutipage.database.Connector;
import javafx_mutipage.entity.Classes;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateController implements Initializable {
    public TextArea ipAddress;
    public TextField ipTelephone;
    public DatePicker ipDob;
    public TextField ipEmail;
    public TextField ipFullName;
    public ComboBox<Classes> ipClass;


    // Các trường và phương thức khác
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Classes> ls = FXCollections.observableArrayList();
        String sql = "select * from classes";
        try{
            Connector connect = Connector.getInstance();
            ResultSet rs = connect.getConn().createStatement().executeQuery(sql);
            while (rs.next()){
                ls.add(new Classes(rs.getInt("id"),rs.getString("name"),rs.getString("room")));
            }
        }catch (Exception e){
            showAlert(e.getMessage());
        }finally {
            ipClass.setItems(ls);
        }

    }
    public void saveStudent(ActionEvent actionEvent) throws Exception {

        // Lấy dữ liệu từ giao diện người dùng
        try{
            String fullName = ipFullName.getText();
            String email = ipEmail.getText();
            String telephone = ipTelephone.getText();
            String address = ipAddress.getText();
            LocalDate dob = ipDob.getValue();
            Classes cl = ipClass.getSelectionModel().getSelectedItem();

            StudentDAO sd = new StudentDAO();
            sd.create(new Student(null,fullName,email,telephone,address,dob,cl.getId()));
            goToStudent(null);
        }catch (Exception e){
            showAlert(e.getMessage());
        }



        // Tạo đối tượng Student mới


    }




    public void goToStudent(ActionEvent actionEvent) throws Exception{
        Parent root = FXMLLoader.load(getClass()
                .getResource("../../fxml/student/list.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }

    private void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(message);
        alert.show();
    }

}

