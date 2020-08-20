package com.pavuk.cars.hibernate;

import com.pavuk.cars.Color;
import com.pavuk.cars.entity.Car;
import com.pavuk.cars.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Save {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();
            Person personToSave = new Person("Albert","Tester");
            personToSave.addCar(new Car("Renault","Renault",Color.Yellow,"KE254AK"));
            session.save(personToSave);
            session.getTransaction().commit();

        } finally {
            factory.close();
            session.close();
        }
    }
}
