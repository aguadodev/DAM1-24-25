package ud7.ejemplousuarios.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ud7.ejemplousuarios.AppUsuario;
import ud7.ejemplousuarios.modelo.Usuario;
import ud7.ejemplousuarios.modelo.UsuarioDAO;

public class RegistroController {

    @FXML
    private PasswordField txtPassword;

    @FXML
    private PasswordField txtRepetirPassword;

    @FXML
    private TextField txtUsuario;

    @FXML
    void login(ActionEvent event) {
        AppUsuario.cargarEscena("Login");
    }

    @FXML
    void registrar(ActionEvent event) {
        String username = txtUsuario.getText();
        String password = txtPassword.getText();
        String repetirPassword = txtRepetirPassword.getText();

        if (username.equals("") || password.equals("") || repetirPassword.equals("")) {
            System.out.println("ERROR: Algún campo está vacío");
            AppUsuario.mostrarError("Error de registro", "ERROR: Algún campo está vacío");
            return;
        }

        if (!password.equals(repetirPassword)) {
            System.out.println("ERROR: Las contraseñas no coinciden");
            AppUsuario.mostrarError("Error de registro", "ERROR: Las contraseñas no coinciden");
            return;
        }

        // Aquí se puede añadir el código para registrar al usuario en la base de datos
        Usuario usuario = UsuarioDAO.registrar(username, password);
        if (usuario == null) {
            System.out.println("ERROR: El usuario ya existe");
            AppUsuario.mostrarError("Error de registro", "ERROR: El usuario ya existe");
            return;
        }
        System.out.println("Usuario registrado correctamente");
        System.out.println("Iniciando sesión...");
        AppUsuario.usuario = usuario;
        // Iniciar sesión automáticamente
        AppUsuario.cargarEscena("Perfil");
    }

}
