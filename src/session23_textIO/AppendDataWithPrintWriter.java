package session23_textIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class AppendDataWithPrintWriter {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("scores.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(0);
        }

        // If file does not exist, it will be created
        // Data will always be added to the end of the file
        try (PrintWriter output = new PrintWriter(new FileOutputStream(file, true))) {
            // Write formatted output to the file
            output.print("Chandler Bing\t");
            output.println(44);
            output.print("Rachel Green\t");
            output.println(78);
            System.out.println("Data written successfully");
        }
    }
}
