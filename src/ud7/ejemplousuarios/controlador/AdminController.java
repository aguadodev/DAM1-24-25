package ud7.ejemplousuarios.controlador;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import ud7.ejemplousuarios.AppUsuario;
import ud7.ejemplousuarios.modelo.Usuario;
import ud7.ejemplousuarios.modelo.UsuarioDAO;

public class AdminController implements Initializable {

    @FXML
    private ListView<Usuario> lstUsuarios;

    @FXML
    private Button btnBorrar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Cargar la lista de usuarios
        List<Usuario> usuarios = UsuarioDAO.getUsuarios();
        lstUsuarios.getItems().setAll(usuarios);
        // Establecer el modo de selección
        lstUsuarios.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.SINGLE);
        // Establecer el modo de selección
        lstUsuarios.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Si se selecciona un usuario, se habilita el botón de eliminar
                btnBorrar.setDisable(false);
            } else {
                // Si no se selecciona ningún usuario, se deshabilita el botón de eliminar
                btnBorrar.setDisable(true);
            }
        });
    }

    @FXML
    void borrar(ActionEvent event) {
        // Obtener el usuario seleccionado
        Usuario usuario = lstUsuarios.getSelectionModel().getSelectedItem();
        if (usuario != null) {
            if (usuario.equals(AppUsuario.usuario)) {
                // Si el usuario es el mismo que el que ha iniciado sesión, no se puede eliminar
                AppUsuario.mostrarError("Error de eliminación", "No se puede eliminar el usuario que ha iniciado sesión");
                return;
            }
            // Eliminar el usuario de la lista
            UsuarioDAO.getUsuarios().remove(usuario);
            // Actualizar la lista de usuarios
            lstUsuarios.getItems().setAll(UsuarioDAO.getUsuarios());
            // Deshabilitar el botón de eliminar
            btnBorrar.setDisable(true);
        }
    }

    @FXML
    void volver(ActionEvent event) {
        AppUsuario.cargarEscena("Perfil");
    }
}
