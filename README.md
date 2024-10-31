<h1>Conversor de Monedas</h1>
¡Convierte fácilmente entre múltiples divisas con este Conversor de Monedas! Este programa realiza conversiones en tiempo real usando un API de tasas de cambio, permitiendo que el usuario seleccione la moneda de destino, consulte los resultados, y mantenga un historial detallado de conversiones en formato JSON.

<h2>📝 Descripción del Proyecto</h2>
Este proyecto de conversión de monedas implementa un cliente HTTP para conectarse a una API de tasas de cambio, capturar los datos de conversión, y mostrarlos al usuario en una interfaz gráfica de usuario (GUI). La aplicación también guarda un historial de conversiones en un archivo JSON, lo que permite al usuario revisar todas las conversiones realizadas.

<h2>🚀 Características</h2>
Conversión en tiempo real: Permite al usuario convertir fácilmente de MXN a varias monedas extranjeras.
API de tasas de cambio: Usa HTTP Requests para obtener las tasas de cambio actuales.
Historial de conversiones: Registra cada transacción en un archivo JSON usando GSON, manteniendo la fecha, hora y detalles de la conversión.
Interfaz gráfica amigable: Construida con Swing, con disposición de elementos intuitiva para facilitar la experiencia de usuario.

<h2>📦 Tecnologías Utilizadas</h2>
Java: Lenguaje de programación principal.
Swing: Biblioteca de Java para la interfaz gráfica.
HTTP Client: Para manejar las solicitudes a la API de tasas de cambio.
GSON: Librería de Java para manejar JSON, utilizada para escribir el historial de conversiones.
API de tasas de cambio: Conexión a un servicio externo que proporciona las tasas de cambio actualizadas.

<h2>📂 Estructura del Proyecto</h2>
Main.java: Clase principal que inicia la GUI y contiene la lógica de conversión.
Client.java: Clase que realiza las solicitudes HTTP y obtiene los datos de la API.
Calculo.java: Lógica de cálculo y obtención de datos para la conversión.
Escritura.java: Gestiona el guardado de cada conversión en un archivo JSON.

<h2>🎉 Uso de la Aplicación</h2>
Ingresa el monto en MXN y selecciona la moneda de destino.
Presiona el botón "Convertir" para realizar la conversión.
Los resultados de la conversión se mostrarán en pantalla, y se guardarán en el archivo JSON con fecha y hora.

<h2>Capturas de ejecución</h2>
![Captura de pantalla 2024-10-31 090029](https://github.com/user-attachments/assets/0178843f-bff5-42fb-a3f6-58648cd157b0)

![Captura de pantalla 2024-10-31 090145](https://github.com/user-attachments/assets/30fc72af-7917-4fef-ac88-4f3b4811322a)

