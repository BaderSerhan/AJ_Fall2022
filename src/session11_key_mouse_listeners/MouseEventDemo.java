package session11_key_mouse_listeners;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MouseEventDemo extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        Pane pane = new Pane();
        Text text = new Text(100, 100, "Programming is fun");
        text.setStyle("-fx-border-color: blue;");
        pane.getChildren().addAll(text);

        //generic mouse event using lambda expression
        text.addEventHandler(MouseEvent.ANY, e -> {
            System.out.println(e.getEventType().getName());
        });

        text.setOnMouseDragged(e -> {
            text.setX(e.getX());
            text.setY(e.getY());
            System.out.println("X: = " + e.getX() + ", Y:= " + e.getY());
            System.out.println("SceneX: = " + e.getSceneX() + ", SceneY:= " + e.getSceneY());
            System.out.println("ScreenX: = " + e.getScreenX() + ", ScreenY:= " + e.getScreenY());
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("MouseEventDemo"); // Set the stage title
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
