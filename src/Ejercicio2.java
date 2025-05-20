import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Ejercicio2 {

    public static int calcularDiferenciaDias(String fecha1, String fecha2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate date1 = LocalDate.parse(fecha1, formatter);
            LocalDate date2 = LocalDate.parse(fecha2, formatter);
            return (int) Math.abs(ChronoUnit.DAYS.between(date1, date2));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Una de las cadenas no representa una fecha válida.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese la primera fecha (dd/MM/yyyy): ");
            String fecha1 = scanner.nextLine();

            System.out.print("Ingrese la segunda fecha (dd/MM/yyyy): ");
            String fecha2 = scanner.nextLine();

            int diferencia = calcularDiferenciaDias(fecha1, fecha2);
            System.out.println("Diferencia en días: " + diferencia);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
