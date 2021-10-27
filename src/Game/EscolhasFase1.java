package Game;

public enum EscolhasFase1 {
    SEGUIR("Seguir", "Você caminha, atento a todos os seus sentidos, por vários metros, até visualizar a frente uma fonte de luz, que você imagina ser a chama de uma tocha, vindo de dentro de uma porta aberta.\n"),
    DESISTIR("Desistir", "O medo invade o seu coração e você sente que ainda não está à altura do desafio. Você se volta para a noite lá fora e corre em direção à segurança.");

    private final String nome;
    private final String texto;

    EscolhasFase1(String nome, String texto) {
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
