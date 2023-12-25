package javafx_mutipage.controllers.classes;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx_mutipage.Main;
import javafx_mutipage.dao.ClassDAO;
import javafx_mutipage.entity.Classes;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteController implements Initializable {

    public Button btnYes;
    public Button btnNo;
    public Text txtN;

    public static Classes deleteClass;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
            btnYes.setOnAction(event -> handleDelete());
            btnNo.setOnAction(event -> {
                try {
                    closeWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });


            txtN.setText(deleteClass.getClassName());
    }
    private void handleDelete() {
        try {
            ClassDAO sd = new ClassDAO();
            sd.delete(deleteClass.getId());

            closeWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void closeWindow() throws Exception {
            Parent root = FXMLLoader.load(getClass()
                    .getResource("../../fxml/classes/listClass.fxml"));
            Main.rootStage.setScene(new Scene(root, 800, 600));
    }
}
