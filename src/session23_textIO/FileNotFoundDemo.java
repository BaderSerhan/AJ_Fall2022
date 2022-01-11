/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session23_textIO;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author bader-aul
 */
public class FileNotFoundDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File file = new File("javaDemo123.txt");

            if (file.createNewFile()) {
                System.out.println("file does not exist, but was successfully created");
            } else {
                System.out.println("file already exists");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error creating file");
            //TODO: handle error cases
        }

    }

}
