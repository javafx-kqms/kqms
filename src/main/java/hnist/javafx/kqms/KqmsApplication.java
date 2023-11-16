package hnist.javafx.kqms;

import hnist.javafx.kqms.fg.main.Router;
import javafx.application.Application;
import javafx.stage.Stage;

public class KqmsApplication extends Application {

    @Override
    public void start(Stage stage) {
        Router router = new Router();
        stage.setScene(router.getRouter());
        stage.show();
    }
}
