package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        //creates a fxml loader with a path to the file mainMenu.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/solar/mainMenu.fxml"));
        //makes instance of MainMenu java class, and sets the controller of fxml-
        // as java class, allowing you to initialize it with the stage variable
        MainMenu controller = new MainMenu(stage);
        loader.setController(controller);
        //switch the scene to the loaded fxml file
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}