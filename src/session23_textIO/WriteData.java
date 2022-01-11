package session23_textIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteData {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("scores.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(0);
        }

        // Write formatted output to the file
        // Create a file
        try (PrintWriter output = new PrintWriter(file)) {
            // Write formatted output to the file
            output.print("John T Smith\t");
            output.println(92);
            output.print("Eric K Jones\t");
            output.println(84);
            output.print("Richard H Green\t");
            output.println(88);
            System.out.println("Data written successfully");
        }
    }
}
