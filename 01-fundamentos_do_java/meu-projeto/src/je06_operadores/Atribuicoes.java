package je06_operadores;

import java.util.Date;

public class Atribuicoes {

    public static void main(String[] args) {

        // ATRIBUIÇÕES
        // Strings
        String nome = "RAFAEL";
        String nomeCompleto = "RAFAEL" + " SIMIONATO";
        nomeCompleto = nomeCompleto.concat(" ZORZENON");

        String intComString = 1 + "uma string";
        System.out.println(intComString); // 1uma string

        int idade = 28;
        double peso = 75.4;
        char sexo = 'M';
        boolean doadorOrgao = false;
        Date dataNascimento = new Date();

        System.out.println(nomeCompleto);

        // Inteiros
        int inteiros = 1 + 1 * 2;
        System.out.println(inteiros);

        // Booleanos
        boolean bol = (1 + 1) > 2;

    }

}
