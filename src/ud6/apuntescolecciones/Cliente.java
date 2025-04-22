package ud6.apuntescolecciones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Clase Cliente para ejemplos posteriores.
public class Cliente implements Comparable<Cliente> {
    String dni;
    String nombre;
    LocalDate fechaNacimiento;

    public Cliente(String dni, String nombre, String fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        DateTimeFormatter formatoFechas = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, formatoFechas);
    }

    

    public Cliente(String nombre) {
        this.nombre = nombre;
    }


    private int edad() {
        return (int) fechaNacimiento.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + " Nombre: " + nombre + " Edad: " + edad() + " \n";
    }

    @Override
    public int compareTo(Cliente o) {
        return dni.compareTo(o.dni);
    }

    /*
     * GETTERSY SETTERS
     */

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    
    public static List<Cliente> clientesDeEjemplo() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente("34534534Z", "Pepe", "20/12/2000"));
        clientes.add(new Cliente("34534534Z", "Pepe", "20/12/2000"));
        clientes.add(new Cliente("34555534Z", "María", "20/12/2000"));
        clientes.add(new Cliente("22222234Z", "Lola", "20/12/2000"));
        return clientes;
    }    

    public static void main(String[] args) {
        Collection<Cliente> clientes = new ArrayList<>();
        System.out.println(clientes.size());

        clientes = clientesDeEjemplo();

        System.out.println(clientes.size());
        System.out.println(clientes.contains(new Cliente("34534534Z", "Pepe", "20/12/2000")));

        System.out.println("IMPRESIÓN CON Collection.toString()");
        System.out.println(clientes);

        System.out.println("IMPRESIÓN CON FOR-EACH");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.nombre);

            /*
             * ERROR: Con un bucle for each no podemos borrar elementos de la colección
             * if (cliente.nombre.equals("Pepe"))
             * clientes.remove(cliente);
             */
        }

        System.out.println("IMPRESIÓN CON ITERADOR");
        Iterator<Cliente> it = clientes.iterator();
        while (it.hasNext()) {
            Cliente c = it.next();
            System.out.println(c.nombre);
            if (c.nombre.equals("Pepe")) {
                it.remove();
            }
        }

        System.out.println("Colección sin Pepes");
        System.out.println(clientes);

        Object[] arrayObject = clientes.toArray();
        ((Cliente) arrayObject[0]).nombre = "Marta";

        Cliente[] arrayClientes = clientes.toArray(new Cliente[0]);
        arrayClientes[0].nombre = "Marta2";

        System.out.println("Array obtenido de la lista: " + Arrays.toString(arrayClientes));

        Collection<Cliente> listaClientes = Arrays.asList(arrayClientes);
        System.out.println("De nuevo una lista: " + listaClientes);

    }



}
