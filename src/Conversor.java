import java.util.Scanner;

public class Conversor {

    // Método para convertir de COP a USD
    public static void convertirCOPaUSD() {
        realizarConversion("COP", "USD");
    }

    // Método para convertir de USD a COP
    public static void convertirUSDaCOP() {
        realizarConversion("USD", "COP");
    }

    // Método para convertir de COP a EUR (Euros)
    public static void convertirCOPaEUR() {
        realizarConversion("COP", "EUR");
    }

    // Método para convertir de COP a MXN (Pesos Mexicanos)
    public static void convertirCOPaMXN() {
        realizarConversion("COP", "MXN");
    }

    // Método para convertir de COP a ARS (Pesos Argentinos)
    public static void convertirCOPaARS() {
        realizarConversion("COP", "ARS");
    }

    // Método para convertir de COP a GBP (Libras Esterlinas)
    public static void convertirCOPaGBP() {
        realizarConversion("COP", "GBP");
    }

    // Método auxiliar para realizar la conversión y evitar repetición de código
    private static void realizarConversion(String monedaOrigen, String monedaDestino) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Ingrese la cantidad en %s que desea convertir a %s: ", monedaOrigen, monedaDestino);
        double cantidad = scanner.nextDouble();

        // Verificación de valor positivo
        if (cantidad < 0) {
            System.out.println("Error: No se puede realizar la conversión. Ingrese un valor positivo.");
            return;
        }

        // Llamada al método obtenerTasaCambio de ApiConnector
        double tasaCambio = ApiConnector.obtenerTasaCambio(monedaOrigen, monedaDestino);

        if (tasaCambio > 0) {
            double resultado = cantidad * tasaCambio;
            System.out.printf("La cantidad de %.2f %s equivale a %.2f %s%n", cantidad, monedaOrigen, resultado, monedaDestino);
        } else {
            System.out.println("No se pudo obtener la tasa de cambio. Inténtelo nuevamente más tarde.");
        }
    }
}
