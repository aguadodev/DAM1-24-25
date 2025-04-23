package ud6.apuntesstream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import ud6.apuntescolecciones.Cliente;

public class E1304 {
    public static void main(String[] args) {
        Integer[] numeros = new Integer[50];
        List<Integer> numerosL = new ArrayList<>();
        for (int i = 0; i < numeros.length; i++) {
            int rnd = (int)(Math.random() * 20 + 1);
            numeros[i] = rnd;
            numerosL.add(rnd);
        }


        System.out.println(Arrays.toString(numeros));

        System.out.println("Filtrando múltiplos de 3:");
        Integer[] multiplos3 = filtrar(numeros, n -> n % 3 == 0);
        System.out.println(Arrays.toString(multiplos3));


        System.out.println("Filtrando pares en la lista:");
        List<Integer> numerosPares = filtrar(numerosL, n -> n % 2 == 0);
        System.out.println(numerosPares);

        
        System.out.println("Clientes");
        List<Cliente> clientes = Cliente.clientesDeEjemplo();
        System.out.println(clientes);
        System.out.println("Clientes mayores de edad:");
        List<Cliente> mayoresEdad = filtrar(clientes, c -> c.getEdad() >= 18);
        System.out.println(mayoresEdad);
    }





    static <T> T[] filtrar(T[] t, Predicate<T> p) {
        // Instanciar tabla nueva
        T[] tn = Arrays.copyOf(t, 0);

        // Recorrer tabla original
        for (T e : t) {
            // Si el elemento cumple el predicado añadir a tabla nueva
            if (p.test(e)) {
                tn = Arrays.copyOf(tn, tn.length + 1);
                tn[tn.length - 1] = e;
            }
        }

        // devolver tabla nueva
        return tn;
    }

    static <T> List<T> filtrar(List<T> l, Predicate<T> p) {
        List<T> lista = new ArrayList<T>();
        for (T e : l) 
            if (p.test(e))
                lista.add(e);

        return lista;
    }

}
