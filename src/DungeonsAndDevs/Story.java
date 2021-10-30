package DungeonsAndDevs;

public class Story {

    public static void intro(Player player) {
        TextInterface.printTitle("Dungeons and Devs - A Batalha Final");
        System.out.println("A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo, e sob a luz do\n" +
                "crepúsculo você está prestes a entrar na fase final da sua missão. Você olha para o portal à sua frente,\n" +
                "e sabe que a partir desse ponto, sua vida mudará para sempre.\n" +
                "Memórias do caminho percorrido para chegar até aqui invadem sua mente. Você se lembra de todos os inimigos\n" +
                "já derrotados para alcançar o covil do líder maligno. Olha para seu equipamento de combate, já danificado e \n" +
                "desgastado depois de tantas lutas. Você está a um passo de encerrar para sempre esse mal.\n" +
                "Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.\n");



        int motivation = 0;
        while (motivation == 0) {
            TextInterface.printTitle("Escolha sua motivação para invadir a caverna do inimigo e derrotá-lo:");
            int options = 0;
            for (PlayerMotivations item : PlayerMotivations.values()) {
                options++;
                System.out.println(item);
            }
            motivation = TextInterface.readInt(options);
            if (TextInterface.confirmChoice(PlayerMotivations.values()[motivation - 1].getName()) == 2) {
                motivation = 0;
                TextInterface.clearConsole();
            }
        }

        TextInterface.clearConsole();
        System.out.println(PlayerMotivations.values()[motivation - 1].getText1());
        TextInterface.enterToContinue();

        player.setMotivation(motivation - 1);
    }


    public static boolean corridor() {
        TextInterface.clearConsole();
        TextInterface.printTitle("O Corredor da Morte");
        System.out.println("Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas, suas\n" +
                "mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado. Você avança pelo portal.\n" +
                "A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas. À sua frente, só é" +
                "possível perceber que você se encontra em um corredor extenso. Você só pode ir à frente, ou desistir.\n");

        int choice = 0;
        while (choice == 0) {
            int options = 0;
            for (CorridorChoices item : CorridorChoices.values()) {
                System.out.println(item);
                options++;
            }
            choice = TextInterface.readInt(options);
            if (TextInterface.confirmChoice(CorridorChoices.values()[choice - 1].getChoice()) == 2)
                choice = 0;
        }
        if (CorridorChoices.values()[choice - 1].getChoice().equals("Desistir")) {
            Game.isRunning = false;
            System.out.println(CorridorChoices.values()[choice - 1].getText());
            return false;
        }
        TextInterface.clearConsole();
        System.out.println(CorridorChoices.values()[choice - 1].getText());
        return true;
    }

    public static boolean mainRoom(Player player) {
        System.out.println("Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha, e pondera sobre como passar pela porta.\n");

        int choice = 0;
        while (choice == 0) {
            int options = 0;
            for (MainRoomChoices item : MainRoomChoices.values()) {
                System.out.println(item);
                options++;
            }
            choice = TextInterface.readInt(options);
            if (TextInterface.confirmChoice(MainRoomChoices.values()[choice - 1].getChoice()) == 2) {
                choice = 0;
            }
        }
        System.out.println(MainRoomChoices.values()[choice - 1].getText());
        if (MainRoomChoices.values()[choice - 1].getChoice().equals("Andando")) {
            int damage = Game.rollDice(10, false);
            System.out.println("TOMOU DANO DE " + damage);
            player.setDefensePoints(player.getDefensePoints() - damage);
            if (player.getDefensePoints() <= 0) {
                Game.playerDied();
                return false;
            }
        }

        System.out.println("Você se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede. Uma delas " +
                "foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas. A porta à sua " +
                "frente é a maior das quatro, com inscrições em seu entorno em uma língua que você não sabe ler, mas " +
                "reconhece como sendo a língua antiga utilizada pelo inimigo. Você se aproxima da porta e percebe que " +
                "ela está trancada por duas fechaduras douradas, e você entende que precisará primeiro derrotar o que " +
                "estiver nas outras duas portas laterais, antes de conseguir enfrentar o líder.\n" +
                "\n" +
                "Você se dirige para a porta à direita.\n");

        TextInterface.enterToContinue();
        return true;
    }

    public static boolean rightDoor(Player player, Enemy enemy) {

        System.out.println("Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada. Segura " +
                "com mais força sua arma com uma mão, enquanto empurra a porta com a outra. Ao entrar, você se depara " +
                "com uma sala espaçosa, com vários equipamentos de batalha pendurados nas paredes e dispostos em " +
                "armários e mesas. Você imagina que este seja o arsenal do inimigo, onde estão guardados os equipamentos " +
                "que seus soldados utilizam quando saem para espalhar o terror nas cidades e vilas da região.\n" +
                "\n" +
                "Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar para " +
                "trás. Ali, de pé entre você e a porta fechada, bloqueando o caminho do seu destino, está um dos capitães " +
                "do inimigo. Um orque horrendo, de armadura, capacete e espada em punho, em posição de combate. Ele avança em sua direção.\n");

        int result = Game.battle(player, enemy);

        if (result == 0) {
            Game.runAway();
            return false;
        } else if (result == -1) {
            Game.playerDied();
            return false;
        } else {
            TextInterface.enterToContinue();
            return true;
        }
    }

    public static void changeArmor(Player player) {

        System.out.println("Após derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados, e olha em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.\n");

        int choice = 0;
        while (choice == 0) {
            int options = 0;
            for (ChangeArmorChoices item : ChangeArmorChoices.values()) {
                System.out.println(item);
                options++;
            }
            choice = TextInterface.readInt(options);
            if (TextInterface.confirmChoice(ChangeArmorChoices.values()[choice-1].getChoice())==2) {
                choice = 0;
            }
        }
        System.out.println(ChangeArmorChoices.values()[choice - 1].getText());
        if (ChangeArmorChoices.values()[choice - 1].getChoice().equals("Trocar armadura")) {
            System.out.println("Recuperou 50 de defesa");
            player.setDefensePoints(player.getDefensePoints() + 50);
        }

        System.out.println("Em uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do líder inimigo. Você pega a chave e guarda numa pequena bolsa que leva presa ao cinto.\n" +
                "\n");

        TextInterface.enterToContinue();
    }

    public static boolean leftDoor(Player player, Enemy enemy) {
        System.out.println("Você retorna à sala anterior e se dirige à porta da esquerda. Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada. Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra. Ao entrar, você se depara com uma sala parecida com a do arsenal, mas em vez de armaduras, existem vários potes e garrafas de vidro com conteúdos misteriosos e de cores diversas, e você entende que o capitão que vive ali, realiza experimentos com diversos ingredientes, criando poções utilizadas pelos soldados para aterrorizar a região.\n" +
                "No fundo da sala, olhando em sua direção, está outro dos capitães do inimigo. Um orque horrendo, de armadura, cajado em punho, em posição de combate. Ele avança em sua direção.\n");

        int result = Game.battle(player, enemy);

        if (result == 0) {
            Game.runAway();
            return false;
        } else if (result == -1) {
            Game.playerDied();
            return false;
        } else {
            TextInterface.enterToContinue();
            return true;
        }
    }


    public static void drinkPotion(Player player) {

        System.out.println("Após derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque do inimigo. Em uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido levemente rosado, pega a garrafa e pondera se deve beber um gole.\n");

        int choice = 0;
        while (choice == 0) {
            int options = 0;
            for (DrinkPotionChoices item : DrinkPotionChoices.values()) {
                System.out.println(item);
                options++;
            }
            choice = TextInterface.readInt(options);
            if (TextInterface.confirmChoice(DrinkPotionChoices.values()[choice-1].getChoice())==2) {
                choice = 0;
            }
        }
        System.out.println(DrinkPotionChoices.values()[choice - 1].getText());
        if (DrinkPotionChoices.values()[choice - 1].getChoice().equals("Beber poção")) {
            System.out.println("Recuperou 100% de defesa");
            player.setDefensePoints(player.getMaxDefensePoints());
        }

        System.out.println("Ao lado da porta, você vê uma chave dourada em cima de uma mesa, e sabe que aquela chave abre a outra fechadura da porta do líder inimigo. Você pega a chave e guarda na pequena bolsa que leva presa ao cinto.\n");

        TextInterface.enterToContinue();
    }


    public static boolean finalRoom(Player player, Enemy enemy) {
        System.out.println("De volta à sala das portas, você se dirige à porta final. Coloca as chaves nas fechaduras, e a porta se abre. Seu coração acelera, memórias de toda a sua vida passam pela sua mente, e você percebe que está muito próximo do seu objetivo final. Segura sua arma com mais firmeza, foca no combate que você sabe que irá se seguir, e adentra a porta.\n" +
                "\n" +
                "Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados às paredes.\n" +
                "\n" +
                "Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de lâmina dupla.\n" +
                "\n");

        int result = Game.battle(player, enemy);

        if (result == 0) {
            Game.runAway();
            return false;
        } else if (result == -1) {
            Game.playerDied();
            return false;
        } else {
            TextInterface.enterToContinue();
            return true;
        }
    }


}

