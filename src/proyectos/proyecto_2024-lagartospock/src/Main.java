import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("PPTLS Game");

        Parent root = FXMLLoader.load(getClass().getResource("Login/paginaLogin_proyecto.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("Util/styles.css").toExternalForm());
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("imgs/Favicon.png"));
        primaryStage.show();
    }


}
