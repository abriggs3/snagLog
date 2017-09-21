package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import java.util.ArrayList;
import java.util.List;

public class UserHibernateDao implements UserDaoInterface {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Return a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            users = session.createCriteria(User.class).list();
        } catch (HibernateException he) {
            log.error("Error getting all users", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return users;
    }



    @Override
    public void updateUser(User user) {
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            session.update(user);
        } catch (HibernateException he) {
            log.error("error updating user " + user.getUserName(), he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteUser(User user) {
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            session.delete(user);
        } catch (HibernateException he) {
            log.error("error trying to delete user " + user.getUserName(), he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}