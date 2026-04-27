// Posso estendere una sola classe alla volta ma posso avere più interfacce
public class PagamentoPaypal extends Pagamento implements Notificabile{
    private String email;

    public PagamentoPaypal(double importo, String email) {
        super(importo, "Paypal");
        this.email = email;
    }

    @Override
    public void inviaNotifica(String messaggio) {
        System.out.println("Email a " + email + ": " + messaggio);
    }

    @Override
    public void esegui() {
        System.out.println("Pagamento PayPal di " + importo + "€ da " + email);
    }
}
