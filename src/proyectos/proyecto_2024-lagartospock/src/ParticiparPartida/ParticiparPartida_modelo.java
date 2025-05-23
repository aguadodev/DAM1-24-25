package ParticiparPartida;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import Util.Eleccion;
import Util.Partida;
import Util.Util;

class ParticiparPartida_modelo {
    static Partida partida;

    static void guardarDatosPartida(Eleccion eleccion) throws Exception {
        // Guardar los datos de la partida
        partida.setEleccionJugador2(eleccion);
        partida.setJugador2(Util.getUsername());
        

        // Guardar los datos de la partida en la base de datos
        guardarDatosJugador2PartidaEnBD(partida);

    }

    public static void crearObjetoPartida(String idPartida, String jugador1,
            String eleccionjugador1) {
        partida = new Partida(idPartida, jugador1, eleccionjugador1);
    }


    private static int determinarGanador(Partida partida) throws Exception {
        int resultado = 0; // Por defecto, asumimos empate

        // Verificar si las elecciones son iguales
        if (partida.getEleccionJugador1() == partida.getEleccionJugador2()) {
            return resultado; // Devolver empate
        }

        // Definir relaciones de victoria en una matriz
        boolean[][] relacionesVictoria = {
            // TIJERAS  PAPEL    PIEDRA   LAGARTO  SPOCK
            {false,   true,    false,   true,    false}, // TIJERAS
            {false,   false,   true,    false,   true},  // PAPEL
            {true,    false,   false,   true,    false}, // PIEDRA
            {false,   true,    false,   false,   true},  // LAGARTO
            {true,    false,   true,    false,   false}  // SPOCK
        };

        // Determinar el resultado basado en las relaciones de victoria
        if (relacionesVictoria[partida.getEleccionJugador2().ordinal()][partida.getEleccionJugador1().ordinal()]) {
            resultado = 1; // Jugador gana
            // Guardar los datos del jugador ganador (usuario) en la base de datos
        } else if (relacionesVictoria[partida.getEleccionJugador1().ordinal()][partida.getEleccionJugador2().ordinal()]) {
            resultado = 2; // Jugador pierde
        }
        return resultado;
    }

    static int determinarGanador() throws Exception {
        return determinarGanador(partida);
    }



    private static void guardarDatosJugador2PartidaEnBD(Partida partida) {
        try {
            Connection conexionBD = ConexionBD.BD.conectarBD();
            // Si la conexión es nula, mostrar un mensaje de error
            if (conexionBD == null) {
                System.out.println("Error al conectar con la BD");
                // Si la conexión no es nula, ejecutar la consulta
            } else {
                // Crear un Statement para ejecutar la consulta
                try (Statement consulta = conexionBD.createStatement()) {
                    // Crear la consulta
                    String sql = "UPDATE Partida SET Jugador2 = '" + partida.getJugador2()
                            + "', EleccionJugador2 = '" + partida.getEleccionJugador2()
                            + "' WHERE ID = " + partida.getIdPartida();
                    consulta.executeUpdate(sql);
                    // Si la consulta devuelve un resultado, el login es correcto
                } catch (SQLException e1) {
                    System.out.println("Error al ejecutar la consulta");
                }
            }
            partida.setJugadorGanador(determinarGanador() == 1 ? partida.getJugador2() : determinarGanador() == 2 ? partida.getJugador1() : null);
            guardarDatosJugadorGanadorPartidaEnBD(partida, conexionBD);
        } catch (Exception e) {
            System.out.println("Error al seleccionar la partida");
        }
    }


    private static void guardarDatosJugadorGanadorPartidaEnBD(Partida partida, Connection conexionBD) {
        try {
            // Si la conexión es nula, mostrar un mensaje de error
            if (conexionBD == null) {
                System.out.println("Error al conectar con la BD");
                // Si la conexión no es nula, ejecutar la consulta
            } else {
                // Crear un Statement para ejecutar la consulta
                try (Statement consulta = conexionBD.createStatement()) {
                    // Crear la consulta
                    if (partida.getJugadorGanador() != null) {
                        String sql = "UPDATE Partida SET JugadorGanador = '"
                                + partida.getJugadorGanador() + "' WHERE ID = "
                                + partida.getIdPartida();
                        consulta.executeUpdate(sql);
                    }
                    // Si la consulta devuelve un resultado, el login es correcto
                } catch (SQLException e1) {
                    System.out.println("Error al ejecutar la consulta");
                }
            }
            actualizarPartidasGanadasYJugadas(partida, conexionBD);
        } catch (Exception e) {
            System.out.println("Error al seleccionar la partida");
        }
    }

    private static void actualizarPartidasGanadasYJugadas(Partida partida, Connection conexionBD) {
        try {
            // Si la conexión es nula, mostrar un mensaje de error
            if (conexionBD == null) {
                System.out.println("Error al conectar con la BD");
                // Si la conexión no es nula, ejecutar la consulta
            } else {
                // Crear un Statement para ejecutar la consulta
                try (Statement consulta = conexionBD.createStatement()) {
                    // Actualizar las partidas jugadas de los jugadores
                    String sqlJugador1 =
                            "UPDATE Jugador SET GamesPlayed = GamesPlayed + 1 WHERE Username = '"
                                    + partida.getJugador1() + "'";
                    consulta.executeUpdate(sqlJugador1);

                    String sqlJugador2 =
                            "UPDATE Jugador SET GamesPlayed = GamesPlayed + 1 WHERE Username = '"
                                    + partida.getJugador2() + "'";
                    consulta.executeUpdate(sqlJugador2);

                    // Si hay un ganador, actualizar las partidas ganadas de ese jugador
                    if (partida.getJugadorGanador() != null) {
                        String sqlGanador =
                                "UPDATE Jugador SET GamesWon = GamesWon + 1 WHERE Username = '"
                                        + partida.getJugadorGanador() + "'";
                        consulta.executeUpdate(sqlGanador);
                    }

                    // Si la consulta devuelve un resultado, el login es correcto
                } catch (SQLException e1) {
                    System.out.println("Error al ejecutar la consulta");
                    e1.printStackTrace();
                }
            }
            // Cerrar la conexión con la BD
            conexionBD.close();
        } catch (Exception e) {
            System.out.println("Error al seleccionar la partida");
            e.printStackTrace();
        }
    }
}
