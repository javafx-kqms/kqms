package hnist.javafx.kqms.fg.navbar;

public class Navbar {
    static private final Page[] pages = {};

    static private final Navbar instance = new Navbar();

    private Navbar() {}

    static public Navbar getInstance() {
        return instance;
    }
}
