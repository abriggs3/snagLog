package edu.matc.persistence;

import edu.matc.entity.User;

import java.util.List;

public interface UserDaoInterface {
    public List<User> getAllUsers();
    public void updateUser(User user);
    public void deleteUser(User user);
}