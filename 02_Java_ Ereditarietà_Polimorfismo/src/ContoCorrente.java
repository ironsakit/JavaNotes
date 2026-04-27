public class ContoCorrente extends ContoBancario{
    private double canone;  // Costo mensile fisso

    public ContoCorrente(String titolare, double saldo, double canone) {
        super(titolare, saldo);
        this.canone = canone;
    }

    // Sottrae il canone al saldo
    public void addebitaCanone(){
        if(this.saldo - canone >= 0) this.saldo -= canone;
        else System.out.println("Saldo insufficiente");
    }

    @Override
    public void mostraSaldo() {
        super.mostraSaldo();
        System.out.println("Canone mensile: " + canone);
    }

    @Override
    public String getInfo(){
        return "Titolare: " + titolare + " | Saldo: " + saldo + "€" + " | Canone mensile: " + canone;
    }
}
