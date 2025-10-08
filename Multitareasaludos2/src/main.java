
class Main {
    public static void main(String[] args){
        for (int i = 0; i < 1o; i++) {

        }
        Saludo saludo1 = new Saludo();
        new Thread(saludo1).start();
        new Thread(saludo1).start();
        new Thread(saludo1).start();
        new Thread(saludo1).start();
        new Thread(saludo1).start();
    }
}

