// package ui;

// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.Tab;
// import javafx.scene.control.TabPane;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;

// public class AdminPanel extends Application 
// {
//     @Override
//     public void start(Stage stage)
//     {
//         stage.setTitle(
//         "Indian Museum Artefact Digitisation System");
//                 // 1. Create the TabPane
//             TabPane tabPane = new TabPane();
//             tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

//             tabPane.setStyle(
//                 "-fx-tab-min-width: 180px;" +        // Extends button clickable width
//                 "-fx-tab-max-width: 300px;" +
//                 "-fx-tab-min-height: 45px;" +        // Taller elegant tab selector header bar
//                 "-fx-background-color: #2C3E50;" +   // Elegant deep dark navy color header block
//                 "-fx-focus-color: transparent;" +    // Removes ugly default dashed focus square outline
//                 "-fx-faint-focus-color: transparent;"
//             );

//             // 2. Create Tab 1 and set its content
//             Tab tab1 = new Tab("Manage Artefacts");
//             tab1.setClosable(false); // Prevents the user from closing this tab
            
//             //StackPane tab1Content = new StackPane();
//             //VBox tab1Content = new VBox(10);
//             Label title =
//                 new Label("Administrator Panel");
//                             title.setStyle(
//                     "-fx-font-size:30px;" +
//                     "-fx-font-weight:bold;" +
//                     "-fx-text-fill:white;");
                    
//             Button addBtn =
//             new Button("Add Artefact");
//                 addBtn.setOnAction(e -> {

//                 AddArtefactPage page =new AddArtefactPage();
//                 page.show(stage);

//                 });

//             Button viewBtn =
//                 new Button("View Artefacts");
//                 Button logoutBtn =
//             new Button("Logout");
//             logoutBtn.setOnAction(e -> {

//             LandingPage page =
//                 new LandingPage();

//             page.show(stage);

//             });

//             logoutBtn.setPrefWidth(250);
//                 viewBtn.setOnAction(e -> {

//                 ViewArtefactsPage page =
//                 new ViewArtefactsPage();

//                 page.show(stage);

//             });

//             addBtn.setPrefWidth(250);
//             viewBtn.setPrefWidth(250);

//             VBox root =
//                     new VBox(20);
//                 root.setStyle(
//             "-fx-background-color: linear-gradient(to bottom, #f5f7fa, #dfe9f3);"+"-fx-background-image: url('file:resources/images/museum_bg.png');" +
//             "-fx-background-size: cover;" +
//             "-fx-background-position: center;"
//             );

//             root.setAlignment(Pos.CENTER);

//             root.setPadding(
//                     new Insets(30)
//             );

//             root.getChildren().addAll(
//                     title,
//                     addBtn,
//                     viewBtn,
//                     logoutBtn
//             );
//             tab1.setContent(root);
        

//             // 3. Create Tab 2 and set its content
//             // --- 1. Create Tab 2 and set its basic properties ---
//             Tab tab2 = new Tab("Manage Users");
//             tab2.setClosable(false); // Prevents users from closing the tab accidental layout drops

//             // --- 2. Create Header Label ---
//             Label title2 = new Label("User Management Panel");
//             title2.setStyle(
//                 "-fx-font-size:30px;" +
//                 "-fx-font-weight:bold;" +
//                 "-fx-text-fill:white;"
//             );

//             // --- 3. Create Option Buttons ---
//             Button addUserBtn = new Button("Add User");
//             addUserBtn.setOnAction(e -> {
//                 AddUser page = new AddUser();
//                 page.show(stage);
//             });

//             Button deleteUserBtn = new Button("Delete User");
//             deleteUserBtn.setOnAction(e -> {
//                 DeleteUser page = new DeleteUser();
//                 page.show(stage);
//             });

//             Button logoutBtn2 = new Button("Logout");
//             logoutBtn2.setOnAction(e -> {
//                 LandingPage page = new LandingPage();
//                 page.show(stage);
//             });

//             // Set uniform widths for all option buttons
//             addUserBtn.setPrefWidth(250);
//             deleteUserBtn.setPrefWidth(250);
//             logoutBtn2.setPrefWidth(250);

//             // Apply styles using your helper method (assuming styleButton is available in AdminPanel)
//             styleButton(addUserBtn);
//             styleButton(deleteUserBtn);
//             styleButton(logoutBtn2);

//             // --- 4. Assemble the layout container ---
//             VBox root2 = new VBox(20); // Spacing of 20px matching Tab 1
//             root2.setStyle(
//                 "-fx-background-color: linear-gradient(to bottom, #f5f7fa, #dfe9f3);" +
//                 "-fx-background-image: url('file:resources/images/museum_bg.png');" +
//                 "-fx-background-size: cover;" +
//                 "-fx-background-position: center;"
//             );
//             root2.setAlignment(Pos.CENTER);
//             root2.setPadding(new Insets(30));

//             // Add children layout elements to VBox container
//             root2.getChildren().addAll(
//                 title2,
//                 addUserBtn,
//                 deleteUserBtn,
//                 logoutBtn2
//             );

//             // --- 5. Assign view panel layout to Tab 2 content frame ---
//             tab2.setContent(root2);
//                     // 4. Add both tabs to the TabPane
                
//         decorateTabLabel(tab1);
//         decorateTabLabel(tab2);
//                 tabPane.getTabs().addAll(tab1, tab2);
//                 Scene scene =
//                         new Scene(tabPane,900,600);
//                 stage.setScene(scene);
//                 stage.show();
//                 styleButton(addBtn);
//                 styleButton(viewBtn);
//                 styleButton(logoutBtn);
//                 addBtn.setPrefWidth(250);
//                 viewBtn.setPrefWidth(250);
                
            

//     }
//     private void styleButton(Button btn) {

//         btn.setStyle(

//             "-fx-background-color: #2E86DE;" +
//             "-fx-text-fill: white;" +
//             "-fx-font-size: 14px;" +
//             "-fx-font-weight: bold;" +
//             "-fx-background-radius: 10px;"

//         );

//         btn.setPrefHeight(40);
//     }
//     private void decorateTabLabel(Tab tab) {
//         Label tabLabel = new Label(tab.getText());
//         tabLabel.setStyle(
//             "-fx-text-fill: black;" +
//             "-fx-font-weight: bold;" +
//             "-fx-font-size: 14px;" +
//             "-fx-font-family: 'Segoe UI', Arial, sans-serif;" +
//             "-fx-padding: 5 15 5 15;"
//         );
//         tab.setGraphic(tabLabel);
//         tab.setText(null); // Wipe default text out so it doesn't duplicate
//     }

// public static void main(String[] args) {
//          launch(args);
//      }
// }

package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminPanel extends Application 
{
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Indian Museum Artefact Digitisation System");
        
        // 1. Create the TabPane
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // 🔥 GLOBAL BACKGROUND: Applied directly to the TabPane so it covers everything, including the top tab bar space
        tabPane.setStyle(
            "-fx-background-image: url('file:resources/images/museum_bg.png');" +
            "-fx-background-size: cover;" +
            "-fx-background-position: center;" +
            "-fx-tab-min-width: 180px;" +        // Extends button clickable width
            "-fx-tab-max-width: 300px;" +
            "-fx-tab-min-height: 45px;" +       // Taller elegant tab selector header bar
            "-fx-focus-color: transparent;" +    // Removes default dashed focus square outline
            "-fx-faint-focus-color: transparent;"
        );

        // 2. Create Tab 1 and set its content
        Tab tab1 = new Tab("Manage Artefacts");
        tab1.setClosable(false); 
        
        Label title = new Label("Administrator Panel");
        title.setStyle(
            "-fx-font-size:30px;" +
            "-fx-font-weight:bold;" +
            "-fx-text-fill:white;"
        );
                
        Button addBtn = new Button("Add Artefact");
        addBtn.setOnAction(e -> {
            AddArtefactPage page = new AddArtefactPage();
            page.show(stage);
        });

        Button viewBtn = new Button("View Artefacts");
        Button logoutBtn = new Button("Logout");
        
        logoutBtn.setOnAction(e -> {
            LandingPage page = new LandingPage();
            page.show(stage);
        });

        viewBtn.setOnAction(e -> {
            ViewArtefactsPage page = new ViewArtefactsPage();
            page.show(stage);
        });

        VBox root = new VBox(20);
        // ✨ TRANSPARENT BACKGROUND: Allows the TabPane background to show through the content area
        root.setStyle("-fx-background-color: transparent;");
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));

        root.getChildren().addAll(
                title,
                addBtn,
                viewBtn,
                logoutBtn
        );
        tab1.setContent(root);
    

        // 3. Create Tab 2 and set its content
        Tab tab2 = new Tab("Manage Users");
        tab2.setClosable(false); 

        Label title2 = new Label("User Management Panel");
        title2.setStyle(
            "-fx-font-size:30px;" +
            "-fx-font-weight:bold;" +
            "-fx-text-fill:white;"
        );

        Button addUserBtn = new Button("Add User");
        addUserBtn.setOnAction(e -> {
            AddUser page = new AddUser();
            page.show(stage);
        });

        Button deleteUserBtn = new Button("Delete User");
        deleteUserBtn.setOnAction(e -> {
            DeleteUser page = new DeleteUser();
            page.show(stage);
        });

        Button logoutBtn2 = new Button("Logout");
        logoutBtn2.setOnAction(e -> {
            LandingPage page = new LandingPage();
            page.show(stage);
        });

        VBox root2 = new VBox(20); 
        // ✨ TRANSPARENT BACKGROUND: Allows the TabPane background to show through the content area
        root2.setStyle("-fx-background-color: transparent;");
        root2.setAlignment(Pos.CENTER);
        root2.setPadding(new Insets(30));

        root2.getChildren().addAll(
            title2,
            addUserBtn,
            deleteUserBtn,
            logoutBtn2
        );
        tab2.setContent(root2);
                
        // 4. Decorate Tab Titles and Assembly
        decorateTabLabel(tab1);
        decorateTabLabel(tab2);
        tabPane.getTabs().addAll(tab1, tab2);
        
        // 5. Apply sizing layout specs uniformly across all buttons
        styleButton(addBtn);
        styleButton(viewBtn);
        styleButton(logoutBtn);
        styleButton(addUserBtn);
        styleButton(deleteUserBtn);
        styleButton(logoutBtn2);

        Scene scene = new Scene(tabPane, 900, 600);
        
        // 💡 CRITICAL STYLING FIX: Removes the default solid grey header bar color built into JavaFX's TabPane skin
        scene.getStylesheets().add("data:text/css," +
            ".tab-header-area, .tab-header-background, .tab-content-area {" +
            "    -fx-background-color: transparent !important;" +
            "}" +
            ".tab {" +
            "    -fx-background-color: rgba(255, 255, 255, 0.15);" + // Gives tabs a subtle sleek semi-transparent back plate
            "    -fx-background-radius: 5 5 0 0;" +
            "}" +
            ".tab:selected {" +
            "    -fx-background-color: rgba(46, 134, 222, 0.4);" +   // Colors the active selected tab smoothly
            "}"
        );

        stage.setScene(scene);
        stage.show();
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
        btn.setPrefWidth(250); // Uniformly handles sizing logic layout tasks here
    }

    private void decorateTabLabel(Tab tab) {
        Label tabLabel = new Label(tab.getText());
        tabLabel.setStyle(
            "-fx-text-fill: white;" + // Flipped text color to white for contrast on your dark museum background image
            "-fx-font-weight: bold;" +
            "-fx-font-size: 14px;" +
            "-fx-font-family: 'Segoe UI', Arial, sans-serif;" +
            "-fx-padding: 5 15 5 15;"
        );
        tab.setGraphic(tabLabel);
        tab.setText(null); 
    }

    public static void main(String[] args) {
         launch(args);
    }
}