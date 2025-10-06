package com.example;

import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.util.Duration;
import java.io.IOException;



public class EarthImpacts {  
    // Reference to the main application stage
    Stage stage;
    
    //FXML annotations link the variables to the elements in the fxml file
    @FXML
    private ImageView foreground;
    @FXML
    private ImageView slides;
    @FXML
    private Text textBox;
    @FXML
    private StackPane root;
    @FXML
    private Button nextSlide;  
    @FXML
    private Button prevSlide;

    boolean goPrev = false;
    boolean goNext = false;

    //String for each slide with description of current process
    String slide1Text = "Space weather storms, caused by the Sun, can reach Earth.\nThey can disturb technology, travel, and even daily life on our planet.";
    String slide2Text = "Solar flares and storms can interfere with satellites.\nThis disrupts GPS, radio signals, and communication systems we depend on.";
    String slide3Text = "Radiation from solar storms is dangerous for \nastronauts in space and can also affect airplane flights at high altitudes.";
    String slide4Text = "Space weather impacts technology, safety, and nature.\nIt reminds us how connected Earth is to the Sun’s powerful activity.";

    // Track the current slide index
    int currentSlide = 0;

    // Array of slide image URLs (placeholders for now)
    String[] slideUrls = {"/images/solarOutput.png", "/images/satellite.png", "/images/astronaut.png", "/images/aurora.png"};
    String[] slideTexts = {slide1Text, slide2Text, slide3Text, slide4Text};

    // //its empty, I'll ad more eventually
    public EarthImpacts(Stage stage) {
        this.stage = stage;
    }

    // method is called after the FXML file has been loaded but the current contents will be moved
    public void initialize() {

        //set initial image and text
        slides.setImage(new Image(getClass().getResource("/images/solarOutput.png").toExternalForm()));
        foreground.setImage(new Image(getClass().getResource("/images/Default_Shuttle.png").toExternalForm()));
        textPrinter(slide1Text);

        updateButtons(); // Disable the Previous button on the first slide
    }
    
    @FXML     //go back to Main Menu
    private void backToMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/mainMenu.fxml"));
        MainMenu mainMenu = new MainMenu(stage);
        loader.setController(mainMenu);
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);   
    }

    @FXML
    private void next() {
        
        currentSlide++;

        updateButtons();

        // Update the slide image and text based on the current slide index
        slides.setImage(new Image(getClass().getResource(slideUrls[currentSlide]).toExternalForm()));
        textPrinter(slideTexts[currentSlide]);
    }

    @FXML
    private void prev() {
        currentSlide--;

        updateButtons();

        // Update the slide image and text based on the current slide index
        slides.setImage(new Image(getClass().getResource(slideUrls[currentSlide]).toExternalForm()));
        textPrinter(slideTexts[currentSlide]);
    }

    public void updateButtons() {
        if (currentSlide == 0) {
            goPrev = true; // Disable the Prev button on the first slide
        } else {
            goPrev = false; // Enable the Prev button
        }
        prevSlide.setDisable(goPrev);

        if (currentSlide == slideUrls.length - 1) {
            goNext = true; // Disable the Next button on the last slide
        } else {
            goNext = false; // Enable the Next button
        }
        nextSlide.setDisable(goNext);
    }

    public void textPrinter(String fullText) {
        textBox.setText(""); // clear existing text first

        final StringBuilder displayedText = new StringBuilder();
        nextSlide.setDisable(true);
        prevSlide.setDisable(true);
        // Create a Timeline to schedule animations (printing letters over time)
        Timeline timeline = new Timeline();

        for (int i = 0; i < fullText.length(); i++) {
            final int index = i; // capture the current index for use inside the lambda

            // Create a KeyFrame that runs at (50ms * position) in the text
            KeyFrame keyFrame = new KeyFrame(
                Duration.millis(50 * (i + 1)), // delay so each character prints one after another
                event -> {
                    // Append the next character to the displayed text
                    displayedText.append(fullText.charAt(index));

                    // Update the textBox to show the progressively revealed string
                    textBox.setText(displayedText.toString());
                }
            );

            // Add this KeyFrame to the timeline
            timeline.getKeyFrames().add(keyFrame);
        }
        
        // Re-enable buttons after text animation completes
        timeline.setOnFinished(event -> {
            nextSlide.setDisable(goNext);
            prevSlide.setDisable(goPrev);
        });
        timeline.play();

    }
}
