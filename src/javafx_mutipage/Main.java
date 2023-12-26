package javafx_mutipage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx_mutipage.database.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Main extends Application {

    public static Stage rootStage;

    public static void main(String[] args) throws SQLException {

        //test query database:
//        String sql = "select * from students";
//        Connector connect = new Connector();
//        try {
//            ResultSet rs = connect.getConn().createStatement().executeQuery(sql);
//            while (rs.next()){
//                int id = rs.getInt("id");
//                String name = rs.getString("fullname");
//                System.out.println(id+"-"+name);
//            }
//        }catch (Exception e){}

        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        rootStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("fxml/home.fxml"));
        primaryStage.setScene(new Scene(root,800,600));
        primaryStage.setTitle("JavaFX MutiPage");
        primaryStage.show();
    }
}