package ud5.xxxexamen;

import java.util.Arrays;

public class Host implements Comparable<Host>{

    // Tu código aquí
    protected String nombre;
    protected String ip;
    protected String mac;
    
    static public String netmask = "255.255.0.0";
    static public String gateway = "192.168.0.11";
    static public String nameserver = "192.168.0.9";

    public Host(String nombre, String ip, String mac) {
        if (nombre == null)
            throw new IllegalArgumentException("Error: El nombre no puede ser nulo");
        else
            this.nombre = nombre;

        if (ip != null && !validarIP(ip))
            throw new IllegalArgumentException("Error: Formato de IP no válido");
        else
            this.ip = ip;

        if (mac == null || mac != null && !validarMAC(mac))
            throw new IllegalArgumentException("Error: dirección MAC nula o con formato no válido");
        else
            this.mac = mac;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Host other = (Host) obj;
        if (mac == null || other.mac == null)
                return false;
        else 
            return this.mac.replaceAll("[:-]", "").equalsIgnoreCase(other.mac.replaceAll("[:-]", ""));
    }


    @Override
    public int compareTo(Host o) {
        return nombre.compareTo(o.nombre);
    }


    @Override
    public String toString() {
        return nombre + " (" + ip + " / " + mac + ")";
    }




    boolean validarIP(String ip) {
        return ip.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
    }

    boolean validarMAC(String mac) {
        return mac.matches("([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})");
    }

    public static void main(String[] args) {
        System.out.println("\nClase Host");
        System.out.println("==========\n");
        Host h100 = new Host("host100", "192.168.117.100", "00:11:22:33:44:55");
        Host h101 = new Host("equipo101", "192.168.117.101", "00:11:22:33:44:55");
        Host h102 = new Host("nodo100", "192.168.117.100", "00-11-22-33-44-AA");
        Host h103 = new Host("host103", "192.168.117.103", "00-11-22-33-44-55");

        Host[] hosts = { h100, h101, h102, h103};
        Arrays.sort(hosts);
        for (Host h : hosts) {
            System.out.println(h);
        }

        System.out.println(h100.nombre + " = " + h101.nombre + "? " + h100.equals(h101)); // true
        System.out.println(h100.nombre + " = " + h102.nombre + "? " + h100.equals(h102)); // false
        System.out.println(h100.nombre + " = " + h103.nombre + "? " + h100.equals(h103)); // true
    }

}