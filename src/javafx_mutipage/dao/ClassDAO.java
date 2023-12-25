package javafx_mutipage.dao;

import javafx_mutipage.database.Connector;
import javafx_mutipage.entity.Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClassDAO implements DAOInterface<Classes> {
    @Override
    public ArrayList<Classes> list() {
        String sql = "select * from classes";
        ArrayList<Classes> cs = new ArrayList<>();
        try {
            Connector connect = Connector.getInstance();
            ResultSet rs = connect.getConn().createStatement().executeQuery(sql);
            while (rs.next()) {
                cs.add(new Classes(rs.getInt("id"), rs.getString("name"), rs.getString("room")));
            }
        } catch (Exception e) {

        }
        return cs;
    }

    @Override
    public boolean create(Classes classes) {
        String sql = "insert into classes(name,room) values(?,?)";
        try {
            Connector connect = Connector.getInstance();
            PreparedStatement pstm = connect.getConn().prepareStatement(sql);
            pstm.setString(1, classes.getClassName());
            pstm.setString(2, classes.getRoom());
            pstm.execute();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Classes classes) {
        String sql = "UPDATE classes set name=?,room=? where id=?";
        try {
            Connector connect = Connector.getInstance();
            PreparedStatement pstm = connect.getConn().prepareStatement(sql);
            pstm.setString(1, classes.getClassName());
            pstm.setString(2, classes.getRoom());
            pstm.setInt(3, classes.getId());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connector connect = Connector.getInstance();
            String sql = "DELETE FROM classes WHERE id = ?";
            PreparedStatement preparedStatement = connect.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Classes findOne(int id) {
        Classes result = null;
        String sql = "SELECT * FROM classes WHERE id=?";
        try {
            Connector connect = Connector.getInstance();
            PreparedStatement preparedStatement = connect.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String className = resultSet.getString("name");
                String room = resultSet.getString("room");


                // Tạo đối tượng Classes từ kết quả truy vấn
                result = new Classes(null, className, room);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Hoặc xử lý ngoại lệ một cách thích hợp cho ứng dụng của bạn
        }
        return result;
    }
}
