package EstadisticasUser;

import Util.Jugador;
import Util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EstadisticasUser_controller {

    @FXML
    private Button botonTopPlayers;

    @FXML
    private Button botonVueltaMenu;

    @FXML
    private Label estadisticasDeJugador;

    @FXML
    private Label partidasGanadas;

    @FXML
    private Label partidasJugadas;

    @FXML
    private Label partidasPerdidas;

    @FXML
    private Label ratioVictorias;

    @FXML
    void metodoEnsenharTopJugadores(ActionEvent event) {
        Util cambiarEscena = new Util();
        cambiarEscena.cambiarEscena(
                "../EstadisticasTopJugadores/paginaEleccionEstadisticas_proyecto.fxml",
                botonTopPlayers);
    }

    @FXML
    void metodoVolverMenu(ActionEvent event) {
        Util cambiarEscena = new Util();
        cambiarEscena.cambiarEscena("../Menu/paginaPrincipal_proyecto.fxml", botonVueltaMenu);
    }

    // Inicializar la escena
    @FXML
    void initialize() {
        // Obtener las estadísticas del jugador
        Jugador usuario = EstadisticasUser_modelo.obtenerEstadisticas(Util.getUsername());
        // Mostrar el nombre del jugador
        estadisticasDeJugador.setText("Estadísticas de " + usuario.getUsername());
        // Mostrar las partidas jugadas
        partidasJugadas.setText(String.valueOf(usuario.getGamesPlayed()));
        // Mostrar las partidas ganadas
        partidasGanadas.setText(String.valueOf(usuario.getGamesWon()));
        // Mostrar las partidas perdidas
        partidasPerdidas.setText(String.valueOf(usuario.getGamesPlayed() - usuario.getGamesWon()));
        // Mostrar el ratio de victorias con 2 decimales
        ratioVictorias.setText(usuario.getWinRate());
    }

}
