package EJ1;

import java.util.concurrent.Semaphore;

public class Cuenta2_Luis {
    double saldo;
    String id;
    Semaphore usandoseCuenta2=new Semaphore(1);

    void sacaDineroCuenta2(double amount){
        saldo -= amount;
    }

    void meteDinero(double amount){
        saldo += amount;
    }

    void transferenciaCuenta2(Cuenta2_Luis desde, double amount) throws InterruptedException {
        desde.sacaDineroCuenta2(amount);
        this.meteDinero(amount);
        System.out.println("Transferencia de " + amount + " de " + desde.id + " a " + this.id);
    }
}
