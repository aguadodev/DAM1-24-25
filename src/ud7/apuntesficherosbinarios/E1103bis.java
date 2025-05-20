package ud7.apuntesficherosbinarios;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class E1103bis {
    static final String PATH = "src/ud7/apuntesficherosbinarios/";

    public static void main(String[] args) {
        double[] t = null;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PATH + "numerosDouble.dat"))) {
            t = (double[]) in.readObject();
            System.out.println(Arrays.toString(t));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
