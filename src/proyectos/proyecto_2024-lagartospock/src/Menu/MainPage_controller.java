package Menu;

import ListaPartidas.ListaPartidas_controller;
import ListaPartidas.ListaPartidas_modelo;
import Util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainPage_controller {

    @FXML
    private Button botonBuscarPartida;

    @FXML
    private Label labelUsuario;

    @FXML
    private Button botonCrearPartida;

    @FXML
    private Button botonInfo;

    @FXML
    private Button botonSalirJuego;

    @FXML
    private Button botonEstadisticas;


    @FXML
    void metodoBuscarPartida(ActionEvent event) {
        // Comprobar si hay partidas disponibles
        ListaPartidas_controller.partidas = ListaPartidas_modelo.buscarPartidas();
        if (!ListaPartidas_modelo.hayPartidas(ListaPartidas_controller.partidas)) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Información");
            alerta.setHeaderText("No hay partidas disponibles");
            alerta.setContentText("Ningún jugador ha creado una partida.");
            alerta.showAndWait();
        } else {
            // Si hay partidas disponibles, mostrar la lista de partidas
            Util cambiarEscena = new Util();
            cambiarEscena.cambiarEscena("../ListaPartidas/listaPartidas_proyecto.fxml",
                    botonBuscarPartida);
        }

    }

    @FXML
    void metodoCrearPartida(ActionEvent event) {
        Util cambiarEscena = new Util();
        cambiarEscena.cambiarEscena("../CrearPartida/paginaPartida_proyecto.fxml", botonCrearPartida);

    }

    @FXML
    void metodoEnsenharInfo(ActionEvent event) {
        Alert alertaInfo = new Alert(Alert.AlertType.INFORMATION);
        alertaInfo.setTitle("Información");
        alertaInfo.setHeaderText("Piedra, papel, tijera, lagarto, Spock");
        alertaInfo.setContentText("Programa hecho por Eloy Rodal Pérez y Xabier Cendón Pazos");
        alertaInfo.showAndWait();
    }

    @FXML
    void metodoSalirJuego(ActionEvent event) {
        Util cambiarEscena = new Util();
        cambiarEscena.cambiarEscena("../Login/paginaLogin_proyecto.fxml", botonSalirJuego);
    }

    @FXML
    void metodoMostrarEstadisticas(ActionEvent event) {
        Util cambiarEscena = new Util();
        cambiarEscena.cambiarEscena("../EstadisticasUser/paginaEstadisticasUser_proyecto.fxml",
                botonEstadisticas);
    }

    @FXML
    private void initialize() {
        labelUsuario.setText(
                "Bienvenid@. Actualmente estás en una sesión como " + Util.getUsername() + ".");
    }
}
