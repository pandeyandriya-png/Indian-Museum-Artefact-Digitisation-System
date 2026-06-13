package app;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.LandingPage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        LandingPage landingPage = new LandingPage();
        landingPage.show(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
