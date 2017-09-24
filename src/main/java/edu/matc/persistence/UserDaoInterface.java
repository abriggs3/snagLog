package edu.matc.persistence;

import edu.matc.entity.User;

import java.util.List;

public interface UserDaoInterface {
    public List<User> getAllUsers();
    public User addUser(User user);
    public User selectUser(String userName);
    public void updateUser(User user);
    public void deleteUser(String userName);
    public List<User> getUserBySearchType(String searchTerm, String searchType);
}