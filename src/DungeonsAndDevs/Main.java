package DungeonsAndDevs;

// Instruções para expandir o jogo:
// Criação de novas classes ou gêneros (não binários) de jogador: basta adicionar o novo tipo no ENUM correspondente, com os devidos atributos
// Criação de novas fases: acrescentar fase em Story.java, e chamar a fase pelo método startGame() da classe Game
// Níveis de dificuldade: estão representados na classe Game (no modo fácil os ataques do inimigo são multiplicados por 0.80,
// e no modo difícil os ataques do jogador são multiplicados por 0.90)

public class Main {
    public static void main(String[] args) {
        Game.startGame();
    }
}
