public class World extends Thread{
    @Override
    public void run() {
        System.out.println("WORLD");
        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread.yield();
    }
}
