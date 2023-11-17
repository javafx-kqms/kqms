package hnist.javafx.kqms.fg.main.view;

import javafx.scene.layout.Pane;

// 所有页面都要实现该接口
public abstract class View {
     private Pane root;
     public Pane getView()  {
          if (root == null)
               root = initView();
          return root;
     }
     abstract public String getName();

     abstract protected Pane initView();
}
