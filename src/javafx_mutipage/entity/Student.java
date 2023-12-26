package javafx_mutipage.entity;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx_mutipage.Main;
import javafx_mutipage.controllers.student.DeleteController;
import javafx_mutipage.controllers.student.EditController;

import java.time.LocalDate;

public class Student {
    private Integer id;
    private String fullName;
    private String email;
    private String telephone;
    private String address;
    private LocalDate dob;
    private Integer class_id;
    private Button btnEdit;

    private Button btnDelete;

    public Button getBtnDelete() {
        return btnDelete;
    }

    public Button getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(Button btnEdit) {
        this.btnEdit = btnEdit;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public Student(Integer id, String fullName, String email, String telephone, String address, LocalDate dob, Integer class_id) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.dob = dob;
        this.class_id = class_id;

        this.btnEdit = new Button("Edit");
        this.btnEdit.setOnAction(event -> {
            try{

                EditController.editStudent = this;
                Parent root = FXMLLoader.load(getClass().getResource("../fxml/student/addnewstudent/editStudent.fxml"));
                Main.rootStage.setScene(new Scene(root,800,600));
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        this.btnDelete = new Button("Delete");
        this.btnDelete.setOnAction(event -> {
            try{
                DeleteController.deleteStudent = this;
                Parent root = FXMLLoader.load(getClass().getResource("../fxml/student/addnewstudent/deleteStudent.fxml"));
                Stage s = new Stage();
                s.setScene(new Scene(root,400,200));
                s.setTitle("DELETE");
                s.show();
            }catch (Exception e){

            }

        });
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String toString(){
        return fullName+"\n"+email+"\n"+telephone+"\n"+address
                +"\n"+dob;
    }
}
