package DungeonsAndDevs;

public class Enemy extends Character {

    private int weaponDamage;

    public Enemy(String name, int maxDefensePoints, int attackPoints, int weaponDamage) {
        super(name, maxDefensePoints, attackPoints);
        this.weaponDamage = weaponDamage;
    }

    @Override
    public int attack(int playerDefensePoints) {
        int diceDamage = Game.rollDice(20);
        int enemyAttack = this.getAttackPoints() + this.getWeaponDamage() + diceDamage;
        if (diceDamage == 1) {
            TextInterface.printText("O inimigo errou o ataque! Você não sofreu dano.");
            return 0;
        } else if (diceDamage == 20) {
            TextInterface.printText("O inimigo acertou um ataque crítico!");
            enemyAttack = playerDefensePoints;
        }
        enemyAttack = (playerDefensePoints - enemyAttack < 0) ? playerDefensePoints : enemyAttack;
        playerDefensePoints -= enemyAttack;
        TextInterface.printText("O inimigo atacou! Você sofreu " + enemyAttack + " de dano e agora possui " + playerDefensePoints + " pontos de vida.");
        return enemyAttack;
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
