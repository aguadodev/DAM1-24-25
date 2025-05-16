package ud7.apuntesjavafx.empresas;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

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
        int id = Integer.parseInt(txtId.getText());
        int indice = AppEmpresa.empresas.indexOf(new Empresa(id));
        if (indice != -1) {
            Empresa e = AppEmpresa.empresas.get(indice);
            e.setNombre(txtNombre.getText());
            e.setWeb(txtWeb.getText());

            actualizarListView();
        }
    }

    private void actualizarListView() {
        // TODO Actualizar listview más quirúrgicamente
        lstEmpresas.getItems().clear();
        lstEmpresas.getItems().addAll(AppEmpresa.empresas);
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

    @FXML
    void guardarFichero(ActionEvent event) {
        AppEmpresa.guardarFichero(AppEmpresa.path + "empresas.csv");
    }

    @FXML
    void cargarFichero(ActionEvent event) {
        AppEmpresa.cargarFichero(AppEmpresa.path + "empresas.csv");
        actualizarListView();
    }

    @FXML
    void guardarComo(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Text Files", "*.txt"),
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            mainStage.display(selectedFile);
        }
    }

}
