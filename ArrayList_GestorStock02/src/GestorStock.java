import java.util.ArrayList;
import java.util.Iterator;

public class GestorStock {
    private ArrayList<Producto> listaProductos;

    public GestorStock(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void escribirDetallesProductos(){
        for (Producto producto : listaProductos){
            System.out.println("Producto numero " + producto.getIdentificador());
            System.out.println("Nombre " + producto.getNombre());
            System.out.println("Stock " + producto.getStock());
        }
    }

    public void escribirDetallesProductosIterator(){
        Iterator<Producto> it = listaProductos.iterator();
        while (it.hasNext()){
            Producto p = it.next();
            System.out.println("Producto numero " + p.getIdentificador());
            System.out.println("Nombre " + p.getNombre());
            System.out.println("Stock " + p.getStock());
        }
    }

    public void escribirDetallesProductosFor(){
        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.println("Producto numero " + listaProductos.get(i).getIdentificador());
            System.out.println("Nombre " + listaProductos.get(i).getNombre());
            System.out.println("Stock " + listaProductos.get(i).getStock());
        }
    }

    public void escribirMenorQue(int stock){
        for (Producto producto : listaProductos){
            if (producto.getStock() <= stock){
                System.out.println("Producto numero " + producto.getIdentificador());
                System.out.println("Nombre " + producto.getNombre());
                System.out.println("Stock " + producto.getStock());
            }
        }

    }


    public Producto localizarProducto(int identificador){
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getIdentificador() == identificador){
                return listaProductos.get(i);
            }
        }
        return null;
    }

    public Producto localizarProducto(String nombre){
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getNombre().equals(nombre)){
                return listaProductos.get(i);
            }
        }
        return null;
    }



    public int cantidadEnStock(int identificador){
        if (localizarProducto(identificador) != null){
            return localizarProducto(identificador).getStock();
        }
        else {
            return -1;
        }
    }

    public void anadirProducto(Producto producto){
        if (localizarProducto(producto.getIdentificador()) != null){
            System.out.println("Este identificador ya existe");
        }
        else {
            listaProductos.add(producto);
            System.out.println("Producto añadido con exito");
        }
    }

    public void recibirProducto(int identificador, int cantidad){
        if (localizarProducto(identificador) == null){
            System.out.println("Producto no encontrado, identificador incorrecto");
        }
        else {
            for (Producto producto : listaProductos){
                if (producto.getIdentificador() == identificador){
                    producto.setStock(producto.getStock() + cantidad);
                }
            }
            System.out.println("Actualizado COrrectamente");
        }
    }





    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
