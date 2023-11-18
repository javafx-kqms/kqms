package hnist.javafx.kqms.fg.main;

import hnist.javafx.kqms.KqmsApplication;
import hnist.javafx.kqms.fg.main.hello.HelloView;
import hnist.javafx.kqms.fg.main.student.AddStudentView;
import hnist.javafx.kqms.fg.main.student.GetStudentView;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainView extends View {
    private final View[] views = {new HelloView(), new GetStudentView(), new AddStudentView()};

    @Override
    public String getName() {
        return null;
    }

    @Override
    protected Pane initView() {
        StackPane router_view = getRouterView();
        VBox root = new VBox(getNavbar(router_view), router_view);
        root.setSpacing(10);
        return root;
    }

    private StackPane getRouterView() {
        StackPane router_view = new StackPane(views[0].getView());
        router_view.setStyle("-fx-padding: 20px; -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 5px;");

        return router_view;
    }

    private HBox getNavbar(StackPane router_view) {
        HBox navbar = new HBox();
        navbar.setStyle("-fx-background-color: #333333;");

        for (View view : views) {
            Button button = new Button(view.getName());
            button.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px 20px;");

            button.setOnAction((e) -> {
                ObservableList<Node> children = router_view.getChildren();
                if (children.get(0) != view.getView()) {
                    children.remove(0);
                    children.add(view.getView());
                }
            });

            navbar.getChildren().add(button);
        }

        return navbar;
    }
}
