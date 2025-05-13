package ud7.apuntesjavafx.empresas;

public class Empresa {
    private int id;
    private String nombre;
    private String web;


    public Empresa(int id, String nombre, String web) {
        this.id = id;
        this.nombre = nombre;
        this.web = web;
    }


    @Override
    public String toString() {
//        return id + " - " + nombre + " (" + web + ")";
        return id + " - " + nombre;
    }
    
}
