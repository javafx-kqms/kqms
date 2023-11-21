package hnist.javafx.kqms;

import hnist.javafx.kqms.fg.login.Login;
import hnist.javafx.kqms.fg.main.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class KqmsApplication extends Application {
    static private Scene scene;

    static private Stage stage;
    private TextArea logTextArea = new TextArea("路径");

    @Override
    public void start(Stage stage) {
        KqmsApplication.stage = stage;
        scene = new Scene(new Login().getView(), 1000, 600);
        scene = new Scene(new MainView().getView(), 1000, 600);

        stage.setScene(scene);
        stage.show();
    }

    static public void changeRoot(Pane root) {
        scene.setRoot(root);
    }

    static public Stage getStage() {
        return stage;
    }
    public static String getFilePath(Stage stage){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        return file.getAbsolutePath();
    }
}
