package Game;

import java.util.ArrayList;

public enum GenerosDePersonagem {
    HOMEM("Homem (+20 de Ataque para Guerreiros e Arqueiros)"),
    MULHER("Mulher (+20 de Ataque para Magas e Estudantes)");

    private final String nome;

    private GenerosDePersonagem(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        String saida = "%d - %s";
        return String.format(saida, ordinal()+1, this.nome);
    }
}
