module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.mybatis;

    opens hnist.javafx.kqms to javafx.fxml;
    opens hnist.javafx.kqms.bg.controller;
    opens hnist.javafx.kqms.bg.mapper;
    opens hnist.javafx.kqms.fg.main.view;
    exports hnist.javafx.kqms;
}