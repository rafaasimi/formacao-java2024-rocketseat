package je06_operadores;

public class Ternario {

    public static void main(String[] args) {

        // TERNÁRIO
        String nome = "Rafael";
        int idade = 28;
        final int MAIOR_IDADE = 18;
        boolean maiorIdade = idade >= MAIOR_IDADE;
        String mensagem = nome + (maiorIdade ? " é de maior" : " não é de maior");
        System.out.println(mensagem);

    }

}
