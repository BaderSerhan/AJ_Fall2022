package session12_animations;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FadeTransitionDemo extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Place an ellipse to the pane
        Pane pane = new Pane();
        Ellipse ellipse = new Ellipse(10, 10, 100, 50);
        ellipse.setFill(Color.RED);
        ellipse.setStroke(Color.BLACK);
        ellipse.centerXProperty().bind(pane.widthProperty().divide(2));
        ellipse.centerYProperty().bind(pane.heightProperty().divide(2));
        ellipse.radiusXProperty().bind(
                pane.widthProperty().multiply(0.4));
        ellipse.radiusYProperty().bind(
                pane.heightProperty().multiply(0.4));
        pane.getChildren().add(ellipse);

        // Apply a fade transition to ellipse
        FadeTransition ft = new FadeTransition();
        ft.setNode(ellipse);
        ft.setDuration(Duration.millis(1000));
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setAutoReverse(true);
        ft.setCycleCount(Timeline.INDEFINITE);

        // Start animation
        ft.play();

        // Control animation
        ellipse.setOnMousePressed(e -> ft.pause());
        ellipse.setOnMouseReleased(e -> ft.play());

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("FadeTransitionDemo"); // Set the stage title
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
