package DungeonsAndDevs;

public enum CorridorChoices {
    SEGUIR("Seguir", "Você caminha, atento a todos os seus sentidos, por vários metros, até visualizar a frente uma fonte de luz, que você imagina ser a chama de uma tocha, vindo de dentro de uma porta aberta.\n"),
    DESISTIR("Desistir", "O medo invade o seu coração e você sente que ainda não está à altura do desafio. Você se volta para a noite lá fora e corre em direção à segurança.");

    private final String choice;
    private final String text;

    CorridorChoices(String choice, String text) {
        this.choice = choice;
        this.text = text;
    }

    public String toString() {
        String saida = "%d - %s";
        return String.format(saida, ordinal()+1, this.choice);
    }

    public String getChoice() {
        return choice;
    }

    public String getText() {
        return text;
    }
}
