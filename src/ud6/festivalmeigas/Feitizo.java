package ud6.festivalmeigas;

import java.util.Arrays;
import java.util.List;

public class Feitizo {



    public static Feitizo[] crearFeitizosExemplo() {
    String[] ingredientes1 = {"auga de río encantada", "pétalos de rosa silvestre", "fume de lareira"};
    String[] ingredientes2 = {"auga do mar", "salicornia", "berberechos místicos"};
    String[] ingredientes3 = {"raíz de toxo", "auga bendita", "po de estrela fugaz"};
    String[] ingredientes4 = {"auga de río encantada", "raíz de toxo", "pel de serpe"};
    String[] ingredientes5 = {"auga do mar", "po de estrela fugaz", "cinza de bidueiro"};
    String[] ingredientes6 = {"auga bendita", "pétalos de rosa silvestre", "brétema das fragas"};

    Feitizo f1 = new Feitizo("Encantamento da Chuvia Mansa", ingredientes1, 3);
    Feitizo f2 = new Feitizo("Invocación Mariña", ingredientes2, 4);
    Feitizo f3 = new Feitizo("Luz do Luar", ingredientes3, 2);
    Feitizo f4 = new Feitizo("Garda da Fraga", ingredientes4, 3);
    Feitizo f5 = new Feitizo("Respiro Oceánico", ingredientes5, 4);
    Feitizo f6 = new Feitizo("Bendición Floral", ingredientes6, 2);

    return new Feitizo[]{f1, f2, f3, f4, f5, f6};
}

}
