package edu.matc.persistence;

import edu.matc.entity.Log;

import java.util.List;

public interface LogDaoInterface {
    public List<Log> getAllUsers();
    public Log addUser(Log user);
    public Log selectUser(String userName);
    public void updateUser(Log user);
    public void deleteUser(String userName);
    public List<Log> getUserBySearchType(String searchTerm, String searchType);
}
