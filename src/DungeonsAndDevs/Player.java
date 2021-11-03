package DungeonsAndDevs;

import java.util.Scanner;

public class Player extends Character {

    private String gender;
    private String playerClassName;
    private String weapon;
    private int weaponDamage;
    private String motivation;
    private String attackText;

    public Player() {
    }

    public String readName() {
        Scanner scanner = new Scanner(System.in);
        boolean nameSet = false;
        String playerName = "";
        while (!nameSet) {
            TextInterface.printTitle("Qual o seu nome, aventureiro(a)?");
            playerName = scanner.nextLine();
            if (TextInterface.confirmChoice(playerName) != 2)
                nameSet = true;
            TextInterface.clearConsole();
        }
        return playerName;
    }

    @Override
    public int attack(int enemyDefensePoints, int enemyHealthPoints) {
        int diceDamage = Game.rollDice(20);
        int playerAttack = this.getAttackPoints() + this.getWeaponDamage() + diceDamage;

        if (Game.gameMode.equals("Difícil"))
            playerAttack = (int) ((double) playerAttack * Game.hard);

        if (diceDamage == 1) {
            TextInterface.printText("Você errou seu ataque! O inimigo não sofreu dano algum.");
            return 0;
        } else if (diceDamage == 20)
            TextInterface.printText("Você acertou um ataque crítico!");
        else
            // Se o ataque não foi crítico nem nulo, subtrai do ataque os pontos de defesa do inimigo
            playerAttack -= enemyDefensePoints;

        // Se o valor do ataque é maior que os pontos de vida do inimigo, o valor do ataque se torna o valor restante de vida do inimigo
        playerAttack = (enemyHealthPoints - playerAttack < 0) ? enemyHealthPoints : playerAttack;

        TextInterface.printText(this.attackText + " e causou " + playerAttack + " de dano ao inimigo!");

        return playerAttack;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlayerClassName() {
        return playerClassName;
    }

    public void setPlayerClassName(String playerClassName) {
        this.playerClassName = playerClassName;
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

    public String getAttackText() {
        return attackText;
    }

    public void setAttackText(String classAttackText) {
        String text = "Você atacou " + classAttackText;
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
