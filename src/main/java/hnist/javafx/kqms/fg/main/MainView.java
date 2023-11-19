package hnist.javafx.kqms.fg.main;

import hnist.javafx.kqms.fg.main.hello.HelloView;
import hnist.javafx.kqms.fg.main.student.AddStudentView;
import hnist.javafx.kqms.fg.main.student.GetStudentView;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainView extends View {
    private final View[] views = {new HelloView(), new GetStudentView(), new AddStudentView()};

    private final Pane routerView = getRouterView();

    @Override
    public String getName() {
        return null;
    }

    @Override
    protected Pane initView() {
        VBox root = new VBox(getNavbar(), getMain());
        root.setSpacing(10);
        return root;
    }

    private Pane getRouterView() {
        StackPane routerView = new StackPane();
        routerView.setStyle("-fx-padding: 20;");
        return routerView;
    }

    private HBox getNavbar() {
        HBox navbar = new HBox();
        navbar.setStyle("-fx-background-color: #333333;");

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

        return navbar;
    }

    private StackPane getMain() {
        Pane borderPane = new Pane();
        borderPane.setStyle(" -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 5px;");

        StackPane main = new StackPane(borderPane, routerView);
        main.setStyle("-fx-padding: 20px;");

        return main;
    }
}
