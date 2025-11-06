package main.java.org.examenpokemon.service;

import org.examenpokemon.dao.JuegoPokemonDAO;
import org.examenpokemon.model.JuegoPokemon;

import java.sql.SQLException;
import java.util.List;

/**
 * Capa de servicio para la entidad {@link JuegoPokemon}.
 * <p>
 * Aplica las validaciones de negocio antes de acceder al DAO.
 * Se encarga de garantizar que los datos sean válidos antes de interactuar con la base de datos.
 * </p>
 *
 * @author Profesor Oak
 */
public class JuegoPokemonService {

    /** DAO que gestiona las operaciones en base de datos. */
    private final JuegoPokemonDAO dao;

    /** Constructor: inicializa el DAO y gestiona posibles errores de conexión. */
    public JuegoPokemonService() {
        try {
            dao = new JuegoPokemonDAO();
        } catch (SQLException e) {
            throw new RuntimeException("Error inicializando JuegoPokemonDAO", e);
        }
    }

    /**
     * Inserta un nuevo juego Pokémon tras validar sus datos.
     *
     * @param j objeto con los datos del juego.
     * @return id generado.
     * @throws SQLException     si ocurre un error de base de datos.
     * @throws ServiceException si los datos no son válidos.
     */
    public int add(JuegoPokemon j) throws SQLException, ServiceException {
        // TODO: Implementa el método acorde al modo en que se solicita en el enunciado
        // y ten en cuenta lo especificado en la documentación Javadoc del método.
    }

    /**
     * Devuelve la lista de todos los juegos Pokémon registrados.
     *
     * @return lista de objetos {@link JuegoPokemon}.
     * @throws SQLException si ocurre un error SQL.
     */
    public List<JuegoPokemon> listAll() throws SQLException {
        // TODO: Implementa el método acorde al modo en que se solicita en el enunciado
        // y ten en cuenta lo especificado en la documentación Javadoc del método.
    }

    /**
     * Actualiza los datos de un juego Pokémon existente tras validar su ID.
     *
     * @param j objeto con los nuevos valores.
     * @return {@code true} si la actualización fue correcta.
     * @throws SQLException     si ocurre un error SQL.
     * @throws ServiceException si el ID o los datos no son válidos.
     */
    public boolean update(JuegoPokemon j) throws SQLException, ServiceException {
        // TODO: Implementa el método acorde al modo en que se solicita en el enunciado
        // y ten en cuenta lo especificado en la documentación Javadoc del método.
    }

    /**
     * Elimina un juego Pokémon de la base de datos por su identificador.
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
