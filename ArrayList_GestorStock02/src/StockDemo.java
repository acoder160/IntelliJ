import java.time.Period;
import java.util.ArrayList;

public class StockDemo {
    public static void main(String[] args) {
        Producto[] listaProductos = {

                new Producto(101, "Portátil HP", 12),
                new Producto(102, "Mouse Logitech", 50),
                new Producto(103, "Teclado Mecánico", 35),
                new Producto(104, "Monitor Samsung 24\"", 20),
                new Producto(105, "Impresora Láser", 8),
                new Producto(106, "Disco SSD 1TB", 45),
                new Producto(107, "Memoria RAM 16GB", 60),
                new Producto(108, "Auriculares Sony", 25),
                new Producto(109, "WebCam HD", 15),
                new Producto(110, "Silla Gamer", 5),
                new Producto(111, "Tablet Samsung", 14),
                new Producto(112, "iPhone 13", 10),
                new Producto(113, "Cargador USB-C", 100),
                new Producto(114, "Cable HDMI 2m", 80),
                new Producto(115, "Router WiFi 6", 22)
        };


        ArrayList<Producto> productos = new ArrayList<>();

        for (int i = 0; i < listaProductos.length; i++) {
            productos.add(listaProductos[i]);
        }



    }
}
