package je05_tipos_wrappers;

public class TiposWrappers {

    public static void main(String[] args) {

        // CONVERSÃO DE VALORES

        // conversão explícita
        double numeroDouble = 123.56;
        int numeroInt = (int) numeroDouble;
        System.out.println(numeroInt);

        // utilizando wrappers
        Double numDouble = 150.99;
        Integer numInt = numDouble.intValue();

        System.out.println(numInt);

        // conversão entre tipos primitivos com parse
        String num = "100";
        int i = Integer.parseInt(num);
        System.out.println(i);

        String numStr = "150.50";
        Double numDoub = Double.valueOf(numStr);
        System.out.println(numDoub);

        // COMPARAÇÃO DE VALORES

        Integer obj1 = Integer.valueOf(100);
        Integer obj2 = Integer.valueOf(150);

        // Se igual => true, se não => false
        System.out.println(obj1.equals(obj2)); // true

        // Se obj1 for menor => -1
        // Se obj1 for igual => 0
        // Se obj1 for maior => 1
        System.out.println(obj1.compareTo(obj2));

        // métodos de informação
        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(Integer.MIN_VALUE); // -2147483648

        // DECLARAÇÃO E ATRIBUIÇÃO
        int anoFabricacao = 2021;
        anoFabricacao = 2024;
        System.out.println(anoFabricacao);


    }

}
