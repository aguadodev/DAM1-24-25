package ud7.apuntesjavafx.empresas;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class EmpresaController implements Initializable {

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

        lstEmpresas.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, empresaSeleccionada) -> {
                    txtId.setText(String.valueOf(empresaSeleccionada.getId()));
                    txtNombre.setText(empresaSeleccionada.getNombre());
                    txtWeb.setText(empresaSeleccionada.getWeb());
                });
    }

    @FXML
    void actualizar(ActionEvent event) {

    }

    @FXML
    void agregar(ActionEvent event) {
        Empresa empresa = new Empresa(Integer.parseInt(txtId.getText()), txtNombre.getText(), txtWeb.getText());

        if (!AppEmpresa.empresas.contains(empresa)) {
            AppEmpresa.empresas.add(empresa);
            lstEmpresas.getItems().add(empresa);
        }
    }

    @FXML
    void borrar(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());
        AppEmpresa.empresas.remove(new Empresa(id));
        lstEmpresas.getItems().remove(new Empresa(id));
    }

}
