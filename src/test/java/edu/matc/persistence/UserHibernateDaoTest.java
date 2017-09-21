package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserHibernateDaoTest {
    private final Logger logger = Logger.getLogger(this.getClass());
    UserHibernateDao userHibernateDao;
    User user;

    @Before
    public void setUp() throws Exception {
        userHibernateDao = new UserHibernateDao();

        user = new User();
        user.setFirstName("Admin");
        user.setLastName("Person");
        user.setUserName("adminUser");
        user.setUserPassword("admin");

    }

    @Test
    public void getAllUsersTest() throws Exception {
        logger.info("running deleteUserTest");
        List<User> users = userHibernateDao.getAllUsers();
        assertEquals("Unexpected number of users returned",2, users.size());
        assertEquals("Correct first name returned", "Admin", users.get(0).getFirstName());

    }

    @Test
    public void updateUserTest() throws Exception {
    }

    @Test
    public void deleteUserTest() throws Exception {
        logger.info("running deleteUserTest");
        userHibernateDao.deleteUser("adminUser");


    }



}

