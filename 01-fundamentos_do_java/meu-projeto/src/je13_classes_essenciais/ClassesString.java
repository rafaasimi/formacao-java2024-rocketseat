package je13_classes_essenciais;

public class ClassesString {

    public static void main(String[] args) {

        // String é uma classe que representa uma sequência de caracteres
        String nome = "Rafael";
        String sobrenome = " Simionato";
        String nomeCompleto = nome.concat(sobrenome);
        System.out.println(nomeCompleto); // Rafael Simionato

        // StringBuilder é uma classe que permite construir strings de forma mais eficiente
        StringBuilder sb = new StringBuilder();
        sb.append("Rafael");
        sb.append(" Simionato");
        System.out.println(sb); // Rafael Simionato

        System.out.println(nomeCompleto.toLowerCase()); // rafael simionato
        System.out.println(nomeCompleto.toUpperCase()); // RAFAEL SIMIONATO
        System.out.println(nomeCompleto.split(" ")[0]); // Rafael

    }

}
