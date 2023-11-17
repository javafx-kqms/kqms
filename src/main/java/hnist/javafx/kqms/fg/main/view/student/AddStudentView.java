package hnist.javafx.kqms.fg.main.view.student;

import hnist.javafx.kqms.bg.controller.StudentController;
import hnist.javafx.kqms.fg.main.view.View;
import hnist.javafx.kqms.pojo.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
        Label studentNumberLabel = new Label("学号");
        TextField studentInfoNumber = new TextField();
        studentInfoNumber.setPromptText("不超过11位");
        Label studentNameLabel = new Label("姓名");
        TextField studentInfoName = new TextField();
        studentInfoName.setPromptText("不超过5个字");
        Label stduentSexLabel = new Label("性别");
        Label studentAgeLabel = new Label("年龄");
        TextField studentInfoAge = new TextField();
        Label studentClassLabel = new Label("班级");
        TextField studentInfoClass = new TextField();
        studentInfoClass.setPromptText("计科21-2BJ");
        Button addStudentInfoButton = new Button("添加");
        addStudentInfoButton.setPrefSize(250,10);

        ObservableList<String> options = FXCollections.observableArrayList(
                "男", "女"
        );
        ComboBox<String> comboBox = new ComboBox<>(options);
        comboBox.setPromptText("选择性别");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(promptLabel,1,0);
        gridPane.add(studentNumberLabel,1,1);
        gridPane.add(studentInfoNumber,2,1);
        gridPane.add(studentNameLabel,1,2);
        gridPane.add(studentInfoName,2,2);
        gridPane.add(stduentSexLabel,1,3);
        gridPane.add(comboBox,2,3);
        gridPane.add(studentAgeLabel,1,4);
        gridPane.add(studentInfoAge,2,4);
        gridPane.add(studentClassLabel,1,5);
        gridPane.add(studentInfoClass,2,5);
        gridPane.add(addStudentInfoButton,1,6);
        GridPane.setConstraints(addStudentInfoButton,1,6,2,1);

        gridPane.setAlignment(Pos.CENTER);


        //提取输入框中的学生信息
        addStudentInfoButton.setOnAction(e -> {

            //与数据库中的学号进行对比
            if (StudentController.getStudentIfExistByNo(studentInfoNumber.getText())) {
                //不重复则填入数据库
                StudentController.addStudent(new Student(studentInfoNumber.getText(), studentInfoName.getText(), comboBox.getValue(), Short.parseShort(studentInfoAge.getText()), studentInfoClass.getText()));
                Label successLabel = new Label("添加成功！");
                gridPane.add(successLabel,2,7);
            } else {
                //学号重复
                Label repeatLabel = new Label("学号重复！");
                repeatLabel.setTextFill(Color.RED);
                gridPane.add(repeatLabel,1,7);
            }

            studentInfoNumber.clear();
            studentInfoName.clear();
            studentInfoAge.clear();
            studentInfoClass.clear();
        });



        // TODO
        return gridPane;
    }
}
