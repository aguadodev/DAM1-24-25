package ud2.aceptaelreto;

import java.util.Locale;
import java.util.Scanner;

public class Ventas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        double max = 0, min = 0, media = 0;
        int diaMax = 0, diaMin = 0;
        double recaudacion = 0;

        for (int i = 0; i < 6; i++) {
            recaudacion = sc.nextDouble();
            // máximo y mínimo
            if (i == 0) {
                min = recaudacion;
                max = recaudacion;
                diaMin = 0;
                diaMax = 0;
            } else {
                if (recaudacion < min) {
                    min = recaudacion;
                    diaMin = i;
                } else if (recaudacion > max) {
                    max = recaudacion;
                    diaMax = i;
                }
            }
            // media
            media += recaudacion;
        }

        sc.close();
        
        media /= 6;

        System.out.println(diaSemana(diaMax) + " " + diaSemana(diaMin) + " " + (recaudacion > media ? "SI" : "NO"));
    }

    private static String diaSemana(int dia) {
        return switch (dia) {
            case 0:
                yield "MARTES";
            case 1:
                yield "MIÉRCOLES";
            case 2:
                yield "JUEVES";
            case 3:
                yield "VIERNES";
            case 4:
                yield "SÁBADO";
            case 5:
                yield "DOMINGO";
            default:
                yield "ERROR";
        };
    }
}
