package Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Util {

    // Variable estática para guardar los datos de la partida para poder usarlos en cualquier escena
    public static String[] datosPartida = new String[3];

    // Variable estática para guardar el nombre de usuario para poder usarlo en cualquier escena
    static String username;

    public static void setUsername(String username) {
        Util.username = username;
    }

    public static String getUsername() {
        return Util.username;
    }

    public void cambiarEscena(String fxml, Button boton) {
        Stage primaryStage;
        Parent root;

        try {
            primaryStage = (Stage) boton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource(fxml));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println("Error al cambiar de escena");
            e.printStackTrace();
        }
    }

    public void cambiarEscena(String fxml, ImageView boton) {
        Stage primaryStage;
        Parent root;

        try {
            primaryStage = (Stage) boton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource(fxml));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println("Error al cambiar de escena");
            e.printStackTrace();
        }
    }

    public void cambiarEscena(String fxml, ListView<?> listView, String partidaSeleccionada) {
        // Obtener el escenario y la raíz de la escena actual
        Stage primaryStage = (Stage) listView.getScene().getWindow();
        Parent root;

        try {
            // Cargar la nueva escena desde el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            // Guardar los datos de la partida seleccionada
            guardarDatosPartida(partidaSeleccionada);
            root = loader.load();
            // Establecer la nueva escena en el escenario
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println("Error al cambiar de escena");
            e.printStackTrace();
        }
    }



    public static void guardarDatosPartida(String partidaSeleccionada) {
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
                    String sql =
                            "SELECT * FROM Partida WHERE ID = " + partidaSeleccionada.split("-")[0];
                    consulta.executeQuery(sql);
                    // Si la consulta devuelve un resultado, el login es correcto
                    if (consulta.getResultSet().next()) {
                        datosPartida[0] = consulta.getResultSet().getString("ID");
                        datosPartida[1] = consulta.getResultSet().getString("Jugador1");
                        datosPartida[2] = consulta.getResultSet().getString("EleccionJugador1");
                    }
                    // Si la consulta no devuelve un resultado, el login es incorrecto
                } catch (SQLException e1) {
                    System.out.println("Error al ejecutar la consulta");
                }
            }
            // Cerrar la conexión con la BD
            conexionBD.close();
        } catch (Exception e) {
            System.out.println("Error al seleccionar la partida");
        }
    }

}
