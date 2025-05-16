package ud7.apuntesficherosbinarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import ud7.apuntesficherostexto.jaxb.Socio;

public class E1108 {
    static final String PATH = "src/ud7/apuntesficherosbinarios/";

    public static void main(String[] args) {
        Socio[] socios = {
                new Socio(1, "Juan", "Calle Chan do Monte", "01/01/2021"),
                new Socio(2, "Ana", "Calle Marín", "01/01/2022"),
                new Socio(3, "Luis", "Calle Vigo", "01/01/2023"),
        };

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PATH + "socios.dat"))) {
            out.writeByte(3);
            out.writeObject(socios);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


        // LEE EL FICHERO BINARIO E IMPRIME SUS DATOS
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("X:\\dam1\\Programación\\UD07\\socios.dat"))) {
            in.readByte();
            Socio[] sociosFichero = (Socio []) in.readObject();

            System.out.println(Arrays.toString(sociosFichero));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
