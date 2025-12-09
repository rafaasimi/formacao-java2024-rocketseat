package je27_excessoes;

import java.text.NumberFormat;
import java.text.ParseException;

public class Excessoes {

    public static void main(String[] args) {

//        Double valor = (double) (100 / 0);
//        System.out.println(valor);

//        Number valor2 = NumberFormat.getCurrencyInstance().parse("a1.75");

//        try {
//            Number valor2 = NumberFormat.getCurrencyInstance().parse("a1.75");
//            System.out.println(valor2);
//        } catch (ParseException e) {
//            System.out.println("Erro: " + e);
//            e.printStackTrace();
//        } finally {
//            System.out.println("Finally executado.");
//        }

        try {
            checkEstado("SP");
            checkEstado("RJ");
        } catch (EstadoValidadeException e) {
            System.out.println(e.getMessage());
            System.out.println("Selecione um estado válido.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Selecione um estado brasileiro.");
        }

    }

    static void checkEstado(String nomeEstado) throws EstadoValidadeException, Exception {

        if (!nomeEstado.equalsIgnoreCase("FL")) {
            throw new Exception("Esse estado não existe no Brasil.");
        }

        if (!nomeEstado.equalsIgnoreCase("SP")) {
            throw new EstadoValidadeException();
        }


        System.out.println("Bem-vindo ao: " + nomeEstado.toUpperCase());

    }

}
