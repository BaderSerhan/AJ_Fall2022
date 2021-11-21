package assignment01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GeometryInsideCircle extends Application {

    static final double WIDTH = 400;
    static final double HEIGHT = 120;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Circle circle = new Circle(100, 60, 50, Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        Text message = new Text(200, 60, "Mouse is outside the circle.");
        pane.getChildren().add(circle);
        pane.getChildren().add(message);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);

        circle.setOnMouseEntered(e -> {
            message.setText("Mouse point is inside the circle.");
        });

        circle.setOnMouseExited(e -> {
            message.setText("Mouse point is outside the circle.");
        });

        primaryStage.setTitle("Geometry Inside Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
