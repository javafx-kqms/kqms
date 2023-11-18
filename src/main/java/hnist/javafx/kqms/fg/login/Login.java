package hnist.javafx.kqms.fg.login;

import hnist.javafx.kqms.bg.controller.ManagerController;
import hnist.javafx.kqms.fg.main.MainView;
import hnist.javafx.kqms.fg.main.View;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends View {
    private final Stage stage;

    public Login(Stage scene) {
        this.stage = scene;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    protected Pane initView() {
        StackPane root = getRoot();
        root.getChildren().addAll(getInputGroup());
        return root;
    }

    private StackPane getRoot() {
        StackPane root = new StackPane();

        root.setAlignment(Pos.CENTER);
        String backgroundImage = getClass().getResource("/image/login.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url('" + backgroundImage + "'); -fx-background-size: cover;");

        Rectangle background = new Rectangle(300, 200);
        background.setStyle("-fx-fill: rgba(255, 255, 255, 0.7); -fx-stroke: black; -fx-stroke-width: 2px; -fx-arc-width: 50px; -fx-arc-height: 50px;");

        root.getChildren().addAll(background);

        return root;
    }

    private GridPane getInputGroup() {
        GridPane inputGroup = new GridPane();
        inputGroup.setStyle("-fx-background-color: transparent; -fx-hgap: 10; -fx-vgap: 10; -fx-padding: 10; -fx-alignment: center;");

        Label usernameLabel = getStyledLabel("账号:");
        Label passwordLabel = getStyledLabel("密码:");
        Label errorLabel = getErrorLabel();
        TextField userNameField = getStyledTextField();
        PasswordField passwordField = getStyledPasswordField();
        Button loginButton = getStyledLoginButton();

        inputGroup.add(usernameLabel, 0, 0);
        inputGroup.add(userNameField, 1, 0, 4, 1);
        inputGroup.add(passwordLabel, 0, 1);
        inputGroup.add(passwordField, 1, 1, 4, 1);
        inputGroup.add(errorLabel, 1, 2, 4, 1);
        inputGroup.add(loginButton, 4, 3, 3, 1);

        loginButton.setOnAction(e -> {
            String username = userNameField.getText();
            String password = passwordField.getText();
            String password1 = ManagerController.getPasswordByUsername(username);
            if (password1 != null && password1.equals(password)) {
                stage.setScene(new Scene(new MainView().getView(), 1000, 600));
            } else {
                errorLabel.setText("账号或密码错误");
            }
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
        button.setFont(new Font("Arial", 14));
        button.setPrefHeight(35);
        button.setPrefWidth(100);
        button.setTextFill(Color.WHITE);
        button.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-pref-width: 100px; -fx-pref-height: 40px; -fx-background-radius: 5px;");
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #45a049; -fx-background-radius: 5;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #4CAF50; -fx-background-radius: 5;"));
        button.setOnMousePressed(e -> button.setStyle("-fx-background-color: #357a38; -fx-background-radius: 5;"));
        button.setOnMouseReleased(e -> button.setStyle("-fx-background-color: #45a049; -fx-background-radius: 5;"));
        return button;
    }
}
