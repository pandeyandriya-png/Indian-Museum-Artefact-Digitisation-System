package ui;

import dao.ArtefactDAO;
import model.Artefact;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UpdateArtefactPage {
public void show(Stage stage, Artefact artefact) {

    Label title =
            new Label("Update Artefact");

    title.setStyle(
            "-fx-font-size:24px;" +
            "-fx-font-weight:bold;"
    );

    TextField nameField =
            new TextField(
                    artefact.getName()
            );

    TextField typeField =
            new TextField(
                    artefact.getType()
            );

    TextField materialField =
            new TextField(
                    artefact.getMaterial()
            );

    TextArea descriptionArea =
            new TextArea(
                    artefact.getDescription()
            );

    Button saveBtn =
            new Button("Save Changes");
            Button backBtn =
        new Button("Back");

backBtn.setOnAction(e -> {

    ViewArtefactsPage page =
            new ViewArtefactsPage();

    page.show(stage);

});

    saveBtn.setOnAction(e -> {

        boolean success =
                ArtefactDAO.updateArtefact(

                        artefact.getId(),

                        nameField.getText(),

                        typeField.getText(),

                        materialField.getText(),

                        descriptionArea.getText()

                );

        Alert alert;

        if(success) {

            alert =
                    new Alert(
                            Alert.AlertType.INFORMATION
                    );

            alert.setContentText(
                    "Updated Successfully!"
            );

        } else {

            alert =
                    new Alert(
                            Alert.AlertType.ERROR
                    );

            alert.setContentText(
                    "Update Failed!"
            );
        }

        alert.showAndWait();
        ViewArtefactsPage page =
        new ViewArtefactsPage();

page.show(stage);
    });

    GridPane root =
            new GridPane();

    root.setAlignment(Pos.CENTER);

    root.setPadding(
            new Insets(20)
    );

    root.setHgap(10);
    root.setVgap(10);

    root.add(title,0,0,2,1);

    root.add(new Label("Name"),0,1);
    root.add(nameField,1,1);

    root.add(new Label("Type"),0,2);
    root.add(typeField,1,2);

    root.add(new Label("Material"),0,3);
    root.add(materialField,1,3);

    root.add(new Label("Description"),0,4);
    root.add(descriptionArea,1,4);

    root.add(saveBtn,1,5);
    root.add(backBtn,1,6);
    Scene scene =
            new Scene(root,700,500);

    stage.setScene(scene);
    stage.show();
}
}

