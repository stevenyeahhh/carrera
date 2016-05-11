package objetos;

/**
 * Esta clase crea los 4 atletas y el testigo. Se encarga de hacer que todos los atletas corran sobre hilos.
 * @author: Johan Steven Capera Peñuela
 */
 

public class Carrera {
	/**
	 * Constructor, al ser instanciada esta clase, este método se ejecuta automáticamente.
	 */
    public Carrera() {
    	/**
    	 * Testigo que indica que atleta puede correr
    	 */
	    Testigo t = new Testigo();
	    /**
	     *Atletas 4: se le pasa el testigo, dentro del objeto atleta, se verifica que sólo uno pueda tener el testigo 
	     */
	    Atleta atleta1 = new Atleta(t, 1);
	    Atleta atleta2 = new Atleta(t, 2);
	    Atleta atleta3 = new Atleta(t, 3);
	    Atleta atleta4 = new Atleta(t, 4);
	    /**
	     * Threads 4: se crea un hilo para cada atleta y se le pone un identificador
	     */
	    Thread t1 = new Thread(atleta1, "Atleta 1");
	    Thread t2 = new Thread(atleta2, "Atleta 2");
	    Thread t3 = new Thread(atleta3, "Atleta 3");
	    Thread t4 = new Thread(atleta4, "Atleta 4");
	    
	    /**
	     * Se inician los hilos.
	     */
	    t1.start();
	    t2.start();
	    t3.start();
	    t4.start();
    }
}
