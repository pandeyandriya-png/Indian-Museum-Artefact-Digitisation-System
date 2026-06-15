
package app;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ui.LandingPage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {

            primaryStage.getIcons().add(new Image("file:resources/images/museum.png"));
        } catch (Exception e) {
            System.out.println("Could not load top-left window icon: " + e.getMessage());
        }

        primaryStage.setTitle("Indian Museum Artefact Digitisation System");

        LandingPage landingPage = new LandingPage();
        landingPage.show(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}