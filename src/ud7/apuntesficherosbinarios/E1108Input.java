package ud7.apuntesficherosbinarios;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

import ud7.apuntesficherostexto.jaxb.Socio;

public class E1108Input {
    static final String PATH = "src/ud7/apuntesficherosbinarios/";

    public static void main(String[] args) {
        // LEE EL FICHERO BINARIO E IMPRIME SUS DATOS
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PATH + "socios.dat"))) {
            in.readByte();
            Socio[] sociosFichero = (Socio[]) in.readObject();

            System.out.println(Arrays.toString(sociosFichero));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
