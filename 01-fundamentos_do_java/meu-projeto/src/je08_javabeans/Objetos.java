package je08_javabeans;

public class Objetos {

    public static void main(String[] args) {

        Aluno rafael = new Aluno();

        rafael.setNome("Rafael Simionato");
        System.out.println(rafael.getNome());

        rafael.setIdade(28);
        System.out.println(rafael.getIdade());

    }

}
