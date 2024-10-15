package utils;

import java.io.File;
import java.io.IOException;

public class ProcessLauncher {
    private static final String GRAVITY_CALCULATOR_ROUTE = "src/net/salesianos/programs/PlanetGravityCalculator.java";

    /**
     * Initializes and starts the gravity calculator process.
     * 
     * @param name     Stands for the name of the planet.
     * @param mass     Stands for the mass of the planet (in kilograms).
     * @param radius   Stands for the radius of the planet (in meters).
     * @param fileName Stands for the name of the file where the process output will be saved.
     * @return A Process object representing the started gravity calculation process.
     * @throws IOException If there is an error starting the process or creating the output file.
     */
    public static Process initGravityCalculator(String name, String mass, String radius, String fileName) throws IOException {

        ProcessBuilder processBuilder = new ProcessBuilder(
            "java", GRAVITY_CALCULATOR_ROUTE, name, mass, radius
        );

        File outputFile = new File("src/net/salesianos/files/output/" + fileName);

        processBuilder.redirectOutput(outputFile);
        processBuilder.redirectError(new File("src/net/salesianos/files/errors/Error.txt"));

        return processBuilder.start();
    }
}
