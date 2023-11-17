package hnist.javafx.kqms.fg.main.view.student;

import hnist.javafx.kqms.bg.controller.StudentController;
import hnist.javafx.kqms.fg.main.view.View;
import hnist.javafx.kqms.pojo.Student;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class AddStudentView extends View {
    @Override
    public String getName() {
        // TODO
        return "添加学生信息";
    }

    @Override
    public Pane initView() {
        Label promptLabel =new Label("请填写必要信息");
        TextField studentInfoNumber = new TextField();
        studentInfoNumber.setPromptText("学号");
        TextField studentInfoName = new TextField();
        studentInfoName.setPromptText("姓名");
        TextField studentInfoSex = new TextField();
        studentInfoSex.setPromptText("性别");
        TextField studentInfoAge = new TextField();
        studentInfoAge.setPromptText("年龄");
        TextField studentInfoClass = new TextField();
        studentInfoClass.setPromptText("班级");
        Button addStudentInfoButton = new Button("添加");

        promptLabel.setLayoutX(100);
        promptLabel.setLayoutY(100);
        studentInfoNumber.setLayoutX(100);
        studentInfoNumber.setLayoutY(300);
        studentInfoName.setLayoutX(250);
        studentInfoName.setLayoutY(300);
        studentInfoSex.setLayoutX(400);
        studentInfoSex.setLayoutY(300);
        studentInfoAge.setLayoutX(550);
        studentInfoAge.setLayoutY(300);
        studentInfoClass.setLayoutX(700);
        studentInfoClass.setLayoutY(300);
        addStudentInfoButton.setLayoutX(850);
        addStudentInfoButton.setLayoutY(300);

        Pane pane = new Pane();
        pane.getChildren().addAll(promptLabel, studentInfoNumber, studentInfoName, studentInfoSex, studentInfoAge, studentInfoClass, addStudentInfoButton);

        //提取输入框中的学生信息
        addStudentInfoButton.setOnAction(e -> {

            //与数据库中的学号进行对比
            if (StudentController.getStudentIfExistByNo(studentInfoNumber.getText())) {
                //不重复则填入数据库
                StudentController.addStudent(new Student(studentInfoNumber.getText(), studentInfoName.getText(), studentInfoSex.getText(), Short.parseShort(studentInfoAge.getText()), studentInfoClass.getText()));
            } else {
                //学号重复
                Label repeatLabel = new Label("学号重复！");
                repeatLabel.setLayoutX(100);
                repeatLabel.setLayoutY(350);
                repeatLabel.setTextFill(Color.RED);

                pane.getChildren().add(repeatLabel);
            }

            studentInfoNumber.clear();
            studentInfoName.clear();
            studentInfoSex.clear();
            studentInfoAge.clear();
            studentInfoClass.clear();
        });


        // TODO
        return pane;
    }
}
