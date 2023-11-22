package hnist.javafx.kqms.fg.main.file_operation;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import hnist.javafx.kqms.KqmsApplication;
import hnist.javafx.kqms.bg.controller.KaoqinController;
import hnist.javafx.kqms.bg.controller.StudentController;
import hnist.javafx.kqms.fg.main.View;
import hnist.javafx.kqms.pojo.Kaoqin;
import hnist.javafx.kqms.pojo.Student;
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

import java.util.ArrayList;
import java.util.List;

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
        importLabel.setFont(new Font("Arial", 20));
        exportLabel.setFont(new Font("Arial", 20));

        //使用TextArea存放“浏览”按钮获取的文件路径，可供用户进行修改
        TextArea importStudentInfoTA = new TextArea();
        importStudentInfoTA.setPrefSize(250,20);
        TextArea importAbsentInfoTA = new TextArea();
        importAbsentInfoTA.setPrefSize(250,20);
        TextArea exportStudentIfoTA = new TextArea();
        exportStudentIfoTA.setPrefSize(250,20);
        TextArea exportAbsentInfoTA = new TextArea();
        exportAbsentInfoTA.setPrefSize(250,20);

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

        //导入学生信息的按钮
        importStudentInfoFileButton.setOnAction(e->{
           importStudentInfoTA.appendText(KqmsApplication.getFilePath(KqmsApplication.getStage()));

        });
        //点击"导入学生信息"
        importStudentInfoButton.setOnAction(e->{
            studentIn(importStudentInfoTA.getText());
            importStudentInfoTA.clear();
        });

        //导入缺课信息的按钮
        importAbsentInfoFileButton.setOnAction(e->{
            importAbsentInfoTA.appendText(KqmsApplication.getFilePath(KqmsApplication.getStage()));
        });
        //点击"导入缺课信息"
        importAbsentInfoButton.setOnAction(e->{
            kaoqinIn(importAbsentInfoTA.getText());
            importAbsentInfoTA.clear();
        });

        //导出学生信息的按钮
        exportStudentInfoFileButton.setOnAction(e->{
            exportStudentIfoTA.appendText(KqmsApplication.getDirectPath(KqmsApplication.getStage()));
        });
        //点击"导出学生信息"
        exportStudentInfoButton.setOnAction(e->{
            studentOut(exportStudentIfoTA.getText());
            exportStudentIfoTA.clear();
        });

        //导出缺课信息的按钮
        exportAbsentInfoFileButton.setOnAction(e->{
            exportAbsentInfoTA.appendText(KqmsApplication.getDirectPath(KqmsApplication.getStage()));
        });
        //点击"导出缺课信息"
        exportAbsentInfoButton.setOnAction(e->{
            kaoqinOut(exportStudentIfoTA.getText());
            exportAbsentInfoTA.clear();
        });

        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }


    private void studentIn(String path) {
        EasyExcel.read(path, Student.class, new ReadListener<Student>() {
            private final List<Student> data = new ArrayList<>();

            @Override
            public void invoke(Student student, AnalysisContext analysisContext) {
                data.add(student);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                StudentController.addStudentByList(data);
            }
        }).sheet().doRead();
    }

    private void studentOut(String path) {
        List<Student> data = StudentController.getStudent(null, null);
        EasyExcel.write(path + "学生信息.xlsx", Student.class).sheet().doWrite(data);
    }

    private void kaoqinIn(String path) {
        EasyExcel.read(path, Student.class, new ReadListener<Kaoqin>() {
            private final List<Kaoqin> data = new ArrayList<>();
            @Override
            public void invoke(Kaoqin kaoqin, AnalysisContext analysisContext) {
                data.add(kaoqin);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                KaoqinController.addKaoqinByList(data);
            }
        }).sheet().doRead();
    }

    private void kaoqinOut(String path) {
        List<Kaoqin> data = KaoqinController.getKaoqin(null, null);
        EasyExcel.write(path + "考勤信息.xlsx", Student.class).sheet().doWrite(data);
    }
}
