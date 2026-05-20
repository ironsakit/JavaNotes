import java.util.*;

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
            Optional<ContoBancario>c1 = banca.trovaConto("wadd");
            c1.ifPresent(c -> c.mostraSaldo());  // ifPresent permette se optional c1 non è vuoto di fare delle azioni come mostrare il saldo
            ContoBancario conto = c1.orElseThrow(() -> new ContoInesistenteException("wadd"));  // Se Optional c1 non è vuoto restituisce quello che ha trovato, sennò lancia un'eccezione
            // ContoBancario conto1 = banca.trovaConto("wadd").orElseThrow(() -> new ContoInesistenteException("wadd"));  // direttamente così possiamo fare
            // conto1.mostraSaldo();
        } catch (ContoInesistenteException e) {
            System.out.println("Attenzione: " + e.getMessage());
        }


        System.out.println("-------");
        banca.mostraTuttiConti();
        System.out.println("-------");
    }
}
