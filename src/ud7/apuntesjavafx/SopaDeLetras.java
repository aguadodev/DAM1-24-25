package ud7.apuntesjavafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SopaDeLetras extends Application {

    static char[][] sopaLetras = {
            { 's', 'o', 'z', 'h', 'i' },
            { 's', 'e' },
            { 'p', 'o', 'v', 'h' },
            { 'p', 'o', 'z', 'e' },
            { 'p', 'o', 'z', 'h', 'n' }
    };

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sopa de Letras");

        GridPane gridpane = new GridPane();
        for (int i = 0; i < sopaLetras.length; i++) {
            for (int j = 0; j < sopaLetras[i].length; j++) {
                Label lblLetra = new Label(String.valueOf(sopaLetras[i][j]));
                lblLetra.setPrefSize(40, 40);
                lblLetra.setAlignment(Pos.CENTER);
                final int row = i;
                final int col = j;
                lblLetra.setOnMouseClicked(e -> {
                    System.out.println(lblLetra.getText());
                    lblLetra.setStyle("-fx-text-fill: #2196F3;");
                    System.out.println("x: "+lblLetra.getLayoutX());
                    System.out.println("y: "+lblLetra.getLayoutY());
                    System.out.println("Has pulsado la letra " + sopaLetras[row][col]);
                    System.out.println("Fila:" + row);
                    System.out.println("Columna: " + col);       
                    System.out.println("Fila: " + GridPane.getRowIndex(lblLetra));
                    System.out.println("Columna: " + GridPane.getColumnIndex(lblLetra));
                    
                });
                gridpane.add(lblLetra, j, i);
            }
        }

        primaryStage.setScene(new Scene(gridpane));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
