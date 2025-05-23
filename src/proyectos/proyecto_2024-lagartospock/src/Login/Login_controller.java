package Login;

import java.io.IOException;
import Util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Login_controller {

    @FXML
    private Button botonLogin;

    @FXML
    private Button botonSignup;

    @FXML
    private TextField campoPassword;

    @FXML
    private TextField campoUsername;

    @FXML
    void loginMethod(ActionEvent event) throws IOException {
        // Si el login es correcto, abrir el menú principal
        if (Login_modelo.login(campoUsername.getText(), campoPassword.getText())) {
            Util cambiarEscena = new Util();
            cambiarEscena.cambiarEscena("../Menu/paginaPrincipal_proyecto.fxml", botonLogin);
        }

    }

    @FXML
    void signupMethod(ActionEvent event) {
        Login_modelo.signup(campoUsername.getText(), campoPassword.getText());
    }
}
