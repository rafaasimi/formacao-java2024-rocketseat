package desafio_sistema_livraria;

import java.time.LocalDate;
import java.util.UUID;

public class Livro {

    private final String id;
    private final String titulo;
    private final Autor autor;
    private boolean disponivel;
    private final LocalDate dataCadastro;
    private final LocalDate dataAtualizacao;

    public Livro(String titulo, Autor autor, boolean disponivel) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
        dataCadastro = LocalDate.now();
        dataAtualizacao = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
