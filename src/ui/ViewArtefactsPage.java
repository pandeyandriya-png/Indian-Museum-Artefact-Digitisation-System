package ui;

import dao.SearchDAO;
import model.Artefact;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import dao.ArtefactDAO;
import javafx.scene.control.Alert;

public class ViewArtefactsPage {

public void show(Stage stage) {

    Label title =
            new Label("View Artefacts");

   title.setStyle(

    "-fx-font-size:30px;" +
    "-fx-font-weight:bold;" +
    "-fx-text-fill:black;"
);

    TableView<Artefact> table =
            new TableView<>();
 table.setStyle(
    "-fx-background-color: rgba(255,255,255,0.65);" +
    "-fx-control-inner-background: rgba(255,255,255,0.65);"
);
            table.setColumnResizePolicy(
     TableView.CONSTRAINED_RESIZE_POLICY
);

    TableColumn<Artefact,Integer> idCol =
            new TableColumn<>("ID");

    idCol.setCellValueFactory(
            new PropertyValueFactory<>("id")
    );

    TableColumn<Artefact,String> nameCol =
            new TableColumn<>("Name");

    nameCol.setCellValueFactory(
            new PropertyValueFactory<>("name")
    );

    TableColumn<Artefact,String> typeCol =
            new TableColumn<>("Type");

    typeCol.setCellValueFactory(
            new PropertyValueFactory<>("type")
    );

    TableColumn<Artefact,String> materialCol =
            new TableColumn<>("Material");

    materialCol.setCellValueFactory(
            new PropertyValueFactory<>("material")
    );

    TableColumn<Artefact,String> dynastyCol =
            new TableColumn<>("Dynasty");

    dynastyCol.setCellValueFactory(
            new PropertyValueFactory<>("dynasty")
    );

    TableColumn<Artefact,String> regionCol =
            new TableColumn<>("Region");

    regionCol.setCellValueFactory(
            new PropertyValueFactory<>("region")
    );

    table.getColumns().addAll(
            idCol,
            nameCol,
            typeCol,
            materialCol,
            dynastyCol,
            regionCol
    );

    ObservableList<Artefact> artefacts =
            SearchDAO.getAllArtefacts();

    table.setItems(artefacts);
    table.setOpacity(0.80);
    Button updateBtn =
            new Button("Update Selected");
            styleButton(updateBtn);

       updateBtn.setOnAction(e -> {

    Artefact selected =
            table.getSelectionModel()
                    .getSelectedItem();

    if(selected == null) {

        Alert alert =
                new Alert(
                        Alert.AlertType.WARNING
                );

        alert.setContentText(
                "Select an artefact first."
        );

        alert.showAndWait();

        return;
    }

    UpdateArtefactPage page =
            new UpdateArtefactPage();

    page.show(stage, selected);

});     

    Button deleteBtn =
            new Button("Delete Selected");
            styleButton(deleteBtn);

    deleteBtn.setOnAction(e -> {

    Artefact selected =
            table.getSelectionModel()
                    .getSelectedItem();

    if(selected == null) {

        Alert alert =
                new Alert(
                        Alert.AlertType.WARNING
                );

        alert.setContentText(
                "Select an artefact first."
        );

        alert.showAndWait();

        return;
    }

    boolean success =
            ArtefactDAO.deleteArtefact(
                    selected.getId()
            );

    if(success) {

        table.setItems(
                SearchDAO.getAllArtefacts()
        );

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setContentText(
                "Artefact Deleted Successfully!"
        );

        alert.showAndWait();

    } else {

        Alert alert =
                new Alert(
                        Alert.AlertType.ERROR
                );

        alert.setContentText(
                "Delete Failed!"
        );

        alert.showAndWait();
    }

});

    Button backBtn =
            new Button("Back");
            styleButton(backBtn);
            updateBtn.setPrefWidth(140);
            updateBtn.setPrefSize(150, 38);
            deleteBtn.setPrefSize(150, 38);
            backBtn.setPrefSize(90, 38);

    backBtn.setOnAction(e -> {

        AdminPanel panel =
                new AdminPanel();

        panel.show(stage);

    });

    HBox buttonBox =new HBox(15);
    buttonBox.setAlignment(Pos.CENTER);
    buttonBox.getChildren().addAll(
        updateBtn,
        deleteBtn,
        backBtn
    );

    BorderPane root =new BorderPane();
    root.setStyle(
    "-fx-background-image: url('file:resources/dashboard_bg.png');" +
    "-fx-background-size: cover;"
);
    root.setPadding(
         new Insets(20)
    );

   root.setTop(title);
   BorderPane.setAlignment(title, Pos.CENTER);
   BorderPane tableWrapper = new BorderPane(table);
   tableWrapper.setStyle(
    "-fx-background-color: rgba(255,255,255,0.25);" +
    "-fx-background-radius: 15;"
);
   root.setCenter(tableWrapper);
   
   root.setBottom(buttonBox);

   BorderPane.setMargin(
        buttonBox,
        new Insets(15,0,0,0)
);

    Scene scene =
            new Scene(root,1100,700);

    stage.setScene(scene);
    stage.show();
}


  private void styleButton(Button btn) {

    btn.setStyle(

        "-fx-background-color: #2E86DE;" +
        "-fx-text-fill: white;" +
        "-fx-font-size: 13px;" +
        "-fx-font-weight: bold;" +
        "-fx-background-radius: 10;" +
        "-fx-cursor: hand;"

    );



    btn.setPrefHeight(40);
    
}

}

