package hnist.javafx.kqms.fg.main.hello;

import hnist.javafx.kqms.KqmsApplication;
import hnist.javafx.kqms.fg.main.View;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
public class HelloView extends View {
    @Override
    public String getName() {
        return "主页";
    }


    @Override
    protected Pane initView() {
        Label label = KqmsApplication.getLabel();
        label.setFont(new Font(100));
        label.setLayoutX(-label.getBoundsInLocal().getWidth());

        return new Pane(label);
    }
}
