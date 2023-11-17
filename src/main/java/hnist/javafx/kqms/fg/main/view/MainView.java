package hnist.javafx.kqms.fg.main.view;

import hnist.javafx.kqms.fg.main.router.Router;
import hnist.javafx.kqms.fg.main.view.hello.HelloView;
import hnist.javafx.kqms.fg.main.view.kaoqin.KaoqinView;
import hnist.javafx.kqms.fg.main.view.student.StudentView;
import javafx.scene.layout.Pane;

public class MainView extends View{
    @Override
    public String getName() {
        return null;
    }

    @Override
    protected Pane initView() {
        return new Router(new HelloView(), new StudentView(), new KaoqinView()).getView();
    }
}
