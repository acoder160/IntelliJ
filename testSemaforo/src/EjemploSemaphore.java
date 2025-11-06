import java.util.concurrent.Semaphore;

class RecursoCompartido {
    private Semaphore sem;

    public RecursoCompartido(int permisos) {
        sem = new Semaphore(permisos); // Número de permisos disponibles
    }

    public void usarRecurso(String nombreHilo) {
        try {
            System.out.println(nombreHilo + " intenta adquirir el recurso...");
            sem.acquire(); // Adquirimos permiso
            System.out.println(nombreHilo + " ha adquirido el recurso.");

            // Simular uso del recurso
            Thread.sleep(2000);

            System.out.println(nombreHilo + " ha terminado de usar el recurso.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release(); // Liberamos el permiso
            System.out.println(nombreHilo + " libera el recurso.");
        }
    }
}

public class EjemploSemaphore {
    public static void main(String[] args) {
        RecursoCompartido recurso = new RecursoCompartido(2); // Solo 2 permisos

        // Crear 5 hilos que intentan usar el recurso
        for (int i = 1; i <= 5; i++) {
            final String nombreHilo = "Hilo-" + i;
            new Thread(() -> recurso.usarRecurso(nombreHilo)).start();
        }
    }
}
