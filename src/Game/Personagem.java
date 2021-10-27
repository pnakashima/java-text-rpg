package Game;

public class Personagem {

    private ClassesDePersonagem tipo;
    private int sexo;
    private String arma;
    private String nome;
    private int pontos_ataque;
    private int pontos_defesa;

//    public Personagem(ClassesDePersonagem tipo, int pontos_ataque, int pontos_defesa) {
//        this.tipo = tipo;
//        this.pontos_ataque = pontos_ataque;
//        this.pontos_defesa = pontos_defesa;
//    }

    public ClassesDePersonagem getTipo() {
        return tipo;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


