public class CalculadorBonificaciones {
    public double calcularBonificacionNivel1(int antiguedad) {
        if (antiguedad > 5) {
            return 100.0;
        } else {
            return 50.0;
        }
    }


    public double calcularBonificacionNivel2(int antiguedad) {
        if (antiguedad > 5) {
            return 200.0;
        } else {
            return 100.0;
        }
    }


    public double calcularBonificacionNivel3(int antiguedad) {
        if (antiguedad > 5) {
            return 300.0;
        } else {
            return 150.0;
        }
    }
}