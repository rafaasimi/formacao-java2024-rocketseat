package je26_java_nio;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class JavaNIO {

    public static void main(String[] args) throws IOException {

        try {

            URL massa = JavaNIO.class.getResource("massa.csv");

            if (massa == null) {
                System.out.println("Massa não encontrada");
            }

            Path path = Paths.get(massa.toURI());

//            byte[] bytesArquivo = Files.readAllBytes(path);
//            String conteudo = new String(bytesArquivo);

            List<String> linhas = Files.readAllLines(path);
            linhas.stream()
                    .skip(1)
                    .forEach(linha -> {
                        System.out.println("Lendo a linha: " + linha);
                        String[] colunas = linha.split(",");

                        String nome = colunas[0];
                        String nascimento = colunas[1];
                        String email = colunas[2];
                        String celular = colunas[3];

                        System.out.println(nome);

                        DateTimeFormatter formatadorBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate data = LocalDate.parse(nascimento);
                        String dataFormatada = data.format(formatadorBR);
                        System.out.println(dataFormatada);

                        System.out.println(email);

                        System.out.println(celular);

                    });


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
