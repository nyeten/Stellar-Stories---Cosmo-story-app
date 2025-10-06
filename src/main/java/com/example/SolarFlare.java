package com.example;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.Slider;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
// import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;



public class SolarFlare {  
    // Reference to the main application stage
    Stage stage;
    
    //FXML annotations link the variables to the elements in the fxml file
    @FXML
    private Slider stageSlider;
    @FXML
    private ImageView foreground;
    @FXML
    private ImageView solarSlides;
    @FXML
    private Text textBox;
    @FXML
    private StackPane root;
    @FXML
    private Text caption;

    //String for each slide with description of current process
    String slide1Text = "Solar flares start as sudden bursts\nof energy on the Sun’s surface.";
    String slide2Text = "The energy grows quickly, and\nthe flare becomes brighter and stronger.";
    String slide3Text = "At its peak, the flare shoots out\nhigh-energy light and particles into space.";
    String slide4Text = "The flare can then travel to te earth,\nnteracting with satelites rotating around the platet.";

    //its empty, I'll ad more eventually
    public SolarFlare(Stage stage) {
        this.stage = stage;
    }

    // method is called after the FXML file has been loaded but the current contents will be moved
    public void initialize() {
        //set initial image and text
        solarSlides.setImage(new Image(
            getClass().getResource("/images/FlareStart.png").toExternalForm()
        ));
 
        foreground.setImage(new Image(
            getClass().getResource("/images/Default_Shuttle.png").toExternalForm()
        ));

        textBox.setText(slide1Text);
        caption.setText("Move slider at bottom to see solar flare progression");


        //add listener to slider to detect changes in value
        stageSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            int value = newVal.intValue();
            int oldValue = oldVal.intValue();

            
            if (value >= 0 && value <= 20 && oldValue > 20) {
                //change image to first slide
                solarSlides.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/images/FlareStart.png")));
                textBox.setText(slide1Text);
            } else if (value >= 21 && value <= 40 && (oldValue <= 20 || oldValue > 40)) {
                //change image to second slide
                solarSlides.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/images/FlareAlmostFormed.png")));
                textBox.setText(slide2Text);
            }  else if (value >= 41 && value <= 60 && (oldValue <= 40 || oldValue > 60)) {
                //change image to third slide
                solarSlides.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/images/FlareToFormed.png")));
                textBox.setText(slide2Text);
            } else if (value >= 61 && value <= 80 && (oldValue <= 60 || oldValue > 80)) {
                //change image to fourth slide
                solarSlides.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/images/FlareToEarth.png")));
                textBox.setText(slide3Text);
            } else if (value >= 81 && value < 100 && oldValue <= 80) {
                //change image to fifth slide
                solarSlides.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/images/FlareHitSatelite.png")));
                textBox.setText(slide4Text);
            }
        });

    }

    @FXML     //go back to Main Menu
    private void exitThing() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/mainMenu.fxml"));
        MainMenu mainMenu = new MainMenu(stage);
        loader.setController(mainMenu);
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);   
    }

}
