package main.java.org.examenpokemon.service;

import org.examenpokemon.dao.PlataformaDAO;
import org.examenpokemon.model.Plataforma;

import java.sql.SQLException;
import java.util.List;

/**
 * Capa de servicio para la entidad {@link Plataforma}.
 *
 * <p>Encapsula la comunicación con el DAO y proporciona
 * un punto de acceso intermedio entre la aplicación y la base de datos.</p>
 *
 * <p>En este examen, la clase solo ofrece el método <code>listAll()</code>
 * para recuperar todas las plataformas registradas.</p>
 *
 * @author Profesor Oak
 */
public class PlataformaService {

    /** DAO utilizado para acceder a los datos de la tabla plataforma. */
    private final PlataformaDAO dao;

    /**
     * Constructor: inicializa el DAO y gestiona posibles errores de conexión.
     */
    public PlataformaService() {
        try {
            dao = new PlataformaDAO();
        } catch (SQLException e) {
            throw new RuntimeException("Error inicializando PlataformaDAO", e);
        }
    }

    /**
     * Devuelve la lista completa de plataformas almacenadas.
     *
     * @return lista de objetos {@link Plataforma}.
     * @throws SQLException si ocurre un error al consultar los datos.
     */
    public List<Plataforma> listAll() throws SQLException {
        // TODO: Implementa el método acorde al modo en que se solicita en el enunciado
        // y ten en cuenta lo especificado en la documentación Javadoc del método.
    }
}
