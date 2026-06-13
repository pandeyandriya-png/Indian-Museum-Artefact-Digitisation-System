package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LandingPage {

    public void show(Stage stage) {

        Label title = new Label("Indian Museum Artefact Digitisation");

        title.setStyle(
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;"
        );

        Button adminBtn = new Button("Administrator");
        adminBtn.setPrefWidth(250);
        adminBtn.setPrefHeight(45);

        Button guestBtn = new Button("Guest User");
        guestBtn.setPrefWidth(250);
        guestBtn.setPrefHeight(45);

        adminBtn.setOnAction(e -> {

            LoginPage loginPage = new LoginPage();
            loginPage.show(stage);

        });

        guestBtn.setOnAction(e -> {

            DashboardPage dashboard = new DashboardPage();
            dashboard.show(stage);

        });

        VBox root = new VBox(25);

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));

        root.getChildren().addAll(
                title,
                adminBtn,
                guestBtn
        );

        Scene scene = new Scene(root, 900, 600);

        stage.setTitle("Museum System");
        stage.setScene(scene);
        stage.show();
    }
}