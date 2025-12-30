package je10_controle_fluxo_repeticao;

import java.util.Random;

public class ExemploWhile {

    public static void main(String[] args) {

        double mesada = 50.0;

        while (mesada > 0) {

            double valorDoce = gerarValorAleatorio(1, 8);

            if (valorDoce > mesada) {
                valorDoce = mesada;
            }

            System.out.println("Doce no valor de: " + valorDoce + " foi adicionado ao carrinho.");
            mesada = mesada - valorDoce;
        }

        System.out.println("Valor da mesada: " + mesada);
        System.out.println("Any gastou toda a sua mesada em doces.");

    }

    private static double gerarValorAleatorio(double minimo, double maximo) {
        Random random = new Random();
        return minimo + (maximo - minimo) * random.nextDouble();
    }

}
