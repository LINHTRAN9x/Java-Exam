package movieTickets;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {
    public static Stage rootStage;

    public static void main(String[] args) throws SQLException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        rootStage = primaryStage;
        Parent root  = FXMLLoader.load(getClass().getResource("fxml/home.fxml"));
        primaryStage.setScene(new Scene(root,1280,832));
        primaryStage.setTitle("Movies");
        primaryStage.show();
    }
}
