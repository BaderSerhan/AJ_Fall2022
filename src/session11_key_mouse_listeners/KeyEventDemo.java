package session11_key_mouse_listeners;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeyEventDemo extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane and set its properties
        Pane pane = new Pane();
        Text text = new Text(20, 20, "A");
        pane.getChildren().addAll(text, new Button("Press Me!"));

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("KeyEventDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        //using generic add event handler function
        //differentiate between event types inside handle function
//        text.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                if (event.getEventType().equals(KeyEvent.KEY_PRESSED)) {
//                    System.out.println("setOnKeyPressed: getCharacter = " + e.getCharacter());
//                    System.out.println("setOnKeyPressed: getCode = " + e.getCode().toString());
//                    System.out.println("setOnKeyPressed: getText = " + e.getText() + "\n");
//                    switch (event.getCode()) {
//                        case DOWN:
//                            text.setY(text.getY() + 10);
//                            break;
//                        case UP:
//                            text.setY(text.getY() - 10);
//                            break;
//                        case LEFT:
//                            text.setX(text.getX() - 10);
//                            break;
//                        case RIGHT:
//                            text.setX(text.getX() + 10);
//                            break;
//                        default:
//                            if (event.getText().length() > 0) {
//                                text.setText(event.getText());
//                            }
//                    }
//                }
//
//                if (event.getEventType().equals(KeyEvent.KEY_TYPED)) {
//                    System.out.println("setOnKeyTyped: getCharacter = " + e.getCharacter());
//                    System.out.println("setOnKeyTyped: getCode = " + e.getCode().toString());
//                    System.out.println("setOnKeyTyped: getText = " + e.getText() + "\n");
//                }
//            }
//        });
//
        text.setOnKeyTyped(e -> {
            System.out.println("setOnKeyTyped: getCharacter = " + e.getCharacter());
            System.out.println("setOnKeyTyped: getCode = " + e.getCode().toString());
            System.out.println("setOnKeyTyped: getText = " + e.getText() + "\n");
        });
        //
        scene.setOnKeyPressed(e -> {
            System.out.println("setOnKeyPressed: getCharacter = " + e.getCharacter());
            System.out.println("setOnKeyPressed: getCode = " + e.getCode());
            System.out.println("setOnKeyPressed: getText = " + e.getText());
            switch (e.getCode()) {
                case DOWN:
                    text.setY(text.getY() + 10);
                    break;
                case UP:
                    text.setY(text.getY() - 10);
                    break;
                case LEFT:
                    text.setX(text.getX() - 10);
                    break;
                case RIGHT:
                    text.setX(text.getX() + 10);
                    break;
                default:
                    if (e.getText().length() > 0) {
                        text.setText(e.getText());
                    }
            }
        });
//        text.requestFocus(); // text is focused to receive key input
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
