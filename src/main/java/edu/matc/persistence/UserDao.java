package edu.matc.persistence;

import edu.matc.entity.Storable;
import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class UserDao implements DataCRUDable {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public List<Storable> retrieveAllRecords(String tableName) {

        List<Storable> objectTypeFromTable = new ArrayList<Storable>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            if (tableName.equalsIgnoreCase("users")) {
                objectTypeFromTable = session.createCriteria(User.class).list();
            }

        } catch (HibernateException he) {
            logger.error("Error getting all users", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return objectTypeFromTable;
    }


    @Override
    public Storable addRecord(Storable recordToAdd) {
        User user = (User)recordToAdd;

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            user = new User(user.getFirstName(), user.getLastName(), user.getUserName(), user.getUserPassword());
            session.save(user);
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            logger.error("Error adding user " + user, e);
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    @Override
    public Storable selectSingleRecord(String PKOfRecord) {
        String userName = PKOfRecord;
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
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    @Override
    public void updateRecord(Storable recordToUpdate) {
        User user = (User)recordToUpdate;
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
    public void deleteRecord(String PKOfRecord) {
        String userName = PKOfRecord;
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
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Storable> getRecordBySearchType(String searchTerm, String searchType){

        List<Storable> users = new ArrayList<Storable>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq(searchType, searchTerm));
            users = criteria.list();
        } catch (HibernateException he) {
            logger.error("Error getting all users with term " +  searchTerm + " and type " + searchType, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return users;
    }










}

