package UT1Ficheros.Ej4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

public class Cotizaciones {
    public static void main(String[] args) {
        HashMap<String, String> cotizaciones = new HashMap<>();

        try {
            URL url = new URL("https://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html?cid=SEM23201");
            InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Aquí debes implementar la lógica para extraer los datos de cotización de cada empresa
                if (line.contains("<td class=\"primera\">")) {
                    String empresa = line.split("<td class=\"primera\">")[1].split("</td>")[0];
                    String cotizacion = line.split("<td class=\"ultima\">")[1].split("</td>")[0];
                    cotizaciones.put(empresa, cotizacion);
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
