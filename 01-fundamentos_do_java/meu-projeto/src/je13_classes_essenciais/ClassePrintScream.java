package je13_classes_essenciais;

public class ClassePrintScream {

    public static void main(String[] args) {

        String nome = "Rafael";
        int idade = 28;
        double peso = 70.5;
        double renda = 5000.75;

        System.out.printf("%s tem %d anos, pesa %.2f kg e tem uma renda de R$ %,.2f", nome, idade, peso, renda);

        // Saída: Rafael tem 28 anos, pesa 70,50 kg e tem uma renda de R$ 5.000,75
        //%s ->     parâmetros do tipo String
        //%d ->     parâmetros do tipo Integer / Long
        //%f ->     parâmetros do tipo Double / Float
        //.2 ->     quer dizer que serão dois dígitos decimais
        //,.2 ->    quer dizer que serão dois dígitos decimais e informando o (.) de milhar

    }

}
