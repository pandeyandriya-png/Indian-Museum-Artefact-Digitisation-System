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
            "-fx-font-size:24px;" +
            "-fx-font-weight:bold;"
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
}


}

