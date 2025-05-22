package ud6.xxxexamenrec.xxxexamenrec.musicollab;

import java.util.Collection;
import java.util.List;

public class Cancion {


    public Cancion(String string, String string2, String string3, List<String> of) {
        //TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        // Canciones de ejemplo
        List<Cancion> canciones = Arrays.asList(
                new Cancion("Bohemian Rhapsody", "Queen", "Rock",
                        List.of("voz", "piano", "guitarra", "batería")),
                new Cancion("Billie Jean", "Michael Jackson", "Pop",
                        List.of("voz", "bajo", "batería")),
                new Cancion("Imagine", "John Lennon", "Balada",
                        List.of("voz", "piano")),
                new Cancion("Smells Like Teen Spirit", "Nirvana", "Grunge",
                        List.of("voz", "guitarra", "bajo", "batería")),
                new Cancion("Yesterday", "The Beatles", "Pop",
                        List.of("voz", "guitarra")),
                new Cancion("Sweet Child O'Mine", "Guns N' Roses", "Rock",
                        List.of("voz", "guitarra", "bajo", "batería")),
                new Cancion("Rolling in the Deep", "Adele", "Pop",
                        List.of("voz", "piano", "batería")),
                new Cancion("Hotel California", "Eagles", "Rock",
                        List.of("voz", "guitarra", "bajo", "batería")));
        
        // Ordenar canciones por nombre                        
        Collections.sort(canciones);
        System.out.println("\nCanciones ordenadas por nombre:");
        System.out.println("===============================\n");
        canciones.forEach(System.out::println);

        // Ordenar canciones alfabéticamente por estilo musical, luego por autor y luego por nombre
        System.out.println("\nCanciones ordenadas por estilo musical, luego por autor y luego por nombre:");
        System.out.println("===========================================================================\n");

        // TODO Tu código aquí
        // ...
        // ...

        canciones.forEach(System.out::println);       
        
        // Obtener lista de instrumentos distintos
        System.out.println("\nLista de instrumentos distintos:");
        System.out.println("================================\n");
        System.out.println(instrumentosDistintos(canciones));

        System.out.println("\n");
    }

    public String getNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
    }

    public Collection<?> getInstrumentos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInstrumentos'");
    }

}
