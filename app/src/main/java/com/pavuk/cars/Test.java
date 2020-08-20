package com.pavuk.cars;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {
    public static void main(String[] args) {
        try{

            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/car_database?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",
                            "root", "root");

            System.out.println("Connected"+" "+connection.toString());

        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
