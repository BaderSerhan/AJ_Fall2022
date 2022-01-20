package assignment02;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Slideshow extends Application {

    private int index = 0;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        Image[] image = new Image[10];
        for (int i = 0; i < 10; i++) {
            image[i] = new Image("File:images/slide" + i + ".jpg");
        }

        ImageView imageView = new ImageView(image[0]);

        Pane pane = new Pane();
        pane.getChildren().add(imageView);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle("Slideshow"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(2000), e -> {
                    imageView.setImage(image[++index % 10]);
                }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation

        pane.setOnMouseClicked(e -> {
            if (animation.getStatus() == Animation.Status.RUNNING) {
                animation.pause();
            } else {
                animation.play();
            }
        });
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
