package model.dao;

/**
 *
 * @author igor
 */

import model.entities.User;
import java.util.*;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class UserDAO implements DAO<User> {
    
    @Override
    public boolean create(User user){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{           
            transaction = s.beginTransaction();
            s.save(user);
            transaction.commit();            
        } catch(HibernateException e){
           if(transaction != null){
               transaction.rollback();
           }
           return false;
        } finally {
            s.close();
        }
        return true;
    }
    
    @Override
    public boolean update(User user){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{           
            transaction = s.beginTransaction();
            s.update(user);
            transaction.commit();            
        } catch(HibernateException e){
           if(transaction != null){
               transaction.rollback();
           }
           return false;
        } finally {
            s.close();
        }
        return true;
    }
        
    @Override
    public boolean remove(Object id){
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{           
            transaction = s.beginTransaction();            
            s.delete(this.getById(id));
            transaction.commit();            
        } catch(HibernateException e){
           if(transaction != null){
               transaction.rollback();
           }
           return false;
        } finally {
            s.close();
        }
        return true;
    }
    
    @Override
    public User getById(Object id){
        User user = new User();
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction;
        try{           
            transaction = s.beginTransaction();
            user = (User)s.get(User.class, (int)id);
            transaction.commit();  
        } catch(HibernateException e){
           
        } finally {
            s.close();
        }
        return user;
    }
    
    @Override
    public List<User> readAll(){
        List<User> users = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        try{           
            s.beginTransaction();
            users = s.createCriteria(User.class).list();
            s.getTransaction().commit();
        } catch(HibernateException e){
           
        }
        return users;
    }
    
    public List<User> searchByNameOrEmail(String regEx){
        List<User> users = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();
        try{           
            s.beginTransaction();
            Criteria query = s.createCriteria(User.class);
            Criterion crName = Restrictions.like("username", regEx, MatchMode.ANYWHERE);
            Criterion crEmail = Restrictions.like("email", regEx, MatchMode.ANYWHERE);
            query.add(Restrictions.or(crName, crEmail));
            users = query.list();
            s.getTransaction().commit();
        } catch(HibernateException e){
           
        }
        return users;
    }
    
    /*
    
    Query qry = session.createQuery("From RegistrationBean as rb where rb."+searchCriteria+"  like ?");
qry.setString(0, "%"+searchField+"%");
    
    
    session = sessionFactory.openSession();
Criteria query = session.createCriteria(Pojo.class);
query.add(Restrictions.like("column", "a", MatchMode.START));
    */
    
    
    /*public static void main(String[] args) {
        UserDAO model = new UserDAO();
        List<User> users = model.searchByNameOrEmail("xm");
        users.forEach((user) -> {
            System.out.println(user);
        });
    }*/
}
