package ud7.apuntesjavafx.empresas;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppEmpresa extends Application {

    static List<Empresa> empresas = new ArrayList<>();

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

}
