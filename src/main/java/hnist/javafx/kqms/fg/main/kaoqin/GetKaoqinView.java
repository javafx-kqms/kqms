package hnist.javafx.kqms.fg.main.kaoqin;

import hnist.javafx.kqms.bg.controller.KaoqinController;
import hnist.javafx.kqms.fg.main.View;
import hnist.javafx.kqms.pojo.Kaoqin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.util.converter.ByteStringConverter;
import javafx.util.converter.DateStringConverter;

import java.util.Date;
import java.util.Optional;

public class GetKaoqinView extends View {
    @Override
    public String getName() {
        return "操作考勤信息";
    }

    @Override
    public Pane initView() {
        Label courseNameLabel = new Label("课程名");
        courseNameLabel.setFont(new Font("Arial", 15));
        TextField courseNameTF = new TextField();
        Label studentNameLabel = new Label("姓名");
        studentNameLabel.setFont(new Font("Arial", 15));
        TextField studentNameTF = new TextField();
        Button searchButton = new Button("搜索");
        Label label = new Label("若没有填入搜索信息则显示全部考勤信息");
        label.setFont(new Font("Arial", 15));
        Label unfindLabel = new Label("该缺课信息不存在！");
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
        TableColumn<Kaoqin, String> courseNameColumn = new TableColumn<>("课程名称");
        TableColumn<Kaoqin, Byte> courseSectionColumn = new TableColumn<>("第几节课");
        TableColumn<Kaoqin, String> typeColumn = new TableColumn<>("缺课类型");
        TableColumn<Kaoqin, String> studentNoColumn = new TableColumn<>("缺课学号");
        dateColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        courseNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        courseSectionColumn.setCellFactory(TextFieldTableCell.forTableColumn(new ByteStringConverter()));
        courseSectionColumn.setCellValueFactory(new PropertyValueFactory<>("section"));
        typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        studentNoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        studentNoColumn.setCellValueFactory(new PropertyValueFactory<>("studentNo"));
        kaoqinIfo.getColumns().addAll(dateColumn, nameColumn, courseNameColumn, courseSectionColumn, typeColumn, studentNoColumn);

        dateColumn.setPrefWidth(100);
        nameColumn.setPrefWidth(100);
        courseNameColumn.setPrefWidth(100);
        courseSectionColumn.setPrefWidth(100);
        typeColumn.setPrefWidth(100);
        studentNoColumn.setPrefWidth(100);

        gridPane.add(kaoqinIfo, 0, 3);
        GridPane.setConstraints(kaoqinIfo, 0, 3, 6, 1);

        //查询缺课信息
        searchButton.setOnAction(e -> {
            removeLabelFromGridPane(gridPane, unfindLabel);
            String courseStr;
            String studentNameStr;
            if (courseNameTF.getText().isEmpty()) {
                courseStr = null;
            } else {
                courseStr = courseNameTF.getText();
            }
            if (studentNameTF.getText().isEmpty()) {
                studentNameStr = null;
            } else {
                studentNameStr = studentNameTF.getText();
            }

            ObservableList<Kaoqin> list = FXCollections.observableArrayList(KaoqinController.getKaoqin(courseStr, studentNameStr));
            if (!list.isEmpty()) {
                kaoqinIfo.setItems(list);
            } else {
                gridPane.add(unfindLabel, 0, 4);
                GridPane.setConstraints(unfindLabel, 0, 4, 6, 1);
            }
        });

        //删除缺课信息
        kaoqinIfo.setRowFactory(tv -> {
            TableRow<Kaoqin> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    Kaoqin kaoqin = row.getItem();
                    //双击弹出操作框，可进行删除操作
                    Alert operatAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    operatAlert.setTitle("删除");
                    operatAlert.setHeaderText("删除缺课信息");

                    ButtonType deleteButtonType = new ButtonType("删除");
                    operatAlert.getButtonTypes().setAll(deleteButtonType);
                    operatAlert.initModality(Modality.APPLICATION_MODAL);
                    operatAlert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

                    Optional<ButtonType> result = operatAlert.showAndWait();
                    if (result.isPresent() && result.get() == deleteButtonType) {
                        //删除界面
                        operatAlert = new Alert(Alert.AlertType.CONFIRMATION);
                        operatAlert.setTitle("确认删除");
                        operatAlert.setHeaderText("确定要删除该缺课信息吗？" + "\n" + kaoqin.toString());
                        operatAlert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
                        Optional<ButtonType> confirmResult = operatAlert.showAndWait();
                        if (confirmResult.isPresent() && confirmResult.get() == ButtonType.YES) {
                            KaoqinController.deleteKaoqin(kaoqin);
                            operatAlert = new Alert(Alert.AlertType.INFORMATION);
                            operatAlert.setTitle("删除成功");
                            operatAlert.setHeaderText(null);
                            operatAlert.setContentText("数据已成功删除！");
                            operatAlert.showAndWait();
                        }

                    }
                    kaoqinIfo.getItems().clear();
                }
            });
            return row;
        });
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }

    private void removeLabelFromGridPane(GridPane gridPane, Label labelToRemove) {
        gridPane.getChildren().removeIf(node -> node == labelToRemove);
    }
}
