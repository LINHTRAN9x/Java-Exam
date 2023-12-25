package movieTickets.dao;

import movieTickets.database.Connector;
import movieTickets.entity.Movies;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class SeatsDAO implements DAOInterface<Movies> {

    @Override
    public ArrayList<Movies> list() {
        ArrayList<Movies> ls = new ArrayList<>();
        String sql = "select * from movies";
        try {
            Connector connect = Connector.get_Instance();
            ResultSet rs = connect.getConn().createStatement().executeQuery(sql);
            while (rs.next()) {
               ls.add(new Movies(rs.getInt("movie_id"),rs.getString("title"),rs.getString("Genre"),LocalDate.parse(rs.getString("release_date")),
                       rs.getInt("duration"),rs.getString("image_path")));
            }
        }catch (Exception e) {
            e.getMessage();
        }

        return ls;
    }



    @Override
    public boolean create(Movies movies) {
        return false;
    }

    @Override
    public boolean update(Movies movies) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Movies findOne(int id) {
        return null;
    }
}
