package ud7.apuntesjavafx;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EjemploDatePicker extends Application {

    LocalTime hora = null;

    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Ejemplo de DatePicker");

        // Crear un DatePicker
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());

        // Como DatePicker no recoge la hora, podemos crear un campo de texto para ello
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        TextField txtHora = new TextField();
        txtHora.setPromptText("HH:mm");
        txtHora.setText(LocalTime.now().format(formatoHora));
        txtHora.setMaxWidth(80);


        // Crear un botón para mostrar la fecha seleccionada
        Button button = new Button("Mostrar Fecha");
        button.setOnAction(e -> {
            LocalDate fechaSeleccionada = datePicker.getValue();

            System.out.println("Fecha seleccionada: " + fechaSeleccionada);

            try {
                hora = LocalTime.parse(txtHora.getText(), formatoHora);
            } catch (DateTimeParseException ex) {
                // A hora non é válida
            }

            if (hora != null) {
                System.out.println("Hora seleccionada: " + hora);
            }
        });


        // Otra opción para "escuchar" cambios en el DatePicker
        datePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Fecha cambiada de " + oldValue + " a " + newValue);
        });

        // Crear un layout y agregar los componentes
        VBox vbox = new VBox(datePicker, txtHora, button);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        // Crear una escena y agregar el layout
        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);

        // Mostrar la ventana
        stage.show();
    }
}