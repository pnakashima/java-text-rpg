package DungeonsAndDevs;

public class Personagem {

    private String nome;
    private String sexo;
    private String classe;
    private int pontos_ataque;
    private int pontos_defesa;
    private String arma;
    private int dano_arma;
    private int motivacao;
    private boolean vivo;

    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", classe=" + classe +
                ", pontos_ataque=" + pontos_ataque +
                ", pontos_defesa=" + pontos_defesa +
                ", arma=" + arma +
                ", dano_arma=" + dano_arma +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getPontos_ataque() {
        return pontos_ataque;
    }

    public void setPontos_ataque(int pontos_ataque) {
        this.pontos_ataque = pontos_ataque;
    }

    public int getPontos_defesa() {
        return pontos_defesa;
    }

    public void setPontos_defesa(int pontos_defesa) {
        this.pontos_defesa = pontos_defesa;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public int getDano_arma() {
        return dano_arma;
    }

    public void setDano_arma(int dano_arma) {
        this.dano_arma = dano_arma;
    }

    public int getMotivacao() {
        return motivacao;
    }

    public void setMotivacao(int motivacao) {
        this.motivacao = motivacao;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
}


