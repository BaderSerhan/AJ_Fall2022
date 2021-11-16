package session10_events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AnonymousHandlerDemo extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Hold two buttons in an HBox
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btNew = new Button("New");
        Button btOpen = new Button("Open");
        Button btSave = new Button("Save");
        Button btPrint = new Button("Print");
        hBox.getChildren().addAll(btNew, btOpen, btSave, btPrint);

        // Create and register the handlers
        btNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("New pressed using Anonymous Inner class.");
            }
        });

        //lambda expression
        btOpen.setOnAction((ActionEvent event) -> {
            System.out.println("Open pressed using Lambda Expression.");
        } //closing the curly braces of the lambda expression
        ); //closing the parantheses of setOnAction

        //lambda expression with multiple statements inside
        btSave.setOnAction(event -> {
            System.out.println("Save pressed using Lambda Expression.");

            //Example on Alert control
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Alert Title");
            alert.setHeaderText("Alert Header");
            alert.setContentText("Alert Content");

            alert.show();
        });

        //lambda expression with one statement only
        btPrint.setOnAction(event -> System.out.println("Print pressed using Lambda expression."));

        // Create a scene and place it in the stage
        Scene scene = new Scene(hBox, 300, 75);
        primaryStage.setTitle("AnonymousHandlerDemo"); // Set title
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
