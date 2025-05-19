package Conta;

import java.time.LocalDate;
import java.util.Date;

public class ContaCorrente {

    int numeroConta = 123456;
    int numeroAgencia = 96;
    String nomeCliente = "Rafael Simionato";
    LocalDate dataNascimento = LocalDate.of(1996, 10, 07);
    private double saldo = 10_000.00;
    boolean contaAtiva = true;

    double sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        }

        return saldo = saldo - valor;
    }

    void transferir(double valor, int numeroConta) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        }

        saldo = saldo - valor;
        System.out.println("Transferência de " + valor + " realizada com sucesso para a conta " + numeroConta);
    }

    void encerrarConta(int numeroConta, String motivo) {
        contaAtiva = false;
        System.out.println("Conta " + numeroConta + " encerrada com sucesso. Motivo: " + motivo);
    }

    void extrato(LocalDate dataInicial, LocalDate dataFinal) {
        System.out.println("Extrato da conta " + numeroConta + " de " + dataInicial + " a " + dataFinal);
        System.out.println("Saldo atual: " + saldo);
    }

    double saldo() {
        return saldo;
    }

}
