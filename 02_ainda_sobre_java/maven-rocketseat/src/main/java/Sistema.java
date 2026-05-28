import java.util.List;

public class Sistema {

    public static void main(String[] args) {
        Conexao.conectar();
        CadastroRepository cadastroRepository = new CadastroRepository();

        // Incluir
        Cadastro cadastro = new Cadastro();
        cadastro.setNome("Julie Zorzenon");
        cadastro.setIdade(15);

        cadastroRepository.incluir(cadastro);

        // Alterar
        Cadastro cadastroAlterado = new Cadastro();
        cadastroAlterado.setId(1);
        cadastroAlterado.setNome("Rafael Simionato Zorzenon");
        cadastroAlterado.setIdade(29);

        cadastroRepository.alterar(cadastroAlterado);

        // Excluir
        // cadastroRepository.excluir(7);

        // Listar
        List<Cadastro> listaCadastros = cadastroRepository.listar();
        for (Cadastro cadastroItem : listaCadastros) {
            System.out.println("ID: " + cadastroItem.getId() + " | Nome: " + cadastroItem.getNome() + " | Idade: " + cadastroItem.getIdade());
        }

        // Buscar
        Cadastro buscarCadastro = cadastroRepository.buscar(1);
        if (buscarCadastro != null) {
            System.out.println("Cadastro encontrado: ID: " + buscarCadastro.getId() + " | Nome: " + buscarCadastro.getNome() + " | Idade: " + buscarCadastro.getIdade());
        } else {
            System.out.println("Cadastro não encontrado.");
        }


    }
}
