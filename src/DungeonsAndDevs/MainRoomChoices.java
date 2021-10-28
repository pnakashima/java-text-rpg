package DungeonsAndDevs;

public enum MainRoomChoices {

    SALTANDO("Saltando", "Você se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala."),
    ANDANDO("Andando", "Você toma cuidado e vai caminhando vagarosamente em direção à luz. Quando você pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta. Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de você, no corredor. Flechas voam da escotilha em sua direção, e você salta para dentro da sala, porém uma delas te acerta na perna."),
    CORRENDO("Correndo", "Você respira fundo e desata a correr em direção à sala. Quando passa pela porta, sente que pisou em uma pedra solta, mas não dá muita importância e segue para dentro da sala, olhando ao redor à procura de inimigos. Não tem ninguém, mas você ouve sons de flechas batendo na pedra atrás de você, e quando se vira, vê várias flechas no chão. Espiando pela porta, você entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto, mas por sorte você entrou correndo e conseguiu escapar desse ataque surpresa.");

    private final String choice;
    private final String text;

    MainRoomChoices(String choice, String text) {
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
