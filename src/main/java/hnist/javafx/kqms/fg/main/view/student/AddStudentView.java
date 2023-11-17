package hnist.javafx.kqms.fg.main.view.student;

import hnist.javafx.kqms.fg.main.view.View;
import javafx.scene.layout.Pane;

public class AddStudentView implements View {
    @Override
    public String getName() {
        return "todo";
    }

    @Override
    public Pane getView() {
        return new Pane();
    }
}
