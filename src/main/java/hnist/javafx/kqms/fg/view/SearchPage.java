package hnist.javafx.kqms.fg.view;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SearchPage implements View{

    Pane searchPane = new Pane();
    class search extends Application {

        @Override
        public void start(Stage stage) throws Exception {
            Button button9 = new Button("查询学生信息");
            Button button10 = new Button("查询缺课信息");

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
            button9.setLayoutX(770);button9.setLayoutY(100);

            searchPane.getChildren().addAll(label3,t1,t2,t3,t4,t5,button9);
            button9.setOnAction(e->{
                System.out.println("查询成功！");
            });

            //查询缺课信息
            TextField t11 = new TextField();t11.setPromptText("课程名");
            TextField t22 = new TextField();t22.setPromptText("学生姓名");

            label4.setLayoutX(50);label4.setLayoutY(200);
            t11.setLayoutX(170);t11.setLayoutY(200);
            t22.setLayoutX(290);t22.setLayoutY(200);
            button10.setLayoutX(410);button10.setLayoutY(200);

            searchPane.getChildren().addAll(label4,t11,t22,button10);
            button10.setOnAction(e->{
                System.out.println("查询成功！");
            });
        }
    }
    @Override
    public Pane getView() {
        return searchPane;
    }
}
