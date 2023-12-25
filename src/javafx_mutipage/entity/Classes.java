package javafx_mutipage.entity;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx_mutipage.Main;
import javafx_mutipage.controllers.classes.DeleteController;
import javafx_mutipage.controllers.classes.EditController;

public class Classes {
    private Integer id;
    private String className;
    private String room;

    private Button editBtn;
    private Button deleteBtn;

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public Button getEditBtn() {
        return editBtn;
    }

    public void setEditBtn(Button editBtn) {
        this.editBtn = editBtn;
    }

    public Classes(Integer id, String className, String room) {
        this.id = id;
        this.className = className;
        this.room = room;

        this.editBtn = new Button("Edit");
        this.editBtn.setOnAction(event -> {
            try {
                EditController.editClasses = this;
                Parent root = FXMLLoader.load(getClass().getResource("../fxml/classes/createClass/editClass.fxml"));
                Main.rootStage.setScene(new Scene(root,800,600));
            }catch (Exception e){

            }

        });

        this.deleteBtn = new Button("Delete");
        this.deleteBtn.setOnAction(event -> {
            try{
                DeleteController.deleteClass = this;
                Parent root = FXMLLoader.load(getClass().getResource("../fxml/classes/createClass/deleteClass.fxml"));
                Stage s = new Stage();
                s.setScene(new Scene(root,400,200));
                s.setTitle("DELETE");
                s.show();
            }catch (Exception e){

            }

        });
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String name) {
        this.className = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return getClassName();
    }
}