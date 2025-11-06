package main.java.org.examenpokemon.dao;

import org.examenpokemon.connection.ConexionBD;
import org.examenpokemon.model.JuegoPokemon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO (Data Access Object) encargada de gestionar las operaciones
 * de acceso a datos de la entidad {@link JuegoPokemon}.
 * <p>
 * Incluye operaciones CRUD completas y utiliza consultas preparadas
 * para prevenir inyecciones SQL. Además, incorpora un JOIN con la tabla
 * {@code plataforma} para mostrar el nombre de la plataforma asociada.
 * </p>
 *
 * @author Profesor Oak
 */
public class JuegoPokemonDAO {

    /** Conexión activa con la base de datos. */
    private final Connection conn;

    /**
     * Constructor: obtiene la conexión del Singleton {@link ConexionBD}.
     *
     * @throws SQLException si ocurre un error al establecer la conexión.
     */
    public JuegoPokemonDAO() throws SQLException {
        this.conn = ConexionBD.getInstance().getConnection();
    }

    // ──────────────────────────────────────────────────────────────
    // MÉTODOS CRUD
    // ──────────────────────────────────────────────────────────────

    /**
     * Inserta un nuevo juego Pokémon en la base de datos.
     * INSERT INTO juego_pokemon (titulo, generacion, anio_lanzamiento, plataforma_id)
     *                 VALUES ("Pokémon Txurdin", 15, 2026, 6)
     *
     * @param j objeto con los datos a insertar.
     * @return id generado (autoincremental).
     * @throws SQLException si ocurre un error SQL.
     */
    public int insert(JuegoPokemon j) throws SQLException {
        // TODO: Implementa este método según las indicaciones del enunciado.
        // Devuelve el id autogenerado.

        return -1;
    }

    /**
     * Devuelve todos los juegos Pokémon junto con el nombre de su plataforma.
     * <p>
     * Usa un alias claro para evitar ambigüedades con {@code plataforma_id}.
     * Si el nombre de la plataforma es nulo, se asigna "Desconocida".
     * </p>
     * SELECT j.id, j.titulo, j.generacion, j.anio_lanzamiento,
     *                        j.plataforma_id, p.nombre AS nombre_plataforma
     *                 FROM juego_pokemon j
     *                 LEFT JOIN plataforma p ON j.plataforma_id = p.id
     *                 ORDER BY j.id
     *
     * @return lista de objetos {@link JuegoPokemon} con nombre de plataforma incluido.
     * @throws SQLException si ocurre un error SQL.
     */
    public List<JuegoPokemon> findAll() throws SQLException {
        // TODO: Implementa el método acorde al modo en que se solicita en el enunciado
        // y ten en cuenta lo especificado en la documentación Javadoc del método.
    }

    /**
     * Actualiza los datos de un juego Pokémon existente.
     *UPDATE juego_pokemon
     *     SET titulo="Pokémon Txurdin", generacion=11, anio_lanzamiento=2026, plataforma_id=6
     *     WHERE id=23
     *
     * @param j objeto con los nuevos valores.
     * @return {@code true} si la actualización fue correcta.
     * @throws SQLException si ocurre un error SQL.
     */
    public boolean update(JuegoPokemon j) throws SQLException {
        // TODO: Implementa el método acorde al modo en que se solicita en el enunciado
        // y ten en cuenta lo especificado en la documentación Javadoc del método.
    }

    /**
     * Elimina un juego Pokémon de la base de datos por su identificador.
     * DELETE FROM juego_pokemon WHERE id=23
     *
     * @param id identificador del juego.
     * @return {@code true} si se eliminó correctamente.
     * @throws SQLException si ocurre un error SQL.
     */
    public boolean delete(int id) throws SQLException {
        // TODO: Implementa el método acorde al modo en que se solicita en el enunciado
        // y ten en cuenta lo especificado en la documentación Javadoc del método.
    }
}
