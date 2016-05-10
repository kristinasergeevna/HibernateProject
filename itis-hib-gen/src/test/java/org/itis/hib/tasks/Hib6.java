package org.itis.hib.tasks;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.itis.hib.genentities.UsersEntity;
import org.itis.hib.util.HibernateUtil;

import java.util.List;

public class Hib6 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        // Задача1
        Criteria criteria = session.createCriteria(UsersEntity.class)
                .add(Restrictions.gt("age", 20));
        List<UsersEntity> list=criteria.list();
        System.out.println("Вывести всех пользователей старше 20 лет");
        for(UsersEntity user: list){
            System.out.println(user);
        }
        Criteria criteria1 = session.createCriteria(UsersEntity.class)
                .add(Restrictions.lt("age", 20));
        List<UsersEntity> list1=criteria1.list();
        System.out.println("Вывести всех пользователей младше 20 лет");
        for(UsersEntity user: list1){
            System.out.println(user);
        }
        Criteria criteria2 = session.createCriteria(UsersEntity.class)
                .add(Restrictions.ge("age", 20));
        List<UsersEntity> list2=criteria2.list();
        System.out.println("Вывести всех пользователей младше 20 или менее лет");
        for(UsersEntity user: list2){
            System.out.println(user);
        }
        Criteria criteria3 = session.createCriteria(UsersEntity.class)
                .add(Restrictions.le("age", 20));
        List<UsersEntity> list3=criteria3.list();
        System.out.println("Вывести всех пользователей старше 20 или более лет");
        for(UsersEntity user: list3){
            System.out.println(user);
        }
        //задача 2
        Criteria criteria4 = session.createCriteria(UsersEntity.class)
                .add(Restrictions.between("age", 18, 23));
        List<UsersEntity> list4=criteria4.list();
        System.out.println("Вывести всех пользователей, у которых возраст между 18 и 23");
        for(UsersEntity user: list4){
            System.out.println(user);
        }
        //Задача3
        System.out.println("Вывести всех пользователей, у кого имя начинается на А");
        Criteria criteria5 = session.createCriteria(UsersEntity.class)
                .add(Restrictions.like("firstname", "А%"));
        List<UsersEntity> list5=criteria5.list();
        for(UsersEntity user: list5){
            System.out.println(user);
        }
        //Задача 4
        System.out.println("Вывести всех пользователей, у кого в имени есть буква И");
        Criteria criteria6 = session.createCriteria(UsersEntity.class)
                .add(Restrictions.or(Restrictions.like("firstname", "%и%"),(Restrictions.like("firstname", "%И%"));
        List<UsersEntity> list6=criteria6.list();
        for(UsersEntity user: list6){
            System.out.println(user);
        }
        // Задача 5

        System.out.println("Вывести всех пользователей, у кого в имени есть буква И или Е");

        Criteria criteria7 = session.createCriteria(UsersEntity.class)
                .add(Restrictions.or(Restrictions.like("firstname", "%И%"), Restrictions.like("firstname", "%и%"),
                        Restrictions.like("firstname", "%е%"), Restrictions.like("firstname", "%Е%")));
        List<UsersEntity> list7=criteria7.list();
        for(UsersEntity user: list7){
            System.out.println(user);
        }
        // Задача 6
        System.out.println("Вывести пользователей, у которых возраст между 15 и 25 и в имени есть либо "+
                "“ли” (Лилия), либо “ик” (Никита), либо “ра” (Айрат)");
        Criteria criteria8 = session.createCriteria(UsersEntity.class)
                .add(Restrictions.or(Restrictions.like("firstname", "%ли%"),Restrictions.like("firstname", "%ра%"),
                        Restrictions.like("firstname", "%ик%")));
        criteria8.add(Restrictions.between("age",15,25));
        List<UsersEntity> list8=criteria8.list();
        for(UsersEntity user: list8){
            System.out.println(user);
        }
        //задача 7
        System.out.println("Вывести пользователей,чье имя либо Регина, либо Марина, либо Алиёр");
        Criteria criteria10 = session.createCriteria(UsersEntity.class)
                .add( Property.forName("firstname").in(new String[]{"Регина", "Марина", "Алиёр"}) );
        List<UsersEntity> list10=criteria10.list();
        for(UsersEntity user: list10){
            System.out.println(user);
        }
        //Задача 8
        System.out.println("Вывести пользователей, отсортировав по возрастанию");
        Criteria criteria11= session.createCriteria(UsersEntity.class)
                .addOrder(Order.asc("age"));
        List<UsersEntity> list11=criteria11.list();
        for(UsersEntity user: list11){
            System.out.println(user);
        }

        System.out.println("Вывести пользователей, отсортировав по убыванию");

        Criteria criteria12 = session.createCriteria(UsersEntity.class)
                .addOrder(Order.desc("age"));
        List<UsersEntity> list12=criteria12.list();
        for(UsersEntity user: list12){
            System.out.println(user);
        }
        //Задача 9
        System.out.println("Вывести первых 7-х пользователей, у которых возраст больше 20.");
        Criteria criteria13 = session.createCriteria(UsersEntity.class)
                .add(Restrictions.gt("age", 20));
        criteria13.setMaxResults(7);
        List<UsersEntity> list13=criteria13.list();
        for(UsersEntity user: list13){
            System.out.println(user);
        }
        System.out.println("Вывести пользователей с 3го по 6");
        Criteria criteria14 = session.createCriteria(UsersEntity.class)
                .setFirstResult(2).setMaxResults(4);
        List<UsersEntity> list14=criteria14.list();
        for(UsersEntity user: list14){
            System.out.println(user);
        }
        // Задача 10

        System.out.println("Вывести пользователей, у которых сумма стоимости заказов больше 100");
        List<UsersEntity> list15= session.createQuery("SELECT u FROM OrdersEntity o " +
                "INNER JOIN UsersEntity u ON u.userId = o.userId " +
                "GROUP BY u.userId HAVING sum( o.price)>:price")
                .setInteger("price", 100).list();
        for(UsersEntity user: list15){
            System.out.println(user);
        }
        HibernateUtil.shutdown();
    }
}
