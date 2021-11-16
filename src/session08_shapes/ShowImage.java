package session08_shapes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ShowImage extends Application {

    //online image url prefixed with https://
    String imageUrl = "https://picsum.photos/200";

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane to hold the image views
        Pane pane = new HBox(10);
        pane.setPadding(new Insets(5, 5, 5, 5));

        /**
         * create image from local path
         * e.g. path:
         * C:\\Users\\Bader\\Documents\\NetBeansProjects\\AJLab_Fall2021\\girl.png
         *
         * prefix it with 'file:///' or 'File:'
         */
        Image image = new Image("File:images/girl.png");

        //first image view is created in-line using Image object
        //no height or width is set => default image sizing is considered
        pane.getChildren().add(new ImageView(image));

        //second image view is created using online image URL
        ImageView imageView2 = new ImageView(imageUrl);
        //set fit height and width to image
        imageView2.setFitHeight(100);
        imageView2.setFitWidth(100);

        pane.getChildren().add(imageView2);

        //third image view created and rotated 90 degrees
        ImageView imageView3 = new ImageView(image);
        imageView3.setRotate(90);
        //by setting only height OR width with preserve ratio, the original ratio of the image will be preserved
        imageView3.setFitHeight(200);
        imageView3.setPreserveRatio(true);

        pane.getChildren().add(imageView3);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowImage"); // Set the stage title
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
