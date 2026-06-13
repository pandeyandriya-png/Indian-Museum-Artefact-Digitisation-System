package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import dao.ArtefactDAO;
import javafx.scene.control.Alert;

public class AddArtefactPage {


public void show(Stage stage) {

    Label title =
            new Label("Add New Artefact");

    title.setStyle(
            "-fx-font-size:24px;" +
            "-fx-font-weight:bold;"
    );

    TextField nameField =
            new TextField();

    TextField materialField =
            new TextField();

    ComboBox<String> typeBox =
            new ComboBox<>();

    ComboBox<String> dynastyBox =
            new ComboBox<>();

    ComboBox<String> regionBox =
            new ComboBox<>();

    TextArea descriptionArea =
            new TextArea();

    typeBox.getItems().addAll(
            "Sculpture",
            "Coin",
            "Ritual Object",
            "Arms and Armours"
    );

    dynastyBox.getItems().addAll(
            "Maurya Dynasty",
            "Gupta Dynasty",
            "Chola Dynasty",
            "Kushan Dynasty"
    );

    regionBox.getItems().addAll(
            "Sarnath",
            "Mathura",
            "Uttar Pradesh",
            "Bihar"
    );

    Button saveBtn =
            new Button("Save Artefact");
            Button backBtn =
        new Button("Back");

backBtn.setOnAction(e -> {

    AdminPanel panel =
            new AdminPanel();

    panel.show(stage);

});
    saveBtn.setOnAction(e -> {

    boolean success =
            ArtefactDAO.addArtefact(

                    nameField.getText(),
                    typeBox.getValue(),
                    materialField.getText(),

                    getDynastyId(
                            dynastyBox.getValue()
                    ),

                    getRegionId(
                            regionBox.getValue()
                    ),

                    descriptionArea.getText()

            );

    Alert alert;

    if(success) {

        alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setContentText(
                "Artefact Added Successfully!"
        );

    } else {

        alert =
                new Alert(
                        Alert.AlertType.ERROR
                );

        alert.setContentText(
                "Failed To Add Artefact"
        );
    }

    alert.showAndWait();
    AdminPanel panel =
        new AdminPanel();

panel.show(stage);
});

    GridPane root =
            new GridPane();

    root.setAlignment(Pos.CENTER);

    root.setHgap(10);
    root.setVgap(10);

    root.setPadding(
            new Insets(20)
    );

    root.add(title,0,0,2,1);

    root.add(new Label("Name"),0,1);
    root.add(nameField,1,1);

    root.add(new Label("Type"),0,2);
    root.add(typeBox,1,2);

    root.add(new Label("Material"),0,3);
    root.add(materialField,1,3);

    root.add(new Label("Dynasty"),0,4);
    root.add(dynastyBox,1,4);

    root.add(new Label("Region"),0,5);
    root.add(regionBox,1,5);

    root.add(new Label("Description"),0,6);
    root.add(descriptionArea,1,6);

    root.add(saveBtn,1,7);
    root.add(backBtn,1,8);

    Scene scene =
            new Scene(root,800,600);

    stage.setScene(scene);
    stage.show();
}
private int getDynastyId(String dynasty) {

    switch (dynasty) {

        case "Maurya Dynasty": return 1;
        case "Gupta Dynasty": return 2;
        case "Chola Dynasty": return 3;
        case "Kushan Dynasty": return 4;

        default: return 1;
    }
}

private int getRegionId(String region) {

    switch (region) {

        case "Sarnath": return 1;
        case "Mathura": return 2;
        case "Uttar Pradesh": return 3;
        case "Bihar": return 4;

        default: return 1;
    }
}
}

