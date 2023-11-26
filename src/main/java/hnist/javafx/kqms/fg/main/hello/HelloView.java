package hnist.javafx.kqms.fg.main.hello;

import hnist.javafx.kqms.KqmsApplication;
import hnist.javafx.kqms.fg.main.View;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.util.Duration;
public class HelloView extends View {
    @Override
    public String getName() {
        return "主页";
    }


    @Override
    protected Pane initView() {
        return new Pane(getRollingWord());
    }

    private Label getRollingWord(){
        Label welcome = new Label("欢迎");
        welcome.setFont(new Font(100));
        welcome.setLayoutX(-welcome.getBoundsInLocal().getWidth());

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5),
                new KeyValue(welcome.translateXProperty(), welcome.getBoundsInLocal().getWidth())));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        return welcome;
    }
}
