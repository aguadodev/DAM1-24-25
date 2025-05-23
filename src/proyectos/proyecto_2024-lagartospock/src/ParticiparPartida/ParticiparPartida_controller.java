package ParticiparPartida;

import Util.Partida;
import Util.Util;
import Util.Eleccion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ParticiparPartida_controller {
    Partida partida;

    @FXML
    private ImageView botonSeleccionLagarto;

    @FXML
    private ImageView botonSeleccionPapel;

    @FXML
    private ImageView botonSeleccionPiedra;

    @FXML
    private ImageView botonSeleccionSpock;

    @FXML
    private ImageView botonSeleccionTijera;

    @FXML
    private Button botonVueltaMenu;

    @FXML
    void metodoDesoscurecerEleccion(MouseEvent event) {
        // Obtener la imagen sobre la que pasó el ratón
        ImageView imagen = (ImageView) event.getSource();

        // Crear un efecto de desenfoque
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(0);

        // Aplicar el efecto de desenfoque a la imagen
        imagen.setEffect(colorAdjust);
    }

    @FXML
    void metodoOscurecerEleccion(MouseEvent event) {
        // Obtener la imagen de la que salió el ratón
        ImageView imagen = (ImageView) event.getSource();

        // Crear un efecto de enfoque
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.3);

        // Aplicar el efecto de enfoque a la imagen
        imagen.setEffect(colorAdjust);
    }

    @FXML
    void metodoSeleccionLagarto(MouseEvent event) throws Exception {
        ParticiparPartida_modelo.guardarDatosPartida(Eleccion.LAGARTO);
        mostrarResultado();
    }

    @FXML
    void metodoSeleccionPapel(MouseEvent event) throws Exception {
        ParticiparPartida_modelo.guardarDatosPartida(Eleccion.PAPEL);
        mostrarResultado();
    }

    @FXML
    void metodoSeleccionPiedra(MouseEvent event) throws Exception {
        ParticiparPartida_modelo.guardarDatosPartida(Eleccion.PIEDRA);
        mostrarResultado();
    }


    @FXML
    void metodoSeleccionSpock(MouseEvent event) throws Exception {
        ParticiparPartida_modelo.guardarDatosPartida(Eleccion.SPOCK);
        mostrarResultado();
    }

    @FXML
    void metodoSeleccionTijera(MouseEvent event) throws Exception {
        ParticiparPartida_modelo.guardarDatosPartida(Eleccion.TIJERAS);
        mostrarResultado();
    }

    @FXML
    void metodoVolverMenu(ActionEvent event) {
        Util cambiarEscena = new Util();
        cambiarEscena.cambiarEscena("../Menu/paginaPrincipal_proyecto.fxml", botonVueltaMenu);
    }

    @FXML
    private void initialize() {
        ParticiparPartida_modelo.crearObjetoPartida(Util.datosPartida[0], Util.datosPartida[1],
                Util.datosPartida[2]);

    }

    private void mostrarResultado() throws Exception  {
        if (ParticiparPartida_modelo.determinarGanador() == 1) {
            // jugador2 gana, es decir, el ususaro actual gana
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Resultado");
            alerta.setHeaderText("¡Has ganado!");
            alerta.setContentText("El rival ha seleccionado " + Util.datosPartida[2] + ". ¡Enhorabuena! Has ganado la partida.");
            alerta.showAndWait();
        } else if (ParticiparPartida_modelo.determinarGanador() == 2) {
            // jugador2 pierde, es decir, el ususaro actual pierde
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Resultado");
            alerta.setHeaderText("¡Has perdido!");
            alerta.setContentText("El rival ha seleccionado " + Util.datosPartida[2] + ". ¡Lo siento! Has perdido la partida.");
            alerta.showAndWait();
        } else if (ParticiparPartida_modelo.determinarGanador() == 0) {
            // empate
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Resultado");
            alerta.setHeaderText("¡Empate!");
            alerta.setContentText("El rival ha seleccionado " + Util.datosPartida[2] + ". ¡Es un empate!");
            alerta.showAndWait();
        }
        Util cambiarEscena = new Util();
        cambiarEscena.cambiarEscena("../Menu/paginaPrincipal_proyecto.fxml", botonVueltaMenu);
    }

}

