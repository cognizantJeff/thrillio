package com.cognizant.thrillio.dao;


import com.cognizant.thrillio.DataStore;
import com.cognizant.thrillio.entities.User;

/**
 * @author cognizant
 */
public class UserDao {
    public User[] getUsers() {
        return DataStore.getUsers();
    }
}
