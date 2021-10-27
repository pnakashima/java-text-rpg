package Game;

public enum TiposDeArma {

    ESPADA(25, "Espada", "", "Guerreiro"),
    MACHADO(20, "Machado", "", "Guerreiro"),
    MARTELO(15, "Martelo", "", "Guerreiro"),
    CLAVA(10, "Clava","", "Guerreiro"),
    ARCO(20, "Arco", "flecha", "Arqueiro"),
    BESTA(15, "Besta", "virote", "Arqueiro"),
    CAJADO(20, "Cajado", "", "Mago"),
    LIVRO(50, "Livro", "", "Estudante");

    private Integer dano;
    private String nome;
    private String municao;
    private String classe;

    private TiposDeArma(Integer dano, String nome, String municao, String classe) {
        this.dano = dano;
        this.nome = nome;
        this.municao = municao;
        this.classe = classe;
    }

    public String toString() {
        String saida = (this.municao == "") ? "%d - %s %s" : "%d - %s e %s";
        return String.format(saida, ordinal()+1, this.nome, this.municao);
    }

    public Integer getDano() {
        return dano;
    }

    public void setDano(Integer dano) {
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMunicao() {
        return municao;
    }

    public void setMunicao(String municao) {
        this.municao = municao;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
}

