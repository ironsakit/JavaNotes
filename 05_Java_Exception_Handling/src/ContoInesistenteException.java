public class ContoInesistenteException extends RuntimeException {
    public ContoInesistenteException(String titolare) {
        super("Conto di " + titolare + " non presente!");
    }
}
