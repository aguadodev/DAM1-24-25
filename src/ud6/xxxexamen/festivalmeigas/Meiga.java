package ud6.xxxexamen.festivalmeigas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Meiga implements Comparable<Meiga> {
    // Atributos
    private String nome;
    private String alcume;
    private List<Feitizo> feitizos;
    private Map<String, Integer> inventario;

    // Constructores
    public Meiga(String nome, String alcume, Collection<Feitizo> feitizos, Map<String, Integer> inventario) {
        this.nome = nome;
        this.alcume = alcume;
        this.feitizos = new ArrayList<Feitizo>(feitizos);
        this.inventario = inventario;
    }

    // EXEMPLO DE USO
    public static Meiga[] crearMeigasExemplo(Feitizo[] feitizosDisponibles) {
        String[] nomes = { "Uxía", "Lúa", "Iria", "Noa" };
        String[] alcumes = { "A das Fraguiñas", "Sombra do Vento", "Luz do Bosque", "Meiga da Brétema" };

        Meiga[] meigas = new Meiga[nomes.length];

        // Obtén todos os feitozos de exemplo e todos os seus ingredientes únicos
        Collection<Feitizo> feitizosExemplo = List.of(Feitizo.crearFeitizosExemplo());
        Collection<String> ingredientesExemplo = Feitizo.ingredientesUnicos(feitizosExemplo);

        for (int i = 0; i < nomes.length; i++) {
            String nome = nomes[i];
            String alcume = alcumes[i];
            // Xera unha colección cunha selección aleatoria de feitizos de exemplo para
            // asignar á meiga
            Collection<Feitizo> feitizos = getFeitizosRnd(feitizosExemplo);
            // Xera un mapa cunha selección aleatoria de ingredientes e cantidades de cada
            // un de exemplo para asignar á meiga
            Map<String, Integer> inventario = getIngredientesRnd(ingredientesExemplo, 3);

            // Crea a meiga e a engade ao array
            meigas[i] = new Meiga(nome, alcume, feitizos, inventario);
        }

        return meigas;

    }

    static Collection<Feitizo> getFeitizosRnd(Collection<Feitizo> feitizos) {
        // Gentea un sublista aleatoria de Feitizo
        List<Feitizo> feitizosRnd = new ArrayList<>(feitizos);
        Collections.shuffle(feitizosRnd);
        // Selecciona un número aleatorio de feitizos entre 1 e o tamaño da lista
        int numFeitizos = new Random().nextInt(feitizosRnd.size()) + 1;
        // Crea unha sublista con ese número de feitizos aleatorios
        List<Feitizo> subFeitizos = feitizosRnd.subList(0, numFeitizos);
        // Retorna a sublista como un Collection<Feitizo>
        return new ArrayList<>(subFeitizos);
    }

    static Map<String, Integer> getIngredientesRnd(Collection<String> ingredientes, int i) {
        // Gentea un mapa aleatorio de ingredientes e cantidades
        Map<String, Integer> inventario = new java.util.HashMap<>();
        List<String> ingredientesRnd = new ArrayList<>(ingredientes);
        Collections.shuffle(ingredientesRnd);
        // Selecciona un número aleatorio de ingredientes entre 1 e o tamaño da lista
        int numIngredientes = new Random().nextInt(ingredientesRnd.size()) + 1;
        // Crea un mapa con ese número de ingredientes aleatorios e cantidades entre 1 e
        // 5
        for (int j = 0; j < numIngredientes; j++) {
            String ingrediente = ingredientesRnd.get(j);
            int cantidade = new Random().nextInt(5) + 1;
            inventario.put(ingrediente, cantidade);
        }
        return inventario;
    }

    public static void main(String[] args) {
        System.out.println("\nMEIGAS DE EXEMPLO:");
        System.out.println("====================\n");
        // Crear un array de meigas de exemplo
        Meiga[] meigasExemplo = Meiga.crearMeigasExemplo(Feitizo.crearFeitizosExemplo());
        Arrays.sort(meigasExemplo);
        // Mostrar as meigas de exemplo
        for (Meiga meiga : meigasExemplo) {
            System.out.println(meiga);
            System.out.println();
        }

        // Lanzar feitizos de exemplo
        System.out.println(meigasExemplo[0].alcume + " lanzando feitizos de exemplo:");
        meigasExemplo[0].lanzarFeitizos();
    }

    public int lanzarFeitizos() {
        Comparator<Feitizo> compFeitizoDificultade = (f1, f2) -> f2.getDificultade() - f1.getDificultade();
        feitizos.sort(compFeitizoDificultade);

        int puntos = 0;

        for (Feitizo feitizo : feitizos) {
            // Comprueba si puede lanzar el hechizo
            if (inventario.keySet().containsAll(feitizo.ingredientes)) {
                // Si puede =>
                // imprime mensaje
                System.out.println("-> Lanzando o feitizo: " + feitizo.getNome());
                // incrementa puntuación
                puntos += feitizo.getDificultade();
                // resta ingredientes
                for (String ingrediente : feitizo.ingredientes) {
                    if (inventario.get(ingrediente) > 1)
                        inventario.put(ingrediente, inventario.get(ingrediente) - 1);
                    else
                        inventario.remove(ingrediente);
                }
            } else {
                // Si no puede
                // Imprime mensaje
                System.out.println("-x Non ten ingredientes suficientes para lanzar o feitizo: " + feitizo.getNome());

            }
        }
        return puntos;

    }

    @Override
    public String toString() {
        String str;

        str = nome + " (" + alcume + ")\n";

        Comparator<Feitizo> compFeitizoDificultade = (f1, f2) -> f2.getDificultade() - f1.getDificultade();
        Comparator<Feitizo> compFeitizoNome = (f1, f2) -> f1.getNome().compareTo(f2.getNome());
        feitizos.sort(compFeitizoDificultade.thenComparing(compFeitizoNome));

        str += "Feitizos: " + feitizos + "\n";

        Set<String> inv = new TreeSet<>(inventario.keySet());

        str += "Inventario: " + inv + "\n";

        return str;
    }

    @Override
    public int compareTo(Meiga o) {
        return alcume.compareTo(o.alcume);
    }

    public int getNumFeitizos() {
        if (feitizos == null)
            return 0;
        return feitizos.size();
    }

    public String getNome() {
        return nome;
    }

    

}
