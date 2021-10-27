package Game;

public enum NiveisDeDificuldade {
    FACIL("Fácil"),
    NORMAL("Normal"),
    DIFICIL("Difícil");

    private final String nome;

    private NiveisDeDificuldade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        String saida = "%d - %s";
        return String.format(saida, ordinal()+1, this.nome);
    }
}
