package assignment01;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MoveBall extends Application {

    private int sceneWidth = 400, sceneHeight = 150;
    private Circle circle;
    private Scene scene;

    @Override
    // Override the start method in the Application class
    public void start(Stage primaryStage) {
        //create the circle component and place it inside a pane
        Pane pane = new Pane();
        pane.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));

        circle = new Circle(150, sceneHeight / 2, 20);
        circle.setFill(Color.RED);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);

        // Create four buttons and place them inside a borderPane
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");

        HBox hbox = new HBox(btLeft, btRight);
        VBox vbox = new VBox(btUp, hbox, btDown);

        hbox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);

        hbox.setSpacing(10);
        vbox.setSpacing(10);

        hbox.setPadding(new Insets(10));
        vbox.setPadding(new Insets(10));

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setRight(vbox);

        // Create a scene and place it in the stage
        scene = new Scene(borderPane, sceneWidth, sceneHeight);
        primaryStage.setTitle("Move a Ball"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        btLeft.setOnAction(e -> moveLeft());
        btRight.setOnAction(e -> moveRight());
        btUp.setOnAction(e -> moveUp());
        btDown.setOnAction(e -> moveDown());

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W:
                    moveUp();
                    break;
                case A:
                    moveLeft();
                    break;
                case S:
                    moveDown();
                    break;
                case D:
                    moveRight();
                    break;
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

    public void moveLeft() {
        circle.setCenterX(circle.getCenterX() - 10);
    }

    public void moveRight() {
        circle.setCenterX(circle.getCenterX() + 10);
    }

    public void moveUp() {
        circle.setCenterY(circle.getCenterY() > - 20 ? circle.getCenterY() - 10 : scene.getHeight() + 20);
    }

    public void moveDown() {
        circle.setCenterY(circle.getCenterY() < scene.getHeight() + 20 ? circle.getCenterY() + 10 : -20);
    }
}
