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
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.util.converter.ByteStringConverter;


import java.util.Optional;

public class GetStudentView extends View {
    @Override
    public String getName() {
        return "操作学生信息";
    }

    @Override
    public Pane initView() {
        Label studentNumberLabel = new Label("学号");
        studentNumberLabel.setFont(new Font("Arial",15));
        TextField studentNumber = new TextField();
        Label studentNameLabel = new Label("姓名");
        studentNameLabel.setFont(new Font("Arial",15));
        TextField studentName = new TextField();
        Button searchButton = new Button("搜索");
        Label label = new Label("若没有填入搜索信息则显示全部学生信息");
        label.setFont(new Font("Arial",15));
        Label unfindLabel = new Label("该学生信息不存在！");
        unfindLabel.setFont(new Font("Arial",15));
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
        TableColumn<Student, Byte> ageColumn = new TableColumn<>("年龄");
        TableColumn<Student, String> classNameColumn = new TableColumn<>("班级");
        numberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("no"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        sexColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        sexColumn.setCellValueFactory(new PropertyValueFactory<>("sex"));
        ageColumn.setCellFactory(TextFieldTableCell.forTableColumn(new ByteStringConverter()));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        classNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        classNameColumn.setCellValueFactory(new PropertyValueFactory<>("className"));
        studentIfo.getColumns().addAll(numberColumn,nameColumn,sexColumn,ageColumn,classNameColumn);

        nameColumn.setPrefWidth(110);
        numberColumn.setPrefWidth(110);
        sexColumn.setPrefWidth(110);
        ageColumn.setPrefWidth(110);
        classNameColumn.setPrefWidth(110);

        gridPane.add(studentIfo,0,3);
        GridPane.setConstraints(studentIfo,0,3,5,1);

        //查询学生信息
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

            ObservableList<Student> list = FXCollections.observableArrayList(StudentController.getStudent(numberStr,nameStr));
            if(!list.isEmpty()){
                studentIfo.setItems(list);
            }else{
                gridPane.add(unfindLabel,0,4);
                GridPane.setConstraints(unfindLabel,0,4,5,1);
            }
        });

        //修改和删除学生信息
        // 添加按钮到每一行
        studentIfo.setRowFactory(tv -> {
            TableRow<Student> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    Student student = row.getItem();
                    //双击弹出操作框，可进行删除和修改操作
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
                        confirmLabel.setFont(new Font("Arial",15));
                        Label modifyNameLabel = new Label("姓名");
                        modifyNameLabel.setFont(new Font("Arial",15));
                        TextField modifyNameTF = new TextField();
                        Label modifySexLabel = new Label("性别");
                        modifySexLabel.setFont(new Font("Arial",15));
                        ObservableList<String> options = FXCollections.observableArrayList(
                                "男", "女"
                        );
                        ComboBox<String> comboBox = new ComboBox<>(options);
                        comboBox.setPromptText("选择性别");
                        Label modifyAgeLabel = new Label("年龄");
                        modifyAgeLabel.setFont(new Font("Arial",15));
                        TextField modifyAgeTF = new TextField();
                        Label modifyClassNameLabel = new Label("班级");
                        modifyClassNameLabel.setFont(new Font("Arial",15));
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
                                    comboBox.getValue() == null ? student.getSex() : comboBox.getValue();
                            byte editAge =
                                    modifyAgeTF.getText().isEmpty() ? student.getAge() : Byte.parseByte(modifyAgeTF.getText());
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
                        operatAlert = new Alert(Alert.AlertType.CONFIRMATION);
                        operatAlert.setTitle("确认删除");
                        operatAlert.setHeaderText("确定要删除该学生信息吗？" + "\n" + student.toString());
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
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }

    //移除学生表下红色提示文本
    private void removeLabelFromGridPane(GridPane gridPane, Label labelToRemove) {
        gridPane.getChildren().removeIf(node -> node == labelToRemove);
    }
}
