package contornos.ud4.doc;

/**
 * <h2>Clase de empregados, que se usa para crear e ler empregados desde unha
 * base de datos</h2>
 *
 * Busca información de javadoc en <a href="http://google.com">GOOGLE</a>
 * 
 * @see <a href="http://www.google.com">Google</a>
 * @version 1-2025
 * @author NAO
 * @since o 1-5-2025
 */
public class Empregado {
    /**
     * Atributo do nome do empregado
     */
    private String nome;
    /**
     * Atributo do apelido do empregado
     */
    private String apelido;
    /**
     * Atributo do salario do empregado
     */
    private double soldo;

    /**
     * Construtor con 3 parámetros.
     * Crea obxectos empregados, con nome, apelidos e salario.
     * 
     * @param nome    <i>Nome do empregado</i>
     * @param apelido <i>Apelido do empregado</i>
     * @param soldo   <i>Salario do empregado</i>
     */
    public Empregado(String nome, String apelido, double soldo) {
        this.nome = nome;
        this.apelido = apelido;
        this.soldo = soldo;
    }

    // Métodos públicos

    /**
     * Aumentar o soldo do empregado.
     * 
     * @see Empregado
     * @param subida <i>Aumento para solicitar o salario</i>
     */
    public void subidasoldo(double subida) {
        if (subida > 0) {
            this.soldo += subida;
        } else {
            System.out.println("Aumento non válido");
        }
    }

    // Métodos privados

    /**
     * Comproba que o nome non estea baleiro
     * @return
     *         <ul>
     *         <li>true: o nome é unha cadea baleira</li>
     *         <li>falso: o nome non é unha cadea baleira</li>
     *         </ul>
     */
    private boolean comprobar() {
        // Comprobar se o nome non está baleiro
        if (nome == null || nome.equals("")) {
            return false;
        }
        return true;
    }
}
