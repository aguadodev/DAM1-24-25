package ud6.apuntesstream;

import java.util.Arrays;
import java.util.function.Function;

public class AppReferenciasMetodos {

    public static void main(String[] args) {
        Function<Double, Double> raiz = Math::sqrt;
        Double x = raiz.apply(9.); // x = 3.0

        Function<Integer, Integer> f1 = Calculos::cubo;
        Calculos calc = new Calculos();
        Function<Integer, Integer> f2 = calc::cuadrado;

        Function<Entero, Entero> siguienteEntero = Entero::siguiente;
        System.out.println(siguienteEntero.apply(new Entero(3))); // 4

        Integer[] t = { 1, 2, 3, 4, 5 };
        aplicar(t, f2); // o aplicar(t, calc::cuadrado):
        System.out.println(Arrays.toString(t)); // [1 4 9 16 25]

        Function<String, Saludo> construyeSaludo = Saludo::new;
        Saludo s = construyeSaludo.apply("Claudia");
        System.out.println(s); //¡Hola Claudia!
    }

    static <T> void aplicar(T[] tabla, Function<T, T> m) {
        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = m.apply(tabla[i]);
        }
    }

}

class Calculos {
    Integer cuadrado(Integer a) {
        return a * a;
    }

    static Integer cubo(Integer x) {
        return x * x * x;
    }
}

class Entero {
    Integer valor;
    public Entero(Integer valor) {
        this.valor = valor;
    }
    Entero siguiente() {
        return new Entero(valor + 1);
    }
    @Override
    public String toString() {
        return "Entero{" + "valor=" + valor + '}';
    }
}

class Saludo {
    String nombre;
    Saludo(String nombre) {
        this.nombre = nombre;
    }
    public String toString() {
        return "Hola, " + nombre;
    }
}