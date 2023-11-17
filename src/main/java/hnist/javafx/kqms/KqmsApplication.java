package hnist.javafx.kqms;

import hnist.javafx.kqms.fg.main.view.Router;
import hnist.javafx.kqms.fg.main.view.AddView;
import hnist.javafx.kqms.fg.main.view.SearchView;
import hnist.javafx.kqms.fg.main.view.kaoqin.KaoqinView;
import hnist.javafx.kqms.fg.main.view.student.StudentView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KqmsApplication extends Application {
    @Override
    public void start(Stage stage) {
        Router router = new Router(new StudentView(), new KaoqinView());
        stage.setScene(new Scene(router.getView(), 1000, 800));
        stage.show();
    }
}
