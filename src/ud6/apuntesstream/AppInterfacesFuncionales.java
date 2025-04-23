package ud6.apuntesstream;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import ud6.apuntescolecciones.Cliente;

public class AppInterfacesFuncionales {
    public static void main(String[] args) {
        /*
         * Interfaz PREDICATE
         */
        // Ejemplo de Interfaz funcional Predicate implementada con una clase anónima
        Predicate<Integer> esPar = new Predicate<>() {
            @Override
            public boolean test(Integer t) {
                return t % 2 == 0;
            }
        };

        esPar.test(4); // true
        esPar.test(5); // false

        // Ejemplo de Interfaz funcional Predicate implementada con una expresión lambda
        Predicate<Integer> esPositivo = x -> x > 0;
        esPositivo.test(5); // true
        esPositivo.test(-5); // false

        // Métodos default de Predicate
        esPositivo.negate().test(5); // false
        esPositivo.and(esPar).test(6); // true
        esPositivo.or(esPar).test(-6); // true

        Predicate<Integer> esPositivoYPar = esPar.and(esPositivo);
        esPositivoYPar.test(4); // true
        esPositivoYPar.test(5); // false

        /*
         * Interfaz FUNCTION
         */
        // Ejemplo de Interfaz funcional Function implementada con una clase anónima
        Function<Integer, String> convertirAString = new Function<>() {
            @Override
            public String apply(Integer t) {
                return String.valueOf(t);
            }
        };

        String resultado1 = convertirAString.apply(5); // "5"
        String resultado2 = convertirAString.apply(10); // "10"

        // Ejemplo de Interfaz funcional Function implementada con una expresión lambda
        Function<Double, Double> cuadrado = x -> x * x;
        Double resultado3 = cuadrado.apply(5.0); // 25.0

        Function<Cliente, Integer> obtenerEdad = c -> c.getEdad();

        obtenerEdad.apply(new Cliente("1", "Pepe", "01/01/2008"));


        /*
         * Interfaz CONSUMER
         */
        Consumer<Cliente> saludoClie = c -> System.out.println("Hola, " + c.getNombre());
        saludoClie.accept(new Cliente("12345678Z", "Pepe", "20/12/2000")); // Hola Pepe

        System.out.println("\nSaludos:\n");
        List<Cliente> clientes = Cliente.clientesDeEjemplo();
        clientes.forEach(saludoClie); // Hola Pepe, Hola María, Hola Lola
    }
}
