package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class LandingPage {

    public void show(Stage stage) {

 Label title = new Label(
    "INDIAN MUSEUM\nARTEFACT DIGITISATION\nSYSTEM"
);
title.setAlignment(Pos.CENTER);
title.setTextAlignment(TextAlignment.CENTER);
Label subtitle = new Label(
    "Preserving India's Cultural Heritage"
);
subtitle.setStyle(

    "-fx-text-fill: #F8F9F9;" +
    "-fx-font-size: 20px;" +
    "-fx-font-style: italic;"+
    "-fx-effect: dropshadow(gaussian, black, 8, 0.6, 2, 2);"

);

title.setStyle(

    "-fx-font-size: 36px;" +
    "-fx-font-weight: bold;" +
    "-fx-text-fill: white;" +

    "-fx-effect: dropshadow(gaussian, black, 12, 0.8, 3, 3);"

);



        Button adminBtn = new Button("Administrator");
        styleButton(adminBtn);

        adminBtn.setPrefWidth(220);
        adminBtn.setPrefHeight(45);

        Button guestBtn = new Button("Guest User");
        styleButton(guestBtn);
        guestBtn.setPrefWidth(220);
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
        root.setStyle(
    "-fx-background-color: linear-gradient(to bottom, #f5f7fa, #dfe9f3);"
    +"-fx-background-image: url('file:resources/images/museum_bg.png');" +
    "-fx-background-position: center;"+
    "-fx-background-size: cover;" 
);
        root.setSpacing(25);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));

        root.getChildren().addAll(
                title,
                subtitle,
                adminBtn,
                guestBtn
        );

        Scene scene = new Scene(root, 900, 600);

        stage.setTitle(
    "Indian Museum Artefact Digitisation System"
);
        stage.setScene(scene);
        stage.show();
    }
    private void styleButton(Button btn) {

    btn.setStyle(

            "-fx-background-color: #3B82D6;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 14px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 12;"

    );

    btn.setPrefHeight(40);
}
}