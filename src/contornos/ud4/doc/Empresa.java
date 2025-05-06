package contornos.ud4.doc;

/**
 * <h2>Clase de empresa</h2>
 * @author NAO
 * @version 1-2025
 */
public class Empresa {
    /**
     * Atributo do nome da empresa
     */
    private String nome;
    /**
     * Empregados da empresa
     */
    Empregado[] empregados;

    /**
     * Construtor: Crea obxectos empresa, con nome.
     * 
     * @param nome <i>Nome da empresa</i>
     */
    public Empresa(String nome) {
        this.nome = nome;
    }

    /**
     * Método para engadir empregados á empresa
     * 
     * @param empregado <i>Empregado a engadir</i>
     */
    public void engadirEmpregado(Empregado empregado) {
        if (empregados == null) {
            empregados = new Empregado[1];
            empregados[0] = empregado;
        } else {
            Empregado[] novosEmpregados = new Empregado[empregados.length + 1];
            for (int i = 0; i < empregados.length; i++) {
                novosEmpregados[i] = empregados[i];
            }
            novosEmpregados[novosEmpregados.length - 1] = empregado;
            empregados = novosEmpregados;
        }
    }
}
