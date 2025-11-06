package org.masacda;

import java.io.*;
import java.net.*;

public class ServidorEcho {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(5000);
        System.out.println("Servidor Iniciado al puerto 5000");

        Socket cliente = servidor.accept();
        System.out.println("Cliente conectado al puerto 5000");

        BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()));

        String mensaje;
        while ((mensaje = entrada.readLine()) != null) {
            if (mensaje.equalsIgnoreCase("SALIR")) {
                System.out.println("Cliente pidió salir. Cerrando conexión...");
                break; // termina bucle
            }

            System.out.println("Del cliente se ha recibido: " + mensaje);

            // Echo: devolver mensaje al cliente
            salida.write(mensaje);
            salida.newLine();
            salida.flush();
        }

        cliente.close();
        servidor.close();
        System.out.println("Servidor cerrado.");
    }
}
