package ud7.apuntesficherostexto;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class EjemploBufferedWriter {

    static final String PATH = "src/ud7/apuntesficherostexto/";

    public static void main(String[] args) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(PATH + "Quijote.txt", true)); 
             BufferedWriter out2 = new BufferedWriter(new FileWriter(PATH + "Quijote.txt", true))) {
            String linea1 = "En un lugar de La Mancha,";
            String linea2 = "de cuyo nombre no quiero acordarme";

            for (int i = 0; i < linea1.length(); i++) {
                out.write(linea1.charAt(i));
            }

            out.flush();

            out.newLine();

            out.write(linea2);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
