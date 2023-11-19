package hnist.javafx.kqms;

import hnist.javafx.kqms.fg.login.Login;
import hnist.javafx.kqms.fg.main.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class KqmsApplication extends Application {
    static private Scene scene;

    @Override
    public void start(Stage stage) {
        scene = new Scene(new Login().getView(), 1000, 600);
//        scene = new Scene(new MainView().getView(), 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    static public void changeRoot(Pane root) {
        scene.setRoot(root);
    }

}
