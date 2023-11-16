module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires spring.boot.autoconfigure;
    requires spring.beans;

    opens hnist.javafx.kqms to javafx.fxml;
    exports hnist.javafx.kqms;
}