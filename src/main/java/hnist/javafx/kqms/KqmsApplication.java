package hnist.javafx.kqms;

import hnist.javafx.kqms.fg.login.Login;
import hnist.javafx.kqms.fg.main.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class KqmsApplication extends Application {
    static private Scene scene;

    static private Stage stage;

    @Override
    public void start(Stage stage) {
        KqmsApplication.stage = stage;
        scene = new Scene(new Login().getView(), 1000, 600);
        scene = new Scene(new MainView().getView(), 1000, 600);

        stage.setScene(scene);
        stage.setTitle("学生考勤管理系统");
        stage.show();
    }

    static public void changeRoot(Pane root) {
        scene.setRoot(root);
    }

    //使用FileChooser打开本地文件，获取文件路径
    public static String getFilePath(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        return file.getAbsolutePath();
    }

    //使用DirectoryChooser打开本地文件夹
    public static String getDirectPath(){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File file = directoryChooser.showDialog(stage);
        return file.getAbsolutePath();
    }
}
