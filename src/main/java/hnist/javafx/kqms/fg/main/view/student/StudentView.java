package hnist.javafx.kqms.fg.main.view.student;

import hnist.javafx.kqms.fg.main.view.Router;
import hnist.javafx.kqms.fg.main.view.View;
import javafx.scene.layout.Pane;

public class StudentView extends View {
    @Override
    public String getName() {
        return "学生信息";
    }

    @Override
    protected Pane initView() {
        return new Router(new GetStudentView(), new AddStudentView(), new ModifyStudentView()).getView();
    }
}
