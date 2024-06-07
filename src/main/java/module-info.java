module com.example.javafxdatabaseapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafxdatabaseapp to javafx.fxml;
    exports com.example.javafxdatabaseapp;
}