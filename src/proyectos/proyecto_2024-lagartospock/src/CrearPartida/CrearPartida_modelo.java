package CrearPartida;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Util.Partida;

public class CrearPartida_modelo {

    // Método para crear una partida con un jugador y una elección
    static boolean CrearPartida(String Jugador1, String EleccionJugador1) {
        Partida partida = new Partida(Jugador1, EleccionJugador1);
        if (guardarDatosPartida(partida)) {
            return true;
        }
        return false;
    }

    // Método para guardar los datos de la partida en la BD
    static boolean guardarDatosPartida(Partida partida) {
        try {
            Connection conexionBD = ConexionBD.BD.conectarBD();
            Statement statement = conexionBD.createStatement();
            String sql = "INSERT INTO Partida (Jugador1, EleccionJugador1) VALUES ('"
                    + partida.getJugador1() + "', '" + partida.getEleccionJugador1() + "')";
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Error al guardar los datos de la partida");
            e.printStackTrace();
            return false;
        }
    }
}
