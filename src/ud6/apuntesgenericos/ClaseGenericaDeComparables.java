package ud6.apuntesgenericos;

class ClaseGenericaDeComparables<T extends Comparable> {
    T a, b, c;
    //operaciones con a y b

        public ClaseGenericaDeComparables(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String[] args) {
        ClaseGenericaDeComparables<Integer> lista = new ClaseGenericaDeComparables<Integer>(3,2,6);
        lista.a.compareTo(lista.b);
        // ClaseGenericaDeComparables<Praia> lista2; // Error si Praia no implementa Comparable

    }

}

