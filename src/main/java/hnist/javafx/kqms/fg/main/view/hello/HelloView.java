package hnist.javafx.kqms.fg.main.view.hello;

import hnist.javafx.kqms.fg.main.view.View;
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
        Label label = new Label("欢迎");
        label.setFont(new Font(100));
        return new Pane(label);
    }
}
