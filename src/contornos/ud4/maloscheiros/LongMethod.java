package contornos.ud4.maloscheiros;

class Cliente {
    private String nombre;
    private String direccion;
    private String telefono;
    private double saldo;

    // Constructor
    public Cliente(String nombre, String direccion, String telefono, double saldo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.saldo = saldo;
    }

    // Métodos
    public void pagarFactura(double monto) {
        saldo -= monto;
    }

    public void enviarNotificacion() {
        System.out.println("Enviando notificación a " + nombre);
    }

    public void generarReporte() {
        System.out.println("Generando reporte de cliente...");
    }

    // Método main para probar la clase
    public static void main(String[] args) {
        // Crear un objeto Cliente
        Cliente cliente = new Cliente("Juan Pérez", "Calle Falsa 123", "555-1234", 500.0);

        // Llamar a los métodos del objeto cliente
        cliente.pagarFactura(100);  // Descontar 100 del saldo
        cliente.enviarNotificacion();  // Enviar notificación
        cliente.generarReporte();  // Generar reporte
    }
}