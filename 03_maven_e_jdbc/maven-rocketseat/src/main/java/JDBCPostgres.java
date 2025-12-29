import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBCPostgres {

    public static void main(String[] args) {

        try {
            // PreparedStatement; Usada para qualquer manipulação dos dados (INSERT, UPDATE, DELETE, SELECT)
            // ResultSet;  Usada para SELECT dos dados

            String url = "jdbc:postgresql://localhost:5432/postgres";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "postgres");
//            props.setProperty("ssl", "true");
            Connection conn = DriverManager.getConnection(url, props);
            System.out.println("Conexão realizada com sucesso!");

            // INSERT INTO public.cadastro (id, nome, idade) VALUES(1, 'Rafael Simionato', 29);
            String instrucaoSQL = "INSERT INTO public.cadastro (nome, idade) VALUES(?, ?)";
            String nome = "Patricia Gomes";
            int idade = 26;

            PreparedStatement pst = conn.prepareStatement(instrucaoSQL);
            pst.setString(1, nome);
            pst.setInt(2, idade);

            pst.execute();
            System.out.println("Cadastro inserido com sucesso!");


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
