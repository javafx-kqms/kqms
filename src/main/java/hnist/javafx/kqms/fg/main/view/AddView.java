package hnist.javafx.kqms.fg.main.view;

import hnist.javafx.kqms.bg.controller.KaoqinController;
import hnist.javafx.kqms.bg.controller.StudentController;
import hnist.javafx.kqms.pojo.Kaoqin;
import hnist.javafx.kqms.pojo.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddView implements View {
    private final Pane addPane = initView();

    StudentController studentController = new StudentController();
    KaoqinController kaoqinController = new KaoqinController();

    @Override
    public Pane getView() {
        return addPane;
    }

    @Override
    public String getName() {
        return "添加信息";
    }

    private Pane initView() {
        Pane root = new Pane();

        Label label1 = new Label("请选择添加类别");
        Label label2 = new Label("请输入信息");
        Label label21 = new Label("请输入信息");
        Label label22 = new Label("请输入信息");
        Button chooseStudenInfoButton = new Button("学生信息");
        Button chooseAbsentInfoButton = new Button("缺课信息");
        Button addStudentInfoButton = new Button("添加学生信息");
        Button addAbsentInfoButton = new Button("添加缺课信息");

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

        TextField absentInfoData = new TextField();
        absentInfoData.setPromptText("缺课日期");
        TextField absentInfoCourseSection = new TextField();
        absentInfoCourseSection.setPromptText("第几节课");
        TextField absentInfoCourseName = new TextField();
        absentInfoCourseName.setPromptText("课程名称");
        TextField absentInfoStudentName = new TextField();
        absentInfoStudentName.setPromptText("学生姓名");
        TextField absentInfoStudentNumber = new TextField();
        absentInfoStudentNumber.setPromptText("学号");

        ObservableList<String> options = FXCollections.observableArrayList(
                "迟到", "早退", "请假", "旷课"
        );
        ComboBox<String> comboBox = new ComboBox<>(options);
        comboBox.setPromptText("选择缺课类型");

        label1.setLayoutX(50);
        label1.setLayoutY(50);
        chooseStudenInfoButton.setLayoutX(170);
        chooseStudenInfoButton.setLayoutY(50);
        chooseAbsentInfoButton.setLayoutX(300);
        chooseAbsentInfoButton.setLayoutY(50);
        root.getChildren().addAll(label2, chooseStudenInfoButton, chooseAbsentInfoButton);

        //添加学生信息
        chooseStudenInfoButton.setOnAction(e -> {
            label2.setLayoutX(50);
            label2.setLayoutY(300);
            studentInfoNumber.setLayoutX(170);
            studentInfoNumber.setLayoutY(300);
            studentInfoName.setLayoutX(290);
            studentInfoName.setLayoutY(300);
            studentInfoSex.setLayoutX(410);
            studentInfoSex.setLayoutY(300);
            studentInfoAge.setLayoutX(530);
            studentInfoAge.setLayoutY(300);
            studentInfoClass.setLayoutX(650);
            studentInfoClass.setLayoutY(300);
            addStudentInfoButton.setLayoutX(770);
            addStudentInfoButton.setLayoutY(300);
            root.getChildren().addAll(label21, studentInfoNumber, studentInfoName, studentInfoSex, studentInfoAge, studentInfoClass, addStudentInfoButton);
        });

        //提取输入框中的学生信息
        addStudentInfoButton.setOnAction(e -> {

            //与数据库中的学号进行对比
            if (studentController.getStudentIfExistByNo(studentInfoNumber.getText())) {
                //不重复则填入数据库
                studentController.addStudent(new Student(studentInfoNumber.getText(), studentInfoName.getText(), studentInfoSex.getText(), Short.parseShort(studentInfoAge.getText()), studentInfoClass.getText()));
            } else {
                //学号重复
                Label label = new Label("学号重复！");
                label.setLayoutX(50);
                label.setLayoutY(90);
                label.setTextFill(Color.RED);

                root.getChildren().add(label);
            }

            studentInfoNumber.clear();
            studentInfoName.clear();
            studentInfoSex.clear();
            studentInfoAge.clear();
            studentInfoClass.clear();
        });

        //添加缺课信息
        chooseAbsentInfoButton.setOnAction(e -> {
            label22.setLayoutX(50);
            label22.setLayoutY(100);
            absentInfoStudentNumber.setLayoutX(170);
            absentInfoStudentName.setLayoutY(100);
            absentInfoData.setLayoutX(170);
            absentInfoData.setLayoutY(150);
            absentInfoCourseSection.setLayoutX(290);
            absentInfoCourseSection.setLayoutY(150);
            absentInfoCourseName.setLayoutX(410);
            absentInfoCourseName.setLayoutY(150);
            absentInfoStudentName.setLayoutX(530);
            absentInfoStudentName.setLayoutY(150);
            comboBox.setLayoutX(650);
            comboBox.setLayoutY(150);
            addAbsentInfoButton.setLayoutX(770);
            addAbsentInfoButton.setLayoutY(150);
            root.getChildren().addAll(label22, absentInfoStudentNumber, absentInfoData, absentInfoCourseSection, absentInfoCourseName, absentInfoStudentName, comboBox, addAbsentInfoButton);
        });


        //提取输入框中的缺课信息

        addAbsentInfoButton.setOnAction(e -> {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            try {
                date = sdf.parse(absentInfoData.getText());
            }catch (ParseException pe){
                pe.printStackTrace();
            }

            if(kaoqinController.getKaoqinIfExistByDateAndSection(date,Byte.parseByte(absentInfoCourseSection.getText()))){
                kaoqinController.addKaoqin(new Kaoqin(date,absentInfoCourseName.getText(),Byte.parseByte(absentInfoCourseSection.getText()),absentInfoStudentName.getText(),comboBox.getSelectionModel().toString(),studentInfoName.getText()));
            }else{
                //信息重复
                Label label = new Label("缺课信息重复！");
                label.setLayoutX(50);
                label.setLayoutY(90);
                label.setTextFill(Color.RED);

                root.getChildren().add(label);
            }

        });

        return root;
    }
}
