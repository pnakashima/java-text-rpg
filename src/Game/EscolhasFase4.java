package Game;

public enum EscolhasFase4 {
    BEBER("Beber", "Você se sente revigorado para seguir adiante!"),
    CONTINUAR("Continuar", "Você fica receoso de beber algo produzido pelo inimigo.");

    private final String nome;
    private final String texto;

    EscolhasFase4(String nome, String texto) {
        this.nome = nome;
        this.texto = texto;
    }

    public String toString() {
        String saida = "%d - %s";
        return String.format(saida, ordinal()+1, this.nome);
    }

    public String getNome() {
        return nome;
    }

    public String getTexto() {
        return texto;
    }
}
