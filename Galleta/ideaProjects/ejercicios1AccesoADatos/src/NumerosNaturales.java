import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NumerosNaturales {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("numNaturales.txt");
        for (int i = 1; i <= 100; i++) {
            fw.write(i + "\n");
        }
        fw.close();

        FileReader fr = new FileReader("numNaturales.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
        fr.close();
    }
}

