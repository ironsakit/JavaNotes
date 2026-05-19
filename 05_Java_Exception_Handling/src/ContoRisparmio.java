// Classe FIGLIA o SOTTOCLASSE
public class ContoRisparmio extends ContoBancario{  // extends indica che estende/eredita la classe padre (ovvero è una sottoclasse)
    private double tassoInteresse;  // Variabile aggiuntiva, solo sua

    public ContoRisparmio(String titolare, double saldo, double tassoInteresse) {
        super(titolare, saldo);  // chiamo il costruttore del padre
        this.tassoInteresse = tassoInteresse;
    }

    // Metodo nuovo, solo del conto risparmio
    public void applicaInteressi(){
        saldo += saldo * tassoInteresse;
        System.out.println("Interessi applicati! Nuovo saldo: " + saldo + "€");
    }

    @Override  // Ridefinisce il metodo del padre (sovrascrive quel metodo)
    public void mostraSaldo(){
        super.mostraSaldo();  // Chiamo prima il metodo del padre
        System.out.println("Tasso interesse: " + (tassoInteresse * 100) + "%");
    }

    @Override
    public String getInfo(){
        return "Titolare: " + titolare + " | Saldo: " + saldo + "€" + " | Tasso interesse: " + tassoInteresse;
    }
}
