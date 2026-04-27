public class Main {
    public static void main(String[] args){
        ContoBancario cb1 = new ContoBancario("Mattia", 2000);
        ContoRisparmio cr1 = new ContoRisparmio("Samuele", 4000, 0.03);
        ContoCorrente cc1 = new ContoCorrente("Kili", 5000, 400);

        cb1.versa(3000);
        cb1.mostraSaldo();
        cb1.preleva(6000);
        cb1.mostraSaldo();

        System.out.println(cb1.getInfo() + "\n-----------\n");

        cr1.versa(3000);
        cr1.mostraSaldo();
        cr1.preleva(6000);
        cr1.applicaInteressi();
        cr1.mostraSaldo();

        System.out.println(cr1.getInfo() + "\n-----------\n");

        cc1.versa(3000);
        cc1.mostraSaldo();
        cc1.preleva(6000);
        cc1.addebitaCanone();
        cc1.mostraSaldo();

        System.out.println(cc1.getInfo() + "\n-----------\n");
    }
}