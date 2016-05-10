package org.itis.hib.repository;

import org.hibernate.Session;
import org.itis.hib.entities.User;

import java.util.List;


public class UserDAOImpl implements UserDAO {
    Session session;
    public UserDAOImpl(Session session){
        this.session=session;
    }
    public List<User> getAllUsers() {
        List<User> allUsers = session.createCriteria(User.class).list();
        return allUsers;
    }

    public void updateUser(User user) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
    }

    public void deleteUser(User user) {
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }
}
