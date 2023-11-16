package hnist.javafx.kqms;

import hnist.javafx.kqms.fg.main.Router;
import hnist.javafx.kqms.fg.main.view.AddView;
import hnist.javafx.kqms.fg.main.view.SearchView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KqmsApplication extends Application {
    @Override
    public void start(Stage stage) {
        Router router = new Router(new AddView(), new SearchView());
        stage.setScene(new Scene( router.getRouter(), 1000, 800));
        stage.show();
    }
}
