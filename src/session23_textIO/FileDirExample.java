/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session23_textIO;

import java.io.File;

/**
 *
 * @author bader-aul
 */
public class FileDirExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f = new File("/Users/bader-aul/Documents/AUL");

        if (f.isDirectory()) {
            File files[] = f.listFiles();
            for (File file : files) {
                System.out.println(file.getName() + " is a directory? " + file.isDirectory());
            }
        }
    }

}
