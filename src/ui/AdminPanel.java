package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminPanel {

public void show(Stage stage) {

    Label title =
            new Label("Administrator Panel");

title.setStyle(
    "-fx-font-size:30px;" +
    "-fx-font-weight:bold;" +
    "-fx-text-fill:white;"
);
stage.setTitle(
    "Indian Museum Artefact Digitisation System"
);
    Button addBtn =
        new Button("Add Artefact");
   addBtn.setOnAction(e -> {

            AddArtefactPage page =new AddArtefactPage();
            page.show(stage);

    });

    Button viewBtn =
            new Button("View Artefacts");
            Button logoutBtn =
        new Button("Logout");
        logoutBtn.setOnAction(e -> {

    LandingPage page =
            new LandingPage();

    page.show(stage);

});

logoutBtn.setPrefWidth(250);
            viewBtn.setOnAction(e -> {

    ViewArtefactsPage page =
            new ViewArtefactsPage();

    page.show(stage);

});

    addBtn.setPrefWidth(250);
    viewBtn.setPrefWidth(250);

    VBox root =
            new VBox(20);
         root.setStyle(
    "-fx-background-color: linear-gradient(to bottom, #f5f7fa, #dfe9f3);"+"-fx-background-image: url('file:resources/images/museum_bg.png');" +
    "-fx-background-size: cover;" +
    "-fx-background-position: center;"
);

    root.setAlignment(Pos.CENTER);

    root.setPadding(
            new Insets(30)
    );

    root.getChildren().addAll(
            title,
            addBtn,
            viewBtn,
            logoutBtn
    );

    Scene scene =
            new Scene(root,900,600);

    stage.setScene(scene);
    stage.show();
    styleButton(addBtn);
styleButton(viewBtn);
styleButton(logoutBtn);
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

