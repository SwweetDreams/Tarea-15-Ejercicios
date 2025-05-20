import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tipo del Pokémon atacante (Agua, Fuego, Planta, Eléctrico): ");
        String tipoAtacante = scanner.nextLine().trim();

        System.out.print("Ingrese el tipo del Pokémon defensor (Agua, Fuego, Planta, Eléctrico): ");
        String tipoDefensor = scanner.nextLine().trim();

        System.out.print("Ingrese el valor de ataque (1-100): ");
        int ataque = scanner.nextInt();

        System.out.print("Ingrese el valor de defensa (1-100): ");
        int defensa = scanner.nextInt();

        double daño = calcularDaño(tipoAtacante, tipoDefensor, ataque, defensa);

        double efectividad = calcularEfectividad(tipoAtacante, tipoDefensor);
        String mensajeEfectividad = determinarEfectividad(efectividad);

        System.out.println("El daño causado es: " + daño);
        System.out.println("El ataque ha sido: " + mensajeEfectividad);
    }

    private static double calcularDaño(String tipoAtacante, String tipoDefensor, int ataque, int defensa) {
        double efectividad = calcularEfectividad(tipoAtacante, tipoDefensor);
        return 50 * ((double) ataque / defensa) * efectividad;
    }

    private static double calcularEfectividad(String tipoAtacante, String tipoDefensor) {
        if (tipoAtacante.equalsIgnoreCase("Agua")) {
            if (tipoDefensor.equalsIgnoreCase("Fuego")) return 2.0; // Súper efectivo
            if (tipoDefensor.equalsIgnoreCase("Planta")) return 0.5; // No muy efectivo
            if (tipoDefensor.equalsIgnoreCase("Agua")) return 0.5; // No muy efectivo
        } else if (tipoAtacante.equalsIgnoreCase("Fuego")) {
            if (tipoDefensor.equalsIgnoreCase("Planta")) return 2.0; // Súper efectivo
            if (tipoDefensor.equalsIgnoreCase("Agua")) return 0.5; // No muy efectivo
            if (tipoDefensor.equalsIgnoreCase("Fuego")) return 0.5; // No muy efectivo
        } else if (tipoAtacante.equalsIgnoreCase("Planta")) {
            if (tipoDefensor.equalsIgnoreCase("Agua")) return 2.0; // Súper efectivo
            if (tipoDefensor.equalsIgnoreCase("Fuego")) return 0.5; // No muy efectivo
            if (tipoDefensor.equalsIgnoreCase("Planta")) return 0.5; // No muy efectivo
        } else if (tipoAtacante.equalsIgnoreCase("Eléctrico")) {
            if (tipoDefensor.equalsIgnoreCase("Agua")) return 2.0; // Súper efectivo
            if (tipoDefensor.equalsIgnoreCase("Planta")) return 1.0; // Neutral
            if (tipoDefensor.equalsIgnoreCase("Eléctrico")) return 0.5; // No muy efectivo
        }
        return 1.0;
    }

    private static String determinarEfectividad(double efectividad) {
        if (efectividad == 2.0) {
            return "súper efectivo";
        } else if (efectividad == 0.5) {
            return "no muy efectivo";
        } else {
            return "neutral";
        }
    }
}
