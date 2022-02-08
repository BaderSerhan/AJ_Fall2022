/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session25_binaryIO;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author bader-aul
 */
public class TestTextFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        System.out.println("Please enter your ID: ");
        Scanner scan = new Scanner(System.in);
        PrintWriter pw = new PrintWriter("ids.txt");

        while (true) {
            pw.println(scan.nextInt());
            pw.flush();
        }

    }

}
