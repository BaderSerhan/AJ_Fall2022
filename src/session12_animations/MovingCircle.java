package session12_animations;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MovingCircle extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    
    Pane pane = new Pane();
    
    Circle circle = new Circle();
    circle.setRadius(50);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.WHITE);
    pane.getChildren().add(circle);

    Timeline timeline = new Timeline();
	double startX = Math.random() * 700 + 50;
	double startY = Math.random() * 500 + 50;
	double endX = Math.random() * 700 + 50;
	double endY = Math.random() * 500 + 50;
	startX = 150; startY = 150; endX = 650; endY = 450;
	
	System.out.println(startX + "  " + startY + "  " + endX + "  " + endY);
 
	KeyFrame k1 = new KeyFrame(Duration.ZERO, // set start position at 0
            new KeyValue(circle.centerXProperty(), startX),
            new KeyValue(circle.centerYProperty(), startY));
	
	KeyFrame k2 = new KeyFrame(new Duration(5000), // set end position 
            new KeyValue(circle.centerXProperty(), endX),
            new KeyValue(circle.centerYProperty(), endY));
	
    timeline.getKeyFrames().addAll(k1, k2);

    timeline.play();

    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 800, 600);
    primaryStage.setTitle("Moving Circle"); // Set the stage title
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

