import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CadastroRepository {
    private Connection conexao;

    public CadastroRepository() {
        conexao = Conexao.getConexao();
    }

    public void incluir(Cadastro cadastro) {
        try {
            String instrucaoSQL = "INSERT INTO public.cadastro (nome, idade) VALUES(?,?)";

            PreparedStatement pst = conexao.prepareStatement(instrucaoSQL);
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());
            pst.execute();

            System.out.println("Cadastro incluído com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alterar(Cadastro cadastro) {
        try {
            String instrucaoSQL = "UPDATE public.cadastro SET nome=?, idade=? WHERE id=?";

            PreparedStatement pst = conexao.prepareStatement(instrucaoSQL);
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());
            pst.setInt(3, cadastro.getId());
            pst.execute();

            System.out.println("Cadastro alterado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(int idCadastro) {
        try {
            String instrucaoSQL = "DELETE FROM public.cadastro WHERE id=?";

            PreparedStatement pst = conexao.prepareStatement(instrucaoSQL);
            pst.setInt(1, idCadastro);
            pst.execute();

            System.out.println("Cadastro excluído com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cadastro> listar() {
        List<Cadastro> listaCadastros = new ArrayList<>();

        try {
            String instrucaoSQL = "SELECT * FROM public.cadastro";

            PreparedStatement pst = conexao.prepareStatement(instrucaoSQL);
            ResultSet result = pst.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String nome = result.getString("nome");
                int idade = result.getInt("idade");

                Cadastro cadastro = new Cadastro();
                cadastro.setId(id);
                cadastro.setNome(nome);
                cadastro.setIdade(idade);

                listaCadastros.add(cadastro);
            }

            System.out.println("Cadastro excluído com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaCadastros;
    }

    public Cadastro buscar(int idCadastro) {
        Cadastro cadastro = null;

        try {
            String instrucaoSQL = "SELECT * FROM public.cadastro WHERE id=?";

            PreparedStatement pst = conexao.prepareStatement(instrucaoSQL);
            pst.setInt(1, idCadastro);
            ResultSet result = pst.executeQuery();

            if (result.next()) {
                cadastro = new Cadastro();

                int id = result.getInt("id");
                String nome = result.getString("nome");
                int idade = result.getInt("idade");

                cadastro.setId(id);
                cadastro.setNome(nome);
                cadastro.setIdade(idade);

            }

            System.out.println("Cadastro excluído com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cadastro;
    }


}
