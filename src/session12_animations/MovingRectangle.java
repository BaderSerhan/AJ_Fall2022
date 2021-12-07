package session12_animations;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MovingRectangle extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        Random random = new Random();

        Rectangle rect = new Rectangle(75, 75, 100, 50);
        pane.getChildren().add(rect);

        Timeline timeline2 = new Timeline();
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.setAutoReverse(true);

        KeyValue kVMoveX = new KeyValue(rect.xProperty(), random.nextInt(200) + 500);
        KeyValue kVRotate = new KeyValue(rect.rotateProperty(), random.nextInt(360) + 180);
        KeyValue kVArcHeight = new KeyValue(rect.arcHeightProperty(), 60);
        KeyValue kVArcWidth = new KeyValue(rect.arcWidthProperty(), 60);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(random.nextInt(1000) + 1000), kVMoveX, kVRotate, kVArcHeight, kVArcWidth);

        timeline2.getKeyFrames().add(keyFrame);
        timeline2.play();

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 800, 200);
        primaryStage.setTitle("Moving Rectangle"); // Set the stage title
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
