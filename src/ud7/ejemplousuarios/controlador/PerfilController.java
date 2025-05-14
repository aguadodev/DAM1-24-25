package ud7.ejemplousuarios.controlador;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import ud7.ejemplousuarios.AppUsuario;
import ud7.ejemplousuarios.modelo.UsuarioDAO;

public class PerfilController implements Initializable {
    @FXML
    private Label lblUsuario;

    @FXML
    private Label lblCreatedAt;

    @FXML
    private Label lblLastLogin;

    @FXML
    private Label lblUpdatedAt;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private PasswordField txtRepetirPassword;

    @FXML
    private Button btnAdmin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Inicializar la etiqueta con el nombre de usuario
        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        lblUsuario.setText(AppUsuario.usuario.getUsername());
        if (AppUsuario.usuario.getCreatedAt() == null) {
            lblCreatedAt.setText("No disponible");
        } else {
            lblCreatedAt.setText(AppUsuario.usuario.getCreatedAt().format(formatoFechaHora));
        }
        if (AppUsuario.usuario.getUpdatedAt() == null) {
            lblUpdatedAt.setText("No disponible");
        } else {
            lblUpdatedAt.setText(AppUsuario.usuario.getUpdatedAt().format(formatoFechaHora));
        }
        if (AppUsuario.usuario.getLastLogin() == null) {
            lblLastLogin.setText("No disponible");
        } else {
            lblLastLogin.setText(AppUsuario.usuario.getLastLogin().format(formatoFechaHora));
        }
        // Inicializar el boton de admin
        btnAdmin.setVisible(AppUsuario.usuario.isAdmin());

    }

    @FXML
    void cambiarPassword(ActionEvent event) {
        // Comprobar que las contraseñas son iguales
        String password = txtPassword.getText();
        String repetirPassword = txtRepetirPassword.getText();
        if (!password.equals(repetirPassword)) {
            System.out.println("Las contraseñas no coinciden");
            AppUsuario.mostrarError("Error de actualización", "ERROR: Las contraseñas no coinciden");
            return;
        } else {
            System.out.println("Las contraseñas coinciden");
            // Cambiar la contraseña
            UsuarioDAO.cambiarPassword(AppUsuario.usuario, password);
            System.out.println("Contraseña cambiada correctamente");
            // Volver a la pantalla de login
            AppUsuario.cargarEscena("Perfil");
        }
    }

    @FXML
    void logout(ActionEvent event) {
        AppUsuario.usuario = null;
        System.out.println("Cerrando sesión...");
        AppUsuario.cargarEscena("Login");
    }

    @FXML
    void admin(ActionEvent event) {
        AppUsuario.cargarEscena("Admin");
    }

}
