package exercicio1;

/**
 * Classe principal da aplicação.
 * Demonstra a utilização de {@link WorldTime#getTimeByCountry(String)},
 * mostrando na consola a hora atual de vários países, bem como o
 * comportamento do método em casos de erro.
 *
 * @author Pedro Cunha
 * @version 1.0
 */
public class Main {

    /**
     * Construtor privado, porque esta classe não deve ser instanciada.
     */
    private Main() {}
    
     /**
     * Ponto de entrada da aplicação.
     *
     * @param args argumentos da linha de comandos (não utilizados)
     */
    public static void main(String[] args) {
        System.out.println("Portugal:       " + WorldTime.getTimeByCountry("PT"));
        System.out.println("Brasil:         " + WorldTime.getTimeByCountry("BR"));
        System.out.println("Japão:          " + WorldTime.getTimeByCountry("JP"));
        System.out.println("Estados Unidos: " + WorldTime.getTimeByCountry("US"));
 
        System.out.println("\" ao \":         " + WorldTime.getTimeByCountry(" ao "));
        System.out.println("\"XX\":           " + WorldTime.getTimeByCountry("XX"));
        System.out.println("null:           " + WorldTime.getTimeByCountry(null));
    }
}
