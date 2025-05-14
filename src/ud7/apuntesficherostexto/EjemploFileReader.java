package ud7.apuntesficherostexto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjemploFileReader {

    static final String PATH = "src/ud7/apuntesficherostexto/";

    public static void main(String[] args) {
        try {
            FileReader fichero = new FileReader(PATH + "texto.txt");
            int ch = fichero.read();
            while (ch != -1) {
                System.out.println((char) ch);
                ch = fichero.read();
            }
            fichero.close();
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
