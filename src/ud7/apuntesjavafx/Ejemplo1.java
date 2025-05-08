import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Ejemplo1 extends Application {
    static int contador = 0;

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, JavaFX!");
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        // contenido
        Button btn = new Button("Púlsame");
        btn.setOnAction(e -> {
            System.out.println("Botón pulsado!!!");
            contador++;
            if (contador > 1)
                btn.setText("Botón pulsado " + contador + " veces!!!");
            else
                btn.setText("Botón pulsado!!!");
        });
        Scene scene = new Scene(btn, 300, 200);
        stage.setTitle("Hola, JavaFX");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
