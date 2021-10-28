package DungeonsAndDevs;

public enum DrinkPotionChoices {
    BEBER("Beber poção", "Você se sente revigorado para seguir adiante!"),
    CONTINUAR("Jogar poção fora", "Você fica receoso de beber algo produzido pelo inimigo.");

    private final String choice;
    private final String text;

    DrinkPotionChoices(String choice, String text) {
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
