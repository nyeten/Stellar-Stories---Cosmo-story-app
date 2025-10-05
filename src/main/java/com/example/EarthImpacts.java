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
    String slide1Text = "_____.";
    String slide2Text = "ojoejfoiofejevfeoijeijeoiiejeoje foiojf.";
    String slide3Text = "_____.";
    String slide4Text = "_____.";

    // Track the current slide index
    int currentSlide = 0;

    // Array of slide image URLs (placeholders for now)
    String[] slideUrls = {"/images/donut.png", "/images/solar.png", "/images/nuc.png", "/images/smoke.png"};
    String[] slideTexts = {slide1Text, slide2Text, slide3Text, slide4Text};

    // //its empty, I'll ad more eventually
    public EarthImpacts(Stage stage) {
        this.stage = stage;
    }

    // method is called after the FXML file has been loaded but the current contents will be moved
    public void initialize() {

        //set initial image and text
        slides.setImage(new Image(getClass().getResource("/images/donut.png").toExternalForm()));
        foreground.setImage(new Image(getClass().getResource("/images/donut.png").toExternalForm()));
        textPrinter(slide1Text);

        updateButtons(); // Disable the Previous button on the first slide
    }
    
    @FXML 
    private void backToMenu() throws IOException {
        System.out.println("boooooooooooooombs");
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
        Timeline timeline = new Timeline();
        for (int i = 0; i < fullText.length(); i++) {
            final int index = i;
            KeyFrame keyFrame = new KeyFrame(
                Duration.millis(50 * (i + 1)), // speed: 50ms per character
                event -> {
                    displayedText.append(fullText.charAt(index));
                    textBox.setText(displayedText.toString());
                }
            );
            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.setOnFinished(event -> {
            nextSlide.setDisable(goNext);
            prevSlide.setDisable(goPrev);
        });
        timeline.play();

    }
}
