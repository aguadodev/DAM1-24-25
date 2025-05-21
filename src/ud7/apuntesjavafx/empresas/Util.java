package ud7.apuntesjavafx.empresas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;

public class Util {
    /**
     * Exporta un objeto a un fichero JSON
     * 
     * @param <T>     tipo del objeto
     * @param fichero ruta del fichero
     * @param o       objeto a exportar
     */
    static public <T> void exportarObjetoJson(String fichero, T o) {
        Gson gson = new Gson();
        String json = gson.toJson(o);
        writeStringToFile(json, fichero);
    }

    /**
     * Importa un objeto desde un fichero JSON
     * 
     * @param <T>     tipo del objeto
     * @param fichero ruta del fichero
     * @param c       clase del objeto. Ejemplo de uso: Persona.class
     * @return objeto importado
     */
    static public <T> T importarObjetoJson(String fichero, Class<T> c) {
        Gson gson = new Gson();
        String json = readFileToString(fichero);
        return gson.fromJson(json, c);
    }

    /**
     * Importa un array de objetos desde un fichero JSON
     * 
     * @param <T>     tipo del objeto
     * @param fichero ruta del fichero
     * @param c       clase del objeto. Ejemplo de uso: Persona[].class
     * @return array de objetos importados
     */
    public static <T> T[] importarArrayJson(String fichero, Class<T[]> c) {
        Gson gson = new Gson();
        String json = readFileToString(fichero);
        return gson.fromJson(json, c);
    }

    /**
     * Importa un array de objetos desde un fichero JSON
     * 
     * @param <T>     tipo del objeto
     * @param fichero ruta del fichero JSON
     * @param t       array
     */
    public static <T> void exportararArrayJson(String fichero, T[] t) {
        Gson gson = new Gson();
        String json = gson.toJson(t);
        writeStringToFile(json, fichero);
    }

    /**
     * Crea un fichero de texto con el contenido de un String
     * 
     * @param str     String a escribir
     * @param fichero fichero a crear
     */
    public static void writeStringToFile(String str, String fichero) {
        try (FileWriter writer = new FileWriter(fichero)) {
            // Escribimos el String en el fichero
            writer.write(str);
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero " + fichero);
        }
    }

    /**
     * Lee y carga el contenido de un fichero de texto a un String
     * 
     * @param fichero fichero a leer
     * @return contenido del fichero
     */
    public static String readFileToString(String fichero) {
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader buffer = new BufferedReader(new FileReader(fichero))) {
            // Leemos el fichero línea a línea
            String line;
            while ((line = buffer.readLine()) != null) {
                // Vamos añadiendo cada línea al StringBuilder
                fileContent.append(line);
                // Añadimos un salto de línea al final de cada línea
                fileContent.append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero " + fichero);
        }
        return fileContent.toString();
    }

    /**
     * Lee el contenido de una url y lo devuelve como un String
     * 
     * @param url url a leer
     * @return contenido de la url
     */
    public static String stream(URL url) {
        try (InputStream input = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
            return json.toString();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Lee el contenido de una URL.
     * 
     * @param url URL a leer.
     * @return Contenido de la URL.
     */
    public static String leerUrl(String url) {
        String contenido = "";

        // Configuración del proxy del sistema
        System.setProperty("java.net.useSystemProxies", "true");

        try {
            java.net.URL urlObjeto = new java.net.URL(url);
            java.net.URLConnection conexion = urlObjeto.openConnection();
            conexion.setRequestProperty("Accept-Language", "es");
            java.io.BufferedReader lector = new java.io.BufferedReader(
                    new java.io.InputStreamReader(conexion.getInputStream()));

            String linea;
            while ((linea = lector.readLine()) != null) {
                contenido += linea + "\n";
            }
            lector.close();
        } catch (java.net.MalformedURLException e) {
            System.out.println("URL mal formada: " + e.getMessage());
        } catch (java.io.IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
        return contenido;
    }

    
    public static void main(String[] args) {
        // Ejemplo de uso
        String url = "https://router.project-osrm.org/route/v1/driving/-8.634701,42.428181;-8.6444,42.3895?overview=false";
        String json = leerUrl(url); 
        System.out.println(json);
    }

}
