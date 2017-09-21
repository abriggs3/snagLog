package edu.matc.persistence;

import edu.matc.entity.User;

import java.util.List;

public interface UserDaoInterface {
    public List<User> getAllUsers();
    public void addUser(String firstName, String lastName, String userName, String userPassword);
    public User selectUser(String userName);
    public void updateUser(User user);
    public void deleteUser(String userName);
}