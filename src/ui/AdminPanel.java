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

    Button updateBtn =
            new Button("Update Artefact");

    Button deleteBtn =
            new Button("Delete Artefact");

    Button viewBtn =
            new Button("View Artefacts");
            viewBtn.setOnAction(e -> {

    ViewArtefactsPage page =
            new ViewArtefactsPage();

    page.show(stage);

});

    addBtn.setPrefWidth(250);
    updateBtn.setPrefWidth(250);
    deleteBtn.setPrefWidth(250);
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
            updateBtn,
            deleteBtn,
            viewBtn
    );

    Scene scene =
            new Scene(root,900,600);

    stage.setScene(scene);
    stage.show();
}


}

