package Game;

public enum ClassesDePersonagem {

    GUERREIRO("Guerreiro",100, 700),
    ARQUEIRO("Arqueiro",80, 1000),
    MAGO("Mago",120, 600),
    ESTUDANTE("Estudante do SENAI",70, 1200);

    private final String nome;
    private final Integer pontos_defesa;
    private final Integer pontos_ataque;

    private ClassesDePersonagem(String nome, Integer pontos_ataque, Integer pontos_defesa) {
        this.nome = nome;
        this.pontos_defesa = pontos_defesa;
        this.pontos_ataque = pontos_ataque;
    }

    public Integer getPontos_defesa() {
        return pontos_defesa;
    }

    public Integer getPontos_ataque() {
        return pontos_ataque;
    }

    public String toString() {
//        return ordinal()+1 + " - " + this.nome + " (Ataque: " + this.pontos_ataque + " / Defesa " + this.pontos_defesa + ")" ;
        String saida = "%d - %s (Ataque: %d | Defesa: %d)";
        return String.format(saida, ordinal()+1, this.nome, this.pontos_ataque, this.pontos_defesa);
    }
}

