package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {
    /*
    private final Logger logger = Logger.getLogger(this.getClass());
    UserDao userDao;
    User user;

    @Before
    public void setUp() throws Exception {
        userDao = new UserDao();
        user = new User();
    }

    @Test
    public void getUserEnteredByFirstNameTest() throws Exception {
        String searchTerm = "Admin";
        String searchType = "first_name";

        List<User> users = userDao.getUserEntered(searchTerm, searchType);
        assertEquals("Unexpected number of users returned",1, users.size());
        assertEquals("Correct first name returned", "Admin", users.get(0).getFirstName());

    }

    @Test
    public void getUserEnteredAllUsersTest() throws Exception {
        String searchTerm = "any search term can go here-it is ignored anyway";
        String searchType = "all";

        List<User> users = userDao.getUserEntered(searchTerm, searchType);
        assertEquals("Unexpected number of users returned",2, users.size());
        assertEquals("Correct first name returned", "Contributor", users.get(1).getFirstName());
    }
    */
}