package edu.masanz.da.kk.menus;

import edu.masanz.da.kk.gui.Gui;
import edu.masanz.da.kk.dao.Dao;

import java.util.List;

public class MenuPrincipal implements Menu {

    @Override
    public void run() {
        Gui.mostrarTituloPrincipal();
        Gui.mostrarMenuPrincipal();
        int opc = Gui.leerOpcion("Opción", 0, 7);
        while (opc != 0) {
            switch (opc) {
                case 1:
                    obtenerIdSesionUsuario();
                    break;
                case 2:
                    crearKukiSesionUsuario();
                    break;
                case 3:
                    eliminarInfoCaducada();
                    break;
                case 4:
                    mostrarIdsNombresItemsFiltrados();
                    break;
                case 5:
                    meterItemInteresesUsuario();
                    break;
                case 6:
                    mostrarItemsInteresantes();
                    break;
                case 7:
                    mostrarItemsNoInteresantes();
                    break;
                default:
            }
            Gui.mostrarMenuPrincipal();
            opc = Gui.leerOpcion("Opción", 0, 7);
        }
    }

    private void obtenerIdSesionUsuario() {
        String idUsuario = Gui.leerTexto("Id de usuario: ");
        String idSesion = Dao.obtenerIdSesionUsuario(idUsuario);
        Gui.mostrarIdSesion(idSesion);
    }

    private void crearKukiSesionUsuario() {
        String idUsuario = Gui.leerTexto("Id de usuario: ");
        String idSesion = Dao.crearKukiSesionUsuario(idUsuario);
        Gui.mostrarIdSesion(idSesion);
    }

    private void eliminarInfoCaducada() {
        int n = Dao.eliminarInfoCaducada();
        Gui.mostrarEliminadaInfoCaducada(n);
    }

    private void meterItemInteresesUsuario() {
        String idUsuario = Gui.leerTexto("Id de usuario: ");
        String idItem = Gui.leerTexto("Id de item: ");
        boolean b = Dao.meterItemInteresesUsuario(idUsuario, idItem);
        Gui.mostrarItemIntroducido(b);
    }

    private void mostrarIdsNombresItemsFiltrados() {
        List<String> lista = Dao.obtenerIdsNombresItems();
        String filtro = Gui.leerTexto("Texto que debe contener (vacío para todos): ");
        boolean b = Dao.filtrarListadoIdNombres(lista, filtro);
        Gui.mostrarListadoItemsFiltrado(b);
        Gui.mostrarListado(lista);
    }

    private void mostrarItemsInteresantes() {
        List<String> lista = Dao.obtenerItemsInteresantes();
        Gui.mostrarListado(lista);
    }

    private void mostrarItemsNoInteresantes() {
        List<String> lista = Dao.obtenerItemsNoInteresantes();
        Gui.mostrarListado(lista);
    }
}
