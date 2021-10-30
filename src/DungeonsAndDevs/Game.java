package DungeonsAndDevs;

import java.util.*;

public class Game {

    public static Scanner scanner = new Scanner(System.in);

    private static String gameMode;
    private static double easy = 0.80; // no modo fácil, os inimigos causam 20% a menos de dano
    private static double hard = 0.90; // no modo difícil, o jogador causa 10% a menos de dano


    public static Player player;

    //Definição dos inimigos
    static Enemy armeiro = new Enemy("Rambo", 500, 80, 10);
    static Enemy alquimista = new Enemy("Paul Rabbit", 500, 80, 10);
    static Enemy chefao = new Enemy("Chefão da Porra Toda", 500, 80, 10);


    public String getGameMode() {
        return gameMode;
    }

    public static void setGameMode() {
        String gameModeTitle = "Escolha um nível de dificuldade:";
        List<String> gameModeMenu = Arrays.asList("Fácil", "Médio", "Difícil");
        List<String> gameModeMenuValues = gameModeMenu;
        TextInterface gameModeChoices = new TextInterface(gameModeTitle, gameModeMenu, gameModeMenuValues);
        gameMode = gameModeChoices.playerChoice();
    }

    public static int rollDice(Integer sides) {
        Random dice = new Random();
        int damage = dice.nextInt(sides + 1) + 1;
        return damage;
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
            TextInterface.printText("Você não estava preparado para a força do inimigo, e decide fugir para que possa tentar novamente em uma próxima vez.");
            return true;
        }
        return false;
    }

    public static Player createPlayer() {

        TextInterface.clearConsole();

        System.out.println("Seja bem vindo(a) à BATALHA FINAL!");

        // Nome do personagem  NAO DEVERIA ESTAR COMO SETNAME NA CLASSE? O MESMO VALE PROS OUTROS ATRIBUTOS
        boolean nameSet = false;
        String playerName = "";
        while (!nameSet) {
            TextInterface.printTitle("Qual o seu nome, aventureiro(a)?");
            playerName = scanner.nextLine();
            if (TextInterface.confirmChoice(playerName) != 2)
                nameSet = true;
            TextInterface.clearConsole();
        }

        //Definição dos gêneros de personagem
        PlayerGender masculino = new PlayerGender("Masculino", 20, Arrays.asList("Guerreiro", "Arqueiro"));
        PlayerGender feminino = new PlayerGender("Feminino", 20, Arrays.asList("Mago", "Estudante do SENAI"));

        //Mapa de gêneros disponíveis
        Map<String, PlayerGender> playerGendersMap = new HashMap<>();
        playerGendersMap.put("Masculino", masculino);
        playerGendersMap.put("Feminino", feminino);

        //Mapa de armas da classe Guerreiro
        Map<String, Integer> warriorWeaponsMap = new HashMap<>();
        warriorWeaponsMap.put("Espada", 25);
        warriorWeaponsMap.put("Machado", 20);
        warriorWeaponsMap.put("Martelo", 15);
        warriorWeaponsMap.put("Clava", 10);

        //Mapa de armas da classe Arqueiro
        Map<String, Integer> archerWeaponsMap = new HashMap<>();
        archerWeaponsMap.put("Arco e flecha", 20);
        archerWeaponsMap.put("Besta e virote", 15);

        //Mapa de armas da classe Mago
        Map<String, Integer> mageWeaponsMap = new HashMap<>();
        mageWeaponsMap.put("Cajado", 20);

        //Mapa de armas da classe Estudante
        Map<String, Integer> studentWeaponsMap = new HashMap<>();
        studentWeaponsMap.put("Livro", 50);

        //Definição das classes de personagem
        PlayerClass guerreiro = new PlayerClass("Guerreiro", 100, 700, warriorWeaponsMap, "com seu/sua %s");
        PlayerClass arqueiro = new PlayerClass("Arqueiro", 80, 1000, archerWeaponsMap, "com seu/sua %s, a/o %s atingiu");
        PlayerClass mago = new PlayerClass("Mago", 80, 1000, mageWeaponsMap, "com seu %s, lançando uma bola de fogo");
        PlayerClass estudante = new PlayerClass("Estudante do SENAI", 80, 1000, studentWeaponsMap, "absorvendo energia do %s com uma mão e liberando com a outra");

        //Mapa de classes disponíveis
        Map<String, PlayerClass> playerClassesMap = new HashMap<>();
        playerClassesMap.put("Guerreiro", guerreiro);
        playerClassesMap.put("Arqueiro", arqueiro);
        playerClassesMap.put("Mago", mago);
        playerClassesMap.put("Estudante do SENAI", estudante);


        TextInterface.clearConsole();

        //Escolha do gênero do personagem
        //Criando array de strings para impressão do menu (genderMenu) e para os valores (nomes) dos gêneros (genderMenuValues)
        List<String> genderMenu = new ArrayList<>();
        List<String> genderMenuValues = new ArrayList<>();
        for (Map.Entry<String, PlayerGender> entry : playerGendersMap.entrySet()) {
            String genderName = entry.getKey();
            PlayerGender playerGender = entry.getValue();
            genderMenu.add(genderName + " (+" + playerGender.getPowerUpPoints() + " pontos de ataque para as classes: " + playerGender.getPowerUpClasses() + ")");
            genderMenuValues.add(genderName);
        }

        //Instanciando e imprimindo o menu de classes de personagem (título, menu, valores)
        String genderMenuTitle = "Escolha o gênero do seu personagem:";
        TextInterface playerGenderMenu = new TextInterface(genderMenuTitle, genderMenu, genderMenuValues);
        String playerGenderName = playerGenderMenu.playerChoice();
        PlayerGender playerGenderClass = playerGendersMap.get(playerGenderName);

        TextInterface.clearConsole();

        //Escolha da Classe do personagem
        //Criando array de strings para impressão do menu (classMenu) e para os valores (nomes) das classes (classMenuValues)
        List<String> classMenu = new ArrayList<>();
        List<String> classMenuValues = new ArrayList<>();
        for (Map.Entry<String, PlayerClass> entry : playerClassesMap.entrySet()) {
            String className = entry.getKey();
            PlayerClass playerClass = entry.getValue();
            classMenu.add(className + " (Ataque " + playerClass.getAttackPoints() + " | Defesa: " + playerClass.getMaxDefensePoints() + ")");
            classMenuValues.add(className);
        }

        //Instanciando e imprimindo o menu de classes de personagem (título, menu, valores)
        String classMenuTitle = "Escolha uma classe de combate:";
        TextInterface playerClassMenu = new TextInterface(classMenuTitle, classMenu, classMenuValues);
        String playerClassName = playerClassMenu.playerChoice();
        PlayerClass playerClass = playerClassesMap.get(playerClassName);
        int attackPoints = playerClass.getAttackPoints();
        int maxDefensePoints = playerClass.getMaxDefensePoints();
        Map<String, Integer> availableWeapons = playerClass.getAvailableWeapons();

        //Aplicando o power-up de acordo com escolha de classe e gênero
        if (playerGenderClass.getPowerUpClasses().contains(playerClassName))
            attackPoints += 20;


        TextInterface.clearConsole();

        // Arma do personagem
        List<String> weaponsMenu = new ArrayList<>();
        List<String> weaponsMenuValues = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : availableWeapons.entrySet()) {
            String weaponName = entry.getKey();
            Integer weaponDamage = entry.getValue();
            weaponsMenu.add(weaponName + " (Dano " + weaponDamage + ")\n");
            weaponsMenuValues.add(weaponName);
        }

        String weaponMenuTitle = "Escolha uma arma:";
        TextInterface playerWeaponMenu = new TextInterface(weaponMenuTitle, weaponsMenu, weaponsMenuValues);
        String playerWeaponName = playerWeaponMenu.playerChoice();
        int weaponDamage = availableWeapons.get(playerWeaponName).intValue();


        Player player = new Player(playerName, playerGenderName, playerClassName, maxDefensePoints, attackPoints, playerWeaponName, weaponDamage);

        //Construindo o texto de ataque
        String classAttackText = playerClass.getAttackText();
        player.setAttackText(classAttackText);

        TextInterface.clearConsole();
        TextInterface.printTitle("A aventura vai começar!");
        System.out.println("Nome: " + playerName
                + "\nGênero: " + playerGenderName
                + "\nClasse: " + playerClassName
                + "\nDefesa: " + maxDefensePoints
                + "\nAtaque: " + attackPoints
                + "\nArma: " + playerWeaponName
                + "\nDano da Arma: " + weaponDamage
                + "\nModo: " + gameMode
        );
        TextInterface.enterToContinue();

        return player;
    }


    public static void startGame() {

        while (true) {
            TextInterface.clearConsole();
            TextInterface.printSeparator(30);
            System.out.println("DUNGEONS AND DEVS");
            System.out.println("Text RPG by Paulo Nakashima");
            TextInterface.printSeparator(30);
            System.out.println("\n\n");

            setGameMode();

            player = createPlayer();

            Story.intro(player);

            if (!Story.corridor())
                break;

            if (!Story.mainRoom(player))
                break;

            if (!Story.rightDoor(player, armeiro))
                break;

            Story.changeArmor(player);

            if (!Story.leftDoor(player, alquimista))
                break;

            Story.drinkPotion(player);

            if (!Story.finalRoom(player, chefao))
                break;

            Story.theEnd(player);
        }
    }

    public static boolean battle(Player player, Enemy enemy) {
        TextInterface.clearConsole();
        Scanner input = new Scanner(System.in);

        String playerName = player.getName();
        String enemyName = enemy.getName();

        TextInterface.printTitle(String.format("Batalha entre %s e %s", playerName, enemyName));
        System.out.println(String.format("%s tem %d pontos de defesa.", playerName, player.getDefensePoints()));
        System.out.println(String.format("%s tem %d pontos de defesa.", enemyName, enemy.getDefensePoints()));

        String playerBattleChoice = "Lutar";
        while ((playerBattleChoice.equals("Lutar")) && (player.getDefensePoints() > 0) && (enemy.getDefensePoints() > 0)) {
            String battleTitle = "Escolha sua ação";
            List<String> battleMenu = Arrays.asList("Lutar", "Fugir");
            List<String> battleMenuValues = battleMenu;
            TextInterface battle = new TextInterface(battleTitle, battleMenu, battleMenuValues);
            playerBattleChoice = battle.playerChoice();

            TextInterface.clearConsole();

            if (playerBattleChoice == "Lutar") {
                int playerAttack = player.attack(enemy.getDefensePoints());
                if (gameMode.equals("Difícil"))
                    playerAttack = (int) ((double) playerAttack * hard);

                enemy.setDefensePoints(enemy.getDefensePoints() - playerAttack);
                if (enemy.getDefensePoints() > 0) {
                    int enemyAttack = player.getDefensePoints();
                    if (gameMode.equals("Fácil"))
                        enemyAttack = (int) ((double) enemyAttack * easy);
                    player.setDefensePoints(player.getDefensePoints() - enemyAttack);
                } else {
                    TextInterface.printTitle(String.format("%s venceu a batalha!", playerName));
                    TextInterface.printText("O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.");
                    TextInterface.enterToContinue();
                    return true;
                }

                if (player.getDefensePoints() <= 0) {
                    TextInterface.printTitle(String.format("%s venceu a batalha!", enemyName));
                    TextInterface.enterToContinue();
                    Game.playerDied();
                    return false;
                }

                System.out.println(String.format("%s tem %d pontos de defesa e %s tem %d pontos de defesa!", playerName, player.getDefensePoints(), enemyName, enemy.getDefensePoints()));

            } else if (playerBattleChoice.equals("Fugir")) {
                if (Game.runAway())
                    return false;
            }
        }
        return true;
    }


}
