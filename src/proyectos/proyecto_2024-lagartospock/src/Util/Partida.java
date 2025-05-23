package Util;

public class Partida {
    private String idPartida;
    private String jugador1;
    private String jugador2;
    private String jugadorGanador;
    private Eleccion eleccionJugador1;
    private Eleccion eleccionJugador2;

    public Partida(String idPartida, String jugador1, String eleccionJugador1) {
        this.idPartida = idPartida;
        this.jugador1 = jugador1;
        this.eleccionJugador1 = Eleccion.valueOf(eleccionJugador1.toUpperCase());
    }

    public Partida(String jugador1, String eleccionJugador1) {
        this.jugador1 = jugador1;
        this.eleccionJugador1 = Eleccion.valueOf(eleccionJugador1.toUpperCase());
    }

    public void setJugador2(String username) {
        jugador2 = username;
    }

    public void setJugadorGanador(String jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    public void setEleccionJugador2(Eleccion eleccion) {
        eleccionJugador2 = eleccion;
    }

    public String getIdPartida() {
        return idPartida;
    }

    public String getJugador1() {
        return jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public String getJugadorGanador() {
        return jugadorGanador;
    }

    public Eleccion getEleccionJugador1() {
        return eleccionJugador1;
    }

    public Eleccion getEleccionJugador2() {
        return eleccionJugador2;
    }
}
