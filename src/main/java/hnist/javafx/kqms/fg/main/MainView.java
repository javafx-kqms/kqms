package hnist.javafx.kqms.fg.main;

import hnist.javafx.kqms.fg.main.file_operation.FileOperationView;
import hnist.javafx.kqms.fg.main.hello.HelloView;
import hnist.javafx.kqms.fg.main.kaoqin.AddKaoqinView;
import hnist.javafx.kqms.fg.main.kaoqin.GetAbsentView;
import hnist.javafx.kqms.fg.main.student.AddStudentView;
import hnist.javafx.kqms.fg.main.student.GetStudentView;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MainView extends View {
    private final View[] views = {new HelloView(), new GetStudentView(), new AddStudentView(),new GetAbsentView(),new AddKaoqinView(),new FileOperationView()};

    private final Pane routerView = getRouterView();

    @Override
    public String getName() {
        return null;
    }

    @Override
    protected Pane initView() {
        VBox root = new VBox(getNavbar(), getMain());
        String path = getClass().getResource("/image/bg.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url(" + path + ");");
        return root;
    }

    private Pane getRouterView() {
        StackPane routerView = new StackPane();
        routerView.setStyle("-fx-padding: 20;");
        return routerView;
    }

    private HBox getNavbar() {
        HBox navbar = new HBox();
        navbar.setStyle("-fx-background-color: #333333; -fx-alignment: center-left;");

        routerView.getChildren().add(views[0].getView());
        for (View view : views) {
            Button button = new Button(view.getName());
            button.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px;");

            button.setOnAction((e) -> {
                ObservableList<Node> children = routerView.getChildren();
                if (children.get(0) != view.getView()) {
                    children.remove(0);
                    children.add(view.getView());
                }
            });

            navbar.getChildren().add(button);
        }

        navbar.getChildren().add(getClock());

        return navbar;
    }

    private Text getClock() {
        Text clock = new Text();
        clock.setStyle("-fx-fill: white; -fx-font-size: 14;");

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    LocalTime currentTime = LocalTime.now();
                    String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                    clock.setText(formattedTime);
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        return clock;
    }

    private StackPane getMain() {
        Pane borderPane = new Pane();
        borderPane.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 5px;");

        StackPane main = new StackPane(borderPane, routerView);
        main.setStyle("-fx-padding: 20px;");

        return main;
    }
}
