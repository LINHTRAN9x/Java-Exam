package javafx_mutipage.controllers.student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx_mutipage.Main;
import javafx_mutipage.dao.ClassDAO;
import javafx_mutipage.dao.StudentDAO;
import javafx_mutipage.database.Connector;
import javafx_mutipage.entity.Classes;
import javafx_mutipage.entity.Student;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EditController implements Initializable {
    public TextArea ipAddress;
    public TextField ipTelephone;
    public DatePicker ipDob;
    public TextField ipEmail;
    public TextField ipFullName;
    public ComboBox<Classes> ipClass;

    public static Student editStudent;
    // Các trường và phương thức khác
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Classes> ls = FXCollections.observableArrayList();
        String sql = "select * from classes";
        try{
            ClassDAO cd = new ClassDAO();
            ls.addAll(cd.list());

            // set edit data to form
            ipFullName.setText(editStudent.getFullName());
            ipEmail.setText(editStudent.getEmail());
            ipTelephone.setText(editStudent.getTelephone());
            ipAddress.setText(editStudent.getAddress());
            ipDob.setValue(editStudent.getDob());
            ipClass.setItems(ls);

        }catch (Exception e){
            showAlert(e.getMessage());
        }finally {
            ipClass.setItems(ls);
        }

    }
    public void saveStudent(ActionEvent actionEvent) throws Exception {

        // Lấy dữ liệu từ giao diện người dùng
        try{
            int id = editStudent.getId();
            String fullName = ipFullName.getText();
            String email = ipEmail.getText();
            String telephone = ipTelephone.getText();
            String address = ipAddress.getText();
            LocalDate dob = ipDob.getValue();
            Classes cl = ipClass.getSelectionModel().getSelectedItem();

            StudentDAO sd = new StudentDAO();
            sd.update(new Student(id,fullName,email,telephone,address,dob,cl.getId()));
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

