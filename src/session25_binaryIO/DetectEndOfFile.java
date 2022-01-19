package session25_binaryIO;

import java.io.*;

public class DetectEndOfFile {

    /*
     * How to Detect End of File Has Been Reached?
     * A - Text File
     * => Use Scanner's hasNext() method
     * B- Binary File
     * 1 => Check if input.read() returns -1
     * 2 => Check if input.available() > 0
     * 3 => Check if EOFException is caught
     */
    public static void main(String[] args) {
        try {
            try (DataOutputStream output
                    = new DataOutputStream(new FileOutputStream("DetectEOF.dat"))) {
                output.writeDouble(4.5);
                output.writeDouble(43.25);
                output.writeDouble(3.2);
            }

            try (DataInputStream input
                    = new DataInputStream(new FileInputStream("DetectEOF.dat"))) {
                //instead of checking if there are more bytes to read
                //we can let it read infinitely and when an EOF exception is caught
                //then I can continue with my program
                while (true) {
                    System.out.println(input.readDouble());
                }
            }
        } catch (EOFException ex) {
            System.out.println("All data were read");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //Continue program here
    }
}
