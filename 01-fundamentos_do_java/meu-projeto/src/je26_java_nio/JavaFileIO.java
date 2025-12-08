package je26_java_nio;

import java.io.File;
import java.io.IOException;

public class JavaFileIO {

    public static void main(String[] args) throws IOException {

        File diretorio = new File("C:\\rocketseat\\curso-java");

        if (!diretorio.exists()) {
            System.out.println("O diretório não existe!");
            System.out.println("Criando o diretório...");
            // diretorio.mkdir(); -> Para diretórios de apenas 1 nível
            diretorio.mkdirs(); // -> Para diretórios aninhados com 2 ou mais níveis
        }

        try {
            File arquivo = new File(diretorio, "aula-java.txt");
            System.out.println("O arquivo não existe!");
            System.out.println("Criando o arquivo...");
            arquivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
