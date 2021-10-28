package DungeonsAndDevs;

public enum ChangeArmorChoices {
    PEGAR("Trocar armadura", "Você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas, que estavam danificadas, pelas peças de armaduras existentes na sala. De armadura nova, você se sente mais protegido para os desafios à sua frente."),
    CONTINUAR("Continuar com minha armadura", "Você decide que não precisa utilizar nada que venha das mãos do inimigo.");

    private final String choice;
    private final String text;

    ChangeArmorChoices(String choice, String text) {
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
