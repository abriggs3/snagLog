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
    public User selectUser(String userName) {
        User user = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            user = (User)session.get(User.class, userName);
            session.get(User.class, userName);
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user;
    }


    @Override
    public void updateUser(User user) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
        } catch (HibernateException he){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    logger.error("Error rolling back update of user: " + user, he2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteUser(String userName){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            User user = (User)session.get(User.class, userName);
            session.delete(user);
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public User addUser(User user) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            user = new User(user.getFirstName(), user.getLastName(), user.getUserName(), user.getUserPassword());
            session.save(user);
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user;

    }

}

