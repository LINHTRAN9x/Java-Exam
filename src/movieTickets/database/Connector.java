package movieTickets.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static Connection conn;

    private static Connector _instance; //Singleton pattern

    private Connector() {
        //tao ket noi voi database.
        String host = "jdbc:mysql://localhost:3306/movies_booking";
        String user = "root";
        String pwd = "root";

        try{
            Class.forName("com.mysql.jdbc.Driver"); //driver ket noi
            this.conn = DriverManager.getConnection(host,user,pwd);
        }catch (SQLException e){
            System.out.println(e.getErrorCode());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Connector get_Instance() {
        if (_instance == null){
            _instance = new Connector();
        }
        return _instance;
    }

    public Connection getConn() {
        return conn;
    }
}
