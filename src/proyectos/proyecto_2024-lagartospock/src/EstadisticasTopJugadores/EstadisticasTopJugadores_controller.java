package EstadisticasTopJugadores;

import Util.Jugador;
import Util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class EstadisticasTopJugadores_controller {

    @FXML
    private Button botonTopPartidas;

    @FXML
    private Button botonTopRatio;

    @FXML
    private Button botonVueltaMenu;

    @FXML
    private Label estadisticasTopJugadores;

    @FXML
    private ListView<Jugador> listaTopJugadores;

    @FXML
    void metodoEnsenharTopGanadas(ActionEvent event) {
        // Vaciar la lista de jugadores
        listaTopJugadores.getItems().clear();
        // Cambiar el texto de la etiqueta
        estadisticasTopJugadores.setText(
                "Usuario - Partidas jugadas - Partidas ganadas - Partidas perdidas - Ratio de victorias");
        // Obtener las estadísticas de los jugadores
        Jugador[] jugadores = EstadisticasTopJugadores_modelo.obtenerTopJugadores();
        // Mostrar las estadísticas de los jugadores
        for (Jugador jugador : jugadores) {
            if (jugador != null)
                listaTopJugadores.getItems().add(jugador);
        }
    }

    @FXML
    void metodoEnsenharTopRatio(ActionEvent event) {
        // Vaciar la lista de jugadores
        listaTopJugadores.getItems().clear();
        // Obtener las estadísticas de los jugadores
        Jugador[] jugadores = EstadisticasTopJugadores_modelo.obtenerTopJugadoresPorWinRate();
        // Mostrar las estadísticas de los jugadores con el win rate
        for (Jugador jugador : jugadores) {
            if (jugador != null)
                listaTopJugadores.getItems().add(jugador);
        }
    }

    @FXML
    void metodoVolverMenu(ActionEvent event) {
        Util cambiarEscena = new Util();
        cambiarEscena.cambiarEscena("../Menu/paginaPrincipal_proyecto.fxml", botonVueltaMenu);
    }

    @FXML
    void initialize() {
        metodoEnsenharTopGanadas(null);
    }

}
