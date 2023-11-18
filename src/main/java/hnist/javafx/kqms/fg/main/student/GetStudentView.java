package hnist.javafx.kqms.fg.main.student;

import hnist.javafx.kqms.bg.controller.StudentController;
import hnist.javafx.kqms.fg.main.View;
import hnist.javafx.kqms.pojo.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.TableColumn;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
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
                    operatAlert.initModality(Modality.APPLICATION_MODAL);
                    operatAlert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

                    Optional<ButtonType> result = operatAlert.showAndWait();
                    if (result.isPresent() && result.get() == modifyButtonType) {
                        //修改页面
                        Alert modifyDialog = new Alert(Alert.AlertType.INFORMATION);
                        modifyDialog.setTitle("修改");
                        modifyDialog.setHeaderText("要修改的学生信息"+student.toString()+"\n"+"学号不可修改!");

                        Label confirmLabel = new Label("请填入修改后的信息");
                        Label modifyNameLabel = new Label("姓名");
                        TextField modifyNameTF = new TextField();
                        Label modifySexLabel = new Label("性别");
                        ObservableList<String> options = FXCollections.observableArrayList(
                                "男", "女"
                        );
                        ComboBox<String> comboBox = new ComboBox<>(options);
                        comboBox.setPromptText("选择性别");
                        Label modifyAgeLabel = new Label("年龄");
                        TextField modifyAgeTF = new TextField();
                        Label modifyClassNameLabel = new Label("班级");
                        TextField modifyClassNameTF = new TextField();
                        modifyClassNameTF.setPromptText("计科21-2BJ");

                        GridPane modifyPane = new GridPane();
                        modifyPane.setHgap(10);
                        modifyPane.setVgap(10);
                        modifyPane.add(confirmLabel,1,0);
                        modifyPane.add(modifyNameLabel,0,1);
                        modifyPane.add(modifyNameTF,1,1);
                        modifyPane.add(modifySexLabel,0,2);
                        modifyPane.add(comboBox,1,2);
                        modifyPane.add(modifyAgeLabel,0,3);
                        modifyPane.add(modifyAgeTF,1,3);
                        modifyPane.add(modifyClassNameLabel,0,4);
                        modifyPane.add(modifyClassNameTF,1,4);
                        modifyPane.setAlignment(Pos.CENTER);

                        modifyDialog.getDialogPane().setContent(modifyPane);

                        ButtonType submitButtonType = new ButtonType("提交");
                        modifyDialog.getButtonTypes().setAll(submitButtonType);


                        Optional<ButtonType> submitResult = modifyDialog.showAndWait();
                        if (submitResult.isPresent() && submitResult.get() == submitButtonType) {
                            String editName =
                                    modifyNameTF.getText().isEmpty() ? student.getName() : modifyNameTF.getText();
                            String editSex =
                                    comboBox.getValue().isEmpty() ? student.getSex() : comboBox.getValue();
                            short editAge =
                                    modifyAgeTF.getText().isEmpty() ? student.getAge() : Short.parseShort(modifyAgeTF.getText());
                            String editClassName =
                                    modifyClassNameTF.getText().isEmpty() ? student.getClassName() : modifyClassNameTF.getText();

                            Student editStudent = new Student(student.getNo(),editName,editSex,editAge,editClassName);
                            // 如果用户点击了"提交"按钮，更新学生的信息
                            StudentController.modifyStudent(editStudent);
                            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                            successAlert.setTitle("修改成功");
                            successAlert.setHeaderText("修改学生信息成功！");
                            successAlert.showAndWait();
                        }
                    } else if (result.isPresent() && result.get() == deleteButtonType) {
                        //删除页面
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

                        }
                    }
                    studentIfo.getItems().clear();

                }
            });
            return row;
        });
        return gridPane;
    }

    //移除学生表下红色提示文本
    private void removeLabelFromGridPane(GridPane gridPane, Label labelToRemove) {
        gridPane.getChildren().removeIf(node -> node == labelToRemove);
    }

}
