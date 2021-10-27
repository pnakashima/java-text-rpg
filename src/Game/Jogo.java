package Game;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    private int dificuldade;
    boolean sair;


    public int luta(Personagem heroi, Personagem inimigo) {
        Scanner input = new Scanner(System.in);

        String nomeHeroi = heroi.getNome();
        String nomeInimigo = inimigo.getNome();
        int ataqueHeroi = heroi.getPontos_ataque() + heroi.getDano_arma();
        int ataqueInimigo = inimigo.getPontos_ataque() + inimigo.getDano_arma();
        int dano = 0;

        System.out.println(String.format("Início da luta entre %s e %s", nomeHeroi, nomeInimigo));
        System.out.println(String.format("Herói %s tem %d pontos de defesa e %d pontos de ataque.", nomeHeroi, heroi.getPontos_defesa(), ataqueHeroi));
        System.out.println(String.format("Inimigo %s tem %d pontos de defesa e %d pontos de ataque.", nomeInimigo, inimigo.getPontos_defesa(), ataqueInimigo));
        int acao = 0;
        while ((acao != 2) && (heroi.getPontos_defesa() > 0) && (inimigo.getPontos_defesa() > 0)) {
            System.out.println(String.format("Escolha sua ação %s:", nomeHeroi));
            System.out.println("1 - Lutar");
            System.out.println("2 - Fugir");
            acao=Integer.parseInt(input.nextLine());
            if (acao == 1) {
                dano = ataqueHeroi + DungeonsAndDevs.rolarDado(20, true);
                inimigo.setPontos_defesa(inimigo.getPontos_defesa() - dano);
                System.out.println(String.format("%s ataca e tira %d pontos de defesa de %s", nomeHeroi, dano, nomeInimigo));
                if (inimigo.getPontos_defesa() > 0) {
                    dano = ataqueInimigo + DungeonsAndDevs.rolarDado(20, true);
                    heroi.setPontos_defesa(heroi.getPontos_defesa() - dano);
                    System.out.println(String.format("%s ataca e tira %d pontos de defesa de %s", nomeInimigo, dano, nomeHeroi));
                }
                System.out.println(String.format("%s tem %d pontos de defesa e %s tem %d pontos de defesa!", nomeHeroi, heroi.getPontos_defesa(), nomeInimigo, inimigo.getPontos_defesa()));
            } else if (acao == 2) {
                this.setSair(true);
                break;
            } else {
                System.out.println("Escolha uma opção válida!");
            }
            if (heroi.getPontos_defesa() <=0) {
                System.out.println(String.format("%s venceu a batalha!", nomeInimigo));
            }
            if (inimigo.getPontos_defesa() <=0) {
                System.out.println(String.format("%s venceu a batalha!", nomeHeroi));
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
}
