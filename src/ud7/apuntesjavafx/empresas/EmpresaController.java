package ud7.apuntesjavafx.empresas;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class EmpresaController implements Initializable{

    @FXML
    private ListView<Empresa> lstEmpresas;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtWeb;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lstEmpresas.getItems().addAll(AppEmpresa.empresas);
    }



    @FXML
    void actualizar(ActionEvent event) {

    }

    @FXML
    void agregar(ActionEvent event) {

    }

    @FXML
    void borrar(ActionEvent event) {

    }



}
