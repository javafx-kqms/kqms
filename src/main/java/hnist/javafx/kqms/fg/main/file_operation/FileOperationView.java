package hnist.javafx.kqms.fg.main.file_operation;

import hnist.javafx.kqms.fg.main.View;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class FileOperationView extends View {

    @Override
    public String getName() {
        return "导入导出";
    }

    @Override
    protected Pane initView() {

        Button importStudentInfoButton = new Button("导入学生信息");
        Button importAbsentInfoButton = new Button("导入缺课信息");
        Button exportStudentInfoButton = new Button("导出学生信息");
        Button exportAbsentInfoButton = new Button("导出缺课信息");

        Label importLabel = new Label("导入");
        Label exportLabel = new Label("导出");
        importLabel.setFont(new Font("Arial",20));
        exportLabel.setFont(new Font("Arial",20));

        TextField importStudentInfoTF = new TextField();
        TextField importAbsentInfoTF = new TextField();
        TextField exportStudentIfoTF = new TextField();
        TextField exportAbsentInfoTF = new TextField();

        GridPane gridPane = new GridPane();
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.add(importLabel,0,0);
        gridPane.add(importStudentInfoTF,1,1);
        gridPane.add(importStudentInfoButton,2,1);
        gridPane.add(importAbsentInfoTF,1,2);
        gridPane.add(importAbsentInfoButton,2,2);
        gridPane.add(exportLabel,0,3);
        gridPane.add(exportStudentIfoTF,1,4);
        gridPane.add(exportStudentInfoButton,2,4);
        gridPane.add(exportAbsentInfoTF,1,5);
        gridPane.add(exportAbsentInfoButton,2,5);


        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }
}
