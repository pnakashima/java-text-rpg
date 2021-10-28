package DungeonsAndDevs;

public class Enemy extends Character{

    private int weaponDamage;

    public Enemy(String name, int maxDefensePoints, int attackPoints, int weaponDamage) {
        super(name, maxDefensePoints, attackPoints);
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

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
}
