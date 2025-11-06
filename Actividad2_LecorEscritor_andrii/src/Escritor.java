public class Escritor implements Runnable {
    private RecursoCompartido recurso;
    private int id;

    public Escritor(RecursoCompartido recurso, int id) {
        this.recurso = recurso;
        this.id = id;
    }

    @Override
    public void run() {
        recurso.escribir("Cambiado por Escritor-" + id, id);
    }
}