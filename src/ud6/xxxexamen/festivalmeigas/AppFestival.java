package ud6.xxxexamen.festivalmeigas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ud6.xxxexamen.genericos.UtilGenerico;

import java.util.Random;

public class AppFestival {

    public static void main(String[] args) {
        System.out.println("\nFESTIVAL DE MEIGAS");
        System.out.println("==================\n");
        // Crea un array de meigas de exemplo
        Meiga[] meigasExemplo = Meiga.crearMeigasExemplo(Feitizo.crearFeitizosExemplo());

        // TODO: Ordena as Meigas de menor a maior número de feitizos
        Arrays.sort(meigasExemplo, (m1, m2) -> m1.getNumFeitizos() - m2.getNumFeitizos());
        Map<Meiga, Integer> puntuaciones = new HashMap<>();

        // Para cada meiga do festival, imprime os seus datos, lanza os
        // feitizos posibles, e imprime os puntos obtidos.
        for (Meiga meiga : meigasExemplo) {
            System.out.println("MEIGA: ");
            System.out.println(meiga);
            int puntos = meiga.lanzarFeitizos();
            System.out.println("TOTAL PUNTOS: " + puntos + "\n\n");

            // TODO: Engade o código que necesites...
            puntuaciones.put(meiga, puntos);
        }

        // Amosa a clasificación final do festival
        System.out.println("Clasificación Final do Festival: ");
        // TODO: Engade o código que necesites...
        List<Entry<Meiga, Integer>> entradas = new ArrayList<>(puntuaciones.entrySet());
        entradas.sort((e1, e2) -> e2.getValue() - e1.getValue());
        for (Entry<Meiga,Integer> entrada : entradas) {
            System.out.println(entrada.getKey().getNome() + " - " + entrada.getValue() + " puntos");
        }



        System.out.println("\nFIN DO FESTIVAL DE MEIGAS\n");


        //System.out.println("EXTRA");
        //List<Entry<Meiga, Integer>> entradasFiltradas = UtilGenerico.filtrarMayores(entradas, /*Entrada con dificultad 5 */, (e1, e2) -> e2.getValue() - e1.getValue());
    }

}
