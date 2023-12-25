package javafx_mutipage.dao;

import javafx_mutipage.database.Connector;
import javafx_mutipage.entity.Classes;
import javafx_mutipage.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class StudentDAO implements DAOInterface<Student>{
    @Override
    public ArrayList<Student> list() {
        String sql = "select * from students";
        ArrayList<Student> ls = new ArrayList<>();
        try{
            Connector connect = Connector.getInstance();
            ResultSet rs = connect.getConn().createStatement().executeQuery(sql);
            while (rs.next()){
                ls.add(new Student(rs.getInt("id"),rs.getString("fullname"),rs.getString("email"),
                        rs.getString("telephone"),rs.getString("address"), LocalDate.parse(rs.getString("dob")),rs.getInt("class_id")));
            }
        }catch (Exception e){
            e.getMessage();
        }
        return ls;
    }

    @Override
    public boolean create(Student s) {
        try {
            String sql = "INSERT INTO students (fullName, email, telephone, address, dob,class_id) values(?,?,?,?,?,?)";
            Connector conn = Connector.getInstance();
            PreparedStatement pstm = conn.getConn().prepareStatement(sql);
            pstm.setString(1,s.getFullName());
            pstm.setString(2,s.getEmail());
            pstm.setString(3,s.getTelephone());
            pstm.setString(4,s.getAddress());
            pstm.setString(5,s.getDob().toString());
            pstm.setInt(6,s.getClass_id());
            pstm.execute();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Student s) {
        String sql = "update students set fullname = ?, email = ?,telephone=?,address=?,dob=?,class_id=? where id=?";
        try{
            Connector connect = Connector.getInstance();
            PreparedStatement pstm = connect.getConn().prepareStatement(sql);
            pstm.setString(1,s.getFullName());
            pstm.setString(2,s.getEmail());
            pstm.setString(3,s.getTelephone());
            pstm.setString(4,s.getAddress());
            pstm.setString(5,s.getDob().toString());
            pstm.setInt(6,s.getClass_id());
            pstm.setInt(7,s.getId());
            pstm.execute();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try{
            Connector connect = Connector.getInstance();
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement preparedStatement = connect.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Student findOne(int id) {
        Student result = null;
        String sql = "SELECT * FROM students WHERE id=?";
        try {
            Connector connect = Connector.getInstance();
            PreparedStatement preparedStatement = connect.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                // Tạo đối tượng Classes từ kết quả truy vấn
                result = new Student(rs.getInt("id"),rs.getString("fullname"),rs.getString("email"),
                        rs.getString("telephone"),rs.getString("address"), LocalDate.parse(rs.getString("dob")),rs.getInt("class_id"));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Hoặc xử lý ngoại lệ một cách thích hợp cho ứng dụng của bạn
        }
        return result;
    }


}
