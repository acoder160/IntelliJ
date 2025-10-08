import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessManager {

    public static void main(String[] args) throws IOException, InterruptedException {
        Process p1 = Runtime.getRuntime().exec("ping google.com");
        System.out.println("Proceso es activo? " + p1.isAlive());


        // Mostrar salida
        BufferedReader bf = new BufferedReader(new InputStreamReader(p1.getInputStream()));
        String line;
        while ((line = bf.readLine()) != null){
            System.out.println(line);
        }

        p1.waitFor();
        System.out.println("Proceso terminado con el codigo de: " + p1.exitValue());


        // Proceso largo
        Process p2 = Runtime.getRuntime().exec("ping -n 20 google.com");
        System.out.println("Proceso es activo? " + p2.isAlive());

        BufferedReader bf2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
        while ((line = bf2.readLine()) != null){
            System.out.println(line);
        }

        p2.waitFor();
        p2.destroy();
        System.out.println("Proceso esta activo? " + p2.isAlive());

    }


}




/*

try {
            // ===== Proceso corto =====
            System.out.println("=== Proceso corto ===");
            Process p1 = Runtime.getRuntime().exec("ping -n 3 127.0.0.1"); // Windows
            System.out.println("Proceso activo? " + p1.isAlive());

            // Mostrar salida
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
            String line;
            while ((line = reader1.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar a que termine
            p1.waitFor();
            System.out.println("Proceso terminado con código: " + p1.exitValue());

            // ===== Proceso largo =====
            System.out.println("\n=== Proceso largo ===");
            Process p2 = Runtime.getRuntime().exec("ping -n 20 127.0.0.1"); // Windows
            System.out.println("Proceso activo? " + p2.isAlive());

            // Esperamos 2 segundos y terminamos
            Thread.sleep(2000);
            p2.destroy();
            System.out.println("Proceso activo después de destroy()? " + p2.isAlive());

        } catch (Exception e) {
            e.printStackTrace();
        }
 */