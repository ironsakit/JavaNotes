import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        // Pagamento p = new Pagamento(100, "wodwa");  Sbagliato
        Bonifico b = new Bonifico(500, "IT60X054211101000000123456");
        b.esegui();  // implementato dal figlio
        b.mostraRicevuta();  // ereditato dal padre

        List<Pagamento> pagamenti = new ArrayList<>();
        pagamenti.add(new Bonifico(200, "IT55X0123456710000001678900"));
        pagamenti.add(new PagamentoPaypal(500, "ironsakit2006@gmail.com"));

        System.out.println("--------------");
        for(Pagamento p: pagamenti){
            p.esegui();  // Non importa il tipo, sa solo che esegui esiste
        }
    }
}
