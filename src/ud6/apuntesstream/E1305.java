package ud6.apuntesstream;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import ud6.apuntescolecciones.Cliente;

public class E1305 {
    public static void main(String[] args) {
        Integer[] numeros = new Integer[50];
        List<Integer> numerosL = new ArrayList<>();
        for (int i = 0; i < numeros.length; i++) {
            int rnd = (int) (Math.random() * 20 + 1);
            numeros[i] = rnd;
            numerosL.add(rnd);
        }

        System.out.println(Arrays.toString(numeros));

        System.out.println("Filtrando múltiplos de 3:");

        Double[] raices;
        raices = transformar(numeros, new Double[0], n -> Math.sqrt(n));
        System.out.println(Arrays.toString(raices));


        List<Double> raicesLista = transformar(numerosL, x -> Math.sqrt(x));
        System.out.println(raicesLista);

        // Ejemplo con clientes para obtener el número de días desde el nacimiento de cada Cliente
        List<Long> diasDesdeNacimiento = transformar(Cliente.clientesDeEjemplo(), c -> c.getFechaNacimiento().until(LocalDate.now(), ChronoUnit.DAYS));
        System.out.println(diasDesdeNacimiento);

    }

    static <T, V> List<V> transformar(List<T> t, Function<T, V> f) {
        List<V> lista = new ArrayList<>();
        for (T e : t)
            lista.add(f.apply(e));
            
        return lista;
    }

    static <T, V> V[] transformar(T[] t, V[] transf, Function<T, V> f) {
        transf = Arrays.copyOf(transf, t.length);
        for (int i = 0; i < t.length; i++) {
            transf[i] = f.apply(t[i]);
        }

        return transf;
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
