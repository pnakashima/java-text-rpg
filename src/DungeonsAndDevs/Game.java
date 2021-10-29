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
        String name = "---";
        while (name.equals("---")) {
            printHeading("Qual o seu nome, aventureiro?");
            name = scanner.nextLine();
            if (confirmChoice(name) == 2) {
                name = "---";
                clearConsole();
            }
        }

        //Gênero do personagem
        String genderMenuTitle = "Escolha o gênero do seu personagem:\n";
        List<String> genderMenu = new ArrayList<>(Arrays.asList(
                "Masculino (+20 de Ataque para Guerreiros e Arqueiros)\n",
                "Feminino (+20 de Ataque para Magas e Estudantes)\n"
        ));
        List<String> genderMenuValues = new ArrayList<>(Arrays.asList("Masculino", "Feminino"));

        GameInteraction playerGenderMenu = new GameInteraction(genderMenuTitle, genderMenu, genderMenuValues);
        List<String> genderChoice = playerGenderMenu.playerChoice();
        String gender = genderChoice.get(1);

        enterToContinue();

        //Classe do personagem
        List<int[]> classOptionAttributes = new ArrayList<>(Arrays.asList(
                new int[]{100, 700},
                new int[]{80, 1000},
                new int[]{120, 600},
                new int[]{70, 1200}
        ));
        List<String> classMenuValues = new ArrayList<>(Arrays.asList("Guerreiro", "Arqueiro", "Mago", "Estudante do SENAI"));

        String classMenuTitle = "Escolha uma classe de combate:";

        List<String> classMenu = new ArrayList<>();
        for (int i = 0; i < classMenuValues.size(); i++) {
            classMenu.add(classMenuValues.get(i) + " (Ataque " + classOptionAttributes.get(i)[0] + " | Defesa: " + classOptionAttributes.get(i)[1] + ")\n");
        }
//        List<String> classMenu = new ArrayList<>(Arrays.asList(
//                "Guerreiro (Ataque " + classOptionAttributes.get(0)[0] + " | Defesa: " + classOptionAttributes.get(0)[1] + ")\n",
//                "Arqueiro (Ataque " + classOptionAttributes.get(1)[0] + " | Defesa: " + classOptionAttributes.get(1)[1] + ")\n",
//                "Mago (Ataque " + classOptionAttributes.get(2)[0] + " | Defesa: " + classOptionAttributes.get(2)[1] + ")\n",
//                "Estudante do SENAI (Ataque " + classOptionAttributes.get(3)[0] + " | Defesa: " + classOptionAttributes.get(3)[1] + ")\n"
//        ));
        List<String[]> weapons = new ArrayList<>(Arrays.asList(
                new String[]{"Espada", "Machado", "Martelo", "Clava"},
                new String[]{"Arco e flecha", "Besta e virote"},
                new String[]{"Cajado"},
                new String[]{"Livro"}
        ));

        GameInteraction playerClassMenu = new GameInteraction(classMenuTitle, classMenu, classMenuValues);
        List<String> classChoice = playerClassMenu.playerChoice();
        int playerClassIndex = Integer.parseInt(classChoice.get(0));
        String playerClass = classChoice.get(1);
        int[] playerAttributes = classOptionAttributes.get(playerClassIndex);
        int attackPoints = playerAttributes[0];
        int maxDefensePoints = playerAttributes[1];
        String[] availableWeapons = weapons.get(playerClassIndex);

        if (gender.equals("Masculino") && (playerClass == "Guerreiro" || playerClass == "Arqueiro"))
            attackPoints += 20;
        if (gender.equals("Feminino") && (playerClass == "Mago" || playerClass == "Estudante do SENAI"))
            attackPoints += 20;

        enterToContinue();

////        //Classe do personagem
//        String playerClass = "";
//        int attackPoints = 0;
//        int maxDefensePoints = 0;
//        while (playerClass.equals("")) {
//            clearConsole();
//            printHeading("Escolha uma classe de combate:");
//            int options = 0;
//            for (PlayerClasses item : PlayerClasses.values()) {
//                options++;
//                System.out.println(options + " - " + item.getPlayerClass());
//            }
//            int input = readInt(options);
//            playerClass = PlayerClasses.values()[input - 1].getPlayerClass();
//            attackPoints = PlayerClasses.values()[input - 1].getAttackPoints();
//            maxDefensePoints = PlayerClasses.values()[input - 1].getMaxDefensePoints();
//            if (confirmChoice(playerClass) == 2)
//                playerClass = "";
//            if (gender.equals("Masculino") && (playerClass == "Guerreiro" || playerClass == "Arqueiro"))
//                attackPoints += 20;
//            if (gender.equals("Feminino") && (playerClass == "Mago" || playerClass == "Estudante do SENAI"))
//                attackPoints += 20;
//        }

        // Arma do personagem
        List<Integer> weaponOptionAttributes = new ArrayList<>(Arrays.asList(25, 20, 15, 10, 20, 15, 20, 50));
        List<String> weaponMenuValues = new ArrayList<>(Arrays.asList("Espada", "Machado", "Martelo", "Clava", "Arco e flecha", "Besta e virote", "Cajado", "Livro"));
        String weaponMenuTitle = "Escolha uma arma:";


        List<String> weaponMenu = new ArrayList<>();
        for (int i = 0; i < classMenuValues.size(); i++) {
            weaponMenu.add(weaponMenuValues.get(i) + " (Dano " + weaponOptionAttributes.get(i) + ")\n");
        }




        GameInteraction playerClassMenu = new GameInteraction(classMenu, classMenuValues);
        List<String> classChoice = playerClassMenu.playerChoice();
        int playerClassIndex = Integer.parseInt(classChoice.get(0));
        String playerClass = classChoice.get(1);
        int[] playerAttributes = classOptionAttributes.get(playerClassIndex);
        int attackPoints = playerAttributes[0];
        int maxDefensePoints = playerAttributes[1];
        String[] availableWeapons = weapons.get(playerClassIndex);

        if (gender.equals("Masculino") && (playerClass == "Guerreiro" || playerClass == "Arqueiro"))
            attackPoints += 20;
        if (gender.equals("Feminino") && (playerClass == "Mago" || playerClass == "Estudante do SENAI"))
            attackPoints += 20;

        enterToContinue();


        //Arma do personagem
        String weapon = "";
        String ammo = "";
        int damage = 0;
        while (weapon.equals("")) {
            clearConsole();
            printHeading("Escolha uma arma:");
            int start = 1000000;
            int end = 0;
            int index = 0;
            for (PlayerWeapons item : PlayerWeapons.values()) {
                index = item.ordinal() + 1;
                if (playerClass.equals(item.getPlayerClass())) {
                    if (index < start)
                        start = index;
                    if (index > end)
                        end = index;
                    System.out.println(index + " - " + item);
                }
            }
            int input = readInt(end);
            weapon = PlayerWeapons.values()[input - 1].getName();
            ammo = PlayerWeapons.values()[input - 1].getAmmo();
            if (!ammo.equals(""))
                weapon = weapon + " e " + ammo;
            damage = PlayerWeapons.values()[input - 1].getDamage();
            if (confirmChoice(weapon) == 2)
                weapon = "";

        }

        Player player = new Player(name, gender, playerClass, maxDefensePoints, attackPoints, weapon, damage);

        clearConsole();
        printHeading("A aventura vai começar!");
        System.out.println("Nome: " + name
                + "\nGênero: " + gender
                + "\nClasse: " + playerClass
                + "\nDefesa: " + maxDefensePoints
                + "\nAtaque: " + attackPoints
                + "\nArma: " + weapon
                + "\nDano da Arma: " + damage);
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


            //Gênero do personagem
            List<String> genderMenu = new ArrayList<>(Arrays.asList(
                    "Escolha o gênero do seu personagem:\n",
                    "Masculino (+20 de Ataque para Guerreiros e Arqueiros)\n",
                    "Feminino (+20 de Ataque para Magas e Estudantes)\n"
            ));
            List<String> genderMenuValues = new ArrayList<>(Arrays.asList("Gêneros", "Masculino", "Feminino"));

            GameInteraction playerGenderMenu = new GameInteraction(genderMenu, genderMenuValues);
            List<String> genderChoice = playerGenderMenu.playerChoice();
            String gender = genderChoice.get(1);

            enterToContinue();

            //Classe do personagem
            List<int[]> classOptionAttributes = new ArrayList<>(Arrays.asList(
                    new int[]{100, 700},
                    new int[]{80, 1000},
                    new int[]{120, 600},
                    new int[]{70, 1200}
            ));
            List<String> classMenu = new ArrayList<>(Arrays.asList(
                    "Escolha uma classe de combate:",
                    "Guerreiro (Ataque " + classOptionAttributes.get(0)[0] + " | Defesa: " + classOptionAttributes.get(0)[1] + ")\n",
                    "Arqueiro (Ataque " + classOptionAttributes.get(1)[0] + " | Defesa: " + classOptionAttributes.get(1)[1] + ")\n",
                    "Mago (Ataque " + classOptionAttributes.get(2)[0] + " | Defesa: " + classOptionAttributes.get(2)[1] + ")\n",
                    "Estudante do SENAI (Ataque " + classOptionAttributes.get(3)[0] + " | Defesa: " + classOptionAttributes.get(3)[1] + ")\n"
            ));
            List<String> classMenuValues = new ArrayList<>(Arrays.asList("Classes de Personagem", "Guerreiro", "Arqueiro", "Mago", "Estudante do SENAI"));
            List<String[]> weapons = new ArrayList<>(Arrays.asList(
                    new String[]{"Armas disponíveis"},
                    new String[]{"Espada", "Machado", "Martelo", "Clava"},
                    new String[]{"Arco e flecha", "Besta e virote"},
                    new String[]{"Cajado"},
                    new String[]{"Livro"}
            ));

            GameInteraction playerClassMenu = new GameInteraction(classMenu, classMenuValues);
            List<String> classChoice = playerClassMenu.playerChoice();
            int playerClassIndex = Integer.parseInt(classChoice.get(0));
            String playerClass = classChoice.get(1);
            int[] playerAttributes = classOptionAttributes.get(playerClassIndex);
            int attackPoints = playerAttributes[0];
            int maxDefensePoints = playerAttributes[1];
            String[] availableWeapons = weapons.get(playerClassIndex);

            if (gender.equals("Masculino") && (playerClass == "Guerreiro" || playerClass == "Arqueiro"))
                attackPoints += 20;
            if (gender.equals("Feminino") && (playerClass == "Mago" || playerClass == "Estudante do SENAI"))
                attackPoints += 20;

//            player = createPlayer();
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
