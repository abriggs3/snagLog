package edu.matc.persistence;

import edu.matc.entity.Storable;
import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * The type User dao test.
 */
public class UserDaoTest{
    private final Logger logger = Logger.getLogger(this.getClass());
    /**
     * The User dao.
     */
    UserDao userDao;
    /**
     * The User.
     */
    User user;
    /**
     * The List of users initial size.
     */
    int listOfUsersInitialSize;
    /**
     * The Table name.
     */
    String tableName = "users";

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        userDao = new UserDao();
        listOfUsersInitialSize = userDao.retrieveAllRecords(tableName).size();
        user = new User();
    }

    /**
     * Gets all records test.
     *
     * @throws Exception the exception
     */
    @Test
    public void getAllRecordsTest() throws Exception {
        List<Storable> objectTypeFromTable = userDao.retrieveAllRecords(tableName);
        assertEquals("Unexpected number of users returned", listOfUsersInitialSize, objectTypeFromTable.size());
        List<User> usersList = objectTypeFromTable
                .stream()
                .map(element -> (User) element)
                .collect(Collectors.toList());
        assertEquals("incorrect first name returned", "Admin", usersList.get(0).getFirstName());
    }

    /**
     * Gets record by search type test.
     */
    @Test
    public void getRecordBySearchTypeTest() {
        List<Storable> users = userDao.getRecordBySearchType("contributorUser", "userName", tableName);
        assertEquals("Incorrect size of results", 1, users.size());
    }

    /**
     * Select single record test.
     *
     * @throws Exception the exception
     */
    @Test
    public void selectSingleRecordTest() throws Exception {
        user = (User) userDao.selectSingleRecord(1, tableName);
        assertNotNull(user);
        assertEquals("incorrect last name returned", "Person", user.getLastName());
    }

    /**
     * Update record test.
     *
     * @throws Exception the exception
     */
    @Test
    public void updateRecordTest() throws Exception {
        listOfUsersInitialSize = userDao.retrieveAllRecords(tableName).size();
        int userId = 2;
        user = (User) userDao.selectSingleRecord(userId, tableName);
        user.setFirstName("ElFabaloso");
        userDao.updateRecord(user, tableName);
        assertEquals("List size has changed", listOfUsersInitialSize, userDao.retrieveAllRecords(tableName).size());
        assertEquals("Update changes failed to save", user.toString(), userDao.selectSingleRecord(userId, tableName).toString());
    }

    /**
     * Delete record test.
     *
     * @throws Exception the exception
     */
    @Test
    public void deleteRecordTest() throws Exception {
        userDao.deleteRecord(4, tableName);
        assertEquals("Incorrect size of results", listOfUsersInitialSize - 1, userDao.retrieveAllRecords(tableName).size());
    }

    /**
     * Add record test.
     */
    @Test
    public void addRecordTest() {
        user = new User(4, "James", "Kirk", "JTK", "tribblesRule");

        userDao.addRecord(user, tableName);
        assertEquals("Incorrect size of results", listOfUsersInitialSize + 1, userDao.retrieveAllRecords(tableName).size());
        assertEquals("User not saved correctly", user.toString(), userDao.selectSingleRecord(4, tableName).toString());
    }



}

