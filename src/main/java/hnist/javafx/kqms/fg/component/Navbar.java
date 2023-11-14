package hnist.javafx.kqms.fg.component;

import hnist.javafx.kqms.fg.view.View;
import javafx.scene.layout.Pane;

public class Navbar {
    static private final View[] views = {};

    static private final Pane instance = initNavbar();

    static private Pane initNavbar() {
        return new Pane();
    }

    static public Pane getInstance() {
        return instance;
    }
}
