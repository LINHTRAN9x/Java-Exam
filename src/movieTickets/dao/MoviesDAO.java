package movieTickets.dao;

import movieTickets.database.Connector;
import movieTickets.entity.MovieSeats;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class MoviesDAO implements DAOInterface<MovieSeats> {

    @Override
    public ArrayList<MovieSeats> list() {
        ArrayList<MovieSeats> ls = new ArrayList<>();
        String sql = "select * from movies";
        try {
            Connector connect = Connector.get_Instance();
            ResultSet rs = connect.getConn().createStatement().executeQuery(sql);
            while (rs.next()) {
               ls.add(new MovieSeats(rs.getInt("movie_id"),rs.getString("title"),rs.getString("Genre"),LocalDate.parse(rs.getString("release_date")),
                       rs.getInt("duration"),rs.getString("image_path")));
            }
        }catch (Exception e) {
            e.getMessage();
        }

        return ls;
    }



    @Override
    public boolean create(MovieSeats movieSeats) {
        return false;
    }

    @Override
    public boolean update(MovieSeats movieSeats) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public MovieSeats findOne(int id) {
        return null;
    }
}
