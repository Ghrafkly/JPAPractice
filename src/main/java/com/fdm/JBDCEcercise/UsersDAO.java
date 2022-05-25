package com.fdm.JBDCEcercise;

import com.fdm.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO implements IUsersDAO {
    private ConnectionPool connPool;
    static final String CREATE_QUERY = "CREATE TABLE Users(username varchar(255) primary key, password varchar(255))";


    public UsersDAO(ConnectionPool connPool) {
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


    @Override
    public void addUser(User user) {
        Connection conn = connPool.getConnection();
        try {
            CallableStatement statement =
                    conn.prepareCall(String.format("{CALL ADD_USERS('%s','%s')}"
                            ,user.getUsername(), user.getPassword()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUser(String username) {
        String removeUserQuery = String.format("" +
                "DELETE FROM users WHERE Username='%s'", username);
        Connection conn = connPool.getConnection();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(removeUserQuery);
        } catch (SQLException e) {
            System.out.println("Goodbye");
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        Connection conn = connPool.getConnection();
        try {
            CallableStatement statement =
                    conn.prepareCall(String.format("{CALL UPDATE_USER('%s','%s')}"
                            ,user.getUsername(), user.getPassword()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public List<User> listUsers() {
        String selectAllQuery = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        Connection conn = connPool.getConnection();
        Statement statement;

        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(selectAllQuery);
            while (rs.next()) {
                String username = rs.getString(1);
                String password = rs.getString(2);
                users.add(new User(username, password));
            }

        } catch (SQLException e) {
            System.out.println("Hello");
            e.printStackTrace();
        }

        return users;
    }
}
