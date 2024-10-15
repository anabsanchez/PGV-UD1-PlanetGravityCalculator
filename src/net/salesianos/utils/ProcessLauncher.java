package utils;

import java.io.File;
import java.io.IOException;

public class ProcessLauncher {
    private static final String GRAVITY_CALCULATOR_ROUTE = "src/net/salesianos/programs/PlanetGravityCalculator.java";

    public static Process initGravityCalculator(String name, String mass, String radius, String fileName) throws IOException {

        ProcessBuilder processBuilder = new ProcessBuilder(
            "java", GRAVITY_CALCULATOR_ROUTE, name, mass, radius
        );

        File outputFile = new File("files/output/" + fileName);

        System.out.println("Entro");
        processBuilder.redirectOutput(outputFile);
        processBuilder.redirectError(new File("files/errors/Error.txt"));

        return processBuilder.start();
    }
}
