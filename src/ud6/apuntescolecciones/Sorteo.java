package ud6.apuntescolecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import ud5.rol.Personaje;
import ud5.rol.Personaje.Raza;

public class Sorteo<T> {

    Set<T> elementos;

    public Sorteo() {
        elementos = new HashSet<>();
    }

    boolean add(T elemento) {
        return elementos.add(elemento);
    }

    Set<T> premiados(int numPremiados) {

        if (numPremiados <= 0)
            return null;

        if (numPremiados > elementos.size())
            numPremiados = elementos.size();

        Set<T> premiados = new LinkedHashSet<>();

        List<T> lista = new ArrayList<>(elementos);
        Collections.shuffle(lista);

        for (int i = 0; i < numPremiados; i++) {
            premiados.add(lista.get(i));
        }

        return premiados;
    }

    public static void main(String[] args) {
        // Crea un sorteo entre 4 personajes para seleccionar los 2 que se enfrentarán
        // en combate singular
        Sorteo<Personaje> sorteo = new Sorteo<>();
        sorteo.add(new Personaje("Aragorn", Raza.HUMANO, 90, 90, 90, 10, 16252, 125));
        sorteo.add(new Personaje("Mara", Raza.ELFO, 100, 100, 100));
        sorteo.add(new Personaje("Dodol Bazbal", Raza.ENANO));
        sorteo.add(new Personaje("Lady Jet"));

        Set<Personaje> elegidos = sorteo.premiados(2);

        System.out.println(elegidos);
    }

}
