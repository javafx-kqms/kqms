module hnist.javafx.kqms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.mybatis;
    requires java.desktop;
    requires easyexcel.core;

    opens hnist.javafx.kqms to javafx.fxml;
    opens hnist.javafx.kqms.bg.controller;
    opens hnist.javafx.kqms.bg.mapper;
    opens hnist.javafx.kqms.pojo;
    opens hnist.javafx.kqms.fg.main;

    exports hnist.javafx.kqms;
}