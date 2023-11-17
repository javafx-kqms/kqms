package hnist.javafx.kqms.fg.main;

import hnist.javafx.kqms.fg.main.hello.HelloView;
import hnist.javafx.kqms.fg.main.student.AddStudentView;
import hnist.javafx.kqms.fg.main.student.GetStudentView;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MainView extends View {
    private final View[] views = {new HelloView(), new GetStudentView(), new AddStudentView()};

    @Override
    public String getName() {
        return null;
    }

    @Override
    protected Pane initView() {
        VBox root = new VBox(getNavbar(), views[0].getView());
        root.setSpacing(10);
        return root;
    }

    private HBox getNavbar() {
        HBox navbar = new HBox();
        navbar.setStyle("-fx-background-color: #333333;");

        for (View view : views) {
            Button button = new Button(view.getName());
            button.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px;");

            button.setOnAction((e) -> {
                ObservableList<Node> children = root.getChildren();
                if (children.get(1) != view.getView()) {
                    children.remove(1);
                    children.add(view.getView());
                }
            });

            navbar.getChildren().add(button);
        }

        return navbar;
    }
}
