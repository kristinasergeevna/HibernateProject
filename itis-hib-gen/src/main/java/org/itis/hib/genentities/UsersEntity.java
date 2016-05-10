package org.itis.hib.genentities;

import javax.persistence.*;

/**
 * Created by SDS on 29.04.2016.
 */
@Entity
@Table(name = "users", schema = "", catalog = "itis_hib_db")
public class UsersEntity {
    private int userId;
    private String firstname;
    private String lastname;
    private int age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "FIRSTNAME")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "LASTNAME")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "AGE")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (userId != that.userId) return false;
        if (age != that.age) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "userId=" + userId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}
/*insert into users (FIRSTNAME, LASTNAME,AGE) VALUES('Полина','Дубровина',12);
insert into users (FIRSTNAME, LASTNAME,AGE) VALUES('Диана','Давлетшина',15);
insert into users (FIRSTNAME, LASTNAME,AGE) VALUES('Дарья','Сычёва',18);
insert into users (FIRSTNAME, LASTNAME,AGE) VALUES('Андрей','Храмов',23);
insert into users (FIRSTNAME, LASTNAME,AGE) VALUES('Айрат','Натфуллин',32);
insert into users (FIRSTNAME, LASTNAME,AGE) VALUES('Дмитрий','Аладьев',20);
insert into users (FIRSTNAME, LASTNAME,AGE) VALUES('Вика','Дылевская',32);
insert into users (FIRSTNAME, LASTNAME,AGE) VALUES('Рома','Гладкий',32);
insert into users (FIRSTNAME, LASTNAME,AGE) VALUES('Динар','Вафин',20);
insert into users (FIRSTNAME, LASTNAME,AGE) VALUES('Андрей','Демидов',20);
insert into users (FIRSTNAME, LASTNAME,AGE) VALUES('Руслан','Миргарипов',20);
insert into users (FIRSTNAME, LASTNAME,AGE) VALUES('Вероника','Шугулёва',25);
insert into users (FIRSTNAME, LASTNAME,AGE) VALUES('Мария','Шугулёва',20);
insert into users (FIRSTNAME, LASTNAME,AGE) VALUES('Анжела','Денисова',30);
insert into users (FIRSTNAME, LASTNAME,AGE) VALUES('Виталий','Денисов',20);*/

