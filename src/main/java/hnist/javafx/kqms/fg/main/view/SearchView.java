package hnist.javafx.kqms.fg.main.view;

import hnist.javafx.kqms.fg.main.View;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class SearchView extends View {
    private final Pane searchPane = initView();

    @Override
    public Pane getView() {
        return searchPane;
    }

    @Override
    public String getName() {
        return "查找信息";
    }

    protected Pane initView() {
        Pane root = new Pane();
        Button searchStudentInfoButton = new Button("查询学生信息");
        Button searchAbsentInfoButton = new Button("查询缺课信息");

        Label searchStudentLabel = new Label("查询学生信息");
        Label searchAbsentLabel = new Label("查询缺课信息");

        //查询学生信息
        TextField searchStudentNumber = new TextField();searchStudentNumber.setPromptText("学号");
        TextField searchStudentName = new TextField();searchStudentName.setPromptText("姓名");
        TextField searchStudentSex = new TextField();searchStudentSex.setPromptText("性别");
        TextField searchStudentAge = new TextField();searchStudentAge.setPromptText("年龄");
        TextField searchStudentClass = new TextField();searchStudentClass.setPromptText("班级");

        searchStudentLabel.setLayoutX(50);searchStudentLabel.setLayoutY(100);
        searchStudentNumber.setLayoutX(170);searchStudentNumber.setLayoutY(100);
        searchStudentName.setLayoutX(290);searchStudentName.setLayoutY(100);
        searchStudentSex.setLayoutX(410);searchStudentSex.setLayoutY(100);
        searchStudentAge.setLayoutX(530);searchStudentAge.setLayoutY(100);
        searchStudentClass.setLayoutX(650);searchStudentClass.setLayoutY(100);
        searchStudentInfoButton.setLayoutX(770);searchStudentInfoButton.setLayoutY(100);
        root.getChildren().addAll(searchStudentLabel,searchStudentNumber,searchStudentName,searchStudentSex,searchStudentAge,searchStudentClass,searchStudentInfoButton);

        searchStudentInfoButton.setOnAction(e->{
            /*





            */


            System.out.println("查询成功！");
        });

        //查询缺课信息
        TextField searchAbsentCourseName = new TextField();searchAbsentCourseName.setPromptText("课程名");
        TextField searchAbsentStudentName = new TextField();searchAbsentStudentName.setPromptText("学生姓名");
        TextField searchAbsentStudentNumber = new TextField();searchAbsentStudentNumber.setPromptText("学生学号");

        searchAbsentLabel.setLayoutX(50);searchAbsentLabel.setLayoutY(200);
        searchAbsentCourseName.setLayoutX(170);searchAbsentCourseName.setLayoutY(200);
        searchAbsentStudentName.setLayoutX(290);searchAbsentStudentName.setLayoutY(200);
        searchAbsentInfoButton.setLayoutX(410);searchAbsentInfoButton.setLayoutY(200);

        root.getChildren().addAll(searchAbsentLabel,searchAbsentCourseName,searchAbsentStudentName,searchAbsentInfoButton);

        searchAbsentInfoButton.setOnAction(e->{
            /*



            */


            System.out.println("查询成功！");
        });

        return root;
    }
}
