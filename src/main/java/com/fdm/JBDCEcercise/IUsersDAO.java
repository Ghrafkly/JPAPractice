package com.fdm.JBDCEcercise;

import java.util.List;

public interface IUsersDAO {
    void addUser (User user);
	void removeUser(String username);
	void updateUser (User user);
	User getUser (String username);
	List<User> listUsers();
}
