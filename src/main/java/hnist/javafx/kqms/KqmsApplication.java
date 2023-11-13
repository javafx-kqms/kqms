package hnist.javafx.kqms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KqmsApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new Label("helllo"), 300, 300));
        stage.show();
    }
}
