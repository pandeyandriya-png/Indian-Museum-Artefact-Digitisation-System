package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import dao.UserDAO;

public class LoginPage {

    public void show(Stage stage) {

        Label title = new Label("Administrator Login");

       title.setStyle(

    "-fx-font-size:30px;" +
    "-fx-font-weight:bold;" +
    "-fx-text-fill:#1B2631;"

);
stage.setTitle(
    "Indian Museum Artefact Digitisation System"
);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginBtn = new Button("Login");
        styleButton(loginBtn);

       Label messageLabel = new Label();
       messageLabel.setStyle("-fx-text-fill:red;");
       VBox loginCard = new VBox(15);

loginCard.setAlignment(Pos.CENTER);

loginCard.setPadding(
        new Insets(30)
);

loginCard.setMaxWidth(400);

loginCard.setStyle(
        "-fx-background-color: rgba(255,255,255,0.90);" +
        "-fx-background-radius: 15;"
);
usernameField.setMaxWidth(250);
passwordField.setMaxWidth(250);

        loginBtn.setOnAction(e -> {
            System.out.println("BUTTON CLICKED");
            String username = usernameField.getText();
            String password = passwordField.getText();

    //    if(UserDAO.validateUser(username, password)) 
    System.out.println("Username = " + username);
    System.out.println("Password = " + password);


    boolean valid =
        UserDAO.validateUser(username,password);

    System.out.println("Result = " + valid);

    if(valid){

        messageLabel.setStyle("-fx-text-fill:green;");
        messageLabel.setText("Login Successful");

        //  DashboardPage dashboard = new DashboardPage();
        // dashboard.show(stage);
        AdminPanel adminPanel =
        new AdminPanel();

        adminPanel.show(stage);
        } 
        else {

            messageLabel.setStyle("-fx-text-fill:red;");
            messageLabel.setText("Invalid Username or Password");
            }

        });

        VBox root = new VBox(15);
           root.setStyle(
    "-fx-background-color: linear-gradient(to bottom, #f5f7fa, #dfe9f3);"+"-fx-background-image: url('file:resources/images/museum_bg.png');" +
    "-fx-background-size: cover;" +
    "-fx-background-position: center;"
);

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        loginCard.getChildren().addAll(
        title,
        usernameField,
        passwordField,
        loginBtn,
        messageLabel
);

root.getChildren().add(
        loginCard
);

        Scene scene = new Scene(root,900,600);

        stage.setScene(scene);
    }
    private void styleButton(Button btn) {

    btn.setStyle(

            "-fx-background-color: #2E86DE;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 14px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 10px;"

    );

    btn.setPrefHeight(40);
}
}