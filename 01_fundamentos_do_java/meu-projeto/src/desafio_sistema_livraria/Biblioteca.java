package desafio_sistema_livraria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private static final List<Livro> livros = new ArrayList<>();
    private static final List<Autor> autores = new ArrayList<>();
    private static final List<Emprestimo> emprestimos = new ArrayList<>();
    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    static {
        popularAutores();
        popularLivros();
        popularEmprestimos();
    }

    public static void main(String[] args) {
        boolean executarMenu = true;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Olá, bem-vindo(a) à Livraria!");
            System.out.println("Deseja ver a lista de livros disponíveis? S (sim) / N (não - sair do programa): ");
            String opcao = scanner.next();

            if (opcao.equalsIgnoreCase("S")) {
                System.out.println("Lista de livros disponíveis para empréstimo:");
                List<Livro> livrosDisponiveis = listarLivrosDisponiveis();
                for (Livro livro : livrosDisponiveis) {
                    System.out.printf("%s - %s - %s%n", livro.getId(), livro.getTitulo(), livro.getAutor().getNome());
                }

                System.out.println("Digite o ID do livro que deseja emprestar: ");
                String idLivro = scanner.next();
                System.out.println("Digite seu nome: ");
                String nomeCliente = scanner.next();

                realizarEmprestimo(idLivro, nomeCliente);

                System.out.println("Deseja realizar outro empréstimo? S (sim) / N (não - sair do programa): ");
                opcao = scanner.next();
                if (opcao.equalsIgnoreCase("S")) {
                    continue;
                }
            }

            executarMenu = false;
        } while (executarMenu);

        scanner.close();
        System.out.println("Obrigado! Volte sempre");
    }

    private static void popularAutores() {
        autores.add(new Autor("Rafael Simionato", LocalDate.of(1996, 10, 7)));
        autores.add(new Autor("Vitor Silva", LocalDate.of(1987, 5, 24)));
        autores.add(new Autor("Lázaro Cavalcante", LocalDate.of(2000, 1, 13)));
        autores.add(new Autor("Amanda Silveira", LocalDate.of(1976, 12, 10)));

        System.out.println("LISTA DE AUTORES POPULADOS");
        for (Autor autor : autores) {
            System.out.printf("%s - %s%n", autor.getNome(), autor.getId());
        }
        System.out.println();
    }

    private static void popularLivros() {
        livros.add(new Livro("A Jornada do Java", autores.get(0), true));
        livros.add(new Livro("Estruturas de Dados em Ação", autores.get(1), true));
        livros.add(new Livro("Design Patterns Essenciais", autores.get(2), true));
        livros.add(new Livro("Programando com Boas Práticas", autores.get(3), true));

        System.out.println("LISTA DE LIVROS POPULADOS");
        for (Livro livro : livros) {
            System.out.printf("%s - %s - %s%n", livro.getId(), livro.getTitulo(), livro.getAutor().getNome());
        }
        System.out.println();
    }

    private static void popularEmprestimos() {
        emprestimos.add(new Emprestimo(livros.get(0), "Carlos Souza", LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 15)));
        emprestimos.add(new Emprestimo(livros.get(1), "Mariana Lima", LocalDate.of(2024, 6, 3))); // dataDevolucao null

        System.out.println("LISTA DE EMPRÉSTIMOS POPULADOS");
        for (Emprestimo emprestimo : emprestimos) {
            String dataEmp = emprestimo.getDataEmprestimo().format(DF);
            String dataDev = emprestimo.getDataDevolucao() != null ? emprestimo.getDataDevolucao().format(DF) : "-";
            System.out.printf("%s - %s - %s - %s - %s%n",
                    emprestimo.getId(),
                    emprestimo.getLivro().getTitulo(),
                    emprestimo.getNomeCliente(),
                    dataEmp,
                    dataDev);
        }
        System.out.println();
    }

    private static List<Livro> listarLivrosDisponiveis() {
        List<Livro> livrosDisponiveis = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                livrosDisponiveis.add(livro);
            }
        }
        return livrosDisponiveis;
    }

    private static boolean realizarEmprestimo(String idLivro, String nomeCliente) {
        for (Livro livro : livros) {
            if (livro.getId().equals(idLivro) && livro.isDisponivel()) {
                livro.setDisponivel(false);
                // registra o empréstimo (dataDevolucao ficará null até a devolução)
                emprestimos.add(new Emprestimo(livro, nomeCliente, LocalDate.now()));
                System.out.println("Empréstimo realizado com sucesso!");
                return true;
            }
        }
        System.out.println("Livro não disponível para empréstimo.");
        return false;
    }
}
