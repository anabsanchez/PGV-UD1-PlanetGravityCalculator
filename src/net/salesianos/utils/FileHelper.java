package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileHelper {

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

    public static double getGravity(File file) {

        String result = "?";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            result = reader.readLine();
            reader.close();
            System.out.println(result);

        } catch (IOException e) {

            System.out.println("No se pudo obtener el resultado del archivo: " + file.getName());
        }
        return Double.parseDouble(result);
    }
}
