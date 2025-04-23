package ud6.apuntesstream.e1301;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import ud6.apuntescolecciones.Cliente;

public class Main {
    public static void main(String[] args) {
        
        Saludo<String> saludoString;

        // Implementando el saludo con una clase anónima
        saludoString = new Saludo<String>() {
            @Override
            public String saludar(String str) {
                return "Hola " + str;
            }
        };

        // Lo mismo pero con una expresión lambda
        saludoString = (cadena) -> "Hola " + cadena;

        Saludo<Cliente> saludoCliente = (c) -> "Buenos días " + c.getNombre();


        System.out.println(saludoString.saludar("Pepe"));

        System.out.println(saludoCliente.saludar(new Cliente("María")));

        // Llamada método E1302
        System.out.println("\nE1302");
        System.out.println("=====\n");

        String[] tString = {"Pepe", "María", "Marcos", "Ana"};
        List<String> saludos = saludar(saludoString , tString);
        System.out.println(saludos);


        Cliente[] tCliente = {
            new Cliente("1", "Pepe", "01/01/2008"), 
            new Cliente("2","María", "01/01/2006"), 
            new Cliente("3","Marcos", "01/01/2000"), 
            new Cliente("4","Ana", "01/01/2005")};

        List<String> saludosClientes = saludar((c) -> "Que pasa, " + c.getNombre() + "?" , tCliente);
        System.out.println(saludosClientes);

        // Llamada método E1302
        System.out.println("\nE1303 - Cliente de más edad");
        System.out.println("===========================\n");        
        System.out.println(max(tCliente, (a, b) -> a.getEdad() - b.getEdad()));

    }


    // Método E1302
    static <T> List<String> saludar(Saludo<T> s, T[] t) {
        List<String> saludos = new ArrayList<>();

        for (T e : t) {
            saludos.add(s.saludar(e));
        }

        return saludos;
    }


    static <T> T max(T[] t, Comparator<T> c) {
        if (t == null || t.length == 0 || c == null)
            return null;

        Arrays.sort(t, c.reversed());

        return t[0];
    }


}
