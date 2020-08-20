package com.pavuk.cars.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "person")
public class Person {

    /** Id primary key ktory sa generuje sam pri kazdom zazname */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    /**
     * ked sa cascadeall vymaze tak vymaze vsetky spolocne car co ma person
     * */
    @OneToMany(
            mappedBy = "person",
            cascade = {CascadeType.ALL},
            orphanRemoval = true)
    private List<Car> carList;


    public Person(){

    }


    public void addCar(Car car){
        if(carList == null){
            carList = new ArrayList<>();
        }
        carList.add(car);

        car.setPerson(this);
    }


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", carList=" + carList +
                '}';
    }
}
