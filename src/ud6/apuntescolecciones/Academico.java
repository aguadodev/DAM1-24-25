package ud6.apuntescolecciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Academico implements Comparable<Academico>{
    String nombre;
    int anhoIngreso;

    public Academico(String nombre, int anhoIngreso) {
        this.nombre = nombre;
        this.anhoIngreso = anhoIngreso;
    }

    @Override
    public String toString() {
        return nombre + " (" + anhoIngreso + ")";
    }

    @Override
    public int compareTo(Academico o) {
        return nombre.compareTo(o.nombre);
    }
    
    



    public static void main(String[] args) {
        Map<Character, Academico> academia = new LinkedHashMap<>();

        String contenidoFichero = readFileToString("src/ud6/apuntescolecciones/academicos.txt");
        // System.out.println(contenidoFichero);
        String[] lineas = contenidoFichero.split("\\n");
        // System.out.println(Arrays.toString(lineas));
        for (int i = 0; i < lineas.length; i++) {
            Character letra = lineas[i].charAt(6);
            String nombre = lineas[i].substring(7, lineas[i].length() - 6);
            int anho = Integer.parseInt(lineas[i].substring(lineas[i].length() - 5, lineas[i].length() - 1));
            // System.out.println(letra + " - " + nombre + " ( " + anho + ")");
            nuevoAcademico(academia, new Academico(nombre, anho), letra);
        }

        // académicos: sin letra, por orden de nombre
        System.out.println("\nAcadémicos: sin letra, por orden de nombre");
        System.out.println("==========================================\n");
        List<Academico> lista = new ArrayList<>(academia.values());
        Collections.sort(lista);
        for (Academico a : lista){
            System.out.println(a);
        }


        // académicos: sin letra, por orden de nombre
        System.out.println("\nAcadémicos: sin letra, por orden de año de ingreso y por nombre");
        System.out.println("===============================================================\n");
        lista.sort(new Comparator<>() {
            @Override
            public int compare(Academico o1, Academico o2) {
                int res = o1.anhoIngreso - o2.anhoIngreso;
                if (res == 0)
                    res = o1.nombre.compareTo(o2.nombre);
                return res;
            }
        });

        for (Academico a : lista){
            System.out.println(a);
        }


        // académicos: sin letra, por orden de nombre
        System.out.println("\nAcadémicos: con letra, por orden de letra (clave), indicando nombre y fecha");
        System.out.println("===========================================================================\n");
        Set<Character> letras = academia.keySet();
        for (Character letra : letras) {
            Academico a = academia.get(letra);
            System.out.println(letra + " - " + a);
        }

    }

    static boolean nuevoAcademico(Map<Character, Academico> academia, Academico nuevo, Character letra) {
        if (Character.isLetter(letra)) {
            academia.put(letra, nuevo);
            return true;
        }
        return false;
    }

    /**
     * Lee y carga el contenido de un fichero de texto a un String (fuente OpenAI)
     * 
     * @param filePath
     * @return
     */
    public static String readFileToString(String filePath) {
        StringBuilder fileContent = new StringBuilder();
        try {
            // Creamos un objeto FileReader que nos permitirá leer el fichero
            FileReader reader = new FileReader(filePath);

            // Creamos un buffer para leer el fichero de forma más eficiente
            BufferedReader buffer = new BufferedReader(reader);

            // Leemos el fichero línea a línea
            String line;
            while ((line = buffer.readLine()) != null) {
                // Vamos añadiendo cada línea al StringBuilder
                fileContent.append(line);
                // Añadimos un salto de línea al final de cada línea
                fileContent.append("\n");
            }

            // Cerramos el buffer y el fichero
            buffer.close();
            reader.close();
        } catch (IOException e) {
            System.out.println("No existe el fichero.");
            // e.printStackTrace();
        }

        // Devolvemos el contenido del fichero como un String
        return fileContent.toString();
    }

}
