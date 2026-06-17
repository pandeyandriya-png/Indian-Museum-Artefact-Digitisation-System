package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import dao.ArtefactDAO;
import javafx.scene.control.Alert;

public class AddArtefactPage {


public void show(Stage stage) {

    Label title =
            new Label("Add New Artefact");
 title.setStyle(

    "-fx-font-size:30px;" +
    "-fx-font-weight:bold;" +
 "-fx-text-fill:black;"
// +//#1B2631;"
//  "-fx-effect: dropshadow(gaussian, black, 10, 0.8, 2, 2);"
);
stage.setTitle(
    "Indian Museum Artefact Digitisation System"
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
            styleButton(saveBtn);
            Button backBtn =
        new Button("Back");
        styleButton(backBtn);

backBtn.setOnAction(e -> {

    AdminPanel panel =
            new AdminPanel();

    panel.start(stage);

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

panel.start(stage);
});

    GridPane root =
            new GridPane();
    root.setStyle(
    "-fx-background-image: url('file:resources/images/lighter_bg.png');" +
    "-fx-background-size: cover;"+
    "-fx-background-color: rgba(255,255,255,0.35);" +
    "-fx-background-insets: 0;"
);

    root.setAlignment(Pos.CENTER);

    root.setHgap(10);
    root.setVgap(10);

    root.setPadding(
            new Insets(20)
    );

    root.add(title,0,0,2,1);
    GridPane.setHalignment(title, HPos.CENTER);
    //trial
    GridPane formCard =new GridPane();
        root.add(formCard,0,1,2,1);  
        formCard.setAlignment(Pos.CENTER);
        formCard.setHgap(10);
        formCard.setVgap(10);

        formCard.setPadding(
                new Insets(30)
        ); 
        formCard.setStyle(
        "-fx-background-color: rgba(255,255,255,0.65);" +
        "-fx-background-radius: 15;"
        );  

        Label nameLabel = new Label("Name :");
        Label typeLabel = new Label("Type :");
        Label materialLabel = new Label("Material :");
        Label dynastyLabel = new Label("Dynasty :");
        Label regionLabel = new Label("Region :");
        Label descriptionLabel = new Label("Description :");
        String labelStyle =
                "-fx-font-weight:bold;" +
                "-fx-font-size:14px;" +
                "-fx-text-fill:#1B2631;";

        nameLabel.setStyle(labelStyle);
        typeLabel.setStyle(labelStyle);
        materialLabel.setStyle(labelStyle);
        dynastyLabel.setStyle(labelStyle);
        regionLabel.setStyle(labelStyle);
        descriptionLabel.setStyle(labelStyle);
//trial
        nameField.setPrefWidth(300);
        materialField.setPrefWidth(300);
        descriptionArea.setPrefRowCount(5);
//trial
        formCard.add(nameLabel,0,1);
        formCard.add(nameField,1,1);

        formCard.add(typeLabel,0,2);
        formCard.add(typeBox,1,2);

        formCard.add(materialLabel,0,3);
        formCard.add(materialField,1,3);

        formCard.add(dynastyLabel,0,4);
        formCard.add(dynastyBox,1,4);

        formCard.add(regionLabel,0,5);
        formCard.add(regionBox,1,5);

        formCard.add(descriptionLabel,0,6);
        formCard.add(descriptionArea,1,6);

        HBox buttonBox = new HBox(15);
        buttonBox.setAlignment(Pos.CENTER);
        formCard.add(buttonBox,1,7);
        buttonBox.getChildren().addAll(
                saveBtn,
                backBtn
        );
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

