package je08_javabeans;

public class Aluno {

    private String nome;
    private int idade;

    private final int IDADE_MINIMA = 0;
    private final int IDADE_MAXIMA = 150;


    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        nome = novoNome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {

        if(idade < IDADE_MINIMA || idade > IDADE_MAXIMA) {
            String mensagemFormatada = String.format("O valor fornecido para a idade deve estar entre %d e %d.", IDADE_MINIMA, IDADE_MAXIMA);
            throw new IllegalArgumentException(mensagemFormatada);
        }

        // Em caso de propriedades com nomes iguais
        // this.idade => Refere-se a minha propriedade privada da classe
        // idade => Refere-se ao argumento recebido no método setIdade()
        this.idade = idade;
    }

}
