import java.util.ArrayList;

import utils.FileHelper;
import utils.ProcessLauncher;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<String> planetData = FileHelper.getAllLines("src/net/salesianos/files/input/planets.txt");

        ArrayList<Process> planetProcesses = new ArrayList<>();

        for (int i = 0; i < planetData.size(); i++) {
            String outputFile = "./files/output/gravity-" + i + ".txt";
            Process subprocess = ProcessLauncher.initGravityCalculator(planetData.get(i), outputFile);
            planetProcesses.add(subprocess);
        }

        for (Process process : planetProcesses) {
            process.waitFor();
        }

        System.out.println("Resultados de los cálculos de gravedad:");
        for (int i = 0; i < planetData.size(); i++) {
            File file = new File("./files/output/gravity-" + i + ".txt");
            double gravity = FileHelper.getGravity(file);
            System.out.println("Gravedad calculada para el planeta " + (i + 1) + ": " + gravity + " m/s²");
            file.delete();
        }

        System.out.println("Saliendo del programa...");
    }
}
