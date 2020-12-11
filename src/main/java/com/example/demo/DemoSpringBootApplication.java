package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.ArrayList;

@SpringBootApplication
public class DemoSpringBootApplication {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        try {
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sql_hr?user=root&password=admin")) {

                System.out.println("database connected :" + connection.getMetaData().getDatabaseProductName());

                try (Statement statement = connection.createStatement()) {
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM sql_hr.employees");
                    while (resultSet.next()) {
                        names.add(resultSet.getString(2));

                    }
                }
            }

            names.stream().filter(el -> el.contains("Ivy")).forEach(System.out::println);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.fillInStackTrace());

        }
    }

}
