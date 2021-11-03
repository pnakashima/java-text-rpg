package DungeonsAndDevs;

public class Enemy extends Character {

    private int weaponDamage;

    public Enemy(String name, int maxHealthPoints, int attackPoints, int defensePoints, int weaponDamage) {
        super(name, maxHealthPoints, attackPoints, defensePoints);
        this.weaponDamage = weaponDamage;
    }

    @Override
    public int attack(int playerDefensePoints, int playerHealthPoints) {
        int diceDamage = Game.rollDice(20);
        int enemyAttack = this.getAttackPoints() + this.getWeaponDamage() + diceDamage;

        if (Game.gameMode.equals("Fácil"))
            enemyAttack = (int) ((double) enemyAttack * Game.easy);

        if (diceDamage == 1) {
            TextInterface.printText("O inimigo errou o ataque! Você não sofreu dano.");
            return 0;
        } else if (diceDamage == 20)
            TextInterface.printText("O inimigo acertou um ataque crítico!");
        else
            // Se o ataque não foi crítico nem nulo, subtrai do ataque os pontos de defesa do jogador
            enemyAttack -= playerDefensePoints;

        // Se o valor do ataque é maior que os pontos de vida do jogador, o valor do ataque se torna o valor restante de vida do jogador
        enemyAttack = (playerHealthPoints - enemyAttack < 0) ? playerHealthPoints : enemyAttack;

        playerHealthPoints -= enemyAttack;
        TextInterface.printText("O inimigo atacou! Você sofreu " + enemyAttack + " de dano e agora possui " + playerHealthPoints + " pontos de vida.");

        return enemyAttack;
    }


    public int getWeaponDamage() {
        return weaponDamage;
    }

}
