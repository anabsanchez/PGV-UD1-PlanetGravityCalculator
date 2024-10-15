package programs;

public class PlanetGravityCalculator {
    
    // Gravitational constant
    private static final float G = 6.67430e-11F; // m³/(kg·s²)

    /**
     * Main method that calculates the gravitational acceleration on a planet 
     * based on its mass and radius.
     * 
     * @param args Command-line arguments: name of the planet, mass (kg), and radius (m).
     */
    public static void main(String[] args) {

        if (args.length < 1) {

            System.out.println("No se proporcionaron los datos del planeta.");
            return;
        }

        try {

            String name = args[0];
            float mass = Float.parseFloat(args[1]);
            float radius = Float.parseFloat(args[2]); 

            float gravity = G * (mass / (radius * radius));

            System.out.println("Gravedad calculada para " + name + ": " + gravity + "m/s²");

        } catch (NumberFormatException e) {

            System.err.println("Formato incorrecto en los datos: " + e.getMessage());
        
        } catch (Exception e) {
        
            System.err.println("Error al calcular la gravedad: " + e.getMessage());
        }
    }
}
