package objetos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase define qu� atleta puede tener el testigo y le permite correr. 
 * @author: Johan Steven Capera Pe�uela
 */

public class Testigo {
	/**
	 * orden = 1 indica que cuando se inicie la clase va a tener valor 1, en la funci�n correr este n�mero va a cambiar
	 * y este n�mero es el que en �ltimas indica que atleta puede correr.
	 */
    private int orden = 1;
    /**
     * Funci�n sincronizada que verifica e indica que atleta puede correr
     * @param idAtleta : Indica que atleta est� corriendo.
     */
    public synchronized void correr(int idAtleta) {
    	/**
    	 * Para que corra siempre
    	 */
        while (true) {
        	/**
        	 * this.orden cambia en la ejecuci�n de esta funci�n. Si this.orden == idAtleta el atleta que est� en espera
        	 * va comenzar a correr, mientras los dem�s duermen. 
        	 */
            if (this.orden == idAtleta) {
            	/**
            	 * Si idAtleta == 1 se va a imprimir en la consola, cu�ndo empez� la carrera.
            	 */
                if (idAtleta == 1) {
                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MMMM/dd hh:mm:ss");
                    System.out.println("Inicia : " + (fmt.format(new Date(System.currentTimeMillis()))));
                }
                try {
                	/**
                	 * Se marca el reelevo: Se marca qui�n empieza y corre de 9 a 11 segundos luego se marca cuando lleg�.
                	 */
                    System.out.println("Empieza el atleta : " + idAtleta);
                    Thread.sleep(((int) (Math.random() * 3) + 9) * 1000);
                    System.out.println("Llega el atleta : " + idAtleta);
                    /**
                	 * Si idAtleta == 4 se va a imprimir en la consola, cu�ndo finaliz� la carrera.
                	 */
                    if (idAtleta == 4) {
                        SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MMMM/dd hh:mm:ss");
                        System.out.println("Finaliza : " + (fmt.format(new Date(System.currentTimeMillis()))));
                    }
                    /**
                     * Se aumenta el orden y verificamos si es > 4, �sto por que s�lo hay 4 atletas, cuando sea > 4, 
                     * se manda el orden al 1, para que el atleta 1 vuelva a correr.
                     */
                    this.orden++;                    
                    if (this.orden > 4) {
                        this.orden = 1;
                    }
                    /**
                     * Notificamos a los atletas que cambiamos para que el siguiente en espera empiece a correr.
                     */
                    notifyAll();
                } catch (InterruptedException ex) {
                	/**
                	 * Excepciones, si se interrumpe el hilo.
                	 */
                    Logger.getLogger(Testigo.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                	/**
                	 * Si el atleta no puede correr por el orden del testigo, se le indica que espere.
                	 */
                    wait();
                } catch (InterruptedException ex) {
                	/**
                	 * Excepciones, si se interrumpe el hilo.
                	 */
                    Logger.getLogger(Testigo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            /**
             * Notificamos a los atletas el fin de ejecuci�n de la funci�n del atleta que estaba corriendo.
             */
            notifyAll();
        }

    }

}
