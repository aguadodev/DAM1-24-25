package ud7.apuntesficherostexto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AP103_Jugadores {

    static final String PATH = "src/ud7/apuntesficherostexto/";

    public static void main(String[] args) {

        List<Jugador> equipo = new ArrayList<>();
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(PATH + "Jugadores.txt"));
            Scanner sc = new Scanner(in);
            while (sc.hasNextLine()) {
                String nombre = sc.next();
                int edad = sc.nextInt();
                double estatura = sc.nextDouble();

                equipo.add(new Jugador(nombre, edad, estatura));
                
            }
            in.close();
            sc.close();

            System.out.println("Equipo = " + equipo);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


class Jugador {
    String nombre;
    int edad;
    double estatura;

    public Jugador(String nombre, int edad, double estatura) {
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
    }
    @Override
    public String toString() {
        return "Jugador [nombre=" + nombre + ", edad=" + edad + ", estatura=" + estatura + "]";
    }

    
}
