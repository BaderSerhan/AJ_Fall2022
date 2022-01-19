package session25_binaryIO;

import java.io.*;

public class TestDataStream {

    public static void main(String[] args) throws IOException {
        // Create a DataOutputStream on top of FileOutputStream for the file
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("DataStreamTest.dat"));) {
            // Write student test scores to the file
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeUTF("Jim");
            output.writeDouble(185.5);
            output.writeUTF("George");
            output.writeDouble(105.25);
        }

        // Create a DataInputStream on top of FileInputStream for the file
        try (DataInputStream input = new DataInputStream(new FileInputStream("DataStreamTest.dat"));) {
            // Read student test scores from the file
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
        }
    }
}
