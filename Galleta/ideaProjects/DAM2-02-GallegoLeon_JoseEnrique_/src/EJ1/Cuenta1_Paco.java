package EJ1;

import java.util.concurrent.Semaphore;

public class Cuenta1_Paco {
    double saldo;
    String id;
    Semaphore usandose=new Semaphore(1);

    void sacaDineroCuenta1(double amount){
        saldo -= amount;
    }

    void meteDineroCuenta1(double amount){
        saldo += amount;
    }

    void transferenciaCuenta1(Cuenta1_Paco desde, double amount) throws InterruptedException {
        desde.sacaDineroCuenta1(amount);
        this.meteDineroCuenta1(amount);
        System.out.println("Transferencia de " + amount + " de " + desde.id + " a " + this.id);
    }
}
