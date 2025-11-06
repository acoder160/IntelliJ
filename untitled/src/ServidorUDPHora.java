import java.io.IOException; //Tecnica moderna
import java.net.DatagramPacket; // dos clases centrales para la comunicacion UDP
import java.net.DatagramSocket;

import java.net.InetAddress; // clase que representa una direccion IP

import java.time.LocalDateTime; // Manejo de fecha y hora
import java.time.format.DateTimeFormatter;

/**
 * Servidor UDP que escucha en el puerto 5000.
 * Cuando recibe un datagrama, responde con la fecha y hora actuales.
 */
public class ServidorUDPHora {

    public static void main(String[] args) {

        final int PUERTO = 5000;
        // El búfer puede ser pequeño, solo esperamos un mensaje como "HORA"
        byte[] bufferEntrada = new byte[1024]; // Se crea un colchon o un espacio en memoria

        // Usamos try-with-resources para asegurar que el socket se cierre al final
        // (Aunque en este caso, el bucle es infinito)
        try (DatagramSocket socket = new DatagramSocket(PUERTO)) {

            System.out.println("Servidor UDP de Hora iniciado en el puerto " + PUERTO);
            System.out.println("Esperando peticiones de clientes...");

            // Bucle infinito para atender peticiones continuamente
            while (true) {

                // 1. Preparar paquete para recibir datos
                DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);

                // 2. Recibir el paquete (método bloqueante)
                socket.receive(paqueteEntrada);

                // 3. Extraer información del paquete recibido
                String mensajeRecibido = new String(paqueteEntrada.getData(), 0, paqueteEntrada.getLength());
                InetAddress direccionCliente = paqueteEntrada.getAddress();
                int puertoCliente = paqueteEntrada.getPort();

                System.out.println("Petición recibida de " + direccionCliente + ":" + puertoCliente + " - Mensaje: " + mensajeRecibido);

                // 4. Preparar la respuesta (hora actual)
                LocalDateTime ahora = LocalDateTime.now();
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                String horaActual = ahora.format(formato);

                byte[] bufferSalida = horaActual.getBytes();

                // 5. Crear paquete de respuesta
                DatagramPacket paqueteSalida = new DatagramPacket(
                        bufferSalida,
                        bufferSalida.length,
                        direccionCliente,
                        puertoCliente
                );

                // 6. Enviar la respuesta
                socket.send(paqueteSalida);

                System.out.println("Respuesta enviada: " + horaActual);
            }

        } catch (IOException e) {
            System.err.println("Error en el servidor UDP: " + e.getMessage());
            e.printStackTrace();
        }
    }
}