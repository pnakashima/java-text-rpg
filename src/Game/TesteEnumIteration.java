package Game;

public class TesteEnumIteration {

    public static void main(String[] args) {
        TiposDeArma armas[] = TiposDeArma.values();
        System.out.println("Tipos de Arma: ");
        for (TiposDeArma arma: armas) {
            if (arma.getClasse().equals("guerreiro"))
            System.out.println(arma);
        }
    }
}
