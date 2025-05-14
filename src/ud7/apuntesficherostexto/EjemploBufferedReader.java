package ud7.apuntesficherostexto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjemploBufferedReader {

    static final String PATH = "src/ud7/apuntesficherostexto/";

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(PATH + "texto.txt"));
            int ch = in.read();
            while (ch != -1) {
                System.out.println((char) ch);
                ch = in.read();
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
