package DungeonsAndDevs;

public enum PlayerClasses {

    GUERREIRO("Guerreiro", 100, 700),
    ARQUEIRO("Arqueiro", 80, 1000),
    MAGO("Mago", 120, 600),
    ESTUDANTE("Estudante do SENAI", 70, 1200);

    private final String playerClass;
    private final Integer attackPoints;
    private final Integer maxDefensePoints;

    PlayerClasses(String playerClass, Integer attackPoints, Integer maxDefensePoints) {
        this.playerClass = playerClass;
        this.attackPoints = attackPoints;
        this.maxDefensePoints = maxDefensePoints;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public Integer getAttackPoints() {
        return attackPoints;
    }

    public Integer getMaxDefensePoints() {
        return maxDefensePoints;
    }


//    public String toString() {
////        return ordinal()+1 + " - " + this.nome + " (Ataque: " + this.pontos_ataque + " / Defesa " + this.pontos_defesa + ")" ;
//        String saida = "%d - %s (Ataque: %d | Defesa: %d)";
//        return String.format(saida, ordinal()+1, this.classe, this.pontos_ataque, this.pontos_defesa);
//    }
}

