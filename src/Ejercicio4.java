import java.util.Scanner;

public class Ejercicio4 {
    public static String analizarMatriz(String[][] matriz) {
        if (!esMatrizValida(matriz)) {
            return "Nulo";
        }

        boolean xGana = haGanado(matriz, "X");
        boolean oGana = haGanado(matriz, "O");

        if (xGana && oGana) {
            return "Nulo";
        } else if (xGana) {
            return "X";
        } else if (oGana) {
            return "O";
        } else {
            return "Empate";
        }
    }

    private static boolean esMatrizValida(String[][] matriz) {
        if (matriz.length != 3 || matriz[0].length != 3) {
            return false;
        }

        int countX = 0, countO = 0;
        for (String[] fila : matriz) {
            for (String celda : fila) {
                if (celda.equals("X")) {
                    countX++;
                } else if (celda.equals("O")) {
                    countO++;
                } else if (!celda.equals("")) {
                    return false;
                }
            }
        }


        return Math.abs(countX - countO) <= 1;
    }

    private static boolean haGanado(String[][] matriz, String jugador) {

        for (int i = 0; i < 3; i++) {
            if (matriz[i][0].equals(jugador) && matriz[i][1].equals(jugador) && matriz[i][2].equals(jugador)) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (matriz[0][i].equals(jugador) && matriz[1][i].equals(jugador) && matriz[2][i].equals(jugador)) {
                return true;
            }
        }

        if (matriz[0][0].equals(jugador) && matriz[1][1].equals(jugador) && matriz[2][2].equals(jugador)) {
            return true;
        }
        if (matriz[0][2].equals(jugador) && matriz[1][1].equals(jugador) && matriz[2][0].equals(jugador)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matriz = {
            {"", "", ""},
            {"", "", ""},
            {"", "", ""}
        };

        String turno = "X";
        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            imprimirMatriz(matriz);
            System.out.println("Turno de " + turno + ". Ingrese la fila y columna (0-2) separadas por un espacio:");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();

            if (fila < 0 || fila > 2 || columna < 0 || columna > 2 || !matriz[fila][columna].equals("")) {
                System.out.println("Movimiento inválido. Intente de nuevo.");
                continue;
            }

            matriz[fila][columna] = turno;
            String resultado = analizarMatriz(matriz);

            if (!resultado.equals("Empate")) {
                imprimirMatriz(matriz);
                System.out.println("Resultado: " + resultado);
                juegoTerminado = true;
            } else if (esMatrizLlena(matriz)) {
                imprimirMatriz(matriz);
                System.out.println("Resultado: Empate");
                juegoTerminado = true;
            } else {
                turno = turno.equals("X") ? "O" : "X";
            }
        }

        scanner.close();
    }

    private static void imprimirMatriz(String[][] matriz) {
        System.out.println("Estado actual de la matriz:");
        for (String[] fila : matriz) {
            for (String celda : fila) {
                System.out.print(celda.isEmpty() ? "-" : celda);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static boolean esMatrizLlena(String[][] matriz) {
        for (String[] fila : matriz) {
            for (String celda : fila) {
                if (celda.equals("")) {
                    return false;
                }
            }
        }
        return true;
    }
}
