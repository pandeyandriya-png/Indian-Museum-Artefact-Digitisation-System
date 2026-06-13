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
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;"
        );

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginBtn = new Button("Login");

       Label messageLabel = new Label();
       messageLabel.setStyle("-fx-text-fill:red;");

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

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));

        root.getChildren().addAll(
                title,
                usernameField,
                passwordField,
                loginBtn,
                messageLabel
        );

        Scene scene = new Scene(root,900,600);

        stage.setScene(scene);
    }
}