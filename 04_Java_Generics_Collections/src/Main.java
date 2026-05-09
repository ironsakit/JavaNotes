import java.util.ArrayList;
import java.util.List;

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
        banca.rimuoviConto("Sohaib");
        System.out.println("-------");
        banca.mostraTuttiConti();

    }
}
