package DungeonsAndDevs;

import java.util.Random;
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

    public static int rolarDado(Integer lados, boolean critico) {
        Random dado = new Random();
        int dano = dado.nextInt(lados + 1) + 1;
        if (critico) {
            if (dano == lados) {
                System.out.println("DANO CRÍTICO!!!");
                dano = 1000;
            }
            if (dano == 1) {
                System.out.println("ERROUUUUUUUUU!!!");
                dano = 0;
            }
        }
        return dano;
    }
}


//    public static void main2(String[] args) {
//        Scanner input = new Scanner(System.in);
//        Personagem heroi = new Personagem();
//        Jogo jogo = new Jogo();
//
//
//        //INÍCIO DO JOGO
//        System.out.println("Seja bem vindo(a) à BATALHA FINAL!");
//
//        int tamanho = 0;
//        int dificuldade = 0;
//        while (dificuldade == 0) {
//            System.out.println("Escolha o nível de dificuldade: ");
//            tamanho = 0;
//            for (NiveisDeDificuldade item : NiveisDeDificuldade.values()) {
//                System.out.println(item);
//                tamanho++;
//            }
//            dificuldade = Integer.parseInt(input.nextLine());
//            if (!verificaOpcao(tamanho, dificuldade)) {
//                dificuldade = 0;
//            }
//        }
//        jogo.setDificuldade(dificuldade);
//
//        System.out.println("Nome do seu personagem: ");
//        String nome = input.nextLine();
//        heroi.setNome(nome);
//        heroi.setVivo(true);
//
//        int sexo = 0;
//        while (sexo == 0) {
//            System.out.println("Escolha o sexo do seu personagem: ");
//            tamanho = 0;
//            for (GenerosDePersonagem item : GenerosDePersonagem.values()) {
//                System.out.println(item);
//                tamanho++;
//            }
//            sexo = Integer.parseInt(input.nextLine());
//            if (!verificaOpcao(tamanho, sexo)) {
//                sexo = 0;
//            }
//        }
//        heroi.setSexo(GenerosDePersonagem.values()[sexo - 1].getGenero());
//
//
//
////        int classe = 0;
////        while (classe == 0) {
////            System.out.println("Escolha uma classe de combate: ");
////            tamanho = 0;
////            for (ClassesDePersonagem item : ClassesDePersonagem.values()) {
////                System.out.println(item);
////                tamanho++;
////            }
////            classe = Integer.parseInt(input.nextLine());
////            if (!verificaOpcao(tamanho, classe)) {
////                classe = 0;
////            }
////        }
////        heroi.setClasse(ClassesDePersonagem.values()[classe - 1].getClasse());
////        heroi.setPontos_ataque(ClassesDePersonagem.values()[classe - 1].getPontos_ataque());
////        heroi.setPontos_defesa(ClassesDePersonagem.values()[classe - 1].getPontos_defesa());
////
////        int arma = 0;
////        while (arma == 0) {
////            System.out.println("Escolha uma arma: ");
////            tamanho = 0;
////            for (TiposDeArma item : TiposDeArma.values()) {
////                if (item.getClasse().equals(ClassesDePersonagem.values()[classe - 1].getClasse())) {
////                    System.out.println(item);
////                    tamanho++;
////                }
////            }
////            arma = Integer.parseInt(input.nextLine());
//////            if (!verificaOpcao(tamanho, arma)) {
//////                arma = 0;
//////            }
////        }
//        String arma_escolhida = (TiposDeArma.values()[arma - 1].getMunicao().equals("")) ? TiposDeArma.values()[arma - 1].getNome() : TiposDeArma.values()[arma - 1].getNome() + " e " + TiposDeArma.values()[arma - 1].getMunicao();
//        heroi.setArma(arma_escolhida);
//        heroi.setDano_arma(TiposDeArma.values()[arma - 1].getDano());
//
//        System.out.println(heroi);
//
//        jogo.setSair(false);
//        jogo.setZerado(false);
//        while ((!jogo.isSair()) && (!jogo.isZerado())) {
////        for (FasesDoJogo item : FasesDoJogo.values()) {
////            System.out.println(item.getTexto());
////        }
//
//
//            //Introdução
//            System.out.println("A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo, e sob a luz do\n" +
//                    "crepúsculo você está prestes a entrar na fase final da sua missão. Você olha para o portal à sua frente,\n" +
//                    "e sabe que a partir desse ponto, sua vida mudará para sempre.\n" +
//                    "Memórias do caminho percorrido para chegar até aqui invadem sua mente. Você se lembra de todos os inimigos\n" +
//                    "já derrotados para alcançar o covil do líder maligno. Olha para seu equipamento de combate, já danificado e \n" +
//                    "desgastado depois de tantas lutas. Você está a um passo de encerrar para sempre esse mal.\n" +
//                    "Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.\n");
//
//
//            int motivacao = 0;
//            while (motivacao == 0) {
//                System.out.println("Escolha sua motivação para invadir a caverna do inimigo e derrotá-lo: ");
//                tamanho = 0;
//                for (TiposDeMotivacao item : TiposDeMotivacao.values()) {
//                    System.out.println(item);
//                    tamanho++;
//                }
//                motivacao = Integer.parseInt(input.nextLine());
//                if (!verificaOpcao(tamanho, motivacao)) {
//                    motivacao = 0;
//                }
//            }
////            heroi.setMotivacao(TiposDeMotivacao.values()[motivacao - 1].getNome());
//            heroi.setMotivacao(motivacao - 1);
//
//            System.out.println(TiposDeMotivacao.values()[motivacao - 1].getTexto());
//
//            System.out.println("Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas, suas\n" +
//                    "mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado. Você avança pelo portal.\n" +
//                    "A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas. À sua frente, só é" +
//                    "possível perceber que você se encontra em um corredor extenso. Você só pode ir à frente, ou desistir.\n");
//
//            int fase1 = 0;
//            while (fase1 == 0) {
//                tamanho = 0;
//                for (EscolhasFase1 item : EscolhasFase1.values()) {
//                    System.out.println(item);
//                    tamanho++;
//                }
//                fase1 = Integer.parseInt(input.nextLine());
//                if (!verificaOpcao(tamanho, fase1)) {
//                    fase1 = 0;
//                }
//            }
//            if (EscolhasFase1.values()[fase1 - 1].getNome().equals("Desistir")) {
//                jogo.setSair(true);
//                System.out.println(EscolhasFase1.values()[fase1 - 1].getTexto());
//                break;
//            }
//            System.out.println(EscolhasFase1.values()[fase1 - 1].getTexto());
//
//            System.out.println("Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha, e pondera sobre como passar pela porta.\n");
//
//            int fase2 = 0;
//            while (fase2 == 0) {
//                tamanho = 0;
//                for (EscolhasFase2 item : EscolhasFase2.values()) {
//                    System.out.println(item);
//                    tamanho++;
//                }
//                fase2 = Integer.parseInt(input.nextLine());
//                if (!verificaOpcao(tamanho, fase2)) {
//                    fase2 = 0;
//                }
//            }
//            System.out.println(EscolhasFase2.values()[fase2 - 1].getTexto());
//            if (EscolhasFase2.values()[fase2 - 1].getNome().equals("Andando")) {
//                int dano = rolarDado(10, false);
//                System.out.println("TOMOU DANO DE " + dano);
//                heroi.setPontos_defesa(heroi.getPontos_defesa() - dano);
//            }
//
//            System.out.println(heroi);
//
//            System.out.println("Você se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede. Uma delas " +
//                    "foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas. A porta à sua " +
//                    "frente é a maior das quatro, com inscrições em seu entorno em uma língua que você não sabe ler, mas " +
//                    "reconhece como sendo a língua antiga utilizada pelo inimigo. Você se aproxima da porta e percebe que " +
//                    "ela está trancada por duas fechaduras douradas, e você entende que precisará primeiro derrotar o que " +
//                    "estiver nas outras duas portas laterais, antes de conseguir enfrentar o líder.\n" +
//                    "\n" +
//                    "Você se dirige para a porta à direita.\n");
//
//            System.out.println("Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada. Segura " +
//                    "com mais força sua arma com uma mão, enquanto empurra a porta com a outra. Ao entrar, você se depara " +
//                    "com uma sala espaçosa, com vários equipamentos de batalha pendurados nas paredes e dispostos em " +
//                    "armários e mesas. Você imagina que este seja o arsenal do inimigo, onde estão guardados os equipamentos " +
//                    "que seus soldados utilizam quando saem para espalhar o terror nas cidades e vilas da região.\n" +
//                    "\n" +
//                    "Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar para " +
//                    "trás. Ali, de pé entre você e a porta fechada, bloqueando o caminho do seu destino, está um dos capitães " +
//                    "do inimigo. Um orque horrendo, de armadura, capacete e espada em punho, em posição de combate. Ele avança em sua direção.\n");
//
//            Personagem armeiro = new Personagem();
//            armeiro.setPontos_defesa(500);
//            armeiro.setDano_arma(10);
//            armeiro.setPontos_ataque(80);
//            armeiro.setNome("Rambo");
//
//            jogo.luta(heroi, armeiro);
//
//            if (!jogo.isSair()) {
//
//                System.out.println("Após derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados, e olha " +
//                        "em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.");
//
//                int fase3 = 0;
//                while (fase3 == 0) {
//                    tamanho = 0;
//                    for (EscolhasFase3 item : EscolhasFase3.values()) {
//                        System.out.println(item);
//                        tamanho++;
//                    }
//                    fase3 = Integer.parseInt(input.nextLine());
//                    if (!verificaOpcao(tamanho, fase3)) {
//                        fase3 = 0;
//                    }
//                }
//                System.out.println(EscolhasFase3.values()[fase3 - 1].getTexto());
//                if (EscolhasFase3.values()[fase3 - 1].getNome().equals("Pegar")) {
//                    System.out.println("Recuperou 50 de defesa");
//                    heroi.setPontos_defesa(heroi.getPontos_defesa() + 50);
//                }
//                System.out.println(heroi);
//
//
//                System.out.println("Em uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras " +
//                        "da porta do líder inimigo. Você pega a chave e guarda numa pequena bolsa que leva presa ao cinto.\n" +
//                        "\n" +
//                        "Você retorna à sala anterior e se dirige à porta da esquerda. Você se aproxima, tentando ouvir o que " +
//                        "acontece porta adentro, mas não escuta nada. Segura com mais força sua arma com uma mão, enquanto empurra " +
//                        "a porta com a outra. Ao entrar, você se depara com uma sala parecida com a do arsenal, mas em vez de " +
//                        "armaduras, existem vários potes e garrafas de vidro com conteúdos misteriosos e de cores diversas, e " +
//                        "você entende que o capitão que vive ali, realiza experimentos com diversos ingredientes, criando " +
//                        "poções utilizadas pelos soldados para aterrorizar a região.\n" +
//                        "No fundo da sala, olhando em sua direção, está outro dos capitães do inimigo. Um orque horrendo, de " +
//                        "armadura, cajado em punho, em posição de combate. Ele avança em sua direção.\n");
//
//                Personagem alquimista = new Personagem();
//                alquimista.setPontos_defesa(500);
//                alquimista.setDano_arma(10);
//                alquimista.setPontos_ataque(80);
//                alquimista.setNome("Bruxa do 71");
//
//                jogo.luta(heroi, alquimista);
//
//                if (!jogo.isSair()) {
//
//                    System.out.println("Após derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque " +
//                            "do inimigo. Em uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido levemente " +
//                            "rosado, pega a garrafa e pondera se deve beber um gole.\n");
//
//                    int fase4 = 0;
//                    while (fase4 == 0) {
//                        tamanho = 0;
//                        for (DrinkPotionChoices item : DrinkPotionChoices.values()) {
//                            System.out.println(item);
//                            tamanho++;
//                        }
//                        fase4 = Integer.parseInt(input.nextLine());
//                        if (!verificaOpcao(tamanho, fase3)) {
//                            fase4 = 0;
//                        }
//                    }
//                    System.out.println(DrinkPotionChoices.values()[fase4 - 1].getTexto());
//                    if (DrinkPotionChoices.values()[fase4 - 1].getNome().equals("Beber")) {
//                        System.out.println("Recuperou 100% de defesa");
//                        heroi.setPontos_defesa(ClassesDePersonagem.values()[classe - 1].getPontos_defesa());
//
//                    }
//                    System.out.println(heroi);
//
//                    System.out.println("Ao lado da porta, você vê uma chave dourada em cima de uma mesa, e sabe que aquela chave " +
//                            "abre a outra fechadura da porta do líder inimigo. Você pega a chave e guarda na pequena bolsa que " +
//                            "leva presa ao cinto.\n" +
//                            "\n" +
//                            "De volta à sala das portas, você se dirige à porta final. Coloca as chaves nas fechaduras, e a porta " +
//                            "se abre. Seu coração acelera, memórias de toda a sua vida passam pela sua mente, e você percebe que " +
//                            "está muito próximo do seu objetivo final. Segura sua arma com mais firmeza, foca no combate que você " +
//                            "sabe que irá se seguir, e adentra a porta.\n" +
//                            "\n" +
//                            "Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e " +
//                            "prisioneiros acorrentados às paredes.\n" +
//                            "\n" +
//                            "Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de lâmina dupla.\n");
//
//
//                    Personagem chefao = new Personagem();
//                    chefao.setPontos_defesa(500);
//                    chefao.setDano_arma(10);
//                    chefao.setPontos_ataque(80);
//                    chefao.setNome("Chefão da Porra Toda");
//
//                    //        //ATACAR OU ESPERAR?
//
//                    jogo.luta(heroi, chefao);
//
//                    System.out.println("Você conseguiu!!!");
//                    System.out.println(TiposDeMotivacao.values()[motivacao - 1].getTexto2());
//
//                    System.out.println("Você se levanta, olha para os prisioneiros, vai de um em um e os liberta, e todos vocês saem " +
//                            "em direção à noite, retornando à cidade. Seu dever está cumprido.");
//                    System.out.println("GAME OVER");
//
//                    jogo.setZerado(true);
//                }
//            }
//        }
//
//        if (jogo.isSair()) {
//            System.out.println("Você não estava preparado para a força do inimigo, e decide fugir para que possa tentar novamente em uma próxima vez.”\n");
//        }
//
//        if (!heroi.isVivo()) {
//            System.out.println("Você não estava preparado para a força do inimigo...\n");
//            int motivacao = heroi.getMotivacao();
//            System.out.println(TiposDeMotivacao.values()[motivacao].getTexto3());
//        }
//
//
//    }
//
//}
