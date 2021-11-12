/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session7_panes;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author bader-aul
 */
public class GridPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        //initialize my components
        Label fLabel = new Label("First Name");
        Label mLabel = new Label("MI");
        Label lLabel = new Label("Last Name");

        TextField firstTF = new TextField();
        TextField middleTF = new TextField();
        middleTF.setPrefColumnCount(1);
        TextField lastTF = new TextField();

        Button addBtn = new Button("Add");

        GridPane root = new GridPane();

        //---------------------------------------------------------
        //adding children one by one
        root.add(fLabel, 0, 0);
        root.add(mLabel, 0, 1);
        root.add(lLabel, 0, 2);

        root.add(firstTF, 1, 0);
        root.add(middleTF, 1, 1);
        root.add(lastTF, 1, 2);
        //add the button by setting just columnIndex and rowIndex
//        root.add(addBtn, 1, 3);
        //add the button by setting columnIndex, rowIndex, and columnSpan, rowSpan to allow taking multiple columns/rows
        root.add(addBtn, 0, 3, 2, 1);

        //to align the button to the right
//        GridPane.setHalignment(addBtn, HPos.RIGHT);
        //to allow the button to grow in width
        addBtn.setMaxWidth(Double.MAX_VALUE);

        //---------------------------------------------------------
        //---------------------------------------------------------
        // or adding children column by column by specifying the columnIndex
        // root.addColumn(0, fLabel, mLabel, lLabel);
        // root.addColumn(1, firstTF, middleTF, lastTF, addBtn);
        //---------------------------------------------------------
        //---------------------------------------------------------
        //or adding children row by row by specifying the rowIndex
        // root.addRow(0, fLabel, firstTF);
        // root.addRow(1, mLabel, middleTF);
        // root.addRow(2, lLabel, lastTF);
        // root.addRow(3, addBtn);
        //---------------------------------------------------------
        //set alignment of gridpane with respect to its container (scene)
        root.setAlignment(Pos.CENTER);
        //---------------------------------------------------------

        //set horizontal gap between children (in same row but different columns)
        root.setHgap(20);
        //---------------------------------------------------------

        //set vertical gap between children (in same column but different rows)
        root.setVgap(10);
        //---------------------------------------------------------

//        root.setGridLinesVisible(true);
        Scene scene = new Scene(root, 400, 200);

        primaryStage.setTitle("GridPane Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //----------------------------------------------------------------------------
    //QUESTIONS
    //1 - find out how to limit middleNameTF's column count to 1 in GridPane
    //          ANSWER: by setting the FillWidth property to false in the GridPane class
    //          GridPane.setFillWidth(middleTF, false);
    //----------------------------------------------------------------------------
    //2 - find out how to align the add button to the right of the text fields
    //          ANSWER: align the button to the right horizontally by using the static method setHalignment from the GridPane class and providing it with the child node to align
    //          GridPane.setHalignment(addBtn, HPos.RIGHT);
    //----------------------------------------------------------------------------
    //3 - find out how to let the add button take multiple columns
    //          ANSWER: add the button by setting columnIndex, rowIndex, and columnSpan, rowSpan to allow taking multiple columns/rows
    //          BUT ALSO NEED TO allow the button to grow in width by setting its maxWidth property (because buttons don't automatically grow)
    //          addBtn.setMaxWidth(Double.MAX_VALUE);
    //----------------------------------------------------------------------------
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
