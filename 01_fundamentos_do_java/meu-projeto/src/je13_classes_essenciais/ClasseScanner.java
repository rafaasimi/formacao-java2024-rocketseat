package je13_classes_essenciais;

import java.util.Scanner;

public class ClasseScanner {

    public static void main(String[] args) {

        String nome = null;
        Integer idade = null;
        Double peso = null;

        String linhaArquivo = "Rafael;28;70.5";

        Scanner scanner = new Scanner(linhaArquivo);
        scanner.useDelimiter(";");

        int index = 0;
        while (scanner.hasNext()) {

            if (index == 0) {
                nome = scanner.next();
            } else if (index == 1) {
                idade = Integer.valueOf(scanner.next());
            } else {
                peso = Double.valueOf(scanner.next());
            }

            index++;
        }

        scanner.close();
        System.out.println("Seu nome é " + nome + ", você tem " + idade + " anos e pesa " + peso + " kg.");

    }

}
