package main.java.org.examenpokemon.app;

import org.examenpokemon.model.JuegoPokemon;
import org.examenpokemon.model.Plataforma;
import org.examenpokemon.service.JuegoPokemonService;
import org.examenpokemon.service.PlataformaService;
import org.examenpokemon.service.ServiceException;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que muestra el menú de consola y gestiona las operaciones CRUD.
 * <p>
 * Utiliza la capa de servicios para acceder a los datos y aplicar las validaciones
 * correspondientes antes de realizar operaciones sobre la base de datos.
 * </p>
 *
 * @author Profesor Oak
 */
public class MainExam {

    private static final Scanner sc = new Scanner(System.in);
    private static final PlataformaService pService = new PlataformaService();
    private static final JuegoPokemonService jService = new JuegoPokemonService();

    /**
     * Método principal del programa.
     * <p>Muestra un menú interactivo con las distintas opciones CRUD disponibles.</p>
     */
    public static void main(String[] args) {
        int op;
        do {
            mostrarMenu();
            op = leerEntero("Opción: ");
            try {
                switch (op) {
                    case 1 -> listarPlataformas();
                    case 2 -> listarJuegos();
                    case 3 -> insertarJuego();
                    case 4 -> editarJuego();
                    case 5 -> eliminarJuego();
                    case 0 -> System.out.println("👋 Fin del programa.");
                    default -> System.out.println("⚠️ Opción no válida.");
                }
            } catch (ServiceException e) {
                System.err.println("❌ Validación: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("💾 Error SQL: " + e.getMessage());
            }
        } while (op != 0);
    }

    /** Muestra el menú principal. */
    private static void mostrarMenu() {
        System.out.println("\n===== GESTOR DE JUEGOS POKÉMON =====");
        System.out.println("1) Listar plataformas");
        System.out.println("2) Listar juegos Pokémon");
        System.out.println("3) Añadir juego Pokémon");
        System.out.println("4) Editar juego Pokémon");
        System.out.println("5) Eliminar juego Pokémon");
        System.out.println("0) Salir");
    }

    /** Lista todas las plataformas disponibles en la base de datos. */
    private static void listarPlataformas() throws SQLException {
        // TODO: Implementa el método acorde al modo en que se solicita en el enunciado
        // y ten en cuenta lo especificado en la documentación Javadoc del método.
    }

    /** Muestra todos los juegos Pokémon con su plataforma asociada. */
    private static void listarJuegos() throws SQLException {
        // TODO: Implementa el método acorde al modo en que se solicita en el enunciado
        // y ten en cuenta lo especificado en la documentación Javadoc del método.
    }

    /** Inserta un nuevo juego Pokémon pidiendo los datos por consola. */
    private static void insertarJuego() throws SQLException, ServiceException {
        // TODO: Implementa el método acorde al modo en que se solicita en el enunciado
        // y ten en cuenta lo especificado en la documentación Javadoc del método.
    }

    /** Edita un juego Pokémon existente validando el ID introducido. */
    private static void editarJuego() throws SQLException, ServiceException {
        // TODO: Implementa el método acorde al modo en que se solicita en el enunciado
        // y ten en cuenta lo especificado en la documentación Javadoc del método.
    }

    /** Elimina un juego Pokémon existente por su identificador. */
    private static void eliminarJuego() throws SQLException {
        // TODO: Implementa el método acorde al modo en que se solicita en el enunciado
        // y ten en cuenta lo especificado en la documentación Javadoc del método.
    }

    // ──────────────────────────────────────────────
    // Métodos auxiliares para lectura de datos
    // ──────────────────────────────────────────────

    /** Lee un número entero del teclado controlando errores. */
    private static int leerEntero(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido.");
            }
        }
    }

    /** Lee texto (String) del teclado. */
    private static String leerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }
}
