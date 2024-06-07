package com.example.javafxdatabaseapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
    @FXML
    public Label showid;
    public Label showname;
    public Label showage;
    public void connectBtn(ActionEvent actionEvent) {
        com.example.javafxdatabaseapp.DatabaseConnectivity connect = new com.example.javafxdatabaseapp.DatabaseConnectivity();
        Connection connectDb = connect.getConnection();
        if (connectDb != null) {
            String connectId = "SELECT id FROM students";
            String connectName = "SELECT name FROM students";
            String connectAge = "SELECT age FROM students";
            try {
                Statement stmt = connectDb.createStatement();
                ResultSet idOutput = stmt.executeQuery(connectId);
                while (idOutput.next()) {
                    showid.setText(idOutput.getString("id"));
                }
                ResultSet nameOutput = stmt.executeQuery(connectName);
                while (nameOutput.next()) {
                    showname.setText(nameOutput.getString("name"));
                }
                ResultSet ageOutput = stmt.executeQuery(connectAge);
                while (ageOutput.next()) {
                    showage.setText(ageOutput.getString("age"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            showid.setText("Not connected to Database");
        }
    }
}
