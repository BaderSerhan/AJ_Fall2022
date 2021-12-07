/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session12_animations;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author bader-aul
 */
public class BasicTimelineDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Rectangle rect = new Rectangle(100, 50, 100, 50);
        rect.setFill(Color.RED);

        //TODO: Create Timeline Animation
        Timeline t = new Timeline();
        t.setAutoReverse(true);
        t.setCycleCount(Timeline.INDEFINITE);

        KeyValue kv = new KeyValue(rect.xProperty(), 300); //getX * 3

        KeyFrame kf = new KeyFrame(Duration.millis(500), kv);

        t.getKeyFrames().add(kf);

        t.play();

        Pane root = new Pane(rect);

        Scene scene = new Scene(root, 600, 300);

        primaryStage.setTitle("Basic Timeline Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
