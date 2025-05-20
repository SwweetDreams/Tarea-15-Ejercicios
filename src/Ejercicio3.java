import java.util.Scanner;

public class Ejercicio3 {

    public static boolean evaluarCarrera(String[] acciones, String pista) {
        if (acciones.length != pista.length()) {
            throw new IllegalArgumentException("La longitud de las acciones y la pista deben ser iguales.");
        }

        StringBuilder pistaModificada = new StringBuilder(pista);
        boolean carreraSuperada = true;

        for (int i = 0; i < pista.length(); i++) {
            char tramo = pista.charAt(i);
            String accion = acciones[i];

            if (tramo == '_' && accion.equals("run")) {
            } else if (tramo == '|' && accion.equals("jump")) {
            } else if (tramo == '_' && accion.equals("jump")) {
                pistaModificada.setCharAt(i, 'x');
                carreraSuperada = false;
            } else if (tramo == '|' && accion.equals("run")) {
                pistaModificada.setCharAt(i, '/');
                carreraSuperada = false;
            } else {
                throw new IllegalArgumentException("Acción inválida: " + accion);
            }
        }

        System.out.println("Pista final: " + pistaModificada);
        return carreraSuperada;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la pista (use '_' para correr y '|' para saltar):");
        String pista = scanner.nextLine();

        System.out.println("Ingrese las acciones separadas por comas (ejemplo: run,jump,run):");
        String[] acciones = scanner.nextLine().split(",");

        if (acciones.length != pista.length()) {
            System.out.println("Error: La cantidad de acciones debe coincidir con la longitud de la pista.");
            return;
        }

        boolean resultado = evaluarCarrera(acciones, pista);
        System.out.println("¿Carrera superada? " + resultado);
    }
}
