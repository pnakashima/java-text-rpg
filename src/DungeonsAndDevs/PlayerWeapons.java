package DungeonsAndDevs;

public class PlayerWeapons {

    private String weaponName;
    private int weaponDamage;

    PlayerWeapons(String weaponName, int weaponDamage) {
        this.weaponName = weaponName;
        this.weaponDamage = weaponDamage;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }
}

