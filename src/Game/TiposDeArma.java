package Game;

public enum TiposDeArma {

    ESPADA(25, "espada", "", "guerreiro"),
    MACHADO(20, "machado", "", "guerreiro"),
    MARTELO(15, "martelo", "", "guerreiro"),
    CLAVA(10, "clava","", "guerreiro"),
    ARCO(20, "arco", "flecha", "arqueiro"),
    BESTA(15, "besta", "virote", "arqueiro"),
    CAJADO(20, "cajado", "", "mago"),
    LIVRO(50, "livro", "", "estudante");

    private Integer ataque;
    private String nome;
    private String municao;
    private String classe;

    private TiposDeArma(Integer ataque, String nome, String municao, String classe) {
        this.ataque = ataque;
        this.nome = nome;
        this.municao = municao;
        this.classe = classe;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public String getNome() {
        return nome;
    }

    public String getMunicao() {
        return municao;
    }

    public String getClasse() {
        return classe;
    }
}

