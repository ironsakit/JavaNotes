public class Persona {
    // Il fatto che queste due variabili siano "private" e dato dall'"incapsulamento", ovvero nessuno li
    // tocca direttamente da fuori ma si possono accedere tramite metodi (così si possono fare controlli)
    // come il controllo sull'età
    // Poi se un domani cambia la logica interna, chi usa la classe non se ne accorge, tanto usa solo i metodi
    private String nome;
    private int eta;

    // "this" indica l'oggetto in questione, quindi con this.nome intendiamo la variabile "nome" dell'oggetto corrente
    // almeno se ci sono parametri con lo stesso nome delle variabili originali si possono distinguere
    public Persona(String nome, int eta){ this.nome = nome; this.eta = eta;}  // <-- Costruttore
    // Se non viene scritto il costruttore Java ne genera uno senza parametri, ma se lo scriviamo
    // con i parametri quello di default sparisce (a meno che non lo riscriviamo noi)

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getEta() { return eta; }

    public void setEta(int eta) { if(eta >= 0) this.eta = eta; }

    public void saluta(){
        System.out.println("Ciao, sono " + nome + " e ho " + eta + " anni");
    }
}
