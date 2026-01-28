import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {

    public static void main(String[] args) {
        HttpClient cliente = HttpClient.newHttpClient();

        System.out.println("EJERCICIO A");
        ejercicioA(cliente);

        System.out.println("EJERCICIO B");
        ejercicioB(cliente, 1);

        System.out.println("EJERCICIO C");
        ejercicioC(cliente);
    }

    // parte A
    public static void ejercicioA(HttpClient cliente) {
        try {
            String url = "https://jsonplaceholder.typicode.com/comments?postId=1";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString());
            String respuesta = response.body();

            // cuento cuantas veces sale la palabra id
            String[] trozos = respuesta.split("\"id\":");
            int total = trozos.length - 1;

            System.out.println("Se han recuperado " + total + " comentarios");

        } catch (Exception e) {
            System.out.println("Fallo en A: " + e.getMessage());
        }
    }

    // parte B
    public static void ejercicioB(HttpClient cliente, int idPost) {
        try {
            // Concateno el numero idPost a la URL
            String url = "https://jsonplaceholder.typicode.com/comments?postId=" + idPost;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString());
            String respuesta = response.body();

            System.out.println("Correos encontrados:");

            // Separo el texto por la etiqueta de email
            String[] partes = respuesta.split("\"email\": \"");

            // Empiezo en 1 porque la parte 0 no me sirve
            for (int i = 1; i < partes.length; i++) {
                String trozo = partes[i];
                // Busco donde cierran las comillas del correo
                int fin = trozo.indexOf("\"");
                // Corto justo el correo
                System.out.println("- " + trozo.substring(0, fin));
            }

        } catch (Exception e) {
            System.out.println("Fallo en B: " + e.getMessage());
        }
    }

    // parte C
    public static void ejercicioC(HttpClient cliente) {
        try {
            String url = "https://jsonplaceholder.typicode.com/comments";

            String json = "{"
                    + "\"postId\": 1,"
                    + "\"name\": \"Mi comentario Java\","
                    + "\"email\": \"java@psep.com\","
                    + "\"body\": \"Esto es una prueba desde Java\""
                    + "}";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json") // Avisamos que enviamos JSON
                    .POST(BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString());

            if (response.statusCode() == 201) {
                System.out.println("Exito! El servidor respondio codigo 201 Created.");
            } else {
                System.out.println("Algo salio mal, codigo: " + response.statusCode());
            }

        } catch (Exception e) {
            System.out.println("Fallo en C: " + e.getMessage());
        }
    }
}