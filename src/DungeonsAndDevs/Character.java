package DungeonsAndDevs;

public abstract class Character {

    private String name;
    private int maxDefensePoints;
    private int attackPoints;
    private int defensePoints;
    private boolean alive;

    public Character() {
    }

    public Character(String name, int maxDefensePoints, int attackPoints) {
        this.name = name;
        this.maxDefensePoints = maxDefensePoints;
        this.defensePoints = maxDefensePoints;  // personagem começa sempre com energia completa
        this.attackPoints = attackPoints;
        this.alive = true;  // personagem começa sempre vivo
    }



    public abstract int attack(int defensePoints);

    public abstract int defend();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxDefensePoints() {
        return maxDefensePoints;
    }

    public void setMaxDefensePoints(int maxDefensePoints) {
        this.maxDefensePoints = maxDefensePoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }


}
