package CrearPartida;

import Util.Eleccion;
import Util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class CrearPartida_controller {

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
    void metodoSeleccionLagarto(MouseEvent event) {
        if (CrearPartida_modelo.CrearPartida(Util.getUsername(), Eleccion.LAGARTO.toString())) {
            mostrarAlerta();
            Util cambiarEscena = new Util();
            cambiarEscena.cambiarEscena("../Menu/paginaPrincipal_proyecto.fxml",
                    botonSeleccionLagarto);
        }
    }

    @FXML
    void metodoSeleccionPapel(MouseEvent event) {
        if (CrearPartida_modelo.CrearPartida(Util.getUsername(), Eleccion.PAPEL.toString())) {
            mostrarAlerta();
            Util cambiarEscena = new Util();
            cambiarEscena.cambiarEscena("../Menu/paginaPrincipal_proyecto.fxml",
                    botonSeleccionPapel);
        }
    }

    @FXML
    void metodoSeleccionPiedra(MouseEvent event) {
        if (CrearPartida_modelo.CrearPartida(Util.getUsername(), Eleccion.PIEDRA.toString())) {
            mostrarAlerta();
            Util cambiarEscena = new Util();
            cambiarEscena.cambiarEscena("../Menu/paginaPrincipal_proyecto.fxml",
                    botonSeleccionPiedra);
        }
    }

    @FXML
    void metodoSeleccionSpock(MouseEvent event) {
        if (CrearPartida_modelo.CrearPartida(Util.getUsername(), Eleccion.SPOCK.toString())) {
            mostrarAlerta();
            Util cambiarEscena = new Util();
            cambiarEscena.cambiarEscena("../Menu/paginaPrincipal_proyecto.fxml",
                    botonSeleccionSpock);
        }
    }

    @FXML
    void metodoSeleccionTijera(MouseEvent event) {
        if (CrearPartida_modelo.CrearPartida(Util.getUsername(), Eleccion.TIJERAS.toString())) {
            mostrarAlerta();
            Util cambiarEscena = new Util();
            cambiarEscena.cambiarEscena("../Menu/paginaPrincipal_proyecto.fxml",
                    botonSeleccionTijera);
        }
    }


    @FXML
    void metodoVolverMenu(ActionEvent event) {
        Util cambiarEscena = new Util();
        cambiarEscena.cambiarEscena("../Menu/paginaPrincipal_proyecto.fxml", botonVueltaMenu);
    }

    private void mostrarAlerta() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Información");
        alerta.setHeaderText("Partida creada");
        alerta.setContentText("La partida se ha creado correctamente.");
        alerta.showAndWait();
    }

}
