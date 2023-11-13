package EJ1;

import java.util.concurrent.Semaphore;

public class Cuenta3_Maria {
    double saldo;
    String id;
    Semaphore usandoseCuenta3=new Semaphore(1);

    void sacaDineroCuenta3(double amount){
        saldo -= amount;
    }

    void meteDineroCuenta3(double amount){
        saldo += amount;
    }

    void transferenciaCuenta3(Cuenta3_Maria desde, double amount) throws InterruptedException {
        desde.sacaDineroCuenta3(amount);
        this.meteDineroCuenta3(amount);
        System.out.println("Transferencia de " + amount + " de " + desde.id + " a " + this.id);
    }
}
