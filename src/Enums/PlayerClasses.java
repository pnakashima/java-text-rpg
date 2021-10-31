package Enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public enum PlayerClasses {
    GUERREIRO("Guerreiro", 100, 700, Map.of("Espada",25,"Machado",20,"Martelo",15,"Clava", 10), "com seu/sua %s"),
    ARQUEIRO("Arqueiro", 80, 1000, Map.of("Arco e flecha",20,"Besta e virote",15), "com seu/sua %s, a/o %s atingiu"),
    MAGO("Mago", 80, 1000, Map.of("Cajado",20), "com seu %s, lançando uma bola de fogo"),
    ESTUDANTE("Estudante do SENAI", 80, 1000, Map.of("Livro",50), "absorvendo energia do %s com uma mão e liberando com a outra");

    private final String className;
    private final int attackPoints;
    private final int maxDefensePoints;
    private Map<String, Integer> weaponsMap;
    private String attackText;

    PlayerClasses(String className, int attackPoints, int maxDefensePoints, Map<String, Integer> weaponsMap, String attackText) {
        this.className = className;
        this.attackPoints = attackPoints;
        this.maxDefensePoints = maxDefensePoints;
        this.weaponsMap = weaponsMap;
        this.attackText = attackText;
    }

    public String getClassName() {
        return className;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getMaxDefensePoints() {
        return maxDefensePoints;
    }

    public Map<String, Integer> getWeaponsMap() {
        return weaponsMap;
    }

    public String getAttackText() {
        return attackText;
    }
}
