import java.awt.*;

public class Main {
    public static void main(String[] args){
        ContoBancario cb1 = new ContoBancario("Mattia", 2000);

        cb1.versa(3000);
        cb1.mostraSaldo();
        cb1.preleva(6000);
        cb1.mostraSaldo();

        System.out.println(cb1.getInfo());
    }
}
