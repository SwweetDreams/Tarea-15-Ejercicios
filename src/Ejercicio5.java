import java.util.*;

public class Ejercicio5 {
    private static final Map<Integer, String> productos = Map.of(
        1, "Agua",
        2, "Refresco",
        3, "Chocolate"
    );
    private static final Map<Integer, Integer> precios = Map.of(
        1, 50,
        2, 100,
        3, 150
    );

    private static final List<Integer> monedasSoportadas = List.of(5, 10, 50, 100, 200);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Productos disponibles:");
        productos.forEach((key, value) -> System.out.println(key + ". " + value + " - " + precios.get(key) + " céntimos"));

        System.out.print("Seleccione el número del producto: ");
        int seleccion = scanner.nextInt();

        System.out.println("Ingrese las monedas separadas por espacio (valores soportados: 5, 10, 50, 100, 200):");
        scanner.nextLine();
        String[] monedasInput = scanner.nextLine().split(" ");
        int[] monedas = Arrays.stream(monedasInput).mapToInt(Integer::parseInt).toArray();

        Map<String, Object> resultado = procesarCompra(monedas, seleccion);

        System.out.println(resultado.get("mensaje"));
        if (resultado.containsKey("producto")) {
            System.out.println("Producto: " + resultado.get("producto"));
        }
        System.out.println("Dinero devuelto: " + resultado.get("dineroDevuelto"));
    }

    public static Map<String, Object> procesarCompra(int[] monedas, int seleccion) {
        Map<String, Object> resultado = new HashMap<>();

        if (!productos.containsKey(seleccion)) {
            resultado.put("mensaje", "Producto no existe.");
            resultado.put("dineroDevuelto", monedas);
            return resultado;
        }

        int totalIngresado = 0;
        for (int moneda : monedas) {
            if (!monedasSoportadas.contains(moneda)) {
                resultado.put("mensaje", "Moneda no soportada.");
                resultado.put("dineroDevuelto", monedas);
                return resultado;
            }
            totalIngresado += moneda;
        }

        int precioProducto = precios.get(seleccion);

        if (totalIngresado < precioProducto) {
            resultado.put("mensaje", "Dinero insuficiente.");
            resultado.put("dineroDevuelto", monedas);
            return resultado;
        }

        int cambio = totalIngresado - precioProducto;
        List<Integer> cambioMonedas = calcularCambio(cambio);

        resultado.put("mensaje", "Compra exitosa.");
        resultado.put("producto", productos.get(seleccion));
        resultado.put("dineroDevuelto", cambioMonedas);
        return resultado;
    }

    private static List<Integer> calcularCambio(int cambio) {
        List<Integer> cambioMonedas = new ArrayList<>();
        int[] denominaciones = {200, 100, 50, 10, 5};

        for (int moneda : denominaciones) {
            while (cambio >= moneda) {
                cambioMonedas.add(moneda);
                cambio -= moneda;
            }
        }
        return cambioMonedas;
    }
}
