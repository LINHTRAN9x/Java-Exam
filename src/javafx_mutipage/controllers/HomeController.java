package javafx_mutipage.controllers;

import javafx.StudentData;
import javafx.scene.control.TableColumn;
import javafx_mutipage.entity.Student;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx_mutipage.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx_mutipage.database.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class HomeController {
    public TextField ipFullName;
    public TextField ipEmail;
    public TextArea ipAddress;
    public TextField ipTelephone;
    public DatePicker ipDob;
    public TableColumn textStudentList;
    private ArrayList<Student> studentList;
    private Student studentData;

    public void initialize() {
        studentList = new ArrayList<>();

        studentData = new Student(0,"", "", "", "", LocalDate.now(),null);
    }

    public void goToStudent(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass()
                .getResource("../fxml/student/list.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
//        Stage s = new Stage();
//        s.setScene(new Scene(root,600,400));
//        s.show();
    }

    public void goToClasses(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass()
                .getResource("../fxml/classes/listClass.fxml"));
        Main.rootStage.setScene(new Scene(root, 800, 600));
    }




//    public void submit(ActionEvent actionEvent) {
////        if (!isValidInput()) {
////            return;
////        }
//
//        Student newStudentData = new Student(
//                studentData.getId(),
//                ipFullName.getText(),
//                ipEmail.getText(),
//                ipTelephone.getText(),
//                ipAddress.getText(),
//                ipDob.getValue(),
//
//        );
//
//        // Thêm đối tượng StudentData mới vào danh sách
//        studentList.add(newStudentData);
//
//        // Hiển thị danh sách sinh viên
//        displayStudentList();
//
//    }


    private void displayStudentList() {
        StringBuilder sb = new StringBuilder();
        for (Student student : studentList) {
            sb.append("Full Name: ").append(student.getFullName()).append("\n");
            sb.append("Email: ").append(student.getEmail()).append("\n");
            sb.append("Telephone: ").append(student.getTelephone()).append("\n");
            sb.append("Address: ").append(student.getAddress()).append("\n");
            sb.append("Date of Birth: ").append(student.getDob()).append("\n");
            sb.append("------------------------\n");
        }

        textStudentList.setText(sb.toString());
    }



}
