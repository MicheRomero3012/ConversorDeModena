import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Client {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";
    public double obtenerTasaCambio(String monedaOrigen, String monedaDestino) throws IOException, InterruptedException {
        //creamos el cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + monedaOrigen))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
        return jsonResponse.getAsJsonObject("rates").get(monedaDestino).getAsDouble();
    }
}





