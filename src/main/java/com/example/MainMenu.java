package com.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import javafx.stage.Stage;

public class MainMenu {

    Stage stage;

    public MainMenu(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void switchToTut1() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/solarFlare.fxml"));
        SolarFlare controller = new SolarFlare(stage);
        loader.setController(controller);
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }

    @FXML
    private void switchToTut2() throws IOException {
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/app/tut2.fxml"));
        // Tut2 controller = new Tut1(stage);
        // loader.setController(controller);
        // Scene scene = new Scene(loader.load());
        // stage.setScene(scene);
    }
    @FXML
    private void switchToTut3() throws IOException {
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/app/tut3.fxml"));
        // Tut3 controller = new Tut1(stage);
        // loader.setController(controller);
        // Scene scene = new Scene(loader.load());
        // stage.setScene(scene);
    }

    @FXML
    private void switchToTut4() throws IOException {
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/app/tut4.fxml"));
        // Tut4 controller = new Tut1(stage);
        // loader.setController(controller);
        // Scene scene = new Scene(loader.load());
        // stage.setScene(scene);
    }

}