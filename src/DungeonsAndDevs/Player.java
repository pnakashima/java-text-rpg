package DungeonsAndDevs;

public class Player extends Character {

    private String gender;
    private String playerClass;
    private String weapon;
    private int weaponDamage;
    private String motivation;

    public Player(String name, String gender, String playerClass, int maxDefensePoints, int attackPoints, String weapon, int weaponDamage) {
        super(name, maxDefensePoints, attackPoints);
        this.gender = gender;
        this.playerClass = playerClass;
        this.weapon = weapon;
        this.weaponDamage = weaponDamage;
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }
}
