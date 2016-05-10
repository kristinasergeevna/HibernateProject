package org.itis.tasks;
import org.hibernate.Session;
import org.itis.hib.entities.User;
import org.itis.hib.repository.UserDAO;
import org.itis.hib.repository.UserDAOImpl;
import org.itis.hib.util.HibernateUtil;

import java.util.List;
import java.util.Random;

public class Hib2 {
    public static void main(String[] args) {
        System.out.println("Hibernate + MySQL + Maven");
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session = HibernateUtil.getSessionFactory().openSession();
            // Задача 1
            UserDAO userDAO=new UserDAOImpl(session);
            List<User> list=userDAO.getAllUsers();
            for(User user: list){
                System.out.println(user);
            }
            //Задача 2
            session.beginTransaction();

            User stock = new User();



            stock.setFirstname("Стребков");

            stock.setLastname("Михаил");
            stock.setAge(23);



            session.save(stock);

            session.getTransaction().commit();
            // Задача 3
            String[] names = {"Мария", "Сабина", "Алия"};
            String[] lastnames = {"Бузукина", "Борошина"};
            User user1 = new User();
            session.beginTransaction();
            user1.setId(new Random().nextInt());
            user1.setFirstname(names[(int) (Math.random() * (names.length))]);
            user1.setLastname(lastnames[(int) (Math.random() * (lastnames.length))]);
            user1.setAge(17 + (int) (Math.random() * ((37 - 17) + 1)));
            session.save(user1);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        HibernateUtil.shutdown();
    }
}
