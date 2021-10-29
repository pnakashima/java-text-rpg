package DungeonsAndDevs;

import java.util.List;
import java.util.Map;

public class PlayerClass {
    private String className;
    private int attackPoints;
    private int maxDefensePoints;
    private Map<String, Integer> availableWeapons;

    public PlayerClass(String className, int attackPoints, int maxDefensePoints, Map<String, Integer> availableWeapons) {
        this.className = className;
        this.attackPoints = attackPoints;
        this.maxDefensePoints = maxDefensePoints;
        this.availableWeapons = availableWeapons;
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

    public Map<String, Integer> getAvailableWeapons() {
        return availableWeapons;
    }
}
