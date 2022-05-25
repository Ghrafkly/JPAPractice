package com.fdm.JBDCEcercise;

import com.fdm.ConnectionPool;

public class Runner {
    public static void main(String[] args) {
        ConnectionPool connPool = new ConnectionPool();

        UsersDAO usersDAO = new UsersDAO(connPool);
        User user = new User("Kyle", "Near");

        usersDAO.updateUser(user);
        System.out.println(usersDAO.listUsers());

        connPool.closeAllConnections();
    }
}
