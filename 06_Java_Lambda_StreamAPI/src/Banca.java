import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        boolean rimosso = conti.removeIf(c -> c.getTitolare().equals(titolare));  // removeIf se rimuove restituisce vero sennò falso
        if(!rimosso) throw new ContoInesistenteException(titolare);  // se non lo trova creo un'eccezione
    }

    public void mostraTuttiConti(){
        conti.forEach(c -> System.out.println(c.getInfo()));
    }

    public Optional <ContoBancario> trovaConto(String titolare){
        return conti.stream().filter(c -> c.getTitolare().equals(titolare)).findFirst();
    }

    // Nuove funzioni

    // Crea una lista di tutti i titolari
    public List<String> getTitolari() {
        //  "ContoBancario::getTitolare" è una method reference, si usa quando la Lambda usa un metodo già esistente senza logica aggiuntiva (c -> c.getSaldo()) viene sostituito
        return conti.stream().map(ContoBancario::getTitolare).collect(Collectors.toList());
    }

    // Prende tutti conto cancari con saldo superiore di una certa soglia
    public List<ContoBancario> getContiConSaldoSuperioreA(double soglia){
        return conti.stream().filter(c -> c.getSaldo() > soglia).collect(Collectors.toList());
    }

    public Optional<ContoBancario> getContoConSaldoMassimo(){
        // Restituisce il massimo (ed è Optional perchè la lista potrebbe essere vuota senza un massimo)
        return conti.stream().max((a,b) -> Double.compare(a.getSaldo(), b.getSaldo()));
    }

}
