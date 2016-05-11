package objetos;
/**
 * Esta clase define al atleta, se le pone un identificador y se le pone el testigo que tiene una función sincronizada 
 * que permite al atleta saber si puede correr o de lo contrario dormir.
 * @author: Johan Steven Capera Peñuela
 */
 
public class Atleta implements Runnable {
	
    private Testigo testigo;
    private int id;
    /**
     * Constructor que inicia los parámetros para que funcione la clase
     * @param testigo : Es el testigo que indica al atleta si puede correr o no.
     * @param id : Identificador para el atleta
     */
    public Atleta(Testigo testigo, int id) {
        this.testigo = testigo;
        this.id = id;
    }
    /**
     * Hace correr al testigo, y éste tiene un filtro que indica si corre o no el atleta
     */

    @Override
    public void run() {
        this.testigo.correr(id);
    }

}
