package hnist.javafx.kqms.fg.main.view.kaoqin;

import hnist.javafx.kqms.fg.main.view.View;
import javafx.scene.layout.Pane;

public class KaoqinView implements View {
    @Override
    public String getName() {
        return "todo";
    }

    @Override
    public Pane getView() {
        return new Pane();
    }
}
