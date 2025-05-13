package ud7.apuntesjavafx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Login");
        Scene scene = new Scene(FXMLLoader.load(Login.class.getResource("Login.fxml")));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

