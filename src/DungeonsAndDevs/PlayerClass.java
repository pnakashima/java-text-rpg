package DungeonsAndDevs;

import java.util.Map;



public class PlayerClass {
    private String className;
    private int attackPoints;
    private int defensePoints;
    private int maxHealthPoints;
    private Map<String, Integer> availableWeapons;
    private String attackText;


    public PlayerClass(String className, int attackPoints, int defensePoints, int maxHealthPoints, Map<String, Integer> availableWeapons, String attackText) {
        this.className = className;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.maxHealthPoints = maxHealthPoints;
        this.availableWeapons = availableWeapons;
        this.attackText = attackText;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public Map<String, Integer> getAvailableWeapons() {
        return availableWeapons;
    }

    public void setAvailableWeapons(Map<String, Integer> availableWeapons) {
        this.availableWeapons = availableWeapons;
    }

    public String getAttackText() {
        return attackText;
    }

    public void setAttackText(String attackText) {
        this.attackText = attackText;
    }
}
