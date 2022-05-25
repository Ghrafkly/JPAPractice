package com.fdm.JBDCDemo;

import com.fdm.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    private ConnectionPool connPool;
    static final String CREATE_QUERY = "CREATE TABLE Movie(id int primary key, name varchar(255), ticketPrice DOUBLE)";
    static final String INSERT_QUERY_PREPARED = "INSERT INTO Movie(name, ticketPrice) VALUES(?,?);";

    public MovieDAO() {
    }

    public MovieDAO(ConnectionPool connPool) {
        this.connPool = connPool;
    }

    public void createTable() {
        Connection conn = connPool.getConnection();
        try {
            Statement statement = conn.createStatement();
            statement.execute(CREATE_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        connPool.returnConnection(conn);
    }

    public void insertMovie(Movie movie) {

        Connection conn = connPool.getConnection();
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(INSERT_QUERY_PREPARED);
            statement.setString(1, movie.getName());
            statement.setDouble(2, movie.getTicketPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        connPool.returnConnection(conn);
    }

    public List<Movie> selectAll() {
        String selectQuery = "SELECT * FROM Movie";
        List<Movie> movies = new ArrayList<>();
        Connection conn = connPool.getConnection();
        Statement statement;
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(selectQuery);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double ticketPrice = rs.getDouble(3);
                movies.add(new Movie(id, name, ticketPrice));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        connPool.returnConnection(conn);
        return movies;
    }
}
