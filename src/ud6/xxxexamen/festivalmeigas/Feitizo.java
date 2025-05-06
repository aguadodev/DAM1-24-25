package ud6.xxxexamen.festivalmeigas;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Feitizo implements Comparable<Feitizo> {
    // Atributos
    private String nome;
    List<String> ingredientes;
    private Integer dificultade;

    // Constructores
    public Feitizo(String nome, String[] ingredientes, Integer dificultade) {
        this.nome = nome;
        this.ingredientes = List.of(ingredientes);
        this.dificultade = dificultade;
    }

    // Otros métodos
    public static Collection<String> ingredientesUnicos(Collection<Feitizo> feitizos) {
        Set<String> ingredientesUnicos = new TreeSet<>();
        for (Feitizo feitizo : feitizos) {
            ingredientesUnicos.addAll(feitizo.ingredientes);
        }
        return ingredientesUnicos;
    }

    // GETTERS E SETTERS

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Integer getDificultade() {
        return dificultade;
    }

    public void setDificultade(Integer dificultade) {
        this.dificultade = dificultade;
    }

    // EXEMPLO DE USO
    public static Feitizo[] crearFeitizosExemplo() {
        String[] ingredientes1 = { "auga de río encantada", "pétalos de rosa silvestre", "fume de lareira" };
        String[] ingredientes2 = { "auga do mar", "salicornia", "berberechos místicos" };
        String[] ingredientes3 = { "raíz de toxo", "auga bendita", "po de estrela fugaz" };
        String[] ingredientes4 = { "auga de río encantada", "raíz de toxo", "pel de serpe" };
        String[] ingredientes5 = { "auga do mar", "po de estrela fugaz", "cinza de bidueiro" };
        String[] ingredientes6 = { "auga bendita", "pétalos de rosa silvestre", "brétema das fragas" };

        Feitizo f1 = new Feitizo("Encantamento da Chuvia Mansa", ingredientes1, 3);
        Feitizo f2 = new Feitizo("Invocación Mariña", ingredientes2, 4);
        Feitizo f3 = new Feitizo("Luz do Luar", ingredientes3, 2);
        Feitizo f4 = new Feitizo("Garda da Fraga", ingredientes4, 3);
        Feitizo f5 = new Feitizo("Respiro Oceánico", ingredientes5, 4);
        Feitizo f6 = new Feitizo("Bendición Floral", ingredientes6, 2);

        return new Feitizo[] { f1, f2, f3, f4, f5, f6 };
    }

    public static void main(String[] args) {
        System.out.println("\nFEITIZOS DE EXEMPLO:");
        System.out.println("====================\n");
        // Crear un array de feitizos de exemplo
        Feitizo[] feitizos = crearFeitizosExemplo();

        Arrays.sort(feitizos);

        // Imprimir os feitizos
        for (Feitizo feitizo : feitizos) {
            System.out.println(feitizo);
        }
    }

    @Override
    public int compareTo(Feitizo o) {
        return nome.compareTo(o.nome);
    }

    @Override
    public String toString() {
        return nome + "(" + dificultade + ")";
    }

    
}
