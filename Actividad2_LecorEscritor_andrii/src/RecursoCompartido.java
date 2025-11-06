import java.util.concurrent.Semaphore;

public class RecursoCompartido {
    private String datos;
    private int numLectores;
    private Semaphore mutex;
    private Semaphore recurso;

    public RecursoCompartido() {
        this.datos = "Datos inicio";
        this.numLectores = 0;
        this.mutex = new Semaphore(1);
        this.recurso = new Semaphore(1);
    }

    public void leer(int idLector) {
        try {
            char letraLector = (char)('A' + idLector);

            // Entrada de lectores
            mutex.acquire();
            numLectores++;
            System.out.println("Lector-" + letraLector +
                    " inicia LECTURA. Lectores activos: " + numLectores);
            if (numLectores == 1) {
                // Primer lector adquiere el recurso
                recurso.acquire();
            }
            mutex.release();

            // Simular tiempo de lectura
            Thread.sleep(100);

            // Lectura del recurso
            String datosLeidos = this.datos;

            // Salida de lectores
            mutex.acquire();
            numLectores--;
            System.out.println("Lector-" + letraLector +
                    " finaliza LECTURA. Datos leidos: '" + datosLeidos +
                    "' Lectores activos: " + numLectores);
            if (numLectores == 0) {
                // Último lector libera el recurso
                recurso.release();
            }
            mutex.release();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Hilo interrumpido: " + e.getMessage());
        }
    }

    public void escribir(String nuevoDato, int idEscritor) {
        try {
            // Escritor adquiere directamente el recurso
            recurso.acquire();

            System.out.println("Escritor-" + idEscritor + " inicia ESCRITURA.");

            // Simular tiempo de escritura
            Thread.sleep(100);

            // Escritura del recurso
            this.datos = nuevoDato;

            System.out.println("Escritor-" + idEscritor +
                    " termina ESCRITURA. Nuevo dato: " + nuevoDato);

            // Escritor libera el recurso
            recurso.release();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Hilo interrumpido: " + e.getMessage());
        }
    }
}