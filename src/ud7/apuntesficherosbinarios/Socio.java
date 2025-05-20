package ud7.apuntesficherosbinarios;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Socio implements Comparable<Socio>, Serializable {
    int id;
    String nombre;
    String direccion;
    LocalDate fechaAlta;

    public Socio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Socio(int id, String nombre, LocalDate fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
    }

    public Socio(int id, String nombre, String direccion, String fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaAlta = LocalDate.parse(fechaAlta, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Override
    public String toString() {
        return id + "-" + nombre + "-" + fechaAlta;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Socio socio = (Socio) o;
        return id == socio.id && Objects.equals(nombre, socio.nombre) && Objects.equals(fechaAlta, socio.fechaAlta);
    }

    @Override
    public int compareTo(Socio o) {
        return this.id - o.id;
    }

}
