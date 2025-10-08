public class Hello extends Thread{
    @Override
    public void run() {
        System.out.println("HELLO");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
