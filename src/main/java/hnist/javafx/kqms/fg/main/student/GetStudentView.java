package hnist.javafx.kqms.fg.main.student;

import hnist.javafx.kqms.bg.controller.StudentController;
import hnist.javafx.kqms.fg.main.View;
import hnist.javafx.kqms.pojo.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.TableColumn;
import javafx.util.converter.ShortStringConverter;


import java.util.Optional;

public class GetStudentView extends View {
    @Override
    public String getName() {
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
        Label unfindLabel = new Label("该学生信息不存在！");
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

        TableView<Student> studentIfo = new TableView<>();
        TableColumn<Student, String> numberColumn = new TableColumn<>("学号");
        TableColumn<Student, String> nameColumn = new TableColumn<>("姓名");
        TableColumn<Student, String> sexColumn = new TableColumn<>("性别");
        TableColumn<Student, Short> ageColumn = new TableColumn<>("年龄");
        TableColumn<Student, String> classNameColumn = new TableColumn<>("班级");
        numberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("no"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        sexColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        sexColumn.setCellValueFactory(new PropertyValueFactory<>("sex"));
        ageColumn.setCellFactory(TextFieldTableCell.forTableColumn(new ShortStringConverter()));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        classNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        classNameColumn.setCellValueFactory(new PropertyValueFactory<>("className"));
        studentIfo.getColumns().addAll(numberColumn,nameColumn,sexColumn,ageColumn,classNameColumn);

        nameColumn.setPrefWidth(100);
        numberColumn.setPrefWidth(100);
        sexColumn.setPrefWidth(100);
        ageColumn.setPrefWidth(100);
        classNameColumn.setPrefWidth(100);

        gridPane.add(studentIfo,0,3);
        GridPane.setConstraints(studentIfo,0,3,5,1);

        searchButton.setOnAction(e->{
            removeLabelFromGridPane(gridPane,unfindLabel);
            String numberStr;
            if(studentNumber.getText().isEmpty()){
                 numberStr = null;
            }else{
                numberStr = studentNumber.getText();
            }
            String nameStr ;
            if(studentName.getText().isEmpty()){
                nameStr = null;
            }else{
                nameStr = studentName.getText();
            }

            ObservableList<Student> list = FXCollections.observableArrayList(StudentController.getStudentByNoAndName(numberStr,nameStr));
            if(!StudentController.getStudentIfExistByNo(numberStr)){
                studentIfo.setItems(list);
            }else{
                gridPane.add(unfindLabel,0,4);
            }
        });

        // 添加按钮到每一行
        studentIfo.setRowFactory(tv -> {
            TableRow<Student> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    Student student = row.getItem();
                    Alert operatAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    operatAlert.setTitle("操作");
                    operatAlert.setHeaderText("请选择操作");

                    ButtonType modifyButtonType = new ButtonType("修改");
                    ButtonType deleteButtonType = new ButtonType("删除");
                    operatAlert.getButtonTypes().setAll(modifyButtonType, deleteButtonType);
                    Optional<ButtonType> result = operatAlert.showAndWait();
                    if (result.isPresent() && result.get() == modifyButtonType) {
                        //TODO
                        // 显示修改界面
                    } else if (result.isPresent() && result.get() == deleteButtonType) {
                        operatAlert = new Alert(Alert.AlertType.CONFIRMATION);
                        operatAlert.setTitle("确认删除");
                        operatAlert.setHeaderText("确定要删除该学生信息吗？" + student.toString());
                        operatAlert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
                        Optional<ButtonType> confirmResult = operatAlert.showAndWait();
                        if (confirmResult.isPresent() && confirmResult.get() == ButtonType.YES) {
                            StudentController.deleteStudent(student.getNo());
                            operatAlert = new Alert(Alert.AlertType.INFORMATION);
                            operatAlert.setTitle("删除成功");
                            operatAlert.setHeaderText(null);
                            operatAlert.setContentText("数据已成功删除！");
                            operatAlert.showAndWait();
                            studentIfo.getItems().clear();
                        }
                    } else{
                        operatAlert.close();
                    }
                }
            });
            return row;
        });
        return gridPane;
    }
    private void removeLabelFromGridPane(GridPane gridPane, Label labelToRemove) {
        gridPane.getChildren().removeIf(node -> node == labelToRemove);
    }

}
