package ud6.xxxexamen.genericos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class UtilGenerico {
    public static <T> List<T> repetidos(List<T> lista) {
        List<T> soloRepetidos = new ArrayList<>();

        for (T e : lista) {
            // Si e está repetido lo añado al resultado
            int cont = 0;
            for (T t : lista) 
                if (t.equals(e))
                    cont++;

            //if (lista.indexOf(e) != lista.lastIndexOf(e))
            if (cont > 1)
                soloRepetidos.add(e);
        }

        return soloRepetidos;
    }


    public static <T> Collection<T> filtrarMayores(Collection<T> coleccion, T valor, Comparator<T> comp) {
        Collection<T> res = new ArrayList<>();
        for (T e : coleccion) 
            if (comp.compare(e, valor) >= 0)
                res.add(e);

        return res;
    }


    public static void main(String[] args) {
        Integer[] t = { 1, 3, 3, 3, 4, 5, 5, 3, 6 };
        System.out.println(repetidos(Arrays.asList(t)));

        Comparator<Integer> comp = Comparator.naturalOrder();
        System.out.println(filtrarMayores(Arrays.asList(t), 4, comp));
    }

}
