package ud6.apuntesstream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import ud6.apuntescolecciones.Cliente;

public class AppReferenciasMetodos {

    public static void main(String[] args) {
        // Referencia a un método estático de la API: Math::sqrt
        Function<Double, Double> raiz1 = x -> Math.sqrt(x);        
        Function<Double, Double> raiz = Math::sqrt;
        Double x = raiz.apply(9.); // x = 3.0
       


        // Referencia a un método estático de una clase propia: Calculos::cubo
        Function<Integer, Integer> f1 = Calculos::cubo;

        // Referencia a un método de instancia de una clase propia: Calculos::cuadrado
        Calculos calc = new Calculos();
        Function<Integer, Integer> f2 = calc::cuadrado;

        // Referencia a un método de instancia de una clase propia: Entero::siguiente
        Function<Entero, Entero> siguienteEntero = Entero::siguiente;
        System.out.println(siguienteEntero.apply(new Entero(3))); // 4

        // Ejemplo de uso de Referencia a un método como parámetro
        Integer[] t = { 1, 2, 3, 4, 5 };
        aplicar(t, Calculos::cubo); // o aplicar(t, f2):
        System.out.println(Arrays.toString(t)); // [1 4 9 16 25]

        // Referencia a un método constructor de una clase propia: Saludo::new
        Function<String, Saludo> construyeSaludo = Saludo::new;
        Saludo s = construyeSaludo.apply("Claudia");
        System.out.println(s); //¡Hola Claudia!
        
        // Uso de Referencias a métodos con Comparator
        List<Cliente> clientes = Cliente.clientesDeEjemplo();
        clientes.sort(Comparator.comparing(Cliente::getFechaNacimiento));
        System.out.println(clientes);   
        
        // Uso de Referencias a métodos con forEach
        //clientes.forEach();
        
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