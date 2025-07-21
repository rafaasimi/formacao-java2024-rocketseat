package je06_atribuicoes;

public class Logicos {

    public static void main(String[] args) {

        boolean condicao1 = true;
        boolean condicao2 = false;

        if (condicao1 && condicao2) {
            System.out.println("Os dois valores precisam ser verdadeiros.");
        }

        if (condicao1 || condicao2) {
            System.out.println("Um dos valores precisa ser verdadeiro.");
        }

        // Expressões lógicas avançadas
        if ((1 == 1 && 2 > 3) || 4 < 5) {
            System.out.println("Um dos valores precisa ser verdadeiro.");
        }

    }

}
