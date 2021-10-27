package Game;

public enum TiposDeMotivacao {
    VINGANCA("Vingança","Imagens daquela noite trágica invadem sua mente. Você nem precisa se esforçar para\n" +
            "lembrar, pois essas memórias estão sempre presentes, mesmo que de pano de fundo, quando você tem outros\n" +
            "pensamentos em foco, elas nunca o deixaram. Elas são o combustível que te fizeram chegar até aqui. E você\n" +
            "sabe que não irá desistir até ter vingado a morte daqueles que foram - e pra sempre serão - sua fonte de\n" +
            "amor e desejo de continuar vivo. O maldito líder finalmente pagará por tanto mal causado na vida de tantos\n" +
            "(e principalmente na sua).\n"),
    GLORIA("Glória","Você já consegue visualizar na sua mente o povo da cidade te recebendo de braços\n" +
            "abertos, bardos criando canções sobre seus feitos heróicos, nobres te presenteando com jóias e diversas\n" +
            "riquezas, taberneiros se recusando a cobrar por suas bebedeiras e comilanças. Desde já, você sente o amor\n" +
            "do público, te louvando a cada passo que dá pelas ruas, depois de destruir o vilão que tanto assombrou a\n" +
            "paz de todos. Porém, você sabe que ainda falta o último ato dessa história. Você se concentra na missão.\n" +
            "A glória o aguarda, mas não antes da última batalha.\n");

    private final String nome;
    private final String texto;

    TiposDeMotivacao(String nome, String texto) {
        this.nome = nome;
        this.texto = texto;
    }

    public String toString() {
        String saida = "%d - %s";
        return String.format(saida, ordinal()+1, this.nome);
    }

    public String getNome() {
        return nome;
    }

    public String getTexto() {
        return texto;
    }
}
