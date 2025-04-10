package ud5.xxxexamen;

import java.util.Arrays;
import java.util.Comparator;

public class Cliente extends Host {

    enum SO {WINDOWS, LINUX, MAC, ANDROID, IOS}
    // Tu código aquí
    private SO so;
    private String resolucion;

    public Cliente(String nombre, String ip, String mac, SO so, String resolucion) {
        super(nombre, ip, mac);
        this.so = so;
        this.resolucion = resolucion;
    }

    public int getPixeles(){
        String[] px = resolucion.split("x");
        int ancho = Integer.valueOf(px[0]);
        int alto = Integer.parseInt(px[1]);
        return ancho * alto;
    }


    @Override
    public String toString() {
        String strSO = switch (so) {
            case SO.WINDOWS -> "Windows";
            case SO.LINUX -> "Linux";
            case SO.MAC -> "Mac";
            case SO.ANDROID -> "Android";
            case SO.IOS -> "iOS";
            default -> "";
        };

        return nombre + " (" + strSO + " " + resolucion + ")";
    }

    public static void main(String[] args) {
        System.out.println("\nClase Cliente");
        System.out.println("=============\n");        
        Cliente cWin1 = new Cliente("Cliente1", "192.168.1.2", "02:1A:2B:3C:4D:5E", SO.WINDOWS, "1920x1080");
        Cliente cLin2 = new Cliente("Cliente2", "192.168.1.3", "01:1A:2B:3C:4D:5F", SO.LINUX, "1366x768");
        Cliente cMac3 = new Cliente("Cliente3", "192.168.1.4", "04:1A:2B:3C:4D:60", SO.MAC, "2560x1440");
        Cliente cAnd4 = new Cliente("Cliente4", "192.168.1.5", "03:1A:2B:3C:4D:61", SO.ANDROID, "1080x2340");
        Cliente cIos5 = new Cliente("Cliente5", "192.168.1.6", "05:1A:2B:3C:4D:62", SO.IOS, "1170x2532");
        Cliente cIos6 = new Cliente("Cliente6", "192.168.1.7", "06:1A:2B:3C:4D:62", SO.IOS, "800x600");

        Cliente[] clientes = { cWin1, cLin2, cMac3, cAnd4, cIos5, cIos6 };
        Arrays.sort(clientes);
        for (Cliente c : clientes) {
            System.out.println(c);
        }
 



        // Tu código aquí
        System.out.println("\nClientes ordenados por SO");
        System.out.println("=========================\n");
        Comparator<Cliente> compNombreSO = new Comparator<>() {

            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o1.so.toString().compareTo(o2.so.toString());
            }

        };
        Arrays.sort(clientes, compNombreSO);
        for (Cliente c : clientes) {
            System.out.println(c);
        }


        System.out.println("\nClientes ordenados por Resolución");
        System.out.println("=================================\n");
        Comparator<Cliente> compResolucion = new Comparator<>() {

            @Override
            public int compare(Cliente o1, Cliente o2) {                
                return o1.getPixeles() - o2.getPixeles();
            }

        };
        Arrays.sort(clientes, compResolucion.reversed());
        for (Cliente c : clientes) {
            System.out.println(c);
        }




    }
    
}
