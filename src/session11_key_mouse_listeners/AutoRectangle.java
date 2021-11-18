package session11_key_mouse_listeners;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.*;

public class AutoRectangle extends Application {

    /*
     * JavaFX properties provide an addListener method that lets you add event
     * handlers that are called whenever the value of a property changes. You
     * can create two types of property event handlers:
     *
     * A change listener, which is called whenever the value of the property has
     * been recalculated. The change listener is passed three arguments: the
     * property whose value has changed, the previous value of the property, and
     * the new value.
     *
     * An invalidation listener, which is called whenever the value of the
     * property becomes unknown. This event is raised when the value of the
     * property needs to be recalculated, but has not yet been recalculated. An
     * invalidation event listener is passed just one argument: the property
     * object itself.
     *
     * Change and invalidation listeners are defined by functional interfaces
     * named ChangeListener and InvalidationListener. Because these interfaces
     * are functional interfaces, you can use Lambda expressions to implement
     * them.
     *
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        /*
         * create a 100×100 rectangle and set the rectangle’s fill color, stroke
         * color, and stroke width
         */
        Rectangle rect = new Rectangle(100, 100);
        rect.setFill(Color.LIGHTGRAY);
        rect.setStroke(Color.BLACK);
        rect.setStrokeWidth(2);

        /*
         * create a stack pane and set its width and height properties
         */
        StackPane pane = new StackPane();
        pane.setMinWidth(200);
        pane.setPrefWidth(200);
        pane.setMaxWidth(200);
        pane.setMinHeight(200);
        pane.setPrefHeight(200);
        pane.setMaxHeight(200);
        pane.getChildren().add(rect);

        /*
         * binding the rectangle's width & height properties to those of the
         * pane
         *
         * rect.widthProperty().bind(pane.widthProperty().divide(2));
         * rect.heightProperty().bind(pane.heightProperty().divide(2));
         */
        //====================================================================
        /*
         * alternatively, we can add a listener to the width and height
         * properties of the pane so that when they change to new values we
         * adjust the rectangle's width and height accordingly
         */
        //====================================================================
        /*
         * use a Lambda expression to register a change handler with the stack
         * pane’s width parameter. When the stack pane’s width changes, the
         * width of the rectangle is set to one half of the stack pane’s width.
         */
        pane.widthProperty().addListener(
                (observable, oldvalue, newvalue)
                -> rect.setWidth((Double) newvalue / 2));

        /*
         * use a Lambda expression to register a change handler with the stack
         * pane’s height parameter. When the stack pane’s height changes, the
         * height of the rectangle is set to one half of the stack pane’s
         * height.
         */
        pane.heightProperty().addListener(
                (observable, oldvalue, newvalue)
                -> rect.setHeight((Double) newvalue / 2)
        );

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Auto Rectangle");
        primaryStage.show();
    }
}
