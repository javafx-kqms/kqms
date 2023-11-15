package hnist.javafx.kqms.fg.main.view;

import hnist.javafx.kqms.fg.main.Student;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SearchView implements View{
    private final Pane searchPane = initView();

    @Override
    public Pane getView() {
        return searchPane;
    }

    @Override
    public String getName() {
        return "查找信息";
    }

    private Pane initView() {
        Pane root = new Pane();
        Button button = new Button("查询学生信息");
        Button button1 = new Button("查询缺课信息");

        Label label3 = new Label("查询学生信息");
        Label label4 = new Label("查询缺课信息");

        //查询学生信息
        TextField t1 = new TextField();t1.setPromptText("学号");
        TextField t2 = new TextField();t2.setPromptText("姓名");
        TextField t3 = new TextField();t3.setPromptText("性别");
        TextField t4 = new TextField();t4.setPromptText("年龄");
        TextField t5 = new TextField();t5.setPromptText("班级");

        label3.setLayoutX(50);label3.setLayoutY(100);
        t1.setLayoutX(170);t1.setLayoutY(100);
        t2.setLayoutX(290);t2.setLayoutY(100);
        t3.setLayoutX(410);t3.setLayoutY(100);
        t4.setLayoutX(530);t4.setLayoutY(100);
        t5.setLayoutX(650);t5.setLayoutY(100);
        button.setLayoutX(770);button.setLayoutY(100);
        root.getChildren().addAll(label3,t1,t2,t3,t4,t5,button);

        button.setOnAction(e->{
            /*





            */


            System.out.println("查询成功！");
        });

        //查询缺课信息
        TextField t11 = new TextField();t11.setPromptText("课程名");
        TextField t22 = new TextField();t22.setPromptText("学生姓名");

        label4.setLayoutX(50);label4.setLayoutY(200);
        t11.setLayoutX(170);t11.setLayoutY(200);
        t22.setLayoutX(290);t22.setLayoutY(200);
        button1.setLayoutX(410);button1.setLayoutY(200);

        root.getChildren().addAll(label4,t11,t22,button1);

        button1.setOnAction(e->{
            /*



            */


            System.out.println("查询成功！");
        });

        return root;
    }
}
