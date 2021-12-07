package session12_animations;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FlagRisingAnimation extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane
        Pane pane = new Pane();

        Line line = new Line(450, 20, 450, 500);
        line.setStyle("-fx-stroke-width:8px; -fx-stroke:blue");
        pane.getChildren().add(line);

        // Add an image view and add it to pane
        ImageView imageView = new ImageView(new Image("file:lebanon-flag.jpg"));
        pane.getChildren().add(imageView);

        // Create a path transition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(5000));
        pt.setPath(new Line(250, 500, 250, 130));
        pt.setNode(imageView);
        pt.setCycleCount(1);

        // Start animation
        pt.play();

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("FlagRisingAnimation"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
