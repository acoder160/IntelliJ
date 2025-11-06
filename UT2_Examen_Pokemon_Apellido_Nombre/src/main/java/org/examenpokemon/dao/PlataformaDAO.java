package org.examenpokemon.dao;

import org.examenpokemon.connection.ConexionBD;
import org.examenpokemon.model.Plataforma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO (Data Access Object) encargada de gestionar las operaciones
 * de acceso a datos de la entidad {@link Plataforma}.
 *
 * <p>En este examen, solo se requiere implementar el método de
 * listado (<code>findAll()</code>), que realiza un SELECT sobre
 * la tabla <code>plataforma</code>.</p>
 *
 * @author Profesor Oak
 */
public class PlataformaDAO {

    /** Conexión activa con la base de datos. */
    private final Connection conn;

    /**
     * Constructor: obtiene la conexión desde el Singleton {@link ConexionBD}.
     *
     * @throws SQLException si ocurre un error al establecer la conexión.
     */
    public PlataformaDAO() throws SQLException {
        this.conn = ConexionBD.getInstance().getConnection();
    }

    /**
     * Devuelve la lista completa de plataformas almacenadas en la base de datos.
     *
     * @return lista de objetos {@link Plataforma}.
     * @throws SQLException si ocurre un error SQL durante la consulta.
     */
    public List<Plataforma> findAll() throws SQLException {
        // TODO: Implementa el método acorde al modo en que se solicita en el enunciado
        // y ten en cuenta lo especificado en la documentación Javadoc del método.

    }
}
