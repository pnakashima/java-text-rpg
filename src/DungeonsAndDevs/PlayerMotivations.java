package DungeonsAndDevs;

public enum PlayerMotivations {
    VINGANCA("Vingança","Imagens daquela noite trágica invadem sua mente. Você nem precisa se esforçar para\n" +
            "lembrar, pois essas memórias estão sempre presentes, mesmo que de pano de fundo, quando você tem outros\n" +
            "pensamentos em foco, elas nunca o deixaram. Elas são o combustível que te fizeram chegar até aqui. E você\n" +
            "sabe que não irá desistir até ter vingado a morte daqueles que foram - e pra sempre serão - sua fonte de\n" +
            "amor e desejo de continuar vivo. O maldito líder finalmente pagará por tanto mal causado na vida de tantos\n" +
            "(e principalmente na sua).\n",
            "Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade. Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.",
            "Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você."),
    GLORIA("Glória","Você já consegue visualizar na sua mente o povo da cidade te recebendo de braços\n" +
            "abertos, bardos criando canções sobre seus feitos heróicos, nobres te presenteando com jóias e diversas\n" +
            "riquezas, taberneiros se recusando a cobrar por suas bebedeiras e comilanças. Desde já, você sente o amor\n" +
            "do público, te louvando a cada passo que dá pelas ruas, depois de destruir o vilão que tanto assombrou a\n" +
            "paz de todos. Porém, você sabe que ainda falta o último ato dessa história. Você se concentra na missão.\n" +
            "A glória o aguarda, mas não antes da última batalha.\n", "O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria. A glória o aguarda, você a conquistou.",
            "A glória que buscavas não será sua, e a cidade aguarda por seu(sua) próximo(a) herói(na).");

    private final String name;
    private final String text1;
    private final String text2;
    private final String text3;

    PlayerMotivations(String name, String text1, String text2, String text3) {
        this.name = name;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
    }

    public String toString() {
        String saida = "%d - %s";
        return String.format(saida, ordinal()+1, this.name);
    }

    public String getName() {
        return name;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public String getText3() {
        return text3;
    }
}
