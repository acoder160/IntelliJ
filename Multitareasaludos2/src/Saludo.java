public class Saludo implements Runnable {
    int ThreadId;

    public Saludo(int threadId){
        this.ThreadId = threadId;
    }

    public void saludar(){
        System.out.println("Hola a todos");
    }

    @Override
    public void run() {
        this.saludar();
    }
}
