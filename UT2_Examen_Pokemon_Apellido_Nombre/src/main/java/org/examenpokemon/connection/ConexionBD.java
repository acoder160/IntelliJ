package org.examenpokemon.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton de conexión a MySQL (Docker ACDA_UT2).
 * @author Profesor Oak
 */
public class ConexionBD {
    private static ConexionBD instance;
    private final Connection conn;

    private ConexionBD() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ACDA_UT2";
        String user = "root";
        String pass = "root"; // Contraseña por defecto del Docker ACDA_UT2
        this.conn = DriverManager.getConnection(url, user, pass);
    }

    public static synchronized ConexionBD getInstance() throws SQLException {
        if (instance == null) instance = new ConexionBD();
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }
}
