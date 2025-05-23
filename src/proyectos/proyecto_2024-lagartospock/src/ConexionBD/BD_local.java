package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// Para usar la BD local de la máquina virtual, cambiar el nombre de la clase BD a otro y decirle al
// IDE que no cambie nada y ponerle a este de nombre BD
public class BD_local {
    final static String HOST = "localhost";
    final static String DATABASE = "PPTLS";
    final static String USER = "root";
    final static String PASSWD = "";

    @SuppressWarnings("unused")
    static private Connection conectarBD() {
        String url = "jdbc:mysql://" + BD.HOST + "/" + BD.DATABASE;
        try {
            return DriverManager.getConnection(url, BD.USER, BD.PASSWD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
