package je13_classes_essenciais;

import java.util.Scanner;

public class ClassesEssenciais {

    public static void main(String[] args) {

        System.out.print("Rafael");
        System.out.print("Simionato");
        // Saída: RafaelSimionato

        System.out.println("Rafael");
        System.out.println("Simionato");
        // Saída:
        // Rafael
        // Simionato

        System.err.println("Aconteceu um erro!");
        // Saída: Aconteceu um erro! (em vermelho no console)

        // SCANNER
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite a sua idade: ");
        int idade = scanner.nextInt();

        System.out.println("Seu nome é " + nome + " e você tem " + idade + " anos.");
        // Saída: Seu nome é Rafael e você tem 28 anos.

        scanner.close();

    }

}
