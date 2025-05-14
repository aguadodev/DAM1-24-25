package ud7.ejemplousuarios.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Conexion {

    // Datos de conexión a la base de datos (localhost)
    static final String HOST = "localhost";
    static final String DATABASE = "compartirviaje";
    static final String USER = "root";
    static final String PASSWORD = "";
    static final String PORT = "3306";

    /**
     * Conecta con la base de datos
     * 
     * @return Conexión con la base de datos
     */
    public static Connection conectar() {
        Connection con = null;

        String url = "jdbc:mysql://" + Conexion.HOST + ":" + Conexion.PORT + "/" + Conexion.DATABASE;

        try {
            con = DriverManager.getConnection(url, Conexion.USER, Conexion.PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la BD.");
        }

        return con;
    }
}