import java.util.ArrayList;

import utils.FileHelper;
import utils.ProcessLauncher;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<String> planets = FileHelper.getAllLines("src/net/salesianos/files/input/planets.txt");
        ArrayList<Process> calculatorProcesses = new ArrayList<>();

        for (int i = 0; i < planets.size(); i++) {
            String[] planetData = planets.get(i).split(",");
            String name = planetData[0];
            String mass = planetData[1];
            String radius = planetData[2];

            Process process = ProcessLauncher.initGravityCalculator(name, mass, radius, "gravity-" + name + ".txt");
            calculatorProcesses.add(process);
        }

        for (Process process : calculatorProcesses) {
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nResultados de los cálculos de gravedad:\n");
        
        for (String planet : planets) {
            String name = planet.split(",")[0];
            File file = new File("src/net/salesianos/files/output/gravity-" + name + ".txt");

            if (file.exists()) {
                FileHelper.getGravity(file);
            } else {
                System.out.println("No se encontró el archivo de salida para " + name);
            }
        }

        System.out.println("\nSaliendo del programa...");
    }
}
