package DungeonsAndDevs;

import java.util.Arrays;
import java.util.List;

// Nesta classe, cada fase do jogo é um método

public class Story {

    public static void intro(Player player) {
        TextInterface.clearConsole();
        TextInterface.printTitle("Dungeons and Devs - A Batalha Final");

        TextInterface.printText("A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo, e sob a luz do crepúsculo você está prestes a entrar na fase final da sua missão. Você olha para o portal à sua frente, e sabe que a partir desse ponto, sua vida mudará para sempre.\n" +
                "\nMemórias do caminho percorrido para chegar até aqui invadem sua mente. Você se lembra de todos os inimigos já derrotados para alcançar o covil do líder maligno. Olha para seu equipamento de combate, já danificado e desgastado depois de tantas lutas. Você está a um passo de encerrar para sempre esse mal.\n" +
                "\nBuscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.\n");

        TextInterface.enterToContinue();

        String motivationTitle = "Escolha sua motivação para invadir a caverna do inimigo e derrotá-lo:";
        List<String> motivationMenu = Arrays.asList("Vingança", "Glória");
        TextInterface motivation = new TextInterface(motivationTitle, motivationMenu);
        int playerMotivationChoice = motivation.playerChoice();
        String playerMotivation = motivationMenu.get(playerMotivationChoice - 1);
        player.setMotivation(playerMotivation);

        TextInterface.clearConsole();

        if (playerMotivation.equals("Vingança"))
            TextInterface.printText("Imagens daquela noite trágica invadem sua mente. Você nem precisa se esforçar para lembrar, pois essas memórias estão sempre presentes, mesmo que de pano de fundo, quando você tem outros pensamentos em foco, elas nunca o deixaram. Elas são o combustível que te fizeram chegar até aqui. E você sabe que não irá desistir até ter vingado a morte daqueles que foram - e pra sempre serão - sua fonte de amor e desejo de continuar vivo. O maldito líder finalmente pagará por tanto mal causado na vida de tantos (e principalmente na sua).");
        else
            TextInterface.printText("Você já consegue visualizar na sua mente o povo da cidade te recebendo de braços abertos, bardos criando canções sobre seus feitos heróicos, nobres te presenteando com jóias e diversas riquezas, taberneiros se recusando a cobrar por suas bebedeiras e comilanças. Desde já, você sente o amor do público, te louvando a cada passo que dá pelas ruas, depois de destruir o vilão que tanto assombrou a paz de todos. Porém, você sabe que ainda falta o último ato dessa história. Você se concentra na missão. A glória o aguarda, mas não antes da última batalha.");

        TextInterface.enterToContinue();
    }


    public static boolean corridor() {
        TextInterface.clearConsole();
        TextInterface.printTitle("O Corredor da Morte");

        TextInterface.printText("Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas, suas mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado. Você avança pelo portal.\n" +
                "\nA escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas. À sua frente, só é possível perceber que você se encontra em um corredor extenso. Você só pode ir à frente, ou desistir.");

        String corridorTitle = "Escolha sua opção:";
        List<String> corridorMenu = Arrays.asList("Seguir em frente", "Desistir");
        TextInterface corridor = new TextInterface(corridorTitle, corridorMenu);
        int playerCorridorChoice = corridor.playerChoice();
        TextInterface.clearConsole();
        if (playerCorridorChoice == 2) {
            TextInterface.printTitle("O medo invade o seu coração e você sente que ainda não está à altura do desafio. Você se volta para a noite lá fora e corre em direção à segurança.");
            return false;
        }

        return true;
    }

    public static boolean mainRoom(Player player) {
        TextInterface.clearConsole();
        TextInterface.printTitle("A Porta dos Desesperados");
        TextInterface.printText("Você caminha, atento a todos os seus sentidos, por vários metros, até visualizar a frente uma fonte de luz, que você imagina ser a chama de uma tocha, vindo de dentro de uma porta aberta.");
        TextInterface.printText("Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha, e pondera sobre como passar pela porta.\n");

        String mainRoomTitle = "Escolha sua opção para atravessar a porta:";
        List<String> mainRoomMenu = Arrays.asList("Saltando", "Andando", "Correndo");
        TextInterface mainRoom = new TextInterface(mainRoomTitle, mainRoomMenu);
        int playerMainRoomChoice = mainRoom.playerChoice();

        TextInterface.clearConsole();

        if (playerMainRoomChoice == 2) {
            TextInterface.printText("Você toma cuidado e vai caminhando vagarosamente em direção à luz. Quando você pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta. Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de você, no corredor. Flechas voam da escotilha em sua direção, e você salta para dentro da sala, porém uma delas te acerta na perna.");
            //Implementei o dano desta fase como sendo de 0 a 20% dos pontos de vida do personagem
            int dice = Game.rollDice(20);
            double damage = (double) dice / 100 * (double) player.getHealthPoints();
            player.setHealthPoints(player.getHealthPoints() - (int) damage);
            TextInterface.printTitle(player.getName() + " perdeu " + dice + "% dos pontos de vida e tem agora " + player.getHealthPoints() + " pontos.");

        } else if (playerMainRoomChoice == 3) {
            TextInterface.printText("Você respira fundo e desata a correr em direção à sala. Quando passa pela porta, sente que pisou em uma pedra solta, mas não dá muita importância e segue para dentro da sala, olhando ao redor à procura de inimigos. Não tem ninguém, mas você ouve sons de flechas batendo na pedra atrás de você, e quando se vira, vê várias flechas no chão. Espiando pela porta, você entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto, mas por sorte você entrou correndo e conseguiu escapar desse ataque surpresa.");

        } else
            TextInterface.printText("Você se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala.");

        TextInterface.enterToContinue();
        TextInterface.clearConsole();

        TextInterface.printText("\nVocê se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede. Uma delas foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas. A porta à sua frente é a maior das quatro, com inscrições em seu entorno em uma língua que você não sabe ler, mas reconhece como sendo a língua antiga utilizada pelo inimigo. Você se aproxima da porta e percebe que ela está trancada por duas fechaduras douradas, e você entende que precisará primeiro derrotar o que estiver nas outras duas portas laterais, antes de conseguir enfrentar o líder.\n" +
                "\nVocê se dirige para a porta à direita.\n");

        TextInterface.enterToContinue();
        return true;
    }

    public static boolean rightDoor(Player player, Enemy enemy) {

        TextInterface.clearConsole();
        TextInterface.printTitle("A Porta da Direita Opressora");

        TextInterface.printText("Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada. Segura " +
                "com mais força sua arma com uma mão, enquanto empurra a porta com a outra. Ao entrar, você se depara " +
                "com uma sala espaçosa, com vários equipamentos de batalha pendurados nas paredes e dispostos em " +
                "armários e mesas. Você imagina que este seja o arsenal do inimigo, onde estão guardados os equipamentos " +
                "que seus soldados utilizam quando saem para espalhar o terror nas cidades e vilas da região.\n" +
                "\n" +
                "Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar para " +
                "trás. Ali, de pé entre você e a porta fechada, bloqueando o caminho do seu destino, está um dos capitães " +
                "do inimigo. Um orque horrendo, de armadura, capacete e espada em punho, em posição de combate. Ele avança em sua direção.\n");

        TextInterface.enterToContinue();

        TextInterface.printTitle("PREPARE-SE PARA O COMBATE!!!");

        Game.printPreBattle(player, enemy);

        TextInterface.enterToContinue();

        return Game.battle(player, enemy);
    }

    public static void changeArmor(Player player) {

        TextInterface.clearConsole();
        TextInterface.printTitle("O Que Não Mata Me Fortalece");

        TextInterface.printText("Após derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados, e olha em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.\n");

        String changeArmorTitle = "Escolha sua opção";
        List<String> changeArmorMenu = Arrays.asList("Trocar armadura", "Continuar com minha armadura");
        TextInterface changeArmor = new TextInterface(changeArmorTitle, changeArmorMenu);
        int playerChangeArmorChoice = changeArmor.playerChoice();

        TextInterface.clearConsole();

        if (playerChangeArmorChoice == 1) {
            TextInterface.printText("Você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas, que estavam danificadas, pelas peças de armaduras existentes na sala. De armadura nova, você se sente mais protegido para os desafios à sua frente.");
            player.setDefensePoints(player.getDefensePoints() + 5);
            TextInterface.printTitle("Você ganhou mais 5 pontos de defesa!");
        } else
            TextInterface.printText("Você decide que não precisa utilizar nada que venha das mãos do inimigo.");

        TextInterface.printText("\nEm uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do líder inimigo. Você pega a chave e guarda numa pequena bolsa que leva presa ao cinto.\n");

        TextInterface.enterToContinue();
    }

    public static boolean leftDoor(Player player, Enemy enemy) {

        TextInterface.clearConsole();
        TextInterface.printTitle("Os Alquimistas Estão Chegando");

        TextInterface.printText("Você retorna à sala anterior e se dirige à porta da esquerda. Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada. Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra. Ao entrar, você se depara com uma sala parecida com a do arsenal, mas em vez de armaduras, existem vários potes e garrafas de vidro com conteúdos misteriosos e de cores diversas, e você entende que o capitão que vive ali, realiza experimentos com diversos ingredientes, criando poções utilizadas pelos soldados para aterrorizar a região.\n" +
                "\nNo fundo da sala, olhando em sua direção, está outro dos capitães do inimigo. Um orque horrendo, de armadura, cajado em punho, em posição de combate. Ele avança em sua direção.\n");

        TextInterface.enterToContinue();

        TextInterface.printTitle("PREPARE-SE PARA O COMBATE!!!");

        Game.printPreBattle(player, enemy);

        TextInterface.enterToContinue();

        return Game.battle(player, enemy);
    }


    public static void drinkPotion(Player player) {

        TextInterface.clearConsole();
        TextInterface.printTitle("Desta Água Não Beberei");

        TextInterface.printText("Após derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque do inimigo. Em uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido levemente rosado, pega a garrafa e pondera se deve beber um gole.\n");

        String drinkPotionTitle = "Escolha sua opção";
        List<String> drinkPotionMenu = Arrays.asList("Beber a poção", "Jogar a poção fora");
        TextInterface drinkPotion = new TextInterface(drinkPotionTitle, drinkPotionMenu);
        int playerDrinkPotionChoice = drinkPotion.playerChoice();
        TextInterface.clearConsole();
        if (playerDrinkPotionChoice == 1) {
            player.setHealthPoints(player.getMaxHealthPoints());
            TextInterface.printTitle("Você se sente revigorado para seguir adiante!");
        } else
            TextInterface.printTitle("Você fica receoso de beber algo produzido pelo inimigo.");


        TextInterface.printText("\nAo lado da porta, você vê uma chave dourada em cima de uma mesa, e sabe que aquela chave abre a outra fechadura da porta do líder inimigo. Você pega a chave e guarda na pequena bolsa que leva presa ao cinto.\n");

        TextInterface.enterToContinue();
    }


    public static boolean finalRoom(Player player, Enemy enemy) {

        TextInterface.clearConsole();
        TextInterface.printTitle("O Poderoso Chefão");

        TextInterface.printText("De volta à sala das portas, você se dirige à porta final. Coloca as chaves nas fechaduras, e a porta se abre. Seu coração acelera, memórias de toda a sua vida passam pela sua mente, e você percebe que está muito próximo do seu objetivo final. Segura sua arma com mais firmeza, foca no combate que você sabe que irá se seguir, e adentra a porta.\n" +
                "\n" +
                "Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados às paredes.\n" +
                "\n" +
                "Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de lâmina dupla.\n" +
                "\n");

        TextInterface.enterToContinue();

        TextInterface.printTitle("PREPARE-SE PARA O COMBATE FINAL!!!");

        Game.printPreBattle(player, enemy);

        TextInterface.enterToContinue();

        return Game.battle(player, enemy);

    }

    public static void theEnd(Player player) {
        TextInterface.printTitle("Você conseguiu!!!");

        if (player.getMotivation().equals("Vingança"))
            TextInterface.printText("\nVocê obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade. Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.");
        else
            TextInterface.printText("\nO êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria. A glória o aguarda, você a conquistou.");

        TextInterface.printText("Você se levanta, olha para os prisioneiros, vai de um em um e os liberta, e todos vocês saem em direção à noite, retornando à cidade. Seu dever está cumprido.");

        TextInterface.enterToContinue();
    }


}

