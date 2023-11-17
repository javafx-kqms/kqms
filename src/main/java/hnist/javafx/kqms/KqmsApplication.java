package hnist.javafx.kqms;

import hnist.javafx.kqms.fg.main.router.Router;
import hnist.javafx.kqms.fg.main.view.MainView;
import hnist.javafx.kqms.fg.main.view.kaoqin.KaoqinView;
import hnist.javafx.kqms.fg.main.view.student.StudentView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KqmsApplication extends Application {
    @Override
    public void start(Stage stage) {

        stage.setScene(new Scene(new MainView().getView(), 1000, 600));
        stage.show();
    }
}
