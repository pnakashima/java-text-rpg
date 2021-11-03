package DungeonsAndDevs;

import Enums.PlayerClasses;
import Enums.PlayerGenders;

import java.util.*;

public class Game {

    public static String gameMode;
    public static double easy = 0.80; // no modo fácil, os inimigos causam 20% a menos de dano
    public static double hard = 0.90; // no modo difícil, o jogador causa 10% a menos de dano

    private static boolean playGame = true;

    public static Player player;

    public static void setGameMode() {
        String gameModeTitle = "Escolha um nível de dificuldade:";
        List<String> gameModeMenu = Arrays.asList("Fácil", "Médio", "Difícil");
        TextInterface gameModeChoices = new TextInterface(gameModeTitle, gameModeMenu);
        int gameModeChoice = gameModeChoices.playerChoice();
        gameMode = gameModeMenu.get(gameModeChoice-1);
    }

    public static int rollDice(Integer sides) {
        Random dice = new Random();
        return dice.nextInt(sides + 1) + 1;
    }

    public static void playerDied() {
        TextInterface.clearConsole();
        TextInterface.printTitle("Você não estava preparado para a força do inimigo...");
        if (player.getMotivation().equals("Vingança"))
            TextInterface.printTitle("Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.");
        else {
            if (player.getGender().equals("Masculino"))
                TextInterface.printTitle("A glória que buscavas não será sua, e a cidade aguarda por seu próximo herói.");
            else
                TextInterface.printTitle("A glória que buscavas não será sua, e a cidade aguarda por sua próxima heroína.");
        }
    }

    public static boolean runAway() {
        int willRun = rollDice(10);
        if (willRun > 5) {
            TextInterface.clearConsole();
            TextInterface.printTitle("Você fugiu...");
            TextInterface.printText("Você não estava preparado para a força do inimigo, e decide fugir para que possa tentar novamente em uma próxima vez.");
            return true;
        }
        TextInterface.printTitle("Você não consegue fugir e continua na batalha!");
        return false;
    }

    // Os inimigos são criados com base nos atributos do jogador
    public static Enemy createEnemy(String enemyName, int playerMaxDefensePoints, int playerAttackPoints, int playerDefensePoints, int playerWeaponDamage) {
        // Os inimigos vão ter de 90 a 110% dos atributos do jogador
        // Gerando um número de 90 a 110
        int random = rollDice(20) + 90;
        double percentage = (double) random / 100;

        int enemyMaxHealthPoints = (int) ((double) playerMaxDefensePoints * percentage);
        int enemyAttackPoints = (int) ((double) playerAttackPoints * percentage);
        int enemyDefensePoints = (int) ((double) playerDefensePoints * percentage);
        int enemyWeaponDamage = (int) ((double) playerWeaponDamage * percentage);

        return new Enemy(enemyName, enemyMaxHealthPoints, enemyAttackPoints, enemyDefensePoints, enemyWeaponDamage);
    }

    public static Player createPlayer() {

        TextInterface.clearConsole();

        Player player = new Player();

        player.setName(player.readName());


        // A partir dos ENUMS, são criados duas listas de strings: uma para impressão do menu na tela, e outra que
        // armazena os valores (nomes) das classes e gêneros.
        // O método playerChoice() da classe TextInterface retorna o número relativo à escolha do jogador, e com este
        // número (índice) eu pego no enum os atributos da classe ou gênero escolhido.


        TextInterface.clearConsole();

        // Escolha do gênero do jogador
        List<String> genderMenu = new ArrayList<>(); // Criando um menu de gêneros para impressão
        List<String> genderMenuValues = new ArrayList<>();  // Criando uma lista com os valores (nomes) dos gêneros
        for (PlayerGenders item : PlayerGenders.values()) {
            genderMenu.add(item.getGenderName() + " (+" + item.getPowerUpPoints() + " pontos de ataque para as classes: " + item.getPowerUpClasses() + ")"); // Adicionando item no menu
            genderMenuValues.add(item.getGenderName());  // Adicionando o gênero na lista de valores
        }
        String genderMenuTitle = "Escolha o gênero do seu personagem:";
        TextInterface playerGenderMenu = new TextInterface(genderMenuTitle, genderMenu, genderMenuValues); //Instanciando o menu de gêneros de personagem (título, menu, valores)
        int playerGenderChoice = playerGenderMenu.playerChoice();
        String playerGenderName = PlayerGenders.values()[playerGenderChoice - 1].getGenderName();

        player.setGender(playerGenderName);
        TextInterface.clearConsole();


        // Escolha da classe do jogador
        List<String> classMenu = new ArrayList<>(); // Criando um menu de classes de jogador para impressão
        List<String> classMenuValues = new ArrayList<>();  // Criando uma lista com os valores (nomes) das classes
        for (PlayerClasses item : PlayerClasses.values()) {
            classMenu.add(item.getClassName() + " (Ataque " + item.getAttackPoints() + " | Defesa: " + item.getDefensePoints() + " | Vida: " + item.getMaxHealthPoints() + ")"); // Adicionando item no menu
            classMenuValues.add(item.getClassName());  // Adicionando o gênero na lista de valores
        }
        String classMenuTitle = "Escolha uma classe de combate:";
        TextInterface playerClassMenu = new TextInterface(classMenuTitle, classMenu, classMenuValues); //Instanciando o menu de classes de personagem (título, menu, valores)
        int playerClassChoice = playerClassMenu.playerChoice();
        String playerClassName = PlayerClasses.values()[playerClassChoice - 1].getClassName();

        int attackPoints = PlayerClasses.values()[playerClassChoice - 1].getAttackPoints();
        int maxHealthPoints = PlayerClasses.values()[playerClassChoice - 1].getMaxHealthPoints();
        int defensePoints = PlayerClasses.values()[playerClassChoice - 1].getDefensePoints();
        Map<String, Integer> availableWeapons = PlayerClasses.values()[playerClassChoice - 1].getWeaponsMap();

        //Aplicando o power-up de acordo com escolha de classe e gênero
        if (PlayerGenders.values()[playerGenderChoice - 1].getPowerUpClasses().contains(playerClassName))
            attackPoints += PlayerGenders.values()[playerGenderChoice - 1].getPowerUpPoints();

        player.setPlayerClassName(playerClassName);
        player.setMaxHealthPoints(maxHealthPoints);
        player.setHealthPoints(maxHealthPoints);
        player.setDefensePoints(defensePoints);
        player.setAttackPoints(attackPoints);
        TextInterface.clearConsole();

        // Arma do personagem
        List<String> weaponsMenu = new ArrayList<>();
        List<String> weaponsMenuValues = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : availableWeapons.entrySet()) {
            String weaponName = entry.getKey();
            Integer weaponDamage = entry.getValue();
            weaponsMenu.add(weaponName + " (Dano " + weaponDamage + ")");
            weaponsMenuValues.add(weaponName);
        }

        String weaponMenuTitle = "Escolha uma arma:";
        TextInterface playerWeaponMenu = new TextInterface(weaponMenuTitle, weaponsMenu, weaponsMenuValues);
        int playerWeaponChoice = playerWeaponMenu.playerChoice();
        String playerWeaponName = weaponsMenuValues.get(playerWeaponChoice - 1);
        int weaponDamage = availableWeapons.get(playerWeaponName);

        player.setWeapon(playerWeaponName);
        player.setWeaponDamage(weaponDamage);


        //Construindo o texto de ataque
        String classAttackText = PlayerClasses.values()[playerClassChoice - 1].getAttackText();
        player.setAttackText(classAttackText);

        TextInterface.clearConsole();

        // Imprimindo o resumo das escolhas
        TextInterface.printTitle("A aventura vai começar!");
        System.out.println("Nome: " + player.getName()
                + "\nGênero: " + playerGenderName
                + "\nClasse: " + playerClassName
                + "\nVida: " + maxHealthPoints
                + "\nAtaque: " + attackPoints
                + "\nDefesa: " + defensePoints
                + "\nArma: " + playerWeaponName
                + "\nDano da Arma: " + weaponDamage
                + "\nModo: " + gameMode
        );
        TextInterface.enterToContinue();

        return player;
    }


    public static void startGame() {

        // Criei este loop while(true) para poder usar o break.
        // Os métodos da classe Story retornam true caso o jogador vença ou siga jogando,
        // e retornam false caso o jogador morra ou desista.
        while (playGame) {
            TextInterface.clearConsole();
            TextInterface.printSeparator(30);
            System.out.println("DUNGEONS AND DEVS");
            System.out.println("Text RPG by Paulo Nakashima");
            TextInterface.printSeparator(30);
            System.out.println("\n\n");

            System.out.println("Seja bem vindo(a) à BATALHA FINAL!\n");

            setGameMode();

            player = createPlayer();

            Story.intro(player);

            if (!Story.corridor())
                break;

            if (!Story.mainRoom(player))
                break;

            Enemy armeiro = createEnemy("Rambo", player.getHealthPoints(), player.getAttackPoints(), player.getDefensePoints(), player.getWeaponDamage());
            if (!Story.rightDoor(player, armeiro))
                break;

            Story.changeArmor(player);

            Enemy alquimista = createEnemy("Paul Rabbit", player.getHealthPoints(), player.getAttackPoints(), player.getDefensePoints(), player.getWeaponDamage());
            if (!Story.leftDoor(player, alquimista))
                break;

            Story.drinkPotion(player);

            Enemy chefao = createEnemy("Lucifer", player.getHealthPoints(), player.getAttackPoints(), player.getDefensePoints(), player.getWeaponDamage());
            if (!Story.finalRoom(player, chefao))
                break;

            Story.theEnd(player);

            String playAgainTitle = "Deseja jogar novamente?";
            List<String> playAgainMenu = Arrays.asList("Sim", "Não");
            TextInterface playAgainChoices = new TextInterface(playAgainTitle, playAgainMenu);

            if (playAgainChoices.playerChoice() == 2)
                playGame = false;
        }
    }

    public static boolean battle(Player player, Enemy enemy) {
        TextInterface.clearConsole();

        String playerName = player.getName();
        String enemyName = enemy.getName();

        TextInterface.printTitle(String.format("Batalha entre %s e %s", playerName, enemyName));
        System.out.println(String.format("%s tem %d pontos de vida.", playerName, player.getHealthPoints()));
        System.out.println(String.format("%s tem %d pontos de vida.", enemyName, enemy.getHealthPoints()));

        String battleTitle = "Escolha sua ação";
        List<String> battleMenu = Arrays.asList("Lutar", "Fugir");
        TextInterface battleChoices = new TextInterface(battleTitle, battleMenu);

        int playerBattleChoice = 1;

        while ((playerBattleChoice == 1) && (player.getHealthPoints() > 0) && (enemy.getHealthPoints() > 0)) {

            playerBattleChoice = battleChoices.playerChoice();

            TextInterface.clearConsole();

            // Se a escolha é lutar:
            if (playerBattleChoice == 1) {

                // Jogador ataca
                int playerAttack = player.attack(enemy.getDefensePoints(), enemy.getHealthPoints());
                enemy.setHealthPoints(enemy.getHealthPoints() - playerAttack);

                // Se o inimigo não morreu, ele ataca
                if (enemy.getHealthPoints() > 0) {
                    int enemyAttack = enemy.attack(player.getDefensePoints(), player.getHealthPoints());
                    player.setHealthPoints(player.getHealthPoints() - enemyAttack);
                } else { // Se o inimigo morreu, imprime mensagem de vitória e retorna true
                    TextInterface.printTitle(String.format("%s venceu a batalha!", playerName));
                    TextInterface.printText("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");
                    TextInterface.enterToContinue();
                    return true;
                }

                // Se o jogador morreu, imprime mensagem de derrota através do método playerDied() e retorna falso
                if (player.getHealthPoints() <= 0) {
                    TextInterface.printTitle(String.format("%s venceu a batalha!", enemyName));
                    TextInterface.enterToContinue();
                    Game.playerDied();
                    return false;
                }

                System.out.println(String.format("%s tem %d pontos de vida e %s tem %d pontos de vida!", playerName, player.getHealthPoints(), enemyName, enemy.getHealthPoints()));

                // Se a escolha é fugir, executa o método runAway(), que vai dizer se o jogador consegue ou não fugir.
                // A chance de fuga é de 50% e o método retorna true caso o jogador consiga fugir, e falso caso contrário.
            } else if (playerBattleChoice == 2) {
                if (Game.runAway())
                    return false; // Se o jogador conseguir fugir, o método battle() retorna falso.
                // Se não conseguir fugir, continua na batalha
                playerBattleChoice = 1;
            }
        }
        return true;
    }

    public static void printPreBattle(Player player, Enemy enemy) {
        System.out.println("\n" + player.getName() + "\t  x  \t" + enemy.getName()
                + "\n" + player.getHealthPoints() + "\t\t Vida\t\t" + enemy.getHealthPoints()
                + "\n" + player.getAttackPoints() + "\t\tAtaque\t\t" + enemy.getAttackPoints()
                + "\n" + player.getDefensePoints() + "\t\tDefesa\t\t" + enemy.getDefensePoints()
                + "\n" + player.getWeaponDamage() + "\t\t Arma\t\t" + enemy.getWeaponDamage()
        );
    }


}
