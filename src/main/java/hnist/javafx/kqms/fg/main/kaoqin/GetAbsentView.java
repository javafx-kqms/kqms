package hnist.javafx.kqms.fg.main.kaoqin;

import hnist.javafx.kqms.fg.main.View;
import hnist.javafx.kqms.pojo.Kaoqin;
import hnist.javafx.kqms.pojo.Student;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.converter.ByteStringConverter;
import javafx.util.converter.DateStringConverter;

import java.util.Date;

public class GetAbsentView extends View {
    @Override
    public String getName() {
        return "操作学生信息";
    }

    @Override
    public Pane initView() {
        Label courseNameLabel = new Label("课程名");
        TextField courseNameTF = new TextField();
        Label studentNameLabel = new Label("姓名");
        TextField studentNameTF = new TextField();
        Button searchButton = new Button("搜索");
        Label label = new Label("若没有填入搜索信息则显示全部缺课信息");
        Label unfindLabel = new Label("该学生信息不存在！");
        unfindLabel.setTextFill(Color.RED);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(courseNameLabel, 0, 0);
        gridPane.add(courseNameTF, 1, 0);
        gridPane.add(studentNameLabel, 2, 0);
        gridPane.add(studentNameTF, 3, 0);
        gridPane.add(searchButton, 4, 0);
        gridPane.add(label, 0, 1);
        GridPane.setConstraints(label, 0, 1, 2, 1);

        TableView<Kaoqin> kaoqinIfo = new TableView<>();
        TableColumn<Kaoqin, Date> dateColumn = new TableColumn<>("缺课日期");
        TableColumn<Kaoqin, String> nameColumn = new TableColumn<>("学生姓名");
        TableColumn<Kaoqin,String> courseNameColumn = new TableColumn<>("课程名称");
        TableColumn<Kaoqin, Byte> courseSectionColumn = new TableColumn<>("第几节课");
        TableColumn<Kaoqin,String> typeColumn = new TableColumn<>("缺课类型");
        TableColumn<Kaoqin,String> studentNoColumn = new TableColumn<>("缺课学号");
        dateColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        courseNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        courseSectionColumn.setCellFactory(TextFieldTableCell.forTableColumn(new ByteStringConverter()));
        courseSectionColumn.setCellValueFactory(new PropertyValueFactory<>("courseSection"));
        typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        studentNoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        studentNoColumn.setCellValueFactory(new PropertyValueFactory<>("studentNo"));
        kaoqinIfo.getColumns().addAll(dateColumn,nameColumn,courseNameColumn,courseSectionColumn,typeColumn,studentNoColumn);

        dateColumn.setPrefWidth(100);
        nameColumn.setPrefWidth(100);
        courseNameColumn.setPrefWidth(100);
        courseSectionColumn.setPrefWidth(100);
        typeColumn.setPrefWidth(100);
        studentNoColumn.setPrefWidth(100);

        gridPane.add(kaoqinIfo,0,3);
        GridPane.setConstraints(kaoqinIfo,0,3,6,1);

        //查询缺课信息
        searchButton.setOnAction(e->{
            removeLabelFromGridPane(gridPane,unfindLabel);
            String courseStr;
            String studentNameStr;
            if(courseNameTF.getText().isEmpty()){
                courseStr = null;
            }else{
                courseStr = courseNameTF.getText();
            }
            if(studentNameTF.getText().isEmpty()){
                studentNameStr = null;
            }else{
                studentNameStr = studentNameTF.getText();
            }

        });

        //编辑缺课信息


        return gridPane;
    }

    private void removeLabelFromGridPane(GridPane gridPane, Label labelToRemove) {
        gridPane.getChildren().removeIf(node -> node == labelToRemove);
    }

}
