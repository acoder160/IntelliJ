package edu.masanz.da.kk.dao;

import java.time.LocalDate;
import java.util.*;
import edu.masanz.da.kk.dto.*;
import edu.masanz.da.kk.utils.Security;

import static edu.masanz.da.kk.conf.Ini.*;

public class Dao {

    // region Colecciones que simulan la base de datos
    private static Map<String, Usuario> mapaUsuarios = new HashMap<>();;
    private static Map<String, Kuki> mapaKukis = new HashMap<>();
    private static Map<String, Item> mapaItems = new HashMap<>();
    private static Map<String, Map<String, Object>> mapaSesiones = new HashMap<>();;
    // endregion

    // region Inicialización de las colecciones con ini()
    public static void ini() {
        iniMapaUsuarios();
        iniMapaKukis();
        iniMapaItems();
        iniMapaSesiones();
    }

    private static void iniMapaUsuarios() {
        for (String txt : USUARIOS) {
            String[] campos = txt.split(",");
            Usuario usuario = new Usuario(
                    campos[0],
                    campos[1],
                    campos[2],
                    campos[3].equals("null")?null:campos[3]
            );
            mapaUsuarios.put(campos[0], usuario);
        }
    }

    private static void iniMapaKukis() {
        for (String txt : KUKIS) {
            String[] campos = txt.split(",");
            Kuki kuki = new Kuki(
                    campos[0],
                    Long.parseLong(campos[1]),
                    Long.parseLong(campos[2])
            );
            mapaKukis.put(campos[0], kuki);
        }
    }

    private static void iniMapaItems() {
        for (String txt : ITEMS) {
            String[] campos = txt.split(",");
            Item item = new Item(
                    campos[0],
                    campos[1],
                    Integer.parseInt(campos[2])
            );
            mapaItems.put(item.getId(), item);
        }
    }


    private static void iniMapaSesiones() {
        // NO HAY QUE HACER NADA AQUÍ
    }
    // endregion


    public static String obtenerIdSesionUsuario(String idUsuario) {
        if (mapaUsuarios.containsKey(idUsuario)){
            if (mapaUsuarios.get(idUsuario).getIdSesion() != null){
                return mapaUsuarios.get(idUsuario).getIdSesion();
            }
        } else {
            System.out.println("No hay usuarios con este id");
            return null;
        }
        return null;
    }

    public static String crearKukiSesionUsuario(String idUsuario) {
        if (mapaUsuarios.containsKey(idUsuario)){
            Kuki kukiGenerado = new Kuki();
            mapaKukis.put(kukiGenerado.getId(), kukiGenerado);
            Map<String, Object> info = new HashMap<>();

            info.put("quiereSugerencias", true);
            info.put("idUsuario", idUsuario);
            info.put("nombreUsuario", mapaUsuarios.get(idUsuario).getNombre());
            mapaSesiones.put(mapaUsuarios.get(idUsuario).getIdSesion(), info);
        } else {
            System.out.println("No hay usuarios con este id");
            return null;
        }
        return null;
    }

    public static int eliminarInfoCaducada() {
        int contador = 0;
        Iterator<Map.Entry<String, Kuki>> it = mapaKukis.entrySet().iterator();
            while (it.hasNext()){
                Kuki kuki = it.next().getValue();
                // parece que aqui es un error ahora debe ser mayor que su fecha + tiempo de vida en el enunciado ()
                if (System.currentTimeMillis() > (kuki.getVida() + kuki.getFecha())){
                    // 1. Elimino desde mapa de sessiones
                    mapaUsuarios.remove(kuki.getId());
                    contador ++;
                    // 2. Cambio a null id de usuariosSessionDeUsuarios
                    mapaUsuarios.get(kuki.getId()).setIdSesion(null);
                    // 3. Elimino kuki
                    it.remove();
                }
            }
            return contador;
        }


    public static List<String> obtenerIdsNombresItems() {
        // Logica genial: paso Uduario a al string. Meto string a list. Sorteo lista
       List <String> items = new ArrayList<>();
       for (Map.Entry<String, Item> listaItems : mapaItems.entrySet()) {
           Item item = listaItems.getValue();
           items.add(item.getId() + " - " + item.getNombre());
       }
       items.sort(null);

       return items;
    }

    public static boolean filtrarListadoIdNombres(List<String> listado, String filtro) {

        if (filtro == null || filtro.equals("")){
            return false;
        }
        boolean eliminado = false;
        Iterator<String> it = listado.iterator();
        while (it.hasNext()){
            String dato = it.next();
            if (dato.contains(filtro)){
            } else {
                it.remove();
                eliminado = true;
            }
        }

        return eliminado;
    }

    public static boolean meterItemInteresesUsuario(String idSesion, String idItem) {
        // TODO 5. meterItemInteresesUsuario
        return false;
    }

    public static List<String> obtenerItemsInteresantes() {
        // TODO 6. obtenerItemsInteresantes
        return null;
    }

    public static List<String> obtenerItemsNoInteresantes() {
        // TODO 7. obtenerItemsNoInteresantes
        return null;
    }}
 
