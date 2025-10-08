package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class ConexionBD{

    /** URL de conexión al servidor MySQL */
    private static final String URL = "jdbc:mysql://localhost:3306/acda";
    private static final String USER = "acda";
    private static final String PASSWORD = "masacda";
    /** Instancia única de la conexión */
    private static Connection conn = null;

    /**
     * Constructor privado para impedir la creación directa de instancias.
     */
    private ConexionBD() { }

    /**
     * Devuelve una instancia única de la conexión a la base de datos.
     * Si la conexión no existe o está cerrada, la crea nuevamente.
     *
     * @return objeto {@link Connection} activo.
     */
    public static Connection getInstance() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión establecida correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conn;
    }
}
