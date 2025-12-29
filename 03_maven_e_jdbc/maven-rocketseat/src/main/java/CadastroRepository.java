import java.sql.Connection;
import java.util.List;

public class CadastroRepository {
    private Connection conexao;

    public CadastroRepository() {
        conexao = Conexao.getConexao();
    }

    public void salvar(Cadastro cadastro) {
        // Lógica para salvar o cadastro no banco de dados
    }

    public void alterar(Cadastro cadastro) {
        // Lógica para alterar o cadastro no banco de dados
    }

    public void excluir(int idCadastro) {
        // Lógica para excluir o cadastro no banco de dados
    }

    public List<Cadastro> listar() {
        // Lógica para listar o cadastro no banco de dados
        return null;
    }

    public Cadastro buscar(int idCadastro) {
        // Lógica para buscar o cadastro no banco de dados
        return null;
    }


}
