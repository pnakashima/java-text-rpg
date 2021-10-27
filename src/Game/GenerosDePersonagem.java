package Game;

import java.util.ArrayList;

public enum GenerosDePersonagem {
    MASC("Masculino","Masculino (+20 de Ataque para Guerreiros e Arqueiros)"),
    FEM("Feminino", "Feminino (+20 de Ataque para Magas e Estudantes)");

    private final String genero;
    private final String texto;

    GenerosDePersonagem(String genero, String texto) {
        this.genero = genero;
        this.texto = texto;
    }

    public String getGenero() {
        return genero;
    }

    public String getTexto() {
        return texto;
    }

    public String toString() {
        String saida = "%d - %s";
        return String.format(saida, ordinal() + 1, this.texto);
    }
}
