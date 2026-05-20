import java.util.ArrayList;
import java.util.List;

// Cosa e' un'eccezione?
// Un errore a runtime che, se non gestito, crasha il programma. Java obbliga a pensarci in anticipo.

public class Main {
    public static void main(String[] args){
        Banca banca = new Banca("Fauser");

        List<ContoBancario> conti = new ArrayList<>(
                List.of(
                        new ContoCorrente("Mattia", 2000,2),
                        new ContoCorrente("Sohaib", 1, 1000),
                        new ContoRisparmio("Francesco", 2000, 10),
                        new ContoRisparmio("Manuel", 9000, 10)
                )
        );

        for(ContoBancario conto: conti){
            banca.aggiungiConto(conto);
        }

        System.out.println("-------");
        banca.mostraTuttiConti();
        System.out.println("-------");

        try{
            banca.rimuoviConto("Sohaib");
        } catch (ContoInesistenteException e) {
            System.out.println("Attenzione: " + e.getMessage());
        }

        // Provo la prima volta (andrà bene)
        try{
            banca.trovaConto("Sohaib");
        } catch (ContoInesistenteException e) {
            System.out.println("Attenzione: " + e.getMessage());
        }

        System.out.println("-------");
        banca.mostraTuttiConti();
        System.out.println("-------");

        try{
            ContoBancario conto = banca.trovaConto("awdawd");  // se ha successo va a eseguire quello sotto sennò se fallisce richiama l'eccezione e non esegue il codice sotto
            conto.preleva(9999999);  // se fallisce richiama l'eccezione
        } catch (ContoInesistenteException e) {
            System.out.println("Attenzione: " + e.getMessage());
        } catch (SaldoInsufficienteException e) {
            System.out.println("Attenzioned: " + e.getMessage());
        }

        System.out.println("-------");


        // Se le due operazioni sono indipendente non ha senso unirle nello stesso try-catch perchè appena "int risultato = 10 / 0;"
        // richiama l'eccezione non esegue nessun altro codice dopo,
        // e non capisco chi ha generato l'eccezione se l'intero o la stringa...
        try{
            int risultato = 10 / 0;
        }catch (ArithmeticException e){
            System.out.println("Errore: " + e.getMessage());
        }finally {  // Finally viene eseguito sempre
            System.out.println("Fine operazione.");
        }

        System.out.println("-------");

        try {
            String s = null;
            s.length();              // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Oggetto null!");
        } catch (Exception e) {
            System.out.println("Errore generico: " + e.getMessage());
        }
        /*
        *   1) Qual è la differenza tra Exception e RuntimeException?
            2) Il blocco finally viene eseguito anche se c'è un return dentro il try?
            3) Perché restituire null è peggio di lanciare un'eccezione?
            4) Cosa significa throws nella firma di un metodo?

            Risposte:

            1) Le RuntimeException sono unchecked — il compilatore non ti obbliga a gestirle.
            * Le Exception normali sono checked — devi obbligatoriamente usare try/catch o dichiarare throws.
            * In Spring Boot userai quasi sempre RuntimeException custom.
            2) Sì, sempre. Il finally viene eseguito in ogni caso, anche con return o eccezione non catturata.
            3) Perché chi riceve null deve ricordarsi di controllarlo, e se dimentica ottiene una NullPointerException misteriosa lontano dal punto del problema.
            *  L'eccezione invece esplode subito nel posto giusto con un messaggio chiaro.
            4) Avvisa il compilatore e chi legge il codice che quel metodo può lanciare quell'eccezione, e che chi lo chiama deve gestirla.*/
    }
}
