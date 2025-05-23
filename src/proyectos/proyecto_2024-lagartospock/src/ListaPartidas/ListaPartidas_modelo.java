package ListaPartidas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Util.Util;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListaPartidas_modelo {

    public static ObservableList<String> buscarPartidas() {
        // Crear una lista observable para almacenar las partidas
        ObservableList<String> partidas = FXCollections.observableArrayList();

        // Inicializar la conexión a la BD
        Connection conexionBD = ConexionBD.BD.conectarBD();

        // Si la conexión es nula, mostrar un mensaje de error
        if (conexionBD == null) {
            System.out.println("Error al conectar con la BD");
        } else {
            // Crear un Statement para ejecutar la consulta
            try (Statement consulta = conexionBD.createStatement()) {
                // Crear la consulta para obtener las partidas que no tienen un ganador y que no
                // fueron creadas por el usuario
                String username = Util.getUsername();
                String sql =
                        "SELECT * FROM Partida WHERE JugadorGanador IS NULL and Jugador2 IS NULL AND Jugador1 != '"
                                + username + "'";
                consulta.executeQuery(sql);

                // Recorrer los resultados de la consulta y añadirlos a la lista de partidas
                ResultSet rs = consulta.getResultSet();
                while (rs.next()) {
                    // Concatenar los valores de las columnas en una cadena
                    String partida = rs.getString("ID") + " - " + rs.getString("Jugador1");
                    // Agregar la cadena a la lista de partidas
                    partidas.add(partida);
                }
                // Si la lista de partidas está vacía, mostrar un mensaje de que no hay partidas
                if (partidas.isEmpty()) {
                    System.out.println("No se encontraron partidas");
                }
                // Si hay un error al ejecutar la consulta, mostrar un mensaje de error
            } catch (SQLException e1) {
                System.out.println("Error al ejecutar guardar las partidas en la lista");
            }
            // Cerrar la conexión con la BD
            try {
                conexionBD.close();
                // Si hay un error al cerrar la conexión, mostrar un mensaje de error
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión con la BD.");
            }
        }
        return partidas;
    }

    public static boolean hayPartidas(ObservableList<String> partidas) {
        return !partidas.isEmpty();
    }
}
