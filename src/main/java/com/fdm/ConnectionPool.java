package com.fdm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    static final String url = "jdbc:mysql://localhost:3306/mydb";
    static final String username = "root";
    static final String password = "password";

    private List<Connection> freeConnections = new ArrayList<>();
    private List<Connection> usedConnections = new ArrayList<>();

    public ConnectionPool() {
        for (int i = 0; i < 10; i++) {
            try {
                Connection conn = DriverManager.getConnection(url, username, password);
                freeConnections.add(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        Connection connection;
        if (!freeConnections.isEmpty()) {
            connection = freeConnections.get(0);
            freeConnections.remove(0);
            usedConnections.add(connection);
        } else {
            throw new RuntimeException("Maximum connections are in use (10)");
        }

        return connection;
    }

    public void returnConnection(Connection connection) {
        freeConnections.add(connection);
        usedConnections.remove(connection);
    }

    public void closeAllConnections() {
        try {
            for (Connection connection : freeConnections) connection.close();
            for (Connection connection : usedConnections) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
