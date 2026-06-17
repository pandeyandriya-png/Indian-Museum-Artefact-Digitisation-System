package ui;

import dao.UserDAO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeleteUser {

    public void show(Stage stage) {
        stage.setTitle("Delete User");

        Label title = new Label("Remove User from System");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: black;");

        VBox box = new VBox(15);
        box.setPadding(new Insets(30));
        box.setAlignment(Pos.CENTER);
        box.setMaxWidth(400);
        box.setStyle("-fx-background-color: rgba(255,255,255,0.9); -fx-background-radius: 15;");

        TextField txtId = new TextField();
        txtId.setPromptText("Enter User ID to Delete");
        txtId.setPrefHeight(40);

        Button btnDelete = new Button("Confirm Deletion");
        btnDelete.setStyle("-fx-background-color: #c0392b; -fx-text-fill: white; -fx-font-weight: bold;");
        btnDelete.setPrefSize(200, 40);

        Button btnBack = new Button("Cancel");
        btnBack.setOnAction(e -> new AdminPanel().start(stage));

        box.getChildren().addAll(new Label("Enter unique ID:"), txtId, btnDelete, btnBack);

        btnDelete.setOnAction(e -> {
            String idStr = txtId.getText().trim();
            if (!idStr.isEmpty()) {
                try {
                    int id = Integer.parseInt(idStr);
                    if (UserDAO.delete_User(id)) {
                        new Alert(Alert.AlertType.INFORMATION, "User Deleted.").show();
                        txtId.clear();
                    } else {
                        new Alert(Alert.AlertType.ERROR, "User ID not found.").show();
                    }
                } catch (NumberFormatException ex) {
                    new Alert(Alert.AlertType.ERROR, "Numeric ID required.").show();
                }
            }
        });

        VBox root = new VBox(20, title, box);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-image: url('file:resources/images/lighter_bg.png'); -fx-background-size: cover;");

        stage.setScene(new Scene(root, 600, 450));
    }
}