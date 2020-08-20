package com.pavuk.cars.entity;

import com.pavuk.cars.Color;

import javax.persistence.*;


@Entity
@Table(name = "car")
public class Car {

    /** Id primary key ktory sa generuje sam pri kazdom zazname */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "car_name")
    private String name;

    @Column(name = "type")
    private String type;

    @Enumerated(EnumType.STRING)
    private Color carColor;

    @Column(name = "spz")
    private String spz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="personId")
    private Person person;

    /**
     * Prázdny konštruktor musí byť vkuse kvoli hibernate
     * */
    public Car(){

    }

    /**
     * Konštruktor pre vytvorenie objektu Car
     * */
    public Car(String name, String type, Color carColor, String spz) {
        this.name = name;
        this.type = type;
        this.carColor = carColor;
        this.spz = spz;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Color getCarColor() {
        return carColor;
    }

    public void setCarColor(Color carColor) {
        this.carColor = carColor;
    }

    public String getSpz() {
        return spz;
    }

    public void setSpz(String spz) {
        this.spz = spz;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", carColor=" + carColor +
                ", spz='" + spz + '\'' +
                ", person=" + person +
                '}';
    }
}
