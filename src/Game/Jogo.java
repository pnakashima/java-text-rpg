package Game;

import java.util.ArrayList;

public class Jogo {
    private int dificuldade;
    boolean sair;

//
//    public int luta(Personagem heroi, Inimigo inimigo) {
//        return 1;
//    }


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
