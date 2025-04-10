package ud5.xxxexamen;

import java.util.Arrays;
import java.util.Comparator;

public class Servidor extends Host {

    // Tu código aquí
    Servicio[] servicios;

    public Servidor(String nombre, String ip, String mac) {
        super(nombre, ip, mac);
        servicios = new Servicio[0];
    }

    public boolean addServicio(String nombre, int puerto, String protocolo) {
        // Tu código aquí
        Servicio nuevoServicio = new Servicio(nombre, puerto, protocolo);
        for (Servicio servicio : servicios) {
            if (servicio.equals(nuevoServicio)) {
                return false; // El servicio ya existe
            }
        }
        servicios = Arrays.copyOf(servicios, servicios.length + 1);
        servicios[servicios.length - 1] = nuevoServicio;
        return true;
    }

    public int getNumServicios() {
        return servicios.length;
    }

    public static Comparator<Servidor> getCompNumServicios() {
        return new Comparator<Servidor>() {
            @Override
            public int compare(Servidor o1, Servidor o2) {
                return Integer.compare(o1.getNumServicios(), o2.getNumServicios());
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder(nombre + " (" + ip + ")\n");
        for (Servicio servicio : servicios) {
            cadena.append("* ").append(servicio).append("\n");
        }
        return cadena.toString();
    }



    public static void main(String[] args) {
        System.out.println("\nClase Servidor");
        System.out.println("==============\n");
        Servidor s1 = new Servidor("dam1", "192.168.0.117", "CC-11-22-33-44-AA");
        s1.addServicio("MySQL", 3306, "TCP");
        Servidor s2 = new Servidor("seixo", "192.168.0.11", "BB:11:22:33:44:55");
        s2.addServicio("HTTP", 80, "TCP");
        s2.addServicio("Proxy", 3128, "TCP");
        Servidor s3 = new Servidor("lapaman", "192.168.0.9", "AA:11:22:33:44:55");
        s3.addServicio("HTTP", 80, "TCP");
        s3.addServicio("Web", 80, "TCP");
        s3.addServicio("DNS", 53, "UDP");
        s3.addServicio("FTP", 21, "TCP");
        s3.addServicio("SSH", 22, "TCP");

        Servidor[] servidores = { s1, s2, s3 };
        for (Servidor s : servidores) {
            System.out.println(s);
        }

        // Tu código aquí
        System.out.println();
        Arrays.sort(servidores, new Comparator<>(){
            @Override
            public int compare(Servidor o1, Servidor o2) {
                return o2.servicios.length - o1.servicios.length;
            }
            
        });
        System.out.println("\nServidores ordenados descendentemente por número de servicios:");
        System.out.println("==============================================================\n");
        for (Servidor s : servidores) {
            System.out.println(s);
        }

    }

}