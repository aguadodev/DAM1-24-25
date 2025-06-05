package contornos.ud4.maloscheiros;

/*
 * El programa calcula el precio final del pedido e imprime los datos finales.
 *  
 *  Contiene los siguientes malos olores:
 *      Demasiados parámetros
 *      Liña de código excesivamente longa
 *      Cadeas de mensaxes
 *          
 */


public class CadeasDeMensaxes{

    public static class Pedido {
        public String nombreEmpresa;
        public String paisDestino;
        public String comunidadDestino;
        public String provinciaDestino;
        public String dirDestino;
        public int cantidad;
        public double precioBase;
        public double gastosEnvio;
        public double comision;
        public double impuestos;

        // Demasiados parámetros 
        public Pedido(String nombreEmpresa, String paisDestino, String comunidadDestino, String provinciaDestino, String dirDestino, int cantidad, double precioBase, double gastosEnvio, double comision, double impuestos) {
            // Liña de código excesivamente longa
            this.nombreEmpresa = nombreEmpresa; this.paisDestino = paisDestino; this.comunidadDestino = comunidadDestino; this.provinciaDestino = provinciaDestino; this.dirDestino = dirDestino; this.cantidad = cantidad; this.precioBase = precioBase; this.gastosEnvio = gastosEnvio; this.comision = comision; this.impuestos = impuestos;
        }

        // Método
        public void imprimirFactura() {
            System.out.println( imprimirFactura1() );
        }


        // Cadeas de mensaxes
        public String imprimirFactura1(){
            return "Empresa: " + nombreEmpresa + imprimirFactura2();
        }

        public String imprimirFactura2(){
            return "\nDirección: " + dirDestino + imprimirFactura3();
        }

        public String imprimirFactura3(){
            return "\nCantidad: " + cantidad + imprimirFactura4();
        }

        public String imprimirFactura4(){
            return "Precio Base: " + ((precioBase + gastosEnvio)*comision)*impuestos;
        }
    }

    public static void main(String[] args) {
        Pedido p = new Pedido("EmpresaGrande","España","Galicia","Pontevedra","Eduardo Pondal 5º 13A",5,0.5,13,1.05,1.20);
        p.imprimirFactura();

    }


}