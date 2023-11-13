module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires spring.boot.autoconfigure;


    opens hnist.javafx.kqms to javafx.fxml;
    exports hnist.javafx.kqms;
}