package hnist.javafx.kqms.fg.login;

import hnist.javafx.kqms.KqmsApplication;
import hnist.javafx.kqms.bg.controller.ManagerController;
import hnist.javafx.kqms.fg.main.MainView;
import hnist.javafx.kqms.fg.main.View;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class LoginView extends View {

    @Override
    public String getName() {
        return null;
    }

    @Override
    protected Pane initView() {
        return getRoot();
    }

    private static final String[] IMAGE_URLS = {
            "/image/login.jpg",
            "/image/login2.jpg",
            "/image/login3.jpg"
    };
    private int currentImageIndex = 0;

    private VBox getRoot() {
        Text title = new Text("学生考勤管理系统");
        title.setStyle("-fx-font-size: 30;");

        VBox root = new VBox(title, getMain());
        root.setStyle("-fx-background-color: #f5e6c5; -fx-padding: 50; -fx-spacing: 20;");

        return root;
    }

    private HBox getMain() {
        HBox main = new HBox(getLeft(), getRight());
        main.setStyle("-fx-background-color: white; -fx-padding: 2; -fx-border-color: #b3d7f1; -fx-border-width: 2; -fx-border-radius: 5;");
        return main;
    }

    private ImageView getLeft() {
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(IMAGE_URLS[currentImageIndex])));
        imageView.setFitHeight(350);
        imageView.setFitWidth(600);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
            currentImageIndex = (currentImageIndex + 1) % IMAGE_URLS.length;
            imageView.setImage(new Image(getClass().getResourceAsStream(IMAGE_URLS[currentImageIndex])));

            // 创建FadeTransition对象
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), imageView);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);

            // 设置淡入淡出效果
            fadeTransition.play();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        return imageView;
    }

    private VBox getRight() {
        Text title = new Text("用户登录");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");

        VBox right = new VBox(title, getInputGroup());
        right.setStyle("-fx-spacing: 10; -fx-padding: 20;");
        return right;
    }

    private GridPane getInputGroup() {
        GridPane inputGroup = new GridPane();
        inputGroup.setStyle("-fx-hgap: 10; -fx-vgap: 10;");

        Label usernameLabel = getStyledLabel("用户名:");
        Label passwordLabel = getStyledLabel("密码:");
        Label errorLabel = getErrorLabel();
        TextField usernameField = getStyledTextField();
        PasswordField passwordField = getStyledPasswordField();
        Button loginButton = getStyledLoginButton();

        inputGroup.add(usernameLabel, 0, 0);
        inputGroup.add(usernameField, 1, 0, 5, 1);
        inputGroup.add(passwordLabel, 0, 1);
        inputGroup.add(passwordField, 1, 1, 5, 1);
        inputGroup.add(loginButton, 0, 2, 6, 1);
        inputGroup.add(errorLabel, 0, 3, 6, 1);

        EventHandler<ActionEvent> loginHandler = e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (ManagerController.login(username, password)) {
                KqmsApplication.changeRoot(new MainView().getView());
            } else {
                errorLabel.setText("账号或密码错误");
            }
        };

        loginButton.setOnAction(loginHandler);

        usernameField.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.ENTER)
                loginHandler.handle(new ActionEvent());
        });
        passwordField.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.ENTER)
                loginHandler.handle(new ActionEvent());
        });

        return inputGroup;
    }

    private Label getStyledLabel(String labelText) {
        Label label = new Label(labelText);
        label.setFont(new Font("Arial", 14));
        label.setTextFill(Color.rgb(51, 51, 51));
        return label;
    }

    private Label getErrorLabel() {
        Label errorLabel = new Label("");
        errorLabel.setTextFill(Color.RED);
        return errorLabel;
    }

    private TextField getStyledTextField() {
        TextField textField = new TextField();
        textField.setFont(new Font("Arial", 14));
        textField.setPrefHeight(30);
        textField.setPrefWidth(200);
        return textField;
    }

    private PasswordField getStyledPasswordField() {
        PasswordField passwordField = new PasswordField();
        passwordField.setFont(new Font("Arial", 14));
        passwordField.setPrefHeight(30);
        passwordField.setPrefWidth(200);
        return passwordField;
    }

    private Button getStyledLoginButton() {
        Button button = new Button("登录");
        button.setPrefWidth(300);
        String baseStyle = "-fx-background-color: #2196F3; -fx-font-size: 14px; -fx-background-radius: 5px;";

        button.setStyle(baseStyle);

        button.setOnMouseEntered(e -> button.setStyle(baseStyle + "-fx-background-color: #1976D2;"));
        button.setOnMouseExited(e -> button.setStyle(baseStyle + "-fx-background-color: #2196F3;"));
        button.setOnMousePressed(e -> button.setStyle(baseStyle + "-fx-background-color: #0D47A1;"));
        return button;
    }
}
