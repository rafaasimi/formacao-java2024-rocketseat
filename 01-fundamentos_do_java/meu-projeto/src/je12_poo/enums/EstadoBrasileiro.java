package je12_poo.enums;

public enum EstadoBrasileiro {

    SAO_PAULO("São Paulo", "SP"),
    RIO_DE_JANEIRO("Rio de Janeiro", "RJ"),
    DISTRITO_FEDERAL("Distrito Federal", "DF"),
    RIO_GRANDE_DO_SUL("Rio Grande do Sul", "RS"),
    MINAS_GERAIS("Minas Gerais", "MG"),;

    private String nome;
    private String sigla;

    private EstadoBrasileiro(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

}
