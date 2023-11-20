package hnist.javafx.kqms.fg.main.file_operation;

import hnist.javafx.kqms.fg.main.View;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class FileOperationView extends View {

    @Override
    public String getName() {
        return "导入导出";
    }

    @Override
    protected Pane initView() {

        Button importStudentInfoButton = new Button("导入学生信息");
        Button importAbsentInfoButton = new Button("导入缺课信息");
        Button importStudentInfoFileButton = new Button("浏览");
        Button importAbsentInfoFileButton = new Button("浏览");
        Button exportStudentInfoButton = new Button("导出学生信息");
        Button exportAbsentInfoButton = new Button("导出缺课信息");
        Button exportStudentInfoFileButton = new Button("浏览");
        Button exportAbsentInfoFileButton = new Button("浏览");

        Label importLabel = new Label("导入");
        Label exportLabel = new Label("导出");
        importLabel.setFont(new Font("Arial",20));
        exportLabel.setFont(new Font("Arial",20));

        //使用TextArea存放“浏览”按钮获取的文件路径，可供用户进行修改
        TextArea importStudentInfoTA = new TextArea();
        importStudentInfoTA.setPrefSize(250,20);
        TextArea importAbsentInfoTA = new TextArea();
        importAbsentInfoTA.setPrefSize(250,20);
        TextArea exportStudentIfoTA = new TextArea();
        exportStudentIfoTA.setPrefSize(250,20);
        TextArea exportAbsentInfoTA = new TextArea();
        exportAbsentInfoTA.setPrefSize(250,20);


        //导入学生信息的按钮
        importStudentInfoFileButton.setOnAction(e->{
            //TODO
//            importStudentInfoTA.appendText(getFilePath());
        });

        //导入缺课信息的按钮
        importAbsentInfoFileButton.setOnAction(e->{
            //TODO
//            importAbsentInfoTA.appendText(getFilePath());
        });

        //导出学生信息的按钮
        importStudentInfoFileButton.setOnAction(e->{
            //TODO
//            exportStudentInfoTA.appendText(getFilePath());
        });

        //导出缺课信息的按钮
        importAbsentInfoFileButton.setOnAction(e->{
            //TODO
//            exportAbsentInfoTA.appendText(getFilePath());
        });

        GridPane gridPane = new GridPane();
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.add(importLabel,0,0);
        gridPane.add(importStudentInfoTA,1,1);
        gridPane.add(importStudentInfoFileButton,2,1);
        gridPane.add(importStudentInfoButton,3,1);
        gridPane.add(importAbsentInfoTA,1,2);
        gridPane.add(importAbsentInfoFileButton,2,2);
        gridPane.add(importAbsentInfoButton,3,2);
        gridPane.add(exportLabel,0,3);
        gridPane.add(exportStudentIfoTA,1,4);
        gridPane.add(exportStudentInfoFileButton,2,4);
        gridPane.add(exportStudentInfoButton,3,4);
        gridPane.add(exportAbsentInfoTA,1,5);
        gridPane.add(exportAbsentInfoFileButton,2,5);
        gridPane.add(exportAbsentInfoButton,3,5);

        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }

    //使用FileChooser打开本地文件，获取文件路径
    private String getFilePath(Stage stage){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        return file.getAbsolutePath();
    }

}
