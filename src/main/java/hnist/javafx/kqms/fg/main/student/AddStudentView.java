package hnist.javafx.kqms.fg.main.student;

import hnist.javafx.kqms.bg.controller.StudentController;
import hnist.javafx.kqms.fg.main.View;
import hnist.javafx.kqms.pojo.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AddStudentView extends View {
    @Override
    public String getName() {
        return "添加学生信息";
    }

    @Override
    public Pane initView() {
        Label successLabel = new Label("添加成功！");
        Label repeatLabel = new Label("学号重复！");
        repeatLabel.setTextFill(Color.RED);

        Label promptLabel = new Label("请填写必要学生信息");
        promptLabel.setFont(new Font("Arial",20));
        Label studentNumberLabel = new Label("学号");
        studentNumberLabel.setFont(new Font("Arial",15));
        TextField studentInfoNumber = new TextField();
        studentInfoNumber.setPromptText("不超过11位");
        Label studentNameLabel = new Label("姓名");
        studentNameLabel.setFont(new Font("Arial",15));
        TextField studentInfoName = new TextField();
        studentInfoName.setPromptText("不超过5个字");
        Label stduentSexLabel = new Label("性别");
        stduentSexLabel.setFont(new Font("Arial",15));
        Label studentAgeLabel = new Label("年龄");
        studentAgeLabel.setFont(new Font("Arial",15));
        TextField studentInfoAge = new TextField();
        Label studentClassLabel = new Label("班级");
        studentClassLabel.setFont(new Font("Arial",15));
        TextField studentInfoClass = new TextField();
        studentInfoClass.setPromptText("计科21-2BJ");
        Button addStudentInfoButton = new Button("添加");
        addStudentInfoButton.setPrefSize(250, 10);

        ObservableList<String> options = FXCollections.observableArrayList(
                "男", "女"
        );
        ComboBox<String> comboBox = new ComboBox<>(options);
        comboBox.setPromptText("选择性别");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(promptLabel, 1, 0);
        gridPane.add(studentNumberLabel, 1, 1);
        gridPane.add(studentInfoNumber, 2, 1);
        gridPane.add(studentNameLabel, 1, 2);
        gridPane.add(studentInfoName, 2, 2);
        gridPane.add(stduentSexLabel, 1, 3);
        gridPane.add(comboBox, 2, 3);
        gridPane.add(studentAgeLabel, 1, 4);
        gridPane.add(studentInfoAge, 2, 4);
        gridPane.add(studentClassLabel, 1, 5);
        gridPane.add(studentInfoClass, 2, 5);
        gridPane.add(addStudentInfoButton, 1, 6);
        GridPane.setConstraints(promptLabel,1,0,2,1);
        GridPane.setConstraints(addStudentInfoButton, 1, 6, 2, 1);

        gridPane.setAlignment(Pos.CENTER);


        //提取输入框中的学生信息
        addStudentInfoButton.setOnAction(e -> {
            removeLabelFromGridPane(gridPane,successLabel);
            removeLabelFromGridPane(gridPane,repeatLabel);

            //与数据库中的学号进行对比
            if (StudentController.getStudentIfExist(studentInfoNumber.getText())) {
                //不重复则填入数据库
                StudentController.addStudent(new Student(studentInfoNumber.getText(), studentInfoName.getText(),
                                                            comboBox.getValue(), Short.parseShort(studentInfoAge.getText()),
                                                                studentInfoClass.getText()));

                gridPane.add(successLabel, 2, 7);

            } else {
                //学号重复
                gridPane.add(repeatLabel, 1, 7);

            }
            comboBox.getSelectionModel().clearSelection();
            studentInfoNumber.clear();
            studentInfoName.clear();
            studentInfoAge.clear();
            studentInfoClass.clear();
        });

        return gridPane;
    }
    private void removeLabelFromGridPane(GridPane gridPane, Label labelToRemove) {
        gridPane.getChildren().removeIf(node -> node == labelToRemove);
    }
}
