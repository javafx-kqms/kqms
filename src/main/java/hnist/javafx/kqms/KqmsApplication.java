package hnist.javafx.kqms;

import hnist.javafx.kqms.fg.login.Login;
import hnist.javafx.kqms.fg.main.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KqmsApplication extends Application {
    @Override
    public void start(Stage stage) {
//        stage.setScene(new Scene(new MainView().getView(), 1000, 600));
        stage.setScene(new Scene(new Login(stage).getView(), 1000, 600));
        stage.show();
    }
}
