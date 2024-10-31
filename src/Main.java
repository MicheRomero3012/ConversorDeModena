import com.google.gson.JsonSyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    static JTextField inputField;
    private JComboBox<String> currencyBox;
    private JTextField outputField;
    private Client consulta;
    private Calculo calculos;
    private Escritura generador;
    private List<String> respuestas;

    public Main() {
        consulta = new Client();
        calculos = new Calculo(consulta);
        generador = new Escritura();
        respuestas = new ArrayList<>();

        setTitle("Proyecto de conversión de moneda | Alura | Romero Flores Brian Michelle");
        setSize(650, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.add(new JLabel("Ingrese cantidad en MX:"));
        inputField = new JTextField();
        inputPanel.add(inputField);
        inputPanel.add(new JLabel("Seleccione moneda de cambio:"));
        currencyBox = new JComboBox<>(new String[]{
                "USD", "EUR", "GBP", "JPY", "CAD", "AUD", "CHF", "CNY", "SEK", "NZD",
                "MXN", "SGD", "HKD", "NOK", "KRW", "TRY", "INR", "BRL", "ZAR"
        });
        inputPanel.add(currencyBox);

        // Panel central para el output
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(new JLabel("Conversión:"), BorderLayout.WEST);
        outputField = new JTextField();
        outputField.setEditable(false);
        outputPanel.add(outputField, BorderLayout.CENTER);

        // Panel inferior para los botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JButton convertButton = new JButton("Convertir");
        JButton exitButton = new JButton("Salir");

        convertButton.addActionListener(new ConvertAction());
        exitButton.addActionListener(e -> exitProgram());

        buttonPanel.add(convertButton);
        buttonPanel.add(exitButton);

        // Agregar paneles a la ventana principal
        add(inputPanel, BorderLayout.NORTH);
        add(outputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private class ConvertAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String amount = inputField.getText();
                String targetCurrency = (String) currencyBox.getSelectedItem();
                calculos.almacenarValores("MXN", targetCurrency);

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                String result = calculos.obtenerMensajeRespuesta();
                respuestas.add(formattedDate + " - " + result);
                outputField.setText(result);
            } catch (JsonSyntaxException | NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Error: Verifique API de moneda.");
            }
        }
    }

    private void exitProgram() {
        generador.guardarJson(respuestas);
        System.out.println("Finalizando programa");
        System.exit(0);
    }

    public static void main(String[] args) {
        new Main();
    }
}
