package ud7.apuntesjavafx.empresas;

import java.io.File;
import java.net.URL;
import java.util.List;
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
        AppEmpresa.cargarFichero(AppEmpresa.ficheroEmpresas);
        AppEmpresa.stagePrincipal.setTitle("Empresas - " + AppEmpresa.ficheroEmpresas);

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
        AppEmpresa.guardarFicheroDat(AppEmpresa.rutaFicheroEmpresas + "empresa.dat");
    }

    @FXML
    void cargarFichero(ActionEvent event) {
        AppEmpresa.cargarFicheroDat(AppEmpresa.rutaFicheroEmpresas + "empresa.dat");
        actualizarListView();
    }

    @FXML
    void guardarComo(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar como...");
        fileChooser.setInitialDirectory(new File(AppEmpresa.rutaFicheroEmpresas));
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("CSV Files", "*.csv"));
        /*
         * new ExtensionFilter("Text Files", "*.txt"),
         * new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
         * new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
         * new ExtensionFilter("All Files", "*.*"));
         */
        File selectedFile = fileChooser.showSaveDialog(AppEmpresa.stagePrincipal);
        if (selectedFile != null){
            AppEmpresa.guardarFichero(selectedFile.toString());
        }
    }

    @FXML
    void abrir(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir...");
        fileChooser.setInitialDirectory(new File(AppEmpresa.rutaFicheroEmpresas));
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("CSV Files", "*.csv"));
        /*
         * new ExtensionFilter("Text Files", "*.txt"),
         * new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
         * new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
         * new ExtensionFilter("All Files", "*.*"));
         */
        File selectedFile = fileChooser.showOpenDialog(AppEmpresa.stagePrincipal);
        if (selectedFile != null) {
            AppEmpresa.cargarFichero(selectedFile.toString());
            actualizarListView();
            AppEmpresa.stagePrincipal.setTitle("Empresas - " + selectedFile.toString());
            AppEmpresa.rutaFicheroEmpresas = selectedFile.getParent();
            AppEmpresa.ficheroEmpresas = selectedFile.getPath();
        }
    }

    @FXML
    void exportarJSON(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Exportar JSON...");
        fileChooser.setInitialDirectory(new File(AppEmpresa.rutaFicheroEmpresas));
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("JSON Files", "*.json"));

        File selectedFile = fileChooser.showSaveDialog(AppEmpresa.stagePrincipal);
        if (selectedFile != null){
            Empresa[] t = AppEmpresa.empresas.toArray(new Empresa[0]);
            Util.exportararArrayJson(selectedFile.toString(), t); 
        }
    }

    @FXML
    void importarJSON(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Importar JSON...");
        fileChooser.setInitialDirectory(new File(AppEmpresa.rutaFicheroEmpresas));
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("JSON Files", "*.json"));

        File selectedFile = fileChooser.showOpenDialog(AppEmpresa.stagePrincipal);
        if (selectedFile != null) {
            Empresa[] t = Util.importarArrayJson(selectedFile.toString(), Empresa[].class); 
            AppEmpresa.empresas.clear();
            AppEmpresa.empresas.addAll(List.of(t));
            actualizarListView();
        }
    }    

}
