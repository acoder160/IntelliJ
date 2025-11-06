void main() {
    RecursoCompartido recurso = new RecursoCompartido();

    // Crear hilos según el orden especificado
    Thread lector1 = new Thread(new Lector(recurso, 0)); // Lector-A
    Thread lector2 = new Thread(new Lector(recurso, 1)); // Lector-B
    Thread escritor1 = new Thread(new Escritor(recurso, 1));
    Thread lector3 = new Thread(new Lector(recurso, 2)); // Lector-C
    Thread escritor2 = new Thread(new Escritor(recurso, 2));

    // Lanzar hilos en el orden especificado
    IO.println("INICIO DEL PROGRAMA");

    lector1.start(); // Lector-A

    // Pequeña pausa para asegurar el orden
    try {
        Thread.sleep(10);
    } catch (InterruptedException e) {
    }

    lector2.start(); // Lector-B

    // Pequeña pausa para asegurar el orden
    try {
        Thread.sleep(10);
    } catch (InterruptedException e) {
    }

    escritor1.start(); // Escritor-1

    // Pequeña pausa para asegurar el orden
    try {
        Thread.sleep(10);
    } catch (InterruptedException e) {
    }

    lector3.start(); // Lector-C

    // Pequeña pausa para asegurar el orden
    try {
        Thread.sleep(10);
    } catch (InterruptedException e) {
    }

    escritor2.start(); // Escritor-2

    // Esperar 5 segundos antes de lanzar Lector-D
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }

    Thread lector4 = new Thread(new Lector(recurso, 3)); // Lector-D
    lector4.start();

    // Esperar a que todos los hilos terminen
    try {
        lector1.join();
        lector2.join();
        escritor1.join();
        lector3.join();
        escritor2.join();
        lector4.join();
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }

    IO.println("FIN DEL PROGRAMA");
}