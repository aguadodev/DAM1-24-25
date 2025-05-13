package ud7.apuntesjavafx.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsuario;

    @FXML
    void login(ActionEvent event) {
        Usuario user = new Usuario (txtUsuario.getText(), txtPassword.getText());

        if (user.login())
            System.out.println("Login OK");
        else 
            System.out.println("Login KO");
    }

}
