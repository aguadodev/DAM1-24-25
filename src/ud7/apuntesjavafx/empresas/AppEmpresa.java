package ud7.apuntesjavafx.empresas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppEmpresa extends Application {

    static List<Empresa> empresas = new ArrayList<>();
    static String path = "src/ud7/apuntesjavafx/empresas/";

    public static void main(String[] args) {
        empresas.add(new Empresa(1, "IES Chan do Monte", "http://ieschandomonte.edu.es/ies/"));

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Empresas");
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(AppEmpresa.class.getResource("Empresa.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static public void guardarFichero(String path) {
        // Crear un fichero de texto para escritura
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
            // Recorrer la lista de empresas
            for (Empresa empresa : empresas) {
                // Grabar en el fichero los datos de cada empresa separados por comas
                String linea = empresa.getId() + "," + empresa.getNombre() + "," + empresa.getWeb();
                out.write(linea);
                out.newLine();
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error de E/S");
        }
    }

    static public void cargarFichero(String path) {
        // Abrir un fichero de texto para lectura
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            empresas.clear();
            // Leer el fichero línea a línea
            // Lectura anticipada
            String linea = in.readLine();
            while (linea != null) {
                // Analizar línea y construir empresa
                String[] campos = linea.split(",");
                Empresa empresa = new Empresa(Integer.parseInt(campos[0]), campos[1], campos[2]);
                // Añadir línea a la lista
                empresas.add(empresa);
                // leer nueva línea
                linea = in.readLine();
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error de E/S");
        }
    }

}
