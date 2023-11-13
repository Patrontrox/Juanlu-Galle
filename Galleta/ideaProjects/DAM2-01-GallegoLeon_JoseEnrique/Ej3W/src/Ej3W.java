import java.io.IOException;
import java.time.Duration;
import java.util.Optional;

public class Ej3W {
    public static void main(String[] args) {
        try {
            // Iniciar los procesos
            Process proceso1 = Runtime.getRuntime().exec("notepad.exe");
            Process proceso2 = Runtime.getRuntime().exec("calc.exe");
            Process proceso3 = Runtime.getRuntime().exec("mspaint.exe");

            // Mostrar los PID de los procesos
            System.out.println("PID proceso 1: " + proceso1.toHandle().pid());
            System.out.println("PID proceso 2: " + proceso2.toHandle().pid());
            System.out.println("PID proceso 3: " + proceso3.toHandle().pid());

            // Esperar a que los procesos finalicen
            proceso1.waitFor();
            proceso2.waitFor();
            proceso3.waitFor();

            // Calcular y mostrar el tiempo transcurrido para cada proceso
            Optional<Duration> duracionProceso1 = proceso1.toHandle().info().totalCpuDuration();
            Optional<Duration> duracionProceso2 = proceso2.toHandle().info().totalCpuDuration();
            Optional<Duration> duracionProceso3 = proceso3.toHandle().info().totalCpuDuration();

            System.out.println("Tiempo transcurrido proceso 1: " + duracionProceso1.orElse(Duration.ZERO).toMillis() + " ms");
            System.out.println("Tiempo transcurrido proceso 2: " + duracionProceso2.orElse(Duration.ZERO).toMillis() + " ms");
            System.out.println("Tiempo transcurrido proceso 3: " + duracionProceso3.orElse(Duration.ZERO).toMillis() + " ms");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
