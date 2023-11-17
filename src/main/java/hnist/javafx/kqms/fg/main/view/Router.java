package hnist.javafx.kqms.fg.main.view;

import hnist.javafx.kqms.fg.main.view.AddView;
import hnist.javafx.kqms.fg.main.view.SearchView;
import hnist.javafx.kqms.fg.main.view.View;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Router {
    private final View[] views;
    public Router(View ..._views) {
        views = _views;
    }

    public VBox getRouter() {
        VBox root = new VBox();
        root.getChildren().addAll(getNavbar(root), views[0].getView());
        return root;
    }

    private HBox getNavbar(VBox root) {
        HBox navbar = new HBox();
        for (View view : views) {
            Button button = new Button(view.getName());
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
