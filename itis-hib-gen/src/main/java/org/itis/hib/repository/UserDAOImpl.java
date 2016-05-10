package org.itis.hib.repository;

import org.hibernate.Session;
import org.itis.hib.genentities.UsersEntity;

import java.util.List;


public class UserDAOImpl implements UserDAO {
    Session session;
    public UserDAOImpl(Session session){
        this.session=session;
    }
    public List<UsersEntity> getAllUsers() {
        List<UsersEntity> allUsers = session.createCriteria(UsersEntity.class).list();
        return allUsers;
    }

    public void updateUser(UsersEntity user) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
    }

    public void deleteUser(UsersEntity user) {
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }
}
