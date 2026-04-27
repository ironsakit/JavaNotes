public class Bonifico extends Pagamento{
    private String ibanDestinatario;

    public Bonifico(double importo, String iban){
        super(importo, "Bonifico Bancario");
        this.ibanDestinatario = iban;
    }

    @Override
    public void esegui() {  // Metodo astratto che devo obbligatoriamente avere (modificarlo anche)
        System.out.println("Invio " + importo + "€ all'IBAN: " + ibanDestinatario);
    }
}
