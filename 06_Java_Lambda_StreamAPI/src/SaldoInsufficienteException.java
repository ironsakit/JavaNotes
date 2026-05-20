public class SaldoInsufficienteException extends RuntimeException {
    public SaldoInsufficienteException(String titolare, double saldo, double importo) {
        super("Saldo insufficiente per " + titolare + ". Saldo: " + saldo + "€, Richiesto: " + importo + "€");
    }
}
