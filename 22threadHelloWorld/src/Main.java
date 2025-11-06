//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Hello hello = new Hello();
        World world = new World();
        while (true){
            new Thread(hello).start();
            new Thread(world).start();
        }
    }
}
