package com.example.javafxdatabaseapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectivity {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "students";
        String databaseUser = "root";
        String url = "jdbc:mysql://127.0.0.1:3307/" + databaseName;
        String databasePassword = "";

        try{
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch(Exception e){
            e.printStackTrace();
        }

        return  databaseLink;
    }
}
