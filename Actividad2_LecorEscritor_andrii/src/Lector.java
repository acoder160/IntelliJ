public class Lector implements Runnable {
    private RecursoCompartido recurso;
    private int id;

    public Lector(RecursoCompartido recurso, int id) {
        this.recurso = recurso;
        this.id = id;
    }

    @Override
    public void run() {
        recurso.leer(id);
    }
}