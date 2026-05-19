// Classe PADRE o SUPERCLASSE
public class ContoBancario {
    // "proteced" è simile a "private" solo che permette di essere visibili dalle "sottoclassi" e alle classi dello stesso "package"
    protected String titolare;
    protected double saldo;

    // Costruttore
    public ContoBancario(String titolare, double saldo) {
        this.titolare = titolare;
        this.saldo = saldo;
    }

    public String getTitolare() {
        return titolare;
    }

    public void setTitolare(String titolare) {
        this.titolare = titolare;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Metodo per mostrare il saldo attuale nel conto bancario
    public void mostraSaldo() {
        System.out.println("Il tuo saldo e': " + saldo);
    }

    // Metodo per versare i soldi sul conto bancario
    public void versa(double importo) {
        if(importo > 0)  this.saldo += importo;
    }

    // Metodo per prelevare i soldi dal conto bancario (se puoi)
    // throws SaldoInsufficienteException, indica che la funzione potrebbe esplodere, e di gestirlo quando richiamato
    public void preleva(double importo) throws SaldoInsufficienteException{  // Per RuntimeException non è obbligatorio ma per le checked exception tipo IOException lo è.
        if(this.saldo - importo >= 0)  this.saldo -= importo;
        else throw new SaldoInsufficienteException(titolare, saldo, importo);
    }

    public String getInfo(){
        return "Titolare: " + titolare + " | Saldo: " + saldo + "€";
    }
}