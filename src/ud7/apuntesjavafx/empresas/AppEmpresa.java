package ud7.apuntesjavafx.empresas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppEmpresa extends Application {

    static List<Empresa> empresas = new ArrayList<>();
    static String rutaFicheroEmpresas = "src/ud7/apuntesjavafx/empresas/";
    static String ficheroEmpresas = "src/ud7/apuntesjavafx/empresas/empresas.csv";
    static Stage stagePrincipal;

    public static void main(String[] args) {
        empresas.add(new Empresa(1, "IES Chan do Monte", "http://ieschandomonte.edu.es/ies/"));

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stagePrincipal = primaryStage;
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

    static public void guardarFicheroDat(String path) {
        // Crear un fichero binario para escritura
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(empresas);
    } catch (FileNotFoundException e) {
        System.out.println("Error: Archivo no encontrado");
    } catch (IOException e) {
        System.out.println("Error de E/S al escribir en el archivo");
    } catch (Exception e) {
        System.out.println("Error desconocido al guardar el archivo");
    }
    }

    static public void cargarFicheroDat(String path) {
        // Carga un fichero binario para lectura
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            empresas = (List<Empresa>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error de E/S al leer el archivo");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Clase no encontrada");
        } catch (Exception e) {
            System.out.println("Error desconocido al cargar el archivo");
        }
    }

}
