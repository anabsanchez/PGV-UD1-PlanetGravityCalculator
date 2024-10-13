package processes;

public class PlanetGravityCalculator {
    
    // Gravitational constant
    private static final double G = 6.67430e-11; // m³/(kg·s²)

    public static void main(String[] args) {

        if (args.length < 1) {

            System.out.println("No se proporcionaron los datos del planeta.");
            return;
        }

        String[] data = args[0].split(",");
        String name = data[0];
        double mass = Double.parseDouble(data[1]);
        double radius = Double.parseDouble(data[2]); 

        double gravity = G * (mass / (radius * radius));

        System.out.println(name + " -> " + gravity + " m/s²");
    }
}
