package ui;

import dao.SearchDAO;
import model.Artefact;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardPage {

public void show(Stage stage) {

    Label title =
            new Label("Indian Museum Artefact Dashboard");

   title.setStyle(

    "-fx-font-size:30px;" +
    "-fx-font-weight:bold;" +
    "-fx-text-fill:black;"
);
stage.setTitle(
    "Indian Museum Artefact Digitisation System"
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

     dynastyBox.setPrefWidth(140);
        regionBox.setPrefWidth(140);
        typeBox.setPrefWidth(140);
        materialBox.setPrefWidth(140); 

    Button searchBtn =
            new Button("Search");
            Button backBtn =
            new Button("Back");
HBox filterBar = new HBox(15);

filterBar.setAlignment(Pos.CENTER_LEFT);
//new
Label dynastyLabel = new Label("Dynasty");
Label regionLabel = new Label("Region");
Label typeLabel = new Label("Type");
Label materialLabel = new Label("Material");
String filterLabelStyle =
    "-fx-font-size:16px;" +
    "-fx-font-weight:bold;" +
    "-fx-text-fill:black;" 
   ;

dynastyLabel.setStyle(filterLabelStyle);
regionLabel.setStyle(filterLabelStyle);
typeLabel.setStyle(filterLabelStyle);
materialLabel.setStyle(filterLabelStyle);

dynastyBox.setPrefSize(170, 35);
regionBox.setPrefSize(170, 35);
typeBox.setPrefSize(170, 35);
materialBox.setPrefSize(170, 35);


filterBar.getChildren().addAll(

        dynastyLabel,
        dynastyBox,

        regionLabel,
        regionBox,

        typeLabel,
        typeBox,

        materialLabel,
        materialBox,

        searchBtn,

        backBtn
);
searchBtn.setStyle(

        "-fx-background-color: #2E86DE;" +
        "-fx-text-fill: white;" +
        "-fx-font-weight: bold;" +
        "-fx-background-radius: 10;"

);

searchBtn.setPrefSize(100,40);
backBtn.setStyle(

        "-fx-background-color: #6B4226;" +
        "-fx-text-fill: white;" +
        "-fx-font-weight: bold;" +
        "-fx-background-radius: 10;"

);

backBtn.setPrefSize(80,40);

    TableView<Artefact> table =
            new TableView<>();
               table.setOpacity(0.85);
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
backBtn.setOnAction(e -> {

    LandingPage page =
            new LandingPage();

    page.show(stage);

});
      
    VBox topBox =
            new VBox(25);
topBox.setAlignment(Pos.CENTER);
topBox.setPadding(new Insets(10, 0, 20, 0));
filterBar.setAlignment(Pos.CENTER);

    topBox.getChildren().addAll(
            title,
            filterBar
    );

    BorderPane root =
            new BorderPane();
    root.setStyle(
    "-fx-background-image: url('file:resources/images/dashboard_bg.png');" + "-fx-background-color: linear-gradient(to bottom, #f5f7fa, #dfe9f3);"
);

    root.setPadding(
            new Insets(20)
    );
    //trial
       BorderPane tableWrapper = new BorderPane(table);
   tableWrapper.setStyle(
    "-fx-background-color: rgba(255,255,255,0.25);" +
    "-fx-background-radius: 15;"
);
    root.setMargin(tableWrapper, new Insets(20, 0, 0, 0));
    root.setTop(topBox);

    root.setCenter(tableWrapper);

    Scene scene =
            new Scene(root,1000,700);

    stage.setScene(scene);
    stage.show();
}


}
