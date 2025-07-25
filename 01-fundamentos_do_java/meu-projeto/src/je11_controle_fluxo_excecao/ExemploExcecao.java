package je11_controle_fluxo_excecao;

public class ExemploExcecao {

    public static void main(String[] args) {

        try {
            Double valor = Double.valueOf("1.75");
            System.out.println(valor);
        } catch (NumberFormatException e) {
            System.err.println("Número inválido");
        }

    }

}
