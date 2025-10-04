package com.example;

import javafx.stage.Stage;
import javafx.scene.control.Slider;
import javafx.scene.control.Slider;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
// import javafx.scene.image.Image;
import javafx.scene.image.ImageView;




public class SolarFlare {  

    Stage stage;
    
    @FXML
    private Slider stageSlider;
    @FXML
    private ImageView foreground;

    @FXML
    private ImageView solarSlides;

    @FXML
    private StackPane root;
    //its empty, I'll ad more eventually
    public SolarFlare(Stage stage) {
        this.stage = stage;
    }

    // method is called after the FXML file has been loaded but the current contents will be moved
    public void initialize() {

        solarSlides.setImage(new Image(
            getClass().getResource("/images/solar.png").toExternalForm()
        ));

        foreground.setImage(new Image(
            getClass().getResource("/images/donut.png").toExternalForm()
        ));


        //add listener to slider to detect changes in value
        stageSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            int value = newVal.intValue();
            int oldValue = oldVal.intValue();

            
            if (value >= 0 && value <= 33 && oldValue > 33) {
                //change image to slide0.png
                solarSlides.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/images/solar.png")));

            }
            if (value >= 34 && value <= 66 && (oldValue <= 33 || oldValue > 66)) {
                //change image to slide1.png
                solarSlides.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/images/nuc.png")));

            }
            if (value >= 67 && value < 100 && oldValue <= 66) {
                //change image to slide2.png
                solarSlides.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/images/flare.png")));

            }
        });

    }
// 
// 
// 
//
// 
// 
// 
// 
//

}
