package com.pavuk.cars.hibernate;

import com.pavuk.cars.entity.Car;
import com.pavuk.cars.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Get {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            int id = 2;
            Person person = session.get(Person.class,id);

            System.out.println(person.getName());

            for(Car car : person.getCarList()){
                System.out.println(car.getName());
            }

            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }
    }
}
