package org.masacda;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteEcho {
    public static void main(String[] args) throws Exception {
        String mensaje = "";
        Scanner sc = new Scanner(System.in);
        Socket socket = new Socket("localhost", 5000);

        BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        while (!mensaje.equalsIgnoreCase("SALIR")) {
            System.out.println("Ingrese SALIR para terminar la conexión o cualquier otro mensaje para enviar:");
            mensaje = sc.nextLine();
            salida.write(mensaje);
            salida.newLine();
            salida.flush();

            // leer respuesta del servidor
            String respuesta = entrada.readLine();
            System.out.println("Servidor: " + respuesta);
        }

        socket.close();
        sc.close();
    }
}
