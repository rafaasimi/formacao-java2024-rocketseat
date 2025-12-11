package je28_expressoes;

import java.time.LocalDate;

public class ExpressoesAvancadas {

    public static void main(String[] args) {

        String nome = "Rafael Simionato";
        Integer matricula = 710;
        Double salario = 9876.54;
        LocalDate dataAdmissao = LocalDate.now();

        String dadosFuncionario = String.format("Matrícula: %05d | Nome: %-10.10s | Data Admissão: %td/%<tm/%<tY | Salário: %,.2f", matricula, nome, dataAdmissao, salario);
        System.out.println(dadosFuncionario);

        System.out.printf("O valor é: %.2f", 5.6789);

    }

}
