package com.fdm.JBDCDemo;

import com.fdm.ConnectionPool;

public class Runner {
    public static void main(String[] args) {
        ConnectionPool connPool = new ConnectionPool();

        MovieDAO movieDAO = new MovieDAO(connPool);
        Movie movie1 = new Movie("Other Guys", 5.00);
        movieDAO.insertMovie(movie1);
        System.out.println(movieDAO.selectAll());
        connPool.closeAllConnections();
    }
}
