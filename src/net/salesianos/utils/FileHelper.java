package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileHelper {

    /**
     * Reads all lines from a specified file and returns them as an ArrayList of strings.
     * 
     * @param filePath Is the path to the file to be read.
     * @return An ArrayList containing each line of the file as a separate string.
     */
    public static ArrayList<String> getAllLines(String filePath) {

        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {

            String currentLine = reader.readLine();

            while (currentLine != null) {
                lines.add(currentLine);
                currentLine = reader.readLine();
            }

        } catch (IOException e) {

            System.out.println("No se pudo leer el archivo: " + filePath);
        }
        
        return lines;
    }

    /**
     * Reads the gravity result from the specified file and prints it to the console.
     * 
     * @param file Is the file from which to read the gravity result.
     * @return A string representing the gravity result, or "?" if the file cannot be read.
     */
    public static String getGravity(File file) {

        String result = "?";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            result = reader.readLine();
            reader.close();
            System.out.println(result);

        } catch (IOException e) {

            System.out.println("No se pudo obtener el resultado del archivo: " + file.getName());
        }
        return result;
    }
}
