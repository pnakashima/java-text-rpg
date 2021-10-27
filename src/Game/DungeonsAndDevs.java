package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DungeonsAndDevs {

    public static boolean verificaOpcao(Integer tamanho, Integer opcao) {
        Scanner input = new Scanner(System.in);
        if ((opcao < 1) || (opcao > tamanho)) {
            System.out.println("Escolha uma opção válida!");
            return false;
        }
        return true;
    }

    public static void imprimeOpcoes(List opcoes) {
        for (int i = 1; i <= opcoes.size(); i++) {
            System.out.println(i + " - " + opcoes.get(i - 1));
        }
    }

//    public static String escolheArma(ArrayList armas) {
//        Scanner input = new Scanner(System.in);
//        imprimeOpcoes(armas);
//        int arma = input.nextInt();
//        if (!verificaOpcao(armas, arma)) {
//            arma = 0;
//        }
//        String arma_escolhida = (String) armas.get(arma);
//        return arma_escolhida;
//    }

//    public static void imprimeClasses(enum Cl) {
//        TiposDeArma armas[] = TiposDeArma.values();
//        System.out.println("Tipos de Arma: ");
//        for (TiposDeArma arma: armas) {
//            if (arma.getClasse().equals("guerreiro"))
//                System.out.println(arma);
//        }
//    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Personagem heroi = new Personagem();
        Jogo jogo = new Jogo();

//        ArrayList<String> nivel_dificuldade = new ArrayList<String>();
//        nivel_dificuldade.add("Fácil");
//        nivel_dificuldade.add("Normal");
//        nivel_dificuldade.add("Difícil");

//        ArrayList<String> sexo_personagem = new ArrayList<String>();
//        sexo_personagem.add("Homem (+20 de Ataque para Guerreiros e Arqueiros)");
//        sexo_personagem.add("Mulher (+20 de Ataque para Magas e Estudantes)");

//        // FAZER UM FOR NO ENUM, PEGANDO OS NOMES E PROPRIEDADES
//        ArrayList<String> classe_personagem = new ArrayList<String>();
//        classe_personagem.add("Guerreiro (Ataque: 100 / Pontos de Vida: 700)");
//        classe_personagem.add("Arqueiro (Ataque: 80 / Pontos de Vida: 1000)");
//        classe_personagem.add("Mago (Ataque: 120 / Pontos de Vida: 600");
//        classe_personagem.add("Estudante do SENAI (Ataque: 70 / Pontos de Vida: 1200");

        ArrayList<String> armas_guerreiro = new ArrayList<String>();
        armas_guerreiro.add("Espada (Ataque: 25)");
        armas_guerreiro.add("Machado (Ataque: 20)");
        armas_guerreiro.add("Martelo (Ataque: 15)");
        armas_guerreiro.add("Clava (Ataque: 10)");

        ArrayList<String> armas_arqueiro = new ArrayList<String>();
        armas_arqueiro.add("Arco e Flecha (Ataque: 20)");
        armas_arqueiro.add("Besta e Virote (Ataque: 15)");

        ArrayList<String> armas_mago = new ArrayList<String>();
        armas_mago.add("Cajado (Ataque: 20)");

        ArrayList<String> armas_estudante = new ArrayList<String>();
        armas_estudante.add("Livro (Ataque: 50)");

        int dificuldade = 0;
        int sexo = 0;
        int classe = 0;
        int arma = 0;
        int tamanho = 0;


        //INÍCIO DO JOGO
        System.out.println("Seja bem vindo(a) à BATALHA FINAL!");

        while (dificuldade == 0) {
            System.out.println("Escolha o nível de dificuldade: ");
            tamanho = 0;
            for (NiveisDeDificuldade item : NiveisDeDificuldade.values()) {
                System.out.println(item);
                tamanho++;
            }
            dificuldade = Integer.parseInt(input.nextLine());
            if (!verificaOpcao(tamanho, dificuldade)) {
                dificuldade = 0;
            }
        }
        jogo.setDificuldade(dificuldade);

        System.out.println("Nome do seu personagem: ");
        String nome = input.nextLine();
        heroi.setNome(nome);

        while (sexo == 0) {
            System.out.println("Escolha o sexo do seu personagem: ");
            tamanho = 0;
            for (GenerosDePersonagem item : GenerosDePersonagem.values()) {
                System.out.println(item);
                tamanho++;
            }
            sexo = Integer.parseInt(input.nextLine());
            if (!verificaOpcao(tamanho, sexo)) {
                sexo = 0;
            }
        }
        heroi.setSexo(GenerosDePersonagem.values()[sexo - 1].getGenero());

        while (classe == 0) {
            System.out.println("Escolha uma classe de combate: ");
            tamanho = 0;
            for (ClassesDePersonagem item : ClassesDePersonagem.values()) {
                System.out.println(item);
                tamanho++;
            }
            classe = Integer.parseInt(input.nextLine());
            if (!verificaOpcao(tamanho, classe)) {
                classe = 0;
            }
        }
        heroi.setClasse(ClassesDePersonagem.values()[classe - 1].getClasse());
        heroi.setPontos_ataque(ClassesDePersonagem.values()[classe - 1].getPontos_ataque());
        heroi.setPontos_defesa(ClassesDePersonagem.values()[classe - 1].getPontos_defesa());

        while (arma == 0) {
            System.out.println("Escolha uma arma: ");
            tamanho = 0;
            for (TiposDeArma item : TiposDeArma.values()) {
                if (item.getClasse().equals(ClassesDePersonagem.values()[classe - 1].getClasse())) {
                    System.out.println(item);
                    tamanho++;
                }
            }
            arma = Integer.parseInt(input.nextLine());
//            if (!verificaOpcao(tamanho, arma)) {
//                arma = 0;
//            }
        }
        String arma_escolhida = (TiposDeArma.values()[arma - 1].getMunicao().equals("")) ? TiposDeArma.values()[arma - 1].getNome() : TiposDeArma.values()[arma - 1].getNome() + " e " + TiposDeArma.values()[arma - 1].getMunicao();
        heroi.setArma(arma_escolhida);
        heroi.setDano_arma(TiposDeArma.values()[arma - 1].getDano());

        System.out.println(heroi);

        jogo.setSair(false);

        for (FasesDoJogo item : FasesDoJogo.values()) {
            System.out.println(item.getTexto());
        }


        //Introdução
        System.out.println("A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo, e sob a luz do\n" +
                "crepúsculo você está prestes a entrar na fase final da sua missão. Você olha para o portal à sua frente,\n" +
                "e sabe que a partir desse ponto, sua vida mudará para sempre.\n" +
                "Memórias do caminho percorrido para chegar até aqui invadem sua mente. Você se lembra de todos os inimigos\n" +
                "já derrotados para alcançar o covil do líder maligno. Olha para seu equipamento de combate, já danificado e \n" +
                "desgastado depois de tantas lutas. Você está a um passo de encerrar para sempre esse mal.\n" +
                "Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.\n");

        System.out.println("Escolha sua motivação para invadir a caverna do inimigo e derrotá-lo: ");
//
//        String texto_motivacao = "";
//        System.out.println("1 - Vingança");
//        System.out.println("2 - Glória");
//        int motivacao = input.nextInt();
//        if (motivacao == 1) {
//            texto_motivacao = "Imagens daquela noite trágica invadem sua mente. Você nem precisa se esforçar para lembrar, " +
//                    "pois essas memórias estão sempre presentes, mesmo que de pano de fundo, quando você tem outros " +
//                    "pensamentos em foco, elas nunca o deixaram. Elas são o combustível que te fizeram chegar até aqui. " +
//                    "E você sabe que não irá desistir até ter vingado a morte daqueles que foram - e pra sempre serão - " +
//                    "sua fonte de amor e desejo de continuar vivo. O maldito líder finalmente pagará por tanto mal causado " +
//                    "na vida de tantos (e principalmente na sua).\n";
//        } else if (motivacao == 2) {
//            texto_motivacao = "Você já consegue visualizar na sua mente o povo da cidade te recebendo de braços abertos, " +
//                    "bardos criando canções sobre seus feitos heróicos, nobres te presenteando com jóias e diversas " +
//                    "riquezas, taberneiros se recusando a cobrar por suas bebedeiras e comilanças. Desde já, você sente " +
//                    "o amor do público, te louvando a cada passo que dá pelas ruas, depois de destruir o vilão que tanto " +
//                    "assombrou a paz de todos. Porém, você sabe que ainda falta o último ato dessa história. Você se " +
//                    "concentra na missão. A glória o aguarda, mas não antes da última batalha.\n";
//        } else {
//            System.out.println("Digite uma opção válida");
//        }
//        System.out.println(motivacao);
//
//        System.out.println("Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas, " +
//                "suas mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado. Você " +
//                "avança pelo portal.\n" +
//                "\n" +
//                "A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas. À sua frente, só " +
//                "é possível perceber que você se encontra em um corredor extenso. Você só pode ir à frente, ou desistir.\n");
//        System.out.println("1 - Seguir em frente");
//        System.out.println("2 - Desistir");
//        int escolha = input.nextInt();
//        String texto_escolha = "";
//        if (escolha == 1) {
//            texto_escolha = "O medo invade o seu coração e você sente que ainda não está à altura do desafio. Você se " +
//                    "volta para a noite lá fora e corre em direção à segurança.\n";
//            sair = true;
//        } else if (escolha == 2) {
//            texto_escolha = "Você caminha, atento a todos os seus sentidos, por vários metros, até visualizar a frente " +
//                    "uma fonte de luz, que você imagina ser a chama de uma tocha, vindo de dentro de uma porta aberta.\n";
//        }
//
//        System.out.println("você caminha, atento a todos os seus sentidos, por vários metros, até visualizar a frente " +
//                "uma fonte de luz, que você imagina ser a chama de uma tocha, vindo de dentro de uma porta aberta.\n");
//        System.out.println("1 - Andando cuidadosamente");
//        System.out.println("2 - Correndo");
//        System.out.println("3 - Saltando");
//        escolha = input.nextInt();
//        if (escolha == 1) {
//            texto_escolha = "Você toma cuidado e vai caminhando vagarosamente em direção à luz. Quando você pisa " +
//                    "exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra " +
//                    "solta. Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de " +
//                    "você, no corredor. Flechas voam da escotilha em sua direção, e você salta para dentro da sala, " +
//                    "porém uma delas te acerta na perna.";
//            // TOMAR DANO DE 1 A 10
//        } else if (escolha == 2) {
//            texto_escolha = "Você respira fundo e desata a correr em direção à sala. Quando passa pela porta, sente " +
//                    "que pisou em uma pedra solta, mas não dá muita importância e segue para dentro da sala, olhando " +
//                    "ao redor à procura de inimigos. Não tem ninguém, mas você ouve sons de flechas batendo na pedra " +
//                    "atrás de você, e quando se vira, vê várias flechas no chão. Espiando pela porta, você entende que " +
//                    "pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto, mas por sorte você " +
//                    "entrou correndo e conseguiu escapar desse ataque surpresa.";
//        } else if (escolha == 3) {
//            texto_escolha = " Você se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala.";
//        }
//
//        System.out.println("Você se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede. Uma delas " +
//                "foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas. A porta à sua " +
//                "frente é a maior das quatro, com inscrições em seu entorno em uma língua que você não sabe ler, mas " +
//                "reconhece como sendo a língua antiga utilizada pelo inimigo. Você se aproxima da porta e percebe que " +
//                "ela está trancada por duas fechaduras douradas, e você entende que precisará primeiro derrotar o que " +
//                "estiver nas outras duas portas laterais, antes de conseguir enfrentar o líder.\n" +
//                "\n" +
//                "Você se dirige para a porta à direita.\n");
//
//        System.out.println("Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada. Segura " +
//                "com mais força sua arma com uma mão, enquanto empurra a porta com a outra. Ao entrar, você se depara " +
//                "com uma sala espaçosa, com vários equipamentos de batalha pendurados nas paredes e dispostos em " +
//                "armários e mesas. Você imagina que este seja o arsenal do inimigo, onde estão guardados os equipamentos " +
//                "que seus soldados utilizam quando saem para espalhar o terror nas cidades e vilas da região.\n" +
//                "\n" +
//                "Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar para " +
//                "trás. Ali, de pé entre você e a porta fechada, bloqueando o caminho do seu destino, está um dos capitães " +
//                "do inimigo. Um orque horrendo, de armadura, capacete e espada em punho, em posição de combate. Ele avança em sua direção.\n");
//
//        //LOOP DE COMBATE
//
//        System.out.println("Após derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados, e olha " +
//                "em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.");
//        System.out.println("1 - Pegar armaduras");
//        System.out.println("2 - Deixar armaduras");
//        escolha = input.nextInt();
//        if (escolha == 1) {
//            texto_escolha = "Você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas, que " +
//                    "estavam danificadas, pelas peças de armaduras existentes na sala. De armadura nova, você se sente " +
//                    "mais protegido para os desafios à sua frente.";
//            //MAIS 5 PONTOS DE DEFESA PARA O JOGADOR
//        } else if (escolha == 2) {
//            texto_escolha = "Você decide que não precisa utilizar nada que venha das mãos do inimigo.";
//        }
//
//
//        System.out.println("Em uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras " +
//                "da porta do líder inimigo. Você pega a chave e guarda numa pequena bolsa que leva presa ao cinto.\n" +
//                "\n" +
//                "Você retorna à sala anterior e se dirige à porta da esquerda. Você se aproxima, tentando ouvir o que " +
//                "acontece porta adentro, mas não escuta nada. Segura com mais força sua arma com uma mão, enquanto empurra " +
//                "a porta com a outra. Ao entrar, você se depara com uma sala parecida com a do arsenal, mas em vez de " +
//                "armaduras, existem vários potes e garrafas de vidro com conteúdos misteriosos e de cores diversas, e " +
//                "você entende que o capitão que vive ali, realiza experimentos com diversos ingredientes, criando " +
//                "poções utilizadas pelos soldados para aterrorizar a região.\n" +
//                "No fundo da sala, olhando em sua direção, está outro dos capitães do inimigo. Um orque horrendo, de " +
//                "armadura, cajado em punho, em posição de combate. Ele avança em sua direção.\n");
//
//        // LOOP DE COMBATE
//
//        System.out.println("Após derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque " +
//                "do inimigo. Em uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido levemente " +
//                "rosado, pega a garrafa e pondera se deve beber um gole.\n");
//        System.out.println("1 - Beber");
//        System.out.println("2 - Não beber");
//        escolha = input.nextInt();
//        if (escolha == 1) {
//            texto_escolha = "Você se sente revigorado para seguir adiante!";
//            //MAIS 100% DOS PONTOS DE VIDA
//        } else if (escolha == 2) {
//            texto_escolha = "Você fica receoso de beber algo produzido pelo inimigo";
//        }
//
//        System.out.println("Ao lado da porta, você vê uma chave dourada em cima de uma mesa, e sabe que aquela chave " +
//                "abre a outra fechadura da porta do líder inimigo. Você pega a chave e guarda na pequena bolsa que " +
//                "leva presa ao cinto.\n" +
//                "\n" +
//                "De volta à sala das portas, você se dirige à porta final. Coloca as chaves nas fechaduras, e a porta " +
//                "se abre. Seu coração acelera, memórias de toda a sua vida passam pela sua mente, e você percebe que " +
//                "está muito próximo do seu objetivo final. Segura sua arma com mais firmeza, foca no combate que você " +
//                "sabe que irá se seguir, e adentra a porta.\n" +
//                "\n" +
//                "Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e " +
//                "prisioneiros acorrentados às paredes.\n" +
//                "\n" +
//                "Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de lâmina dupla.\n");
//
//        //ATACAR OU ESPERAR?
//
//        //LOOP DE COMBATE
//
//        System.out.println("Você conseguiu!");
//        if (motivacao == 1) {
//            texto_motivacao = "Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de " +
//                    "alívio e felicidade. Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.\n";
//        } else if (motivacao == 2) {
//            texto_motivacao = "O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria. " +
//                    "A glória o aguarda, você a conquistou.";
//        }
//
//        System.out.println("Você se levanta, olha para os prisioneiros, vai de um em um e os liberta, e todos vocês saem " +
//                "em direção à noite, retornando à cidade. Seu dever está cumprido.");
//        System.out.println("GAME OVER");
//
//
    }

}
