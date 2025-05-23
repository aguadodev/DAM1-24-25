package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {
    final static String HOST = "bd.mimejoridea.com";
    final static String DATABASE = "lagartospock";
    final static String USER = "lagartospock";
    final static String PASSWD = "xnvaoA1opopvR7J3";
    final static String PORT = "3306";


    static public Connection conectarBD() {
        String url = String.format("jdbc:mysql://%s:%s/%s", HOST, PORT, DATABASE);
        try {
            return DriverManager.getConnection(url, BD.USER, BD.PASSWD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
