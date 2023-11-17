package hnist.javafx.kqms.fg.main.view.student;

import hnist.javafx.kqms.fg.main.view.View;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GetStudentView extends View {
    @Override
    public String getName() {
        // TODO
        return "操作学生信息";
    }

    @Override
    public Pane initView() {
        Label studentNumberLabel = new Label("学号");
        TextField studentNumber = new TextField();
        Label studentNameLabel = new Label("姓名");
        TextField studentName = new TextField();
        Button searchButton = new Button("搜索");
        Label label = new Label("若没有填入搜索信息则显示全部学生信息");

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(studentNumberLabel, 0, 0);
        gridPane.add(studentNumber, 1, 0);
        gridPane.add(studentNameLabel, 2, 0);
        gridPane.add(studentName, 3, 0);
        gridPane.add(searchButton, 4, 0);
        gridPane.add(label, 0, 1);
        GridPane.setConstraints(label, 0, 1, 2, 1);

        // TODO
        return gridPane;
    }
}
