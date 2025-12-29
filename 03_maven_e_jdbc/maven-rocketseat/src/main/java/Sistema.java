public class Sistema {

    public static void main(String[] args) {
        Conexao.conectar();
        CadastroRepository cadastroRepository = new CadastroRepository();

        Cadastro cadastro = new Cadastro();
        cadastro.setNome("Zoe Maria");
        cadastro.setIdade(4);

        cadastroRepository.salvar(cadastro);

    }
}
