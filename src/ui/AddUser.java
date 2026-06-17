package ui;

import dao.UserDAO;
import dao.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AddUser {

    private TableView<User> userTable = new TableView<>();
    private ObservableList<User> userList = FXCollections.observableArrayList();

    public void show(Stage stage) {
        stage.setTitle("Add New User");

        // Header
        Label title = new Label("Register New System User");
        title.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: #000000;");

        // Form Layout
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(15);
        form.setPadding(new Insets(20));
        form.setAlignment(Pos.CENTER);
        form.setStyle("-fx-background-color: rgba(255,255,255,0.8); -fx-background-radius: 10;");

        TextField txtId = new TextField();
        txtId.setPromptText("Numeric ID");
        TextField txtUser = new TextField();
        txtUser.setPromptText("Username");
        PasswordField txtPass = new PasswordField();
        txtPass.setPromptText("Password");

        form.add(new Label("User ID:"), 0, 0);   form.add(txtId, 1, 0);
        form.add(new Label("Username:"), 0, 1); form.add(txtUser, 1, 1);
        form.add(new Label("Password:"), 0, 2); form.add(txtPass, 1, 2);

        Button btnSave = new Button("Register User");
        Button btnBack = new Button("Back to Menu");
        styleButton(btnSave, "#27ae60");
        styleButton(btnBack, "#7f8c8d");

        HBox actions = new HBox(10, btnSave, btnBack);
        actions.setAlignment(Pos.CENTER);
        form.add(actions, 0, 3, 2, 1);

        // Table Setup
        setupTable();
        loadUsers();

        // Logic
        btnSave.setOnAction(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                if (UserDAO.add_User(new User(id, txtUser.getText(), txtPass.getText()))) {
                    showAlert(Alert.AlertType.INFORMATION, "Success", "User added!");
                    loadUsers();
                }
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid Input.");
            }
        });

        btnBack.setOnAction(e -> new AdminPanel().start(stage));

        VBox root = new VBox(20, title, form, new Label("Current Users:"), userTable);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);
        root.setStyle("-fx-background-image: url('file:resources/images/lighter_bg.png'); -fx-background-size: cover;");

        stage.setScene(new Scene(root, 800, 600));
    }

    private void setupTable() {
        TableColumn<User, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("ID"));
        TableColumn<User, String> colName = new TableColumn<>("User");
        colName.setCellValueFactory(new PropertyValueFactory<>("user"));
        userTable.getColumns().addAll(colId, colName);
        userTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    private void loadUsers() {
        userList.setAll(UserDAO.getAllUsers());
        userTable.setItems(userList);
    }

    private void styleButton(Button b, String color) {
        b.setStyle("-fx-background-color: " + color + "; -fx-text-fill: white; -fx-font-weight: bold;");
        b.setPrefWidth(120);
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert a = new Alert(type);
        a.setTitle(title);
        a.setContentText(content);
        a.show();
    }
}