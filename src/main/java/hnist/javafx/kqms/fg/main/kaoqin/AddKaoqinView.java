package hnist.javafx.kqms.fg.main.kaoqin;

import hnist.javafx.kqms.bg.controller.KaoqinController;
import hnist.javafx.kqms.fg.main.View;
import hnist.javafx.kqms.pojo.Kaoqin;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddKaoqinView extends View {
    @Override
    public String getName() {
        return "添加考勤信息";
    }

    @Override
    protected Pane initView() {
        Label confirmLabel = new Label("添加成功！");
        Label confirmLabel2 = new Label("缺课信息重复！");
        confirmLabel2.setTextFill(Color.RED);


        Label absentPromptLabel = new Label("请填写必要缺课信息");
        Label absentDateLabel = new Label("缺课日期");
        TextField absentDateTF = new TextField();
        absentDateTF.setPromptText("2023-11-18");
        Label courseSectionLabel = new Label("第几节课");
        TextField courseSectionTF = new TextField();
        Label courseNameLabel = new Label("课程名称");
        TextField courseNameTF = new TextField();
        Label studentNameLabel = new Label("学生姓名");
        TextField studentNameTF = new TextField();
        Label absentTypeLabel = new Label("缺课类型");
        ObservableList<String> options = FXCollections.observableArrayList(
                "迟到", "早退", "请假", "旷课"
        );
        ComboBox<String> comboBox = new ComboBox<>(options);
        comboBox.setPromptText("选择缺课类型");
        Label studentNoLabel = new Label("学号");
        TextField studentNoTF = new TextField();
        Button addAbsentInfoButton = new Button("添加");
        addAbsentInfoButton.setPrefSize(250, 10);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(absentPromptLabel, 1, 0);
        gridPane.add(absentDateLabel, 1, 1);
        gridPane.add(absentDateTF, 2, 1);
        gridPane.add(courseSectionLabel, 1, 2);
        gridPane.add(courseSectionTF, 2, 2);
        gridPane.add(courseNameLabel, 1, 3);
        gridPane.add(courseNameTF, 2, 3);
        gridPane.add(studentNameLabel, 1, 4);
        gridPane.add(studentNameTF, 2, 4);
        gridPane.add(absentTypeLabel, 1, 5);
        gridPane.add(comboBox, 2, 5);
        gridPane.add(studentNoLabel, 1, 6);
        gridPane.add(studentNoTF,2,6);
        gridPane.add(addAbsentInfoButton,1,7);
        GridPane.setConstraints(addAbsentInfoButton, 1, 7, 2, 1);

        gridPane.setAlignment(Pos.CENTER);

        addAbsentInfoButton.setOnAction(e->{
            removeLabelFromGridPane(gridPane,confirmLabel);
            removeLabelFromGridPane(gridPane,confirmLabel2);
            try {
                if(KaoqinController.getKaoqinIfExist(getStringToData(absentDateTF.getText()),Byte.parseByte(courseSectionTF.getText()))){
                    KaoqinController.addKaoqin(new Kaoqin(getStringToData(absentDateTF.getText()), courseNameTF.getText(),
                                                            Byte.parseByte(courseSectionTF.getText()),comboBox.getValue(),
                                                                studentNameTF.getText(),studentNoTF.getText()));

                    gridPane.add(confirmLabel,2,8);
                    System.out.println("学生信息" + new Kaoqin(getStringToData(absentDateTF.getText()), courseNameTF.getText(),
                            Byte.parseByte(courseSectionTF.getText()),comboBox.getValue(),
                            studentNameTF.getText(),studentNoTF.getText()));
                } else {
                    gridPane.add(confirmLabel2,1,8);
                }
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            comboBox.getSelectionModel().clearSelection();
            absentDateTF.clear();
            courseSectionTF.clear();
            courseNameTF.clear();
            studentNameTF.clear();
            studentNoTF.clear();

        });

        return gridPane;
    }

    public Date getStringToData(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(str);
    }
    private void removeLabelFromGridPane(GridPane gridPane, Label labelToRemove) {
        gridPane.getChildren().removeIf(node -> node == labelToRemove);
    }
}
