package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;

public class UserHibernateDao {
    private final Logger log = Logger.getLogger(this.getClass());


    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();


        return users;
    }
}

