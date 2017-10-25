package edu.matc.service;

import edu.matc.HibernateUtil;
import edu.matc.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class GenericServiceImplTest {
    User user = new User();
    IGenericService<User> userService = new GenericServiceImpl<User>(User.class, HibernateUtil.getSessionFactory());
    User newUserToSave;


    @Before
    public void setUp() throws Exception {
        userService = new GenericServiceImpl<User>(
                User.class, HibernateUtil.getSessionFactory());
        user = new User();
        newUserToSave = new User("Mulberry", "Briggs", "MulBee", "coolPassWord");
    }


    @Test
    public void getTest() throws Exception {
        user = userService.get(User.class, 1);
        assertEquals("First name returned is not what was expected ", "Admin", user.getFirstName());
    }

    @Test
    public void saveTest() throws Exception {
        // attempts to add user
        userService.save(newUserToSave);
        // attempts to retrieve newly added user by using the size of the array as the id
        user = userService.get(User.class, userService.getAll().size());
        assertEquals("User name returned is not what was expected ", "Mulberry", user.getFirstName());
        // cleans the db by removing the inserted user
        userService.delete(user);
    }

    @Test
    public void updateTest() throws Exception {
        User userToUpdate = userService.get(User.class, 4);
        userToUpdate.setUserName("Updated");
        userService.update(userToUpdate);
        assertEquals("Returned userName does not match expected value ", "Updated", userService.get(User.class, 4).getUserName());

    }

    @Test
    public void deleteTest() throws Exception {
        int currentListSize = userService.getAll().size();
        //gets the user with the id of 4 from db
        user = userService.get(User.class, 4);
        // attempts to delete the user
        userService.delete(user);
        assertEquals("Number of records in database do not match expected number ", currentListSize - 1, userService.getAll().size());
        // clean up by adding deleted record back into db
        userService.save(user);
    }

    @Test
    public void testQueryTest() {
        Map<String, Object> params = new HashMap<>();
        List<User> users = userService.query("FROM User where usersId = 1", params);
        assertEquals("list of users returned do not match expected size", 1, users.size());
    }

    @Test
    public void getAllTest() throws Exception {
        List<User> userList = userService.getAll();
        assertEquals("incorrect first name returned", "Admin", userList.get(0).getFirstName());
    }


}