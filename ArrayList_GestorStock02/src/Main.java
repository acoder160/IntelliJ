import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // 1. CREACIÓN DE DATOS
        System.out.println("=== 1. INICIALIZANDO TIENDA ===");
        ArrayList<Producto> listaInicial = new ArrayList<>();

        // Añadimos los 15 productos generados anteriormente
        listaInicial.add(new Producto(101, "Portátil HP", 12));
        listaInicial.add(new Producto(102, "Mouse Logitech", 50));
        listaInicial.add(new Producto(103, "Teclado Mecánico", 35));
        listaInicial.add(new Producto(104, "Monitor Samsung 24\"", 20));
        listaInicial.add(new Producto(105, "Impresora Láser", 8));
        listaInicial.add(new Producto(106, "Disco SSD 1TB", 45));
        listaInicial.add(new Producto(107, "Memoria RAM 16GB", 60));
        listaInicial.add(new Producto(108, "Auriculares Sony", 25));
        listaInicial.add(new Producto(109, "WebCam HD", 15));
        listaInicial.add(new Producto(110, "Silla Gamer", 5));
        listaInicial.add(new Producto(111, "Tablet Samsung", 14));
        listaInicial.add(new Producto(112, "iPhone 13", 10));
        listaInicial.add(new Producto(113, "Cargador USB-C", 100));
        listaInicial.add(new Producto(114, "Cable HDMI 2m", 80));
        listaInicial.add(new Producto(115, "Router WiFi 6", 22));

        // Instanciamos el Gestor
        GestorStock miTienda = new GestorStock(listaInicial);
        System.out.println("Tienda creada con " + listaInicial.size() + " productos.");

        // 2. PRUEBA DE LISTADOS
        System.out.println("\n=== 2. PROBANDO LISTADO (FOR-EACH) ===");
        miTienda.escribirDetallesProductos();

        // System.out.println("\n=== PROBANDO LISTADO (ITERATOR) ===");
        // miTienda.escribirDetallesProductosIterator(); 
        // ¡OJO! Tu método Iterator original fallará aquí si no lo corriges.

        // 3. PRUEBA DE BÚSQUEDA (Localizar)
        System.out.println("\n=== 3. PROBANDO BÚSQUEDAS ===");

        // Buscar por ID existente
        Producto p1 = miTienda.localizarProducto(102);
        System.out.println("Buscando ID 102 (Existe): " + (p1 != null ? p1.getNombre() : "No encontrado"));

        // Buscar por ID inexistente
        Producto p2 = miTienda.localizarProducto(999);
        System.out.println("Buscando ID 999 (No existe): " + (p2 != null ? p2.getNombre() : "Correctamente devuelto null"));

        // Buscar por Nombre
        Producto p3 = miTienda.localizarProducto("iPhone 13");
        System.out.println("Buscando 'iPhone 13': " + (p3 != null ? "Encontrado ID: " + p3.getIdentificador() : "No encontrado"));

        // 4. PRUEBA DE STOCK
        System.out.println("\n=== 4. CONSULTAR STOCK ESPECÍFICO ===");
        int stockMouse = miTienda.cantidadEnStock(102);
        System.out.println("Stock del Mouse (ID 102): " + stockMouse); // Debería ser 50

        System.out.println("Stock de producto falso (ID 999): " + miTienda.cantidadEnStock(999)); // Debería ser -1

        // 5. PRUEBA DE AÑADIR PRODUCTO
        System.out.println("\n=== 5. AÑADIR PRODUCTOS ===");
        // Caso A: Añadir uno nuevo válido
        Producto nuevoProd = new Producto(200, "Gafas VR", 7);
        System.out.print("Intentando añadir Gafas VR (ID 200): ");
        miTienda.anadirProducto(nuevoProd);

        // Caso B: Añadir uno con ID repetido
        Producto repetido = new Producto(101, "Portátil Falso", 1);
        System.out.print("Intentando añadir ID repetido (101): ");
        miTienda.anadirProducto(repetido); // Debería decir que ya existe

        // 6. PRUEBA DE RECIBIR MERCANCÍA (Aumentar Stock)
        System.out.println("\n=== 6. RECIBIR MERCANCÍA ===");
        System.out.println("Stock inicial Monitor (ID 104): " + miTienda.cantidadEnStock(104));

        System.out.print("Recibiendo 10 monitores más... ");
        miTienda.recibirProducto(104, 10);

        System.out.println("Stock final Monitor (ID 104): " + miTienda.cantidadEnStock(104)); // Debería ser 20 + 10 = 30

        // 7. PRUEBA DE FILTRO (Menores que)
        System.out.println("\n=== 7. PRODUCTOS CON POCO STOCK (< 10) ===");
        miTienda.escribirMenorQue(10);
        // Debería mostrar Impresora(8), Silla(5), Gafas VR(7)
    }
}