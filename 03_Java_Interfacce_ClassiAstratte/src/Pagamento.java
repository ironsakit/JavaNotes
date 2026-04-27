// Classe Astratta = una classe che non può essere stanziata ma può essere solo estesa
// Può avere metodo completi o metodi astratti (i figli devono implementarli obbligatoriamente)
public abstract class Pagamento {
    protected double importo;
    protected String descrizione;

    public Pagamento(double importo, String descrizione) {
        this.descrizione = descrizione;
        this.importo = importo;
    }

    public abstract void esegui();  // E' un metodo astratto senza corpo, i figli lo devono implementare obbligatoriamente

    public void mostraRicevuta(){  // Metodo concreto
        System.out.println("Pagamento di " + importo + "€ - " + descrizione);
    }
}
