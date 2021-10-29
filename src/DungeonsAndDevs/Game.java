package DungeonsAndDevs;

import java.util.*;

public class Game {

    static Scanner scanner = new Scanner(System.in);

    static Player player;

    static Enemy armeiro = new Enemy("Rambo", 500, 80, 10);

    static Enemy alquimista = new Enemy("Bruxa do 71", 500, 80, 10);

    static Enemy chefao = new Enemy("Chefão da Porra Toda", 500, 80, 10);


    public static boolean isRunning = true;

//    public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest"};
//
//    public static String[] enemies = {"Ogre", "Ogre", "Goblin", "Goblin", "Stone Elemental"};
//
//    public static int place = 0, act = 1;
//    public static String[] places = {"Everlasting Mountains", "Haunted Landlines", "Castle of the Evil Emperor", "Throne Room"};


    public static int readInt(int options) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        while (input < 1 || input > options) {
            System.out.println("Digite sua escolha:");
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                input = 0;
                System.out.println("Digite um número entre as opções!");
            }
        }
        return input;
    }

    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    public static void enterToContinue() {
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }

    public static int confirmChoice(String choice) {
//        clearConsole();
        printHeading("Sua escolha é: " + choice.toUpperCase() + ".\nDeseja continuar?");
        System.out.println("1 - Sim!");
        System.out.println("2 - Não, quero trocar de escolha.");
        int input = readInt(2);
        return input;
    }

    public static int rollDice(Integer sides, boolean critic) {
        Random dice = new Random();
        int damage = dice.nextInt(sides + 1) + 1;
        if (critic) {
            if (damage == sides) {
                System.out.println("DANO CRÍTICO!!!");
                damage = 1000;
            }
            if (damage == 1) {
                System.out.println("ERROUUUUUUUUU!!!");
                damage = 0;
            }
        }
        return damage;
    }

    public static void playerDied() {
        clearConsole();
        printHeading("You died...");
    }

    public static void runAway() {
        clearConsole();
        printHeading("Você correu....");
    }

    public static Player createPlayer() {
        // Nome do personagem
        boolean nameSet = false;
        String playerName = "";
        while (!nameSet) {
            printHeading("Qual o seu nome, aventureiro?");
            playerName = scanner.nextLine();
            if (confirmChoice(playerName) != 2)
                nameSet=true;
        }

        clearConsole();

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
        PlayerClass guerreiro = new PlayerClass("Guerreiro", 100, 700, warriorWeaponsMap);
        PlayerClass arqueiro = new PlayerClass("Arqueiro", 80, 1000, archerWeaponsMap);
        PlayerClass mago = new PlayerClass("Mago", 80, 1000, mageWeaponsMap);
        PlayerClass estudante = new PlayerClass("Estudante do SENAI", 80, 1000, studentWeaponsMap);

        //Mapa de classes disponíveis
        Map<String, PlayerClass> playerClassesMap = new HashMap<>();
        playerClassesMap.put("Guerreiro", guerreiro);
        playerClassesMap.put("Arqueiro", arqueiro);
        playerClassesMap.put("Mago", mago);
        playerClassesMap.put("Estudante do SENAI", estudante);


        //Escolha do gênero do personagem
        //Criando array de strings para impressão do menu (genderMenu) e para os valores (nomes) dos gêneros (genderMenuValues)
        List<String> genderMenu = new ArrayList<>();
        List<String> genderMenuValues = new ArrayList<>();
        for (Map.Entry<String, PlayerGender> entry : playerGendersMap.entrySet()) {
            String genderName = entry.getKey();
            PlayerGender playerGender = entry.getValue();
            genderMenu.add(genderName + " (+" + playerGender.getPowerUpPoints() + " pontos de ataque para as classes: " + playerGender.getPowerUpClasses() + ")\n");
            genderMenuValues.add(genderName);
        }

        //Instanciando e imprimindo o menu de classes de personagem (título, menu, valores)
        String genderMenuTitle = "Escolha o gênero do seu personagem:";
        GameInteraction playerGenderMenu = new GameInteraction(genderMenuTitle, genderMenu, genderMenuValues);
        String playerGenderName = playerGenderMenu.playerChoice();
        PlayerGender playerGenderClass = playerGendersMap.get(playerGenderName);

        enterToContinue();

        //Escolha da Classe do personagem
        //Criando array de strings para impressão do menu (classMenu) e para os valores (nomes) das classes (classMenuValues)
        List<String> classMenu = new ArrayList<>();
        List<String> classMenuValues = new ArrayList<>();
        for (Map.Entry<String, PlayerClass> entry : playerClassesMap.entrySet()) {
            String className = entry.getKey();
            PlayerClass playerClass = entry.getValue();
            classMenu.add(className + " (Ataque " + playerClass.getAttackPoints() + " | Defesa: " + playerClass.getMaxDefensePoints() + ")\n");
            classMenuValues.add(className);
        }

        //Instanciando e imprimindo o menu de classes de personagem (título, menu, valores)
        String classMenuTitle = "Escolha uma classe de combate:";
        GameInteraction playerClassMenu = new GameInteraction(classMenuTitle, classMenu, classMenuValues);
        String playerClassName = playerClassMenu.playerChoice();
        PlayerClass playerClass = playerClassesMap.get(playerClassName);
        int attackPoints = playerClass.getAttackPoints();
        int maxDefensePoints = playerClass.getMaxDefensePoints();
        Map<String, Integer> availableWeapons = playerClass.getAvailableWeapons();

        //Aplicando o power-up de acordo com escolha de classe e gênero
        if (playerGenderClass.getPowerUpClasses().contains(playerClassName))
            attackPoints += 20;

        enterToContinue();

        // Arma do personagem

        List<String> weaponsMenu = new ArrayList<>();
        List<String> weaponsMenuValues = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : availableWeapons.entrySet()) {
            String weaponName = entry.getKey();
            Integer weaponDamage = entry.getValue();
            weaponsMenu.add(weaponName + " (Dano " + weaponDamage  + ")\n");
            weaponsMenuValues.add(weaponName);
        }

        String weaponMenuTitle = "Escolha uma arma:";
        GameInteraction playerWeaponMenu = new GameInteraction(weaponMenuTitle, weaponsMenu, weaponsMenuValues);
        String playerWeaponName = playerWeaponMenu.playerChoice();
        int weaponDamage = availableWeapons.get(playerWeaponName).intValue();


        enterToContinue();

        Player player = new Player(playerName, playerGenderName, playerClassName, maxDefensePoints, attackPoints, playerWeaponName, weaponDamage);

        clearConsole();
        printHeading("A aventura vai começar!");
        System.out.println("Nome: " + playerName
                + "\nGênero: " + playerGenderName
                + "\nClasse: " + playerClassName
                + "\nDefesa: " + maxDefensePoints
                + "\nAtaque: " + attackPoints
                + "\nArma: " + playerWeaponName
                + "\nDano da Arma: " + weaponDamage);
        enterToContinue();

        return player;
    }


    public static void startGame() {

        while (isRunning) {
            clearConsole();
            printSeparator(40);
            System.out.println("DUNGEONS AND DEVS");
            System.out.println("Text RPG by Paulo Nakashima");
            printSeparator(40);

            player = createPlayer();
//
//            Story.intro(player);
//
//            if (!Story.corridor())
//                break;
//
//            if (!Story.mainRoom(player))
//                break;
//
//            if (!Story.rightDoor(player, armeiro))
//                break;
//
//            Story.changeArmor(player);
//
//            if (!Story.leftDoor(player, alquimista))
//                break;
//
//            Story.drinkPotion(player);
//
//            if (!Story.finalRoom(player, chefao))
//                break;


        }
    }

    public static int battle(Player player, Enemy enemy) {
        Scanner input = new Scanner(System.in);

        String playerName = player.getName();
        String enemyName = enemy.getName();
        int playerAttack = player.getAttackPoints() + player.getWeaponDamage();
        int enemyAttack = enemy.getAttackPoints() + enemy.getWeaponDamage();
        int totalDamage = 0;

        System.out.println(String.format("Início da luta entre %s e %s", playerName, enemyName));
        System.out.println(String.format("Herói %s tem %d pontos de defesa e %d pontos de ataque.", playerName, player.getDefensePoints(), playerAttack));
        System.out.println(String.format("Inimigo %s tem %d pontos de defesa e %d pontos de ataque.", enemyName, enemy.getDefensePoints(), enemyAttack));
        int choice = 0;
        int diceDamage = 0;
        while ((choice != 2) && (player.getDefensePoints() > 0) && (enemy.getDefensePoints() > 0)) {
            System.out.println(String.format("Escolha sua ação %s:", playerName));
            System.out.println("1 - Lutar");
            System.out.println("2 - Fugir");
            choice = readInt(2);
            if (choice == 1) {
//                System.out.println("Começando Loop:");
                diceDamage = rollDice(20, true);
                totalDamage = playerAttack + diceDamage;
//                dano = ataqueHeroi + DungeonsAndDevs.rolarDado(20, true);
                System.out.println("dano heroi: " + diceDamage);
                if (diceDamage == 0) {
                    System.out.println("Você errou seu ataque! O inimigo não sofreu dano algum.");
                } else {
                    enemy.setDefensePoints(enemy.getDefensePoints() - totalDamage);
                    System.out.println(String.format("%s ataca e tira %d pontos de defesa de %s", playerName, totalDamage, enemyName));
                }
                if (enemy.getDefensePoints() > 0) {
                    diceDamage = rollDice(20, true);
                    totalDamage = enemyAttack + diceDamage;
//                    dano = ataqueInimigo + DungeonsAndDevs.rolarDado(20, true);
                    System.out.println("dano vilao: " + diceDamage);
                    if (diceDamage == 0) {
                        System.out.println("O inimigo errou o ataque! Você não sofreu dano.");
                    } else {
                        player.setDefensePoints(player.getDefensePoints() - totalDamage);
                        System.out.println(String.format("%s ataca e tira %d pontos de defesa de %s", enemyName, totalDamage, playerName));
                    }

                }
                System.out.println(String.format("%s tem %d pontos de defesa e %s tem %d pontos de defesa!", playerName, player.getDefensePoints(), enemyName, enemy.getDefensePoints()));
                // Escolheu fugir
            } else if (choice == 2) {
                isRunning = false;
                return 0;
            }
            // Inimigo venceu
            if (player.getDefensePoints() <= 0) {
                System.out.println(String.format("%s venceu a batalha!", enemyName));
                return -1;
            }
            // Jogador venceu
            if (enemy.getDefensePoints() <= 0) {
                System.out.println(String.format("%s venceu a batalha!", playerName));
            }
        }

        return 1;
    }


}
