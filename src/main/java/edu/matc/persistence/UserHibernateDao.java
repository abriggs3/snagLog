package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.ArrayList;
import java.util.List;

public class UserHibernateDao implements UserDaoInterface {
    private final Logger logger = Logger.getLogger(this.getClass());

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
            logger.error("Error getting all users", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return users;
    }

    @Override
    public void addUser(String firstName, String lastName, String userName, String userPassword) {
        
    }

    // TODO
    @Override
    public User selectUser(String userName) {
        return null;
    }


    @Override
    public void updateUser(User user) {
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            session.update(user);
        } catch (HibernateException he) {
            logger.error("error updating user " + user.getUserName(), he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
/*
    @Override
    public void deleteUser(String userName) {
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            session.delete(userName);
        } catch (HibernateException he) {
            log.error("error trying to delete user " + userName, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
*/

    @Override
    public void deleteUser(String userName){
        logger.info("running deleteUserTest with userName " + userName);
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            User user=
                    (User)session.get(User.class, userName);
            session.delete(user);
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}