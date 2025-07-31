package je13_classes_essenciais;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ClassesNumeros {

    public static void main(String[] args) {

        Integer numero1 = 100;
        Integer numero2 = 100;

        System.out.println(numero1==numero2);
        System.out.println(numero1.equals(numero2));

        numero1 = 128;
        numero2 = 128;

        // acima de 127, internamente o Java cria um novo objeto do tipo Integer -> Integer numero1/2 = new Integer(128)
        // logo estamos agora nos referindo a dois objetos na aplicação.
        System.out.println(numero1==numero2);
        System.out.println(numero1.equals(numero2));
        System.out.println(numero1.intValue()==numero2.intValue());

        // BigDecimal é uma classe que representa números decimais de forma precisa
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal dez = BigDecimal.TEN;
        BigDecimal resultado = zero.add(new BigDecimal("100"));
        System.out.println(resultado);
        resultado = zero.subtract(new BigDecimal("27.8"));
        System.out.println(resultado);

        BigDecimal decimal = BigDecimal.valueOf(1234.5678);
        BigDecimal numeroString = new BigDecimal("1234.5678");

        // POSTO DE GASOLINA
        BigDecimal precoLitro = new BigDecimal("5.799");
        BigDecimal quantidadeLitros = new BigDecimal("21.752");
        BigDecimal total = precoLitro.multiply(quantidadeLitros);
        System.out.println("Total a pagar: R$ " + total); // Total a pagar: R$ 126.139848

        // Arredondando o valor do combustivel
        BigDecimal totalArredondado = total.setScale(2, RoundingMode.HALF_EVEN);
        System.out.println("Total a pagar (arredondado): R$ " + totalArredondado); // Total a pagar (arredondado): R$ 126.14

    }

}
