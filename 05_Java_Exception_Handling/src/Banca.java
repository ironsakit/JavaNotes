import java.util.ArrayList;
import java.util.List;

public class Banca {
    private String nome;
    private List<ContoBancario> conti;

    public Banca(String nome) {
        this.nome = nome;
        this.conti = new ArrayList<>();
    }

    public Banca(String nome, List<ContoBancario> conti) {
        this.nome = nome;
        this.conti = conti;
    }

    // Metodo per aggiungere un conto bancario in banca
    public void aggiungiConto(ContoBancario conto){
        conti.add(conto);
        System.out.println("Conto di " + conto.getTitolare()  + " inserito correttamente");
    }

    // Metodo per rimuovere un conto bancario in banca (in base al nome del titolare)
    public void rimuoviConto(String titolare){
        for(int i = 0; i < conti.size(); i++){
            if(conti.get(i).getTitolare().equals(titolare)){  // Se lo trova
                conti.remove(i);  // Lo rimuove
                System.out.println("Conto di " + titolare  + " rimosso correttamente");
                return;  // Esce
            }
        }
        throw new ContoInesistenteException(titolare);
        // Oppure
        // conti.removeIf(conto -> conto.getTitolare().equals(titolare));
    }

    public void mostraTuttiConti(){
        for(ContoBancario conto: conti){
            System.out.println(conto.getInfo());
        }
    }

    public ContoBancario trovaConto(String titolare){
        for(ContoBancario conto: conti){
            if(conto.getTitolare().equals(titolare)){  // Se lo trova
                return conto;  // Lo restituisce
            }
        }
        throw new ContoInesistenteException(titolare);  // Exception handling
    }

}
