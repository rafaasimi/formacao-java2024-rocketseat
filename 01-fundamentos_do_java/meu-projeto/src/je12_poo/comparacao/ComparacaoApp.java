package je12_poo.comparacao;

public class ComparacaoApp {

    public static void main(String[] args) {

        int i1 = 10;
        int i2 = 10;
        System.out.println(i1 == i2);
        // Saída: true

        Integer n1 = 128;
        Integer n2 = Integer.parseInt("128");
        System.out.println(n1 == n2);
        // Saída: false

        // s1 e s2 apontam para OBJETOS DIFERENTES na Heap, mesmo que tenham o mesmo conteúdo
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2);
        // Saída: false
        System.out.println(s1.equals(s2));
        // Saída: true

        // Otimização: String Literal Pool
        String nome1 = "João";
        String nome2 = "João";
        System.out.println(nome1 == nome2);
        // Saída: true
    }

}
