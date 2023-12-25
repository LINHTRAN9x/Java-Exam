package javafx_mutipage.controllers.student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx_mutipage.Main;
import javafx_mutipage.dao.StudentDAO;
import javafx_mutipage.database.Connector;
import javafx_mutipage.entity.Classes;
import javafx_mutipage.entity.Student;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DeleteController implements Initializable {

    public Button btnYes;
    public Button btnNo;
    public Text txtN;

    public static Student deleteStudent;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
            btnYes.setOnAction(event -> handleDelete());
            btnNo.setOnAction(event -> {
                try {
                    closeWindow();
                } catch (Exception e) {

                }
            });


            txtN.setText(deleteStudent.getFullName());
    }
    private void handleDelete() {
        try {
            StudentDAO sd = new StudentDAO();
            sd.delete(deleteStudent.getId());

            closeWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void closeWindow() throws Exception {
            Parent root = FXMLLoader.load(getClass()
                    .getResource("../../fxml/student/list.fxml"));
            Main.rootStage.setScene(new Scene(root, 800, 600));
    }
}
