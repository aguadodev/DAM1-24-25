package EstadisticasTopJugadores;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Util.Jugador;

public class EstadisticasTopJugadores_modelo {

    public static Jugador[] obtenerTopJugadores() {
        // Buscar en la base de datos los 10 jugadores con más partidas ganadas
        Jugador[] jugadores = new Jugador[10];
        try {
            Connection conexionBD = ConexionBD.BD.conectarBD();
            // Si la conexión es nula, mostrar un mensaje de error
            if (conexionBD == null) {
                System.out.println("Error al conectar con la BD");
                // Si la conexión no es nula, ejecutar la consulta
            } else {
                // Crear un Statement para ejecutar la consulta
                try (Statement consulta = conexionBD.createStatement()) {
                    // Crear la consulta, seleccionar los 10 jugadores con más partidas ganadas, y si tienen el mismo número de partidas ganadas, ordenarlos por partidas jugadas
                    String sql = "SELECT * FROM Jugador ORDER BY GamesWon DESC, GamesPlayed DESC LIMIT 10";
                    consulta.executeQuery(sql);
                    // Si la consulta devuelve un resultado, el login es correcto
                    int i = 0;
                    while (consulta.getResultSet().next()) {
                        Jugador jugador = new Jugador(consulta.getResultSet().getString("Username"),
                                consulta.getResultSet().getInt("GamesWon"),
                                consulta.getResultSet().getInt("GamesPlayed"));
                        jugadores[i] = jugador;
                        i++;
                    }
                    // Cerrar la conexión con la base de datos
                    conexionBD.close();
                } catch (SQLException e1) {
                    System.out.println("Error al ejecutar la consulta");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al seleccionar la partida");
        }

        return jugadores;
    }

    public static Jugador[] obtenerTopJugadoresPorWinRate() {
        // Buscar en la base de datos los 10 jugadores con el mejor ratio de victorias
        Jugador[] jugadores = new Jugador[10];
        try {
            Connection conexionBD = ConexionBD.BD.conectarBD();
            // Si la conexión es nula, mostrar un mensaje de error
            if (conexionBD == null) {
                System.out.println("Error al conectar con la BD");
                // Si la conexión no es nula, ejecutar la consulta
            } else {
                // Crear un Statement para ejecutar la consulta
                try (Statement consulta = conexionBD.createStatement()) {
                    // Crear la consulta, seleccionar los 10 jugadores con el mejor ratio de victorias, y si tienen el mismo ratio de victorias, ordenarlos por partidas jugadas
                    String sql = "SELECT * FROM Jugador WHERE GamesPlayed > 10 ORDER BY GamesWon/GamesPlayed DESC, GamesPlayed DESC LIMIT 10";
                    consulta.executeQuery(sql);
                    // Si la consulta devuelve un resultado, el login es correcto
                    int i = 0;
                    while (consulta.getResultSet().next()) {
                        Jugador jugador = new Jugador(consulta.getResultSet().getString("Username"),
                                consulta.getResultSet().getInt("GamesWon"),
                                consulta.getResultSet().getInt("GamesPlayed"));
                        jugadores[i] = jugador;
                        i++;
                    }
                    // Cerrar la conexión con la base de datos
                    conexionBD.close();
                } catch (SQLException e1) {
                    System.out.println("Error al ejecutar la consulta");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al seleccionar la partida");
        }

        return jugadores;
    }
}
