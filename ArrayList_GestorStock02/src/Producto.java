public class Producto {
    private int identificador;
    private String nombre;
    private int stock;


    public Producto(int identificador, String nombre, int stock) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.stock = stock;
    }


    public void incrementarCantidad(){
        stock++;
    }

    public void vender(){
        stock--;
    }


    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
