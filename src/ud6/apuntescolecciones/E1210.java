package ud6.apuntescolecciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class E1210 {

    public static void main(String[] args) {
        Random rd = new Random();

        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            lista.add(rd.nextInt(0, 10)); // 2 4 5 3 6 7 8 4 3 2 8 9
        }

        // TODOS LOS ELEMENTOS, REPETIDOS O NO, PERO EXCLUYENDO LOS DUPLICADOS
        Set<Integer> sinRepetidos = new LinkedHashSet<>();
        sinRepetidos.addAll(lista);

        /*
         * Solución con bucle
         * for (int i = 0; i < lista.size(); i++) {
         * sinRepetidos.add(lista.get(i)); // 2 3 4 5 6 7 8 9
         * }
         */

        Set<Integer> elementosRepetidos = new TreeSet<>();
        for (Integer numero : lista) {
            if (lista.indexOf(numero) != lista.lastIndexOf(numero)) { // 2 3 4 8
                elementosRepetidos.add(numero);
            }
        }

        Set<Integer> elementosSinRepetir = new TreeSet<>();
        elementosSinRepetir.addAll(sinRepetidos);
        elementosSinRepetir.removeAll(elementosRepetidos);

        /*
         * Solución con bucle
         * for (Integer numero : sinRepetidos) {
         * if (lista.indexOf(numero) == lista.lastIndexOf(numero)) {// 5 6 7 9
         * elementosSinRepetir.add(numero);
         * }
         * }
         */

        System.out.println("LISTA");
        System.out.println(lista);

        System.out.println("\nLISTA SIN REPETIDOS");
        System.out.println(sinRepetidos);

        System.out.println("\nELEMENTOS QUE SE REPITEN");
        System.out.println(elementosRepetidos);

        System.out.println("\nElEMENTOS QUE SOLO APARECEN UNA VEZ");
        System.out.println(elementosSinRepetir);

        // OTRA SOLUCIÓN
        Set<Integer> repetidos = new HashSet<>();
        Set<Integer> unicos = new HashSet<>();
        for (Integer num : lista) {
            if (!unicos.add(num)) {
                repetidos.add(num);
            }
        }

        unicos.removeAll(repetidos);

        // Comprueba que los resultados son iguales que en la solución anterior
        System.out.println("Conjunto de repetidos: " + repetidos.equals(elementosRepetidos));
        System.out.println("Conjunto de únicos: " + unicos.equals(elementosSinRepetir));

    }
}
