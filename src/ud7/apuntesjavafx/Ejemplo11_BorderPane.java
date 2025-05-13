package ud7.apuntesjavafx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Ejemplo11_BorderPane extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuItem menRojo = new MenuItem("Rojo");
        MenuItem menVerde = new MenuItem("Verde");
        MenuItem menAzul = new MenuItem("Azul");

        Menu menColores = new Menu("Colores");
        menColores.getItems().addAll(menRojo, menVerde, menAzul);

        MenuBar menuBar = new MenuBar(menColores);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        
        // EVENTOS
        menRojo.setOnAction(e -> borderPane.setBackground(Background.fill(Paint.valueOf("RED"))));
        menVerde.setOnAction(e -> borderPane.setStyle("-fx-background-color: green;"));
        menAzul.setOnAction(e -> borderPane.setStyle("-fx-background-color: blue;"));


        Scene scene = new Scene(borderPane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BorderPane con Menú y Colores de fondo");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
