package ud7.apuntesjavafx.empresas;

import java.io.Serializable;

public class Empresa implements Serializable {
    private int id;
    private String nombre;
    private String web;

    public Empresa(int id, String nombre, String web) {
        this.id = id;
        this.nombre = nombre;
        this.web = web;
    }

    public Empresa(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        // return id + " - " + nombre + " (" + web + ")";
        return id + " - " + nombre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        Empresa other = (Empresa) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

}
