package session25_binaryIO;

import java.io.*;

public class TestFileStream {

    public static void main(String[] args) throws IOException {
        // Create an output stream to the file
        try (FileOutputStream output = new FileOutputStream("TestFileStream.obj");) {
            // Output values to the file
            for (int i = 1; i <= 10; i++) {
                output.write(i);
            }
        }

        // Create an input stream for the file
        try (FileInputStream input = new FileInputStream("TestFileStream.obj");) {
            // Read values from the file
            int value;
            //check if input.read() function returns -1 meaning end of file
            //has been reached to stop the loop
            while ((value = input.read()) != -1) {
                System.out.print(value + " ");
            }
        }
    }
}
