/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author bader-aul
 */
public class ActionEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        //TODO: write my own logic here
        System.out.println("Hello World!!!!!!");
    }

}
