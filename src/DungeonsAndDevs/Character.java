package DungeonsAndDevs;

public abstract class Character {

    private String name;
    private int maxHealthPoints;
    private int healthPoints;
    private int attackPoints;
    private int defensePoints;

    public Character() {
    }

    public Character(String name, int maxHealthPoints, int attackPoints, int defensePoints) {
        this.name = name;
        this.maxHealthPoints = maxHealthPoints;
        this.healthPoints = maxHealthPoints;  // personagem começa sempre com energia completa
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
    }

    public abstract int attack(int defensePoints, int healthPoints);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
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
}
