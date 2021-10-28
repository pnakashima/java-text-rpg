package Game;

public enum EscolhasFase3 {
    PEGAR("Pegar", "Você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas, que estavam danificadas, pelas peças de armaduras existentes na sala. De armadura nova, você se sente mais protegido para os desafios à sua frente."),
    CONTINUAR("Continuar", "Você decide que não precisa utilizar nada que venha das mãos do inimigo.");

    private final String nome;
    private final String texto;

    EscolhasFase3(String nome, String texto) {
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
