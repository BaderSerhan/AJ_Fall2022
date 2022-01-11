/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session23_textIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author bader-aul
 */
public class FileNotFoundExceptionDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Enter a filename: ");
        Scanner inputFromConsole = new Scanner(System.in);

        String filename = inputFromConsole.nextLine();

        File file = new File(filename);

        try {
            Scanner inputFromFile = new Scanner(file);
            System.out.println("file exists");
            //... TODO: process file / read data from file

        } catch (FileNotFoundException ex) {
            System.out.println("file does not exist");
            ex.printStackTrace();
        }
    }

}
