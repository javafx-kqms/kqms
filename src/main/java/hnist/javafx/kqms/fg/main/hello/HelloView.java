package hnist.javafx.kqms.fg.main.hello;

import hnist.javafx.kqms.fg.main.View;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class HelloView extends View {
    @Override
    public String getName() {
        return "主页";
    }

    @Override
    protected Pane initView() {
        return new HBox(getRollingWord());
    }

    private Text getRollingWord(){
        Text welcome = new Text("欢迎");
        welcome.setFont(new Font(100));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10),
                new KeyValue(welcome.translateXProperty(), 700)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        return welcome;
    }
}
