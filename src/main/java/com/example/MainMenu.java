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
    private void switchToCME() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/cme.fxml"));
        CME controller = new CME(stage);
        loader.setController(controller);
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }
    @FXML
    private void switchToEarthImpacts() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/earthImpacts.fxml"));
        EarthImpacts controller = new EarthImpacts(stage);
        loader.setController(controller);
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }

    @FXML
    private void switchToSpaceWeather() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/spaceWeather.fxml"));
        SpaceWeather controller = new SpaceWeather(stage);
        loader.setController(controller);
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }

}