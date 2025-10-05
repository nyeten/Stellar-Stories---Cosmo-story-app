package com.example;

import javafx.stage.Stage;
import javafx.scene.control.Slider;
import javafx.scene.control.Slider;

import javafx.fxml.FXML;
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

    //String for each slide with description of current process
    String slide1Text = "Solar flares start as sudden bursts of energy on the Sun’s surface.";
    String slide2Text = "The energy grows quickly, and the flare becomes brighter and stronger.";
    String slide3Text = "At its peak, the flare shoots out high-energy light and particles into space.";
    String slide4Text = "After the peak, the flare fades, leaving behind calmer sunspots.";

    //its empty, I'll ad more eventually
    public SolarFlare(Stage stage) {
        this.stage = stage;
    }

    // method is called after the FXML file has been loaded but the current contents will be moved
    public void initialize() {
        //set initial image and text
        solarSlides.setImage(new Image(
            getClass().getResource("/images/solar.png").toExternalForm()
        ));
 
        foreground.setImage(new Image(
            getClass().getResource("/images/donut.png").toExternalForm()
        ));

        textBox.setText(slide1Text);


        //add listener to slider to detect changes in value
        stageSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            int value = newVal.intValue();
            int oldValue = oldVal.intValue();

            
            if (value >= 0 && value <= 33 && oldValue > 33) {
                //change image to slide0.png
                solarSlides.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/images/solar.png")));
                textBox.setText(slide1Text);
            }
            if (value >= 34 && value <= 66 && (oldValue <= 33 || oldValue > 66)) {
                //change image to slide1.png
                solarSlides.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/images/nuc.png")));
                textBox.setText(slide2Text);
            }
            if (value >= 67 && value < 100 && oldValue <= 66) {
                //change image to slide2.png
                solarSlides.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/images/smoke.png")));
                textBox.setText(slide3Text);
            }
        });

    }

}
