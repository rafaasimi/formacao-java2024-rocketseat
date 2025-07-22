package je09_controle_fluxo.condicional;

public class ResultadoEscolar {

    public static void main(String[] args) {

        double nota = 5;

        if (nota >= 7) {
            System.out.println("Aprovado");
        } else if (nota >= 5 && nota < 7) {
            System.out.println("Recuperação");
        } else {
            System.out.println("Reprovado");
        }

    }

}
