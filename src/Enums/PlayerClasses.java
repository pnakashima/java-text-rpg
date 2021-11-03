package Enums;

import java.util.Map;

public enum PlayerClasses {
    GUERREIRO("Guerreiro", 100, 10, 700, Map.of("Espada", 25, "Machado", 20, "Martelo", 15, "Clava", 10), "com seu/sua %s"),
    ARQUEIRO("Arqueiro", 80, 8, 900, Map.of("Arco e flecha", 20, "Besta e virote", 15), "com seu/sua %s, a/o %s atingiu"),
    MAGO("Mago", 120, 12, 600, Map.of("Cajado", 20), "com seu %s, lançando uma bola de fogo"),
    ESTUDANTE("Estudante do SENAI", 70, 7, 1000, Map.of("Livro", 50), "absorvendo energia do %s com uma mão e liberando com a outra");

    private final String className;
    private final int attackPoints;
    private final int defensePoints;
    private final int maxHealthPoints;
    private Map<String, Integer> weaponsMap;
    private String attackText;

    PlayerClasses(String className, int attackPoints, int defensePoints, int maxHealthPoints, Map<String, Integer> weaponsMap, String attackText) {
        this.className = className;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.maxHealthPoints = maxHealthPoints;
        this.weaponsMap = weaponsMap;
        this.attackText = attackText;
    }

    public String getClassName() {
        return className;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public Map<String, Integer> getWeaponsMap() {
        return weaponsMap;
    }

    public void setWeaponsMap(Map<String, Integer> weaponsMap) {
        this.weaponsMap = weaponsMap;
    }

    public String getAttackText() {
        return attackText;
    }

    public void setAttackText(String attackText) {
        this.attackText = attackText;
    }
}
