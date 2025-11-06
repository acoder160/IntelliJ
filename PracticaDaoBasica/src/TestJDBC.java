import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/acda";
        String usuario = "acda";
        String password = "masacda";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión exitosa a MySQL!");

            Statement stmt = conexion.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS prueba(id INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(50))");
            stmt.executeUpdate("INSERT INTO prueba(nombre) VALUES('Andrii')");

            ResultSet rs = stmt.executeQuery("SELECT * FROM prueba");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nombre: " + rs.getString("nombre"));
            }

            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
