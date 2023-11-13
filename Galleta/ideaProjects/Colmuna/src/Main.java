import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String separator = "[ \t]+"; // Utilizamos una expresión regular para separar por uno o más espacios o tabulaciones

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] columns = line.split(separator);

            if (args.length > 0 && Integer.parseInt(args[0]) <= columns.length) {
                int selectedColumn = Integer.parseInt(args[0]) - 1;
                System.out.println(columns[selectedColumn]);
            } else {
                System.out.println();
            }
        }

        scanner.close();
    }
}
