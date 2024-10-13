package utils;

import java.io.File;
import java.io.IOException;

public class ProcessLauncher {
    private static final String GRAVITY_CALCULATOR_ROUTE = "net.salesianos.processes.PlanetGravityCalculator";

    public static Process initGravityCalculator(String planetInfo, String outputPath) throws IOException {


        ProcessBuilder processBuilder = new ProcessBuilder(
            "java", GRAVITY_CALCULATOR_ROUTE, planetInfo
        );


        processBuilder.redirectOutput(new File(outputPath));
        processBuilder.redirectError(new File("./files/errors/Error.txt"));

        return processBuilder.start();
    }
}
