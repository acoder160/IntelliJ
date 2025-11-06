public class Hello extends Thread{
    @Override
    public void run() {
        System.out.println("HELLO");
        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread.yield();
    }
}
