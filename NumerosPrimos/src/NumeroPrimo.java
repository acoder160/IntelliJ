public class NumeroPrimo implements Runnable{
    private int numComprobar;
    private int numResultado;

    public NumeroPrimo(int comprobar){
        this.numComprobar = comprobar;

    }

    public int getComprobador(){
        return numComprobar;
    }

    public int getNumResultado(){
        return numResultado;
    }


    @Override
    public void run() {
        if (numComprobar > 2) {
            for (int i = 0; i <= numComprobar; i++) {
                if (numComprobar % i == 0){
                    numResultado = i;
                } else {
                    numResultado = -1;
                }
            }
        }
    }
}
