import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ApiConnector {

    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    // Método que obtiene la tasa de cambio entre dos monedas
    public static double obtenerTasaCambio(String monedaOrigen, String monedaDestino) {
        try {
            // Crear cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + monedaOrigen))
                    .GET()
                    .build();

            // Enviar solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Procesar el JSON de la respuesta para obtener la tasa de cambio
            return extraerTasaCambio(response.body(), monedaDestino);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            return -1;
        }
    }

    // Método auxiliar para extraer la tasa de cambio usando Gson
    private static double extraerTasaCambio(String respuestaJson, String monedaDestino) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(respuestaJson, JsonObject.class);

        // Extrae la tasa de cambio para la moneda destino
        return jsonObject.getAsJsonObject("rates").get(monedaDestino).getAsDouble();
    }
}
