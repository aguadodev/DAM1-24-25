package ud7.ejemplousuarios;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ud7.ejemplousuarios.modelo.Usuario;

public class AppUsuario extends Application {

    static Stage primaryStage;
    public static Usuario usuario = null;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        primaryStage.setTitle("AppUsuario");
        cargarEscena("Login");
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void cargarEscena(String fxml) {
        try {
            // Cargar la nueva ventana
            FXMLLoader loader = new FXMLLoader(AppUsuario.class.getResource("vista/" + fxml + ".fxml"));
            Parent root = loader.load();

            // Crear una nueva escena
            Scene scene = new Scene(root);

            // Cambiar la escena
            primaryStage.setScene(scene);

        } catch (Exception e) {
            System.out.println("Error al cargar la escena: " + e.getMessage());
        }
    }

    public static void mostrarError(String titulo, String texto) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }

}
