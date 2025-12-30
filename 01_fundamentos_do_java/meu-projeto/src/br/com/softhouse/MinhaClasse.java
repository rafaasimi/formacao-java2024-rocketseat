package br.com.softhouse;

import java.math.BigDecimal;

public class MinhaClasse {

    public static void main(String[] args) {

        User user = new User();
        user.showMyName();

        String nome = "Softhouse";
        Integer idade = 10;
        BigDecimal altura = BigDecimal.ONE;
        System.out.println(altura);

        br.com.softhouse.model.User userModel = new br.com.softhouse.model.User();
        userModel.showMyName();

    }

}
