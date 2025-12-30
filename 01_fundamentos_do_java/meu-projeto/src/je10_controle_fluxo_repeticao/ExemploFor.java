package je10_controle_fluxo_repeticao;

import java.util.Arrays;
import java.util.List;

public class ExemploFor {

    public static void main(String[] args) {

        for(int carneirinhos = 1; carneirinhos <= 20; carneirinhos++) {
            System.out.println(carneirinhos + " - Carneirinho(s)");
        }

        // forma feia
        int carneirinhos = 1;
        for(;carneirinhos <= 20;) {
            System.out.println(carneirinhos + " - Carneirinho(s)");
            carneirinhos = carneirinhos + 2;
        }

        // iterando sobre arrays
        String[] alunos = {"Rafael", "João", "Luiz", "Patricia"};
        for (int x = 0; x < alunos.length; x++) {
            System.out.println("O aluno no indice x=" + x + " é " + alunos[x]);
        }

        // arrays
        for(String aluno : alunos) {
            System.out.println(aluno);
        }

        // list
        List<String> frutas = Arrays.asList("Maça", "Banana", "Morango", "Melancia");
        for (int x = 0; x < frutas.size(); x++) {
            System.out.println(frutas.get(x));
        }

    }

}
