package org.itis.hib.tasks;
import org.hibernate.Session;
import org.itis.hib.entities.Order;
import org.itis.hib.entities.User;
import org.itis.hib.repository.UserDAO;
import org.itis.hib.repository.UserDAOImpl;
import org.itis.hib.util.HibernateUtil;

import java.util.List;
import java.util.Random;

public class Hib3 {
    public static void main(String[] args) {
        System.out.println("Hibernate + MySQL + Maven");
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            @SuppressWarnings("unchecked")
            List<Order> allOrders = session.createCriteria(Order.class).list();
            System.out.println("Orders count: " + allOrders.size());
            for (Order order : allOrders) {
                System.out.println(order.getName());
                System.out.println(order.getUser().getFirstname());
                System.out.println(order.getPrice());
                System.out.println(order.getUser().getOrderses().size());
            }
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        HibernateUtil.shutdown();
    }
}
