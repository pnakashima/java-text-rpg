package DungeonsAndDevs;

import java.util.Scanner;

public class Jogo {

    private int dificuldade;
    private boolean sair;
    private boolean zerado;


    public int luta(Personagem heroi, Personagem inimigo) {
        Scanner input = new Scanner(System.in);

        String nomeHeroi = heroi.getNome();
        String nomeInimigo = inimigo.getNome();
        int ataqueHeroi = heroi.getPontos_ataque() + heroi.getDano_arma();
        int ataqueInimigo = inimigo.getPontos_ataque() + inimigo.getDano_arma();
        int danoTotal = 0;

        System.out.println(String.format("Início da luta entre %s e %s", nomeHeroi, nomeInimigo));
        System.out.println(String.format("Herói %s tem %d pontos de defesa e %d pontos de ataque.", nomeHeroi, heroi.getPontos_defesa(), ataqueHeroi));
        System.out.println(String.format("Inimigo %s tem %d pontos de defesa e %d pontos de ataque.", nomeInimigo, inimigo.getPontos_defesa(), ataqueInimigo));
        int acao = 0;
        int danoDado = 0;
        while ((acao != 2) && (heroi.getPontos_defesa() > 0) && (inimigo.getPontos_defesa() > 0)) {
            System.out.println(String.format("Escolha sua ação %s:", nomeHeroi));
            System.out.println("1 - Lutar");
            System.out.println("2 - Fugir");
            acao = Integer.parseInt(input.nextLine());
            if (acao == 1) {
                System.out.println("Começando Loop:");
                danoDado = DungeonsAndDevs.rolarDado(20, true);
                danoTotal = ataqueHeroi + danoDado;
//                dano = ataqueHeroi + DungeonsAndDevs.rolarDado(20, true);
                System.out.println("dano heroi: " + danoDado);
                if (danoDado == 0) {
                    System.out.println("Você errou seu ataque! O inimigo não sofreu dano algum.");
                } else {
                    inimigo.setPontos_defesa(inimigo.getPontos_defesa() - danoTotal);
                    System.out.println(String.format("%s ataca e tira %d pontos de defesa de %s", nomeHeroi, danoTotal, nomeInimigo));
                }
                if (inimigo.getPontos_defesa() > 0) {
                    danoDado = DungeonsAndDevs.rolarDado(20, true);
                    danoTotal = ataqueInimigo + danoDado;
//                    dano = ataqueInimigo + DungeonsAndDevs.rolarDado(20, true);
                    System.out.println("dano vilao: " + danoDado);
                    if (danoDado == 0) {
                        System.out.println("O inimigo errou o ataque! Você não sofreu dano.");
                    } else {
                        heroi.setPontos_defesa(heroi.getPontos_defesa() - danoTotal);
                        System.out.println(String.format("%s ataca e tira %d pontos de defesa de %s", nomeInimigo, danoTotal, nomeHeroi));
                    }

                }
                System.out.println(String.format("%s tem %d pontos de defesa e %s tem %d pontos de defesa!", nomeHeroi, heroi.getPontos_defesa(), nomeInimigo, inimigo.getPontos_defesa()));
            } else if (acao == 2) {
                this.setSair(true);
                break;
            } else {
                System.out.println("Escolha uma opção válida!");
            }
            if (heroi.getPontos_defesa() <= 0) {
                System.out.println(String.format("%s venceu a batalha!", nomeInimigo));
                heroi.setVivo(false);
                break;
            }
            if (inimigo.getPontos_defesa() <= 0) {
                System.out.println(String.format("%s venceu a batalha!", nomeHeroi));
                break;
            }
        }

        return 1;
    }


    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
//        ArrayList<String> nivel_dificuldade = new ArrayList<String>();
//        nivel_dificuldade.add("Fácil");
//        nivel_dificuldade.add("Normal");
//        nivel_dificuldade.add("Difícil");
        this.dificuldade = dificuldade;
    }

    public boolean isSair() {
        return sair;
    }

    public void setSair(boolean sair) {
        this.sair = sair;
    }

    public boolean isZerado() {
        return zerado;
    }

    public void setZerado(boolean zerado) {
        this.zerado = zerado;
    }
}
