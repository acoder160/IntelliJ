import java.io.IOException; //Tecnica moderna
import java.net.DatagramPacket; // dos clases centrales para la comunicacion UDP
import java.net.DatagramSocket;

import java.net.InetAddress; // clase que representa una direccion IP
import java.net.SocketTimeoutException;

/**
 * Cliente UDP que envía una petición "HORA" al servidor en el puerto 5000
 * y muestra la respuesta recibida.
 */
public class ClienteUDPHora {

    public static void main(String[] args) {

        final String HOST_SERVIDOR = "localhost";
        final int PUERTO_SERVIDOR = 5000;
        final int TIMEOUT = 5000; // 5 segundos de espera

        // Usamos try-with-resources para que el socket se cierre automáticamente
        try (DatagramSocket socket = new DatagramSocket()) {

            // Establecer un timeout para la respuesta
            socket.setSoTimeout(TIMEOUT);

            // 1. Obtener la dirección IP del servidor
            InetAddress direccionServidor = InetAddress.getByName(HOST_SERVIDOR);

            // 2. Preparar el mensaje de solicitud
            String mensaje = "HORA";
            byte[] bufferSalida = mensaje.getBytes();

            // 3. Crear el paquete para enviar
            DatagramPacket paqueteEnvio = new DatagramPacket(
                    bufferSalida,
                    bufferSalida.length,
                    direccionServidor,
                    PUERTO_SERVIDOR
            );

            // 4. Enviar el paquete
            System.out.println("Enviando petición '" + mensaje + "' al servidor " + HOST_SERVIDOR + ":" + PUERTO_SERVIDOR);
            socket.send(paqueteEnvio);

            // 5. Preparar el paquete para recibir la respuesta
            byte[] bufferEntrada = new byte[1024];
            DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);

            // 6. Recibir la respuesta (método bloqueante)
            socket.receive(paqueteEntrada);

            // 7. Procesar y mostrar la respuesta
            String horaRecibida = new String(paqueteEntrada.getData(), 0, paqueteEntrada.getLength());
            System.out.println("Hora recibida del servidor: " + horaRecibida);

        } catch (SocketTimeoutException e) {
            System.err.println("Error: El servidor no respondió en " + TIMEOUT / 1000 + " segundos.");
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
            e.printStackTrace();
        }
    }
}