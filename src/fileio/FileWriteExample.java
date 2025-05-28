package fileio;

import java.io.FileWriter;
import java.io.IOException;

//Writing to a File Using FileWriter

public class FileWriteExample {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("Output.txt")) {
            writer.write("Hello, this is a file write example.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}