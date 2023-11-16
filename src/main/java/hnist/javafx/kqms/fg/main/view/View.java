package hnist.javafx.kqms.fg.main.view;

import javafx.scene.layout.Pane;

// 所有页面都要实现该接口
public interface View {
     String getName();
     Pane getView();
}
