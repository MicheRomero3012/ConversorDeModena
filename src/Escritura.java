import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Escritura {
    public void guardarJson(List<String> respuestas) {
        Gson gson = new Gson();
        String json = gson.toJson(respuestas);

        try (FileWriter writer = new FileWriter("historial_conversiones.json")) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Error al guardar el historial de conversiones.");
        }
    }
}

