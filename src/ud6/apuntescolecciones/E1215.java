package ud6.apuntescolecciones;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class E1215 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        Map<Producto, Integer> stock = new HashMap<>();
        Integer i;


        do {
            opcion = opcionMenu();

            switch (opcion) {
                case 1:
                    System.out.println("\nNUEVO PRODUCTO:");
                    System.out.println("===============\n");
                    System.out.print("Código:");
                    String codigo = sc.nextLine();
                    System.out.print("Nombre:");
                    String nombre = sc.nextLine();
                    System.out.print("Unidades:");
                    Integer unidades = sc.nextInt();
                    Producto p = new Producto(codigo, nombre);
                    stock.put(p, unidades);
                    break;
                case 2:
                    System.out.println("\nELIMINAR PRODUCTO:");
                    System.out.println("==================\n");
                    System.out.print("Código:");
                    codigo = sc.nextLine();
                    p = new Producto(codigo);
                    stock.remove(p);
                    break;
                case 3:
                    System.out.println("\nACTUALIZAR EXISTENCIAS:");
                    System.out.println("=======================\n");
                    System.out.print("Código:");
                    codigo = sc.nextLine();
                    System.out.print("Nuevo número de Unidades:");
                    unidades = sc.nextInt();
                    p = new Producto(codigo);
                    stock.put(p, unidades);
                    break;
                case 4:
                    System.out.println("toString() del mapa:");
                    System.out.println(stock);

                    System.out.println("\nIterando el conjunto de entradas\n");
                    Set<Map.Entry<Producto, Integer>> entradas = stock.entrySet();
                    Iterator<Map.Entry<Producto, Integer>> it = entradas.iterator();
                    while (it.hasNext()) {
                        Map.Entry<Producto, Integer> entrada = it.next();
                        System.out.println("* " + entrada.getKey() + " (" + entrada.getValue() + " uds)");
                    }
                    break;

                default:
                    break;
            }
        } while (opcion != 0);

    }

    private static int opcionMenu() {
        int opcion;
        System.out.println("\nSTOCK REPUESTOS AUTOMÓVIL");
        System.out.println("==========================\n");
        System.out.println("1. dar de alta");
        System.out.println("2. dar de baja");
        System.out.println("3. actualizar número de unidades");
        System.out.println("4. mostrar existencias");
        System.out.println("0. SALIR");
        System.out.print("Opción: ");
        opcion = sc.nextInt();
        sc.nextLine(); // Vaciar buffer de entrada
        return opcion;
    }

}
