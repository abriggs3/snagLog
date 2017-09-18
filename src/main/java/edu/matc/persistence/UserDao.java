package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements UserDaoInterfaceable {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<User> getUserEntered(String searchTerm, String searchType) {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        logger.info("this is searchTerm " + searchTerm);
        logger.info("this is searchType " + searchType);

        String sql = "";
        if(searchType.equals("all")) {
            sql = "SELECT * FROM users;";
        } else {
            sql = "SELECT * FROM users where " + searchType + " = '" + searchTerm +"';";
        }

        runQuery(users, database, sql);
        return users;
    }

    private void runQuery(List<User> users, Database database, String sql) {
        logger.info("Code reached runQuery(), the sql is " + sql);
        Connection connection;
        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            runWhileLoopToCreateUserList(users, results);
            database.disconnect();
        } catch (SQLException e) {
            logger.error("SearchUser.getUserEntered()...SQL Exception: " + e);
        } catch (Exception e) {
            logger.error("SearchUser.getUserEntered()...Exception: " + e);
        }
    }

    private void runWhileLoopToCreateUserList(List<User> users, ResultSet results) throws SQLException {
        while (results.next()) {
            User employee = createUserFromResults(results);
            users.add(employee);
        }
    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setUserName(results.getString("user_name"));
        user.setUserPassword(results.getString("user_pass"));
        return user;
    }

}