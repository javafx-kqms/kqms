package hnist.javafx.kqms.fg.main.view.student;

import hnist.javafx.kqms.bg.controller.StudentController;
import hnist.javafx.kqms.fg.main.view.View;
import hnist.javafx.kqms.pojo.Student;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

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
        Label unfindLabel = new Label("该学生信息不存在");
        unfindLabel.setTextFill(Color.RED);

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

        TableView<Student> studentIfo = new TableView<Student>();
        TableColumn numberColumn = new TableColumn("学号");
        TableColumn nameColumn = new TableColumn("姓名");
        TableColumn sexColumn = new TableColumn("性别");
        TableColumn ageColumn = new TableColumn("年龄");
        TableColumn classNameColumn = new TableColumn("班级");
        nameColumn.setPrefWidth(100);
        numberColumn.setPrefWidth(100);
        sexColumn.setPrefWidth(100);
        ageColumn.setPrefWidth(100);
        classNameColumn.setPrefWidth(100);

        studentIfo.getColumns().addAll(numberColumn,nameColumn,sexColumn,ageColumn,classNameColumn);
        gridPane.add(studentIfo,0,3);
        GridPane.setConstraints(studentIfo,0,3,5,1);

        searchButton.setOnAction(e->{
            if(studentNumber.getText().isEmpty() && studentName.getText().isEmpty()){
                //TODO
                // 返回全部学生信息到studentInfo表中
            }else if(!studentNumber.getText().isEmpty() && studentName.getText().isEmpty()){
                if(StudentController.getStudentIfExistByNo(studentNumber.getText())){
                    //TODO
                    // 将与studentNumber.getText()相同的学号的信息写入表中

                }else{
                    gridPane.add(unfindLabel,0,2);
                }
            }else if(studentNumber.getText().isEmpty() && !studentName.getText().isEmpty()){
                //TODO
                // 比较是否有与输入的姓名相同的记录
            }
        });

        return gridPane;
    }
}
