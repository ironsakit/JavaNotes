public class Main {
    public static void main(String[] args){
        Persona p1 = new Persona("Marco", 25);  // "new" alloca in memoria l'oggetto, p1 punta a un oggetto senza new punta a "NULL"
        Persona p2 = new Persona("Luigi", 30);

        p1.saluta();
        p2.saluta();
    }
}
