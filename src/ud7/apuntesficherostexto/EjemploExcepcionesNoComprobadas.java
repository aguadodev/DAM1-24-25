package ud7.apuntesficherostexto;

import java.util.Scanner;

public class EjemploExcepcionesNoComprobadas {
    public static void main(String[] args) {
        try {
            // Bloque de código susceptible de provocar una excepción
            System.out.println("EJEMPLOS DE EXCEPCIONES NO COMPROBADAS:");
            Scanner sc = new Scanner(System.in);
            System.out.println("(1) - Provoca ArithmeticException");
            System.out.println("(2) - Provoca ArrayIndexOutOfBoundsException");
            System.out.println("(3) - Provoca NullPointerException");
            System.out.println("(no entero) - Provoca InputMismatchException");
            System.out.print("Elige una opción: ");

            int opcion = sc.nextInt();
            sc.close();
            switch (opcion) {
                case 1:
                    int a = 5 / 0; // División por cero
                    System.out.println(a);
                    break;
                case 2:
                    int[] arr = new int[0];
                    arr[1] = 0; // Índice fuera del límite
                    break;
                case 3:
                    Integer i = null;
                    i.compareTo(5); // Acceso a un miembro de null
                    break;
            }
        } catch (Exception e) {
            // Se puede capturar cada excepción con su propio bloque catch() o
            // capturarlas todas indicando la clase "madre" Exception.
            System.out.println("\nEXCEPCIÓN!!");
            System.out.println("toString(): " + e);
            System.out.println("Clase: " + e.getClass().getSimpleName());
            System.out.println("Mensaje: " + e.getMessage());
        } finally {
            // Este bloque se ejecutará siempre
            System.out.println("FIN DEL EJEMPLO");
        }
    }

}
