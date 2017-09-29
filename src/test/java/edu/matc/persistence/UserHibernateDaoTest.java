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
    int listOfUsersInitialSize;

    @Before
    public void setUp() throws Exception {
        userHibernateDao = new UserHibernateDao();
        listOfUsersInitialSize = userHibernateDao.getAllUsers().size();
        user = new User();
    }

    @Test
    public void getAllUsersTest() throws Exception {
        List<User> users = userHibernateDao.getAllUsers();
        assertEquals("Unexpected number of users returned", listOfUsersInitialSize, users.size());
        assertEquals("incorrect first name returned", "Admin", users.get(0).getFirstName());
    }

    @Test
    public void getUserBySearchTypeTest() {
        List<User> users = userHibernateDao.getUserBySearchType("contributorUser", "userName");
        assertEquals("Incorrect size of results", 1, users.size());
    }

    @Test
    public void selectUserTest() throws Exception {
        user = userHibernateDao.selectUser("adminUser");
        assertNotNull(user);
        assertEquals("incorrect last name returned", "Person", user.getLastName());
    }

    @Test
    public void updateUserTest() throws Exception {
        listOfUsersInitialSize = userHibernateDao.getAllUsers().size();
        String userName = "adminUser";
        user = userHibernateDao.selectUser(userName);
        user.setFirstName("ElFabaloso");
        userHibernateDao.updateUser(user);
        assertEquals("List size has changed", listOfUsersInitialSize, userHibernateDao.getAllUsers().size());
        assertEquals("Update changes failed to save", user.toString(), userHibernateDao.selectUser(userName).toString());

    }

    @Test
    public void deleteUserTest() throws Exception {

        userHibernateDao.deleteUser("adminUser");
        assertEquals("Incorrect size of results", listOfUsersInitialSize - 1, userHibernateDao.getAllUsers().size());
    }
/*
    @Test
    public void addUserTest() {
        user = new User("James", "Kirk", "JTK", "tribblesRule");

        userHibernateDao.addUser(user);
        assertEquals("Incorrect size of results", listOfUsersInitialSize + 1, userHibernateDao.getAllUsers().size());
        assertEquals("User not saved correctly", user.toString(), userHibernateDao.selectUser("JTK").toString());
    }
*/
}

