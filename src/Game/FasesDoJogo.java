package Game;

public enum FasesDoJogo {
    INTRO("Intro", "A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo, e sob a luz do\n" +
            "crepúsculo você está prestes a entrar na fase final da sua missão. Você olha para o portal à sua frente,\n" +
            "e sabe que a partir desse ponto, sua vida mudará para sempre.\n" +
            "Memórias do caminho percorrido para chegar até aqui invadem sua mente. Você se lembra de todos os inimigos\n" +
            "já derrotados para alcançar o covil do líder maligno. Olha para seu equipamento de combate, já danificado e \n" +
            "desgastado depois de tantas lutas. Você está a um passo de encerrar para sempre esse mal.\n" +
            "Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.\n", true, false);

    private final String nome;
    private final String texto;
    private final boolean escolha;
    private final boolean luta;

    FasesDoJogo(String nome, String texto, boolean escolha, boolean luta) {
        this.nome = nome;
        this.texto = texto;
        this.escolha = escolha;
        this.luta = luta;
    }

    public String getNome() {
        return nome;
    }

    public String getTexto() {
        return texto;
    }

    public boolean isEscolha() {
        return escolha;
    }

    public boolean isLuta() {
        return luta;
    }
}



