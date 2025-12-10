package je28_expressoes;

import java.time.LocalDate;

public class ExpressoesSimples {

    public static void main(String[] args) {

        String nome = "Rafael";
        String sobrenome = "Simionato";
        String textoImpresso = "Olá " + nome + " " + sobrenome;
        System.out.println(textoImpresso);

        // s: string
        // d: digitos/caracteres
        // f: decimais, floats, doubles
        // t: time/data
        String textoImpressoExpressao = String.format("Olá %s %s", nome, sobrenome);
        System.out.println(textoImpressoExpressao);

        char sexo = 'M';
        Integer idade = 29;
        long telefone = 19999999999L;
        Double salario = 9876.54;
        LocalDate dataNascimento = LocalDate.of(1996, 10, 7);
        String textoImpressoExpressao2 = String.format("Olá, meu nome é %s %s, meu gênero é %s, tenho %d anos, meu celular é %d e nasci em %tD, salario de %,.2f", nome, sobrenome, sexo, idade, telefone, dataNascimento, salario);
        System.out.println(textoImpressoExpressao2);
    }

}
