package je10_controle_fluxo_repeticao;

public class ExemploBreakContinue {

    public static void main(String[] args) {

        // uso do break
        // saída: 1, 2
        for (int numero = 1; numero <= 5; numero++) {
            if (numero == 3) {
                break; // interrompe a iteração dos elementos
            }
            System.out.println(numero);
        }

        // uso do continue
        // saída: 1, 2, 4, 5
        for (int numero = 1; numero <= 5; numero++) {
            if (numero == 3) {
                continue; // interrompe a iteração atual e passa para a proxima iteração
            }
            System.out.println(numero);
        }

    }

}
