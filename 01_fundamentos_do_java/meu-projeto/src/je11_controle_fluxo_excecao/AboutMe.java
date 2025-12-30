package je11_controle_fluxo_excecao;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class AboutMe {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        try {
            System.out.println("Digite o seu nome:");
            String nome = scanner.next();

            System.out.println("Digite o seu sobrenome:");
            String sobrenome = scanner.next();

            System.out.println("Digite a sua idade:");
            int idade = lerInteiro(scanner);

            System.out.println("Digite a sua altura:");
            double altura = lerDouble(scanner);

            // imprimindo os dados obtidos pelo usuário
            System.out.println("Olá, me chamo " + nome.toUpperCase() + " " + sobrenome.toUpperCase());
            System.out.println("Tenho " + idade + " anos ");
            System.out.println("Minha altura é " + altura + "cm ");
        } finally {
            scanner.close();
        }
    }

    private static int lerInteiro(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("A idade deve ser um número inteiro.");
            return 0;
        }
    }

    private static double lerDouble(Scanner scanner) {
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.err.println("A altura deve ser informada no padrão americano (1.90).");
            return 0.0;
        }
    }

}

