package edu.matc.persistence;

import edu.matc.entity.User;

import java.util.List;

public interface UserDaoInterfaceable {
    public List<User> getUserEntered(String searchTerm, String searchType);
}