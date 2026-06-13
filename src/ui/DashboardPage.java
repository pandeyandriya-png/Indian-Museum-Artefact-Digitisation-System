package ui;

import dao.SearchDAO;
import model.Artefact;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardPage {

public void show(Stage stage) {

    Label title =
            new Label("Indian Museum Artefact Dashboard");

    title.setStyle(
            "-fx-font-size:24px;" +
            "-fx-font-weight:bold;"
    );

    ComboBox<String> dynastyBox =
            new ComboBox<>();

    ComboBox<String> regionBox =
            new ComboBox<>();

    ComboBox<String> typeBox =
            new ComboBox<>();

    ComboBox<String> materialBox =
            new ComboBox<>();

    dynastyBox.setItems(
            SearchDAO.getDynasties()
    );

    regionBox.setItems(
            SearchDAO.getRegions()
    );

    typeBox.setItems(
            SearchDAO.getTypes()
    );

    materialBox.setItems(
            SearchDAO.getMaterials()
    );

    dynastyBox.setValue("All");
    regionBox.setValue("All");
    typeBox.setValue("All");
    materialBox.setValue("All");

    Button searchBtn =
            new Button("Search");

    TableView<Artefact> table =
            new TableView<>();

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
            dynastyCol,
            regionCol
    );

    table.setItems(
            SearchDAO.getAllArtefacts()
    );

searchBtn.setOnAction(e -> {

    ObservableList<Artefact> results =
            SearchDAO.searchArtefacts(

                    dynastyBox.getValue(),
                    regionBox.getValue(),
                    typeBox.getValue(),
                    materialBox.getValue()

            );

    table.setItems(results);

});

    GridPane filters =
            new GridPane();

    filters.setHgap(10);
    filters.setVgap(10);

    filters.add(
            new Label("Dynasty"),0,0
    );

    filters.add(
            dynastyBox,1,0
    );

    filters.add(
            new Label("Region"),0,1
    );

    filters.add(
            regionBox,1,1
    );

    filters.add(
            new Label("Type"),0,2
    );

    filters.add(
            typeBox,1,2
    );

    filters.add(
            new Label("Material"),0,3
    );

    filters.add(
            materialBox,1,3
    );

    filters.add(
            searchBtn,1,4
    );

    VBox topBox =
            new VBox(15);

    topBox.getChildren().addAll(
            title,
            filters
    );

    BorderPane root =
            new BorderPane();

    root.setPadding(
            new Insets(20)
    );

    root.setTop(topBox);

    root.setCenter(table);

    Scene scene =
            new Scene(root,1000,700);

    stage.setScene(scene);
    stage.show();
}


}
