import java.io.IOException;

public class Calculo {
    private Client consulta;
    private String mensajeRespuesta;

    public Calculo(Client consulta) {
        this.consulta = consulta;
    }

    public void almacenarValores(String monedaOrigen, String monedaDestino) {
        try {
            double tasaCambio = consulta.obtenerTasaCambio(monedaOrigen, monedaDestino);
            double cantidad = Double.parseDouble(Main.inputField.getText());
            double resultado = cantidad * tasaCambio;

            mensajeRespuesta = String.format("La conversión de %.2f %s a %s es: %.2f", cantidad, monedaOrigen, monedaDestino, resultado);
        } catch (IOException | InterruptedException e) {
            mensajeRespuesta = "Error al obtener la tasa de cambio.";
        } catch (NumberFormatException e) {
            mensajeRespuesta = "Por favor, ingrese una cantidad válida.";
        }
    }

    public String obtenerMensajeRespuesta() {
        return mensajeRespuesta;
    }
}
