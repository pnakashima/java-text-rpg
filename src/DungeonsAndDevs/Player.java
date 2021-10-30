package DungeonsAndDevs;

import java.util.Locale;
import java.util.Scanner;

public class Player extends Character {

    private String gender;
    private String playerClass;
    private String weapon;
    private int weaponDamage;
    private String motivation;
    private String attackText;


    public Player(String name, String gender, String playerClass, int maxDefensePoints, int attackPoints, String weapon, int weaponDamage) {
        super(name, maxDefensePoints, attackPoints);
        this.gender = gender;
        this.playerClass = playerClass;
        this.weapon = weapon;
        this.weaponDamage = weaponDamage;
    }

    @Override
    public int attack(int enemyDefensePoints) {
        int diceDamage = Game.rollDice(20);
        int playerAttack = this.getAttackPoints() + this.getWeaponDamage() + diceDamage;
        if (diceDamage == 1) {
            TextInterface.printText("Você errou seu ataque! O inimigo não sofreu dano algum.");
            return 0;
        } else if (diceDamage == 20) {
            TextInterface.printText("Você acertou um ataque crítico!");
            playerAttack = enemyDefensePoints;
        } else
            playerAttack = (enemyDefensePoints - playerAttack < 0) ? enemyDefensePoints : playerAttack;
        TextInterface.printText(this.attackText + " e causou " + playerAttack + " de dano ao inimigo!");
        return playerAttack;
    }

    @Override
    public int defend() {
        return 0;
    }

    public String getGender() {
        return gender;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public String getWeapon() {
        return weapon;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getAttackText() {
        return attackText;
    }

    public void setAttackText(String classAttackText) {
        String text = "Você atacou " + classAttackText;
        System.out.println("setAttack " + text);
        String weapon = this.weapon.toLowerCase();
        String ammo = "";
        String[] weaponSplit = weapon.split(" e ");
        if (weaponSplit.length > 1) {
            weapon = weaponSplit[0];
            ammo = weaponSplit[1];
            this.attackText = String.format(text, weapon, ammo);
        } else
            this.attackText = String.format(text, weapon);
        ;
    }
}
