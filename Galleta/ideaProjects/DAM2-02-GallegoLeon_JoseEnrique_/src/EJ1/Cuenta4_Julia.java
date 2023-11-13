package EJ1;

import java.util.concurrent.Semaphore;

public class Cuenta4_Julia {
    double saldo;
    String id;
    Semaphore usandoseCuenta4=new Semaphore(1);

    void sacaDineroCuenta4(double amount){
        saldo -= amount;
    }

    void meteDineroCuenta4(double amount){
        saldo += amount;
    }

    void transferenciaCuenta4(Cuenta4_Julia desde, double amount) throws InterruptedException {
        desde.sacaDineroCuenta4(amount);
        this.meteDineroCuenta4(amount);
        System.out.println("Transferencia de " + amount + " de " + desde.id + " a " + this.id);
    }
}
