package hnist.javafx.kqms.fg.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AddPage implements View{
    Pane addPane = new Pane();
    class add extends Application{

        @Override
        public void start(Stage stage) throws Exception {

            Label label1 = new Label("请选择添加类别");
            Label label2 = new Label("请输入信息");
            Button button = new Button("学生信息");
            Button button1 = new Button("缺课信息");
            Button button2 = new Button("添加学生信息");
            Button button3 = new Button("添加缺课信息");

            TextField t1 = new TextField();t1.setPromptText("学号");
            TextField t2 = new TextField();t2.setPromptText("姓名");
            TextField t3 = new TextField();t3.setPromptText("性别");
            TextField t4 = new TextField();t4.setPromptText("年龄");
            TextField t5 = new TextField();t5.setPromptText("班级");

            TextField t11 = new TextField();t11.setPromptText("缺课日期");
            TextField t22 = new TextField();t22.setPromptText("第几节课");
            TextField t33 = new TextField();t33.setPromptText("课程名称");
            TextField t44 = new TextField();t44.setPromptText("学生姓名");

            ObservableList<String> options = FXCollections.observableArrayList(
                    "迟到","早退","请假","旷课"
            );
            ComboBox<String> comboBox = new ComboBox<>(options);
            comboBox.setPromptText("选择缺课类型");

            label1.setLayoutX(50);label1.setLayoutY(50);
            button.setLayoutX(170);button.setLayoutY(50);
            button1.setLayoutX(300);button1.setLayoutY(50);
            addPane.getChildren().addAll(label2,button,button1);

            //添加学生信息
            button.setOnAction(e->{
                label2.setLayoutX(50);label2.setLayoutY(100);
                t1.setLayoutX(170);t1.setLayoutY(100);
                t2.setLayoutX(290);t2.setLayoutY(100);
                t3.setLayoutX(410);t3.setLayoutY(100);
                t4.setLayoutX(530);t4.setLayoutY(100);
                t5.setLayoutX(650);t5.setLayoutY(100);
                button2.setLayoutX(770);button2.setLayoutY(100);
                addPane.getChildren().addAll(label2,t1,t2,t3,t4,t5,button2);
            });
            button2.setOnAction(e->{
                //学号重复
                Label label = new Label("学号重复！");
                label.setLayoutX(50);label.setLayoutY(90);
                label.setTextFill(Color.RED);
                t1.clear();t2.clear();t3.clear();t4.clear();t5.clear();
                addPane.getChildren().add(label);
            });

            //添加缺课信息
            button1.setOnAction(e->{
                label2.setLayoutX(50);label2.setLayoutY(100);
                t1.setLayoutX(170);t1.setLayoutY(100);
                t11.setLayoutX(170);t11.setLayoutY(150);
                t22.setLayoutX(290);t22.setLayoutY(150);
                t33.setLayoutX(410);t33.setLayoutY(150);
                t44.setLayoutX(530);t44.setLayoutY(150);
                comboBox.setLayoutX(650);comboBox.setLayoutY(150);
                button3.setLayoutX(770);button3.setLayoutY(150);
                addPane.getChildren().addAll(label2,t1,t11,t22,t33,t44,comboBox,button3);
            });
            button3.setOnAction(e->{
                System.out.println("添加缺课记录成功！");
            });

        }
    }

    @Override
    public Pane getView() {
        return addPane;
    }


}
