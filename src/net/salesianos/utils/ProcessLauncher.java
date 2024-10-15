package utils;

import java.io.File;
import java.io.IOException;

public class ProcessLauncher {
    private static final String GRAVITY_CALCULATOR_ROUTE = "src/net/salesianos/programs/PlanetGravityCalculator.java";

    public static Process initGravityCalculator(String name, String mass, String radius, String outputPath) throws IOException {

        ProcessBuilder processBuilder = new ProcessBuilder(
            "java", GRAVITY_CALCULATOR_ROUTE, name, mass, radius
        );

        Process javaProcess = null;

        try {
            File newFile = new File("files/output/" + outputPath);
            processBuilder.redirectOutput(newFile);
            System.out.println("Entro");
            javaProcess = processBuilder.start();
        } catch (IOException e) {
            processBuilder.redirectError(new File("files/errors/Error.txt"));
        }

        return javaProcess;
    }
}
