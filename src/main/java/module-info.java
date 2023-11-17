module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.mybatis;

    opens hnist.javafx.kqms to javafx.fxml;
    opens hnist.javafx.kqms.bg.controller;
    opens hnist.javafx.kqms.bg.mapper;
    opens hnist.javafx.kqms.fg.main.view;
    opens hnist.javafx.kqms.pojo;
    exports hnist.javafx.kqms;
    opens hnist.javafx.kqms.fg.main.router;
}