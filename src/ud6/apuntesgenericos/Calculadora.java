package ud6.apuntesgenericos;

class Calculadora<T extends Number> {
    T a, b;
    // operaciones con a y b

    public static void main(String[] args) {
        Calculadora<Double> c = new Calculadora<>();
        Calculadora<Integer> c2 = new Calculadora<>();

        // Calculadora<Object> c3 = new Calculadora<>();
        c.a = 2.0;
        c2.a = 2;

    }

}
