package ud7.apuntesficherostexto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EjemploScanner {

    static final String PATH = "src/ud7/apuntesficherostexto/";

    public static void main(String[] args) {
        int suma = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(PATH + "Enteros.txt"));
            Scanner sc = new Scanner(in);
            while (sc.hasNextInt()) {
                int num = sc.nextInt();
                suma += num;
            }
            sc.close();
            in.close();

            System.out.println("Suma = " + suma);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
