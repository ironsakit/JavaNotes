public class ContoBancario {
    private String titolare;
    private double saldo;

    // Costruttore
    public ContoBancario(String titolare, double saldo) {
        this.titolare = titolare;
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
    public void preleva(double importo) {
        if(this.saldo - importo >= 0)  this.saldo -= importo;
        else System.out.println("Saldo insufficiente");
    }

    public String getInfo(){
        return "Titolare: " + titolare + " | Saldo: " + saldo + "€";
    }
}
