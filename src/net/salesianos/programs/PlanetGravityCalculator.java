package programs;

public class PlanetGravityCalculator {
    
    // Gravitational constant
    private static final double G = 6.67430e-11; // m³/(kg·s²)

    public static void main(String[] args) {

        if (args.length < 1) {

            System.out.println("No se proporcionaron los datos del planeta.");
            return;
        }

        try {

            double mass = Double.parseDouble(args[1]);
            double radius = Double.parseDouble(args[2]); 

            double gravity = G * (mass / (radius * radius));

            System.out.println(gravity);

        } catch (NumberFormatException e) {

            System.err.println("Formato incorrecto en los datos: " + e.getMessage());
        
        } catch (Exception e) {
        
            System.err.println("Error al calcular la gravedad: " + e.getMessage());
        }
    }
}
