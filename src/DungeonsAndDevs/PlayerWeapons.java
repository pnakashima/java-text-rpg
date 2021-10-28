package DungeonsAndDevs;

public enum PlayerWeapons {

    ESPADA("Espada", "", 25, "Guerreiro"),
    MACHADO("Machado", "", 20, "Guerreiro"),
    MARTELO("Martelo", "", 15, "Guerreiro"),
    CLAVA("Clava", "", 10, "Guerreiro"),

    ARCO("Arco", "flecha", 20, "Arqueiro"),
    BESTA("Besta", "virote", 15, "Arqueiro"),

    CAJADO("Cajado", "", 20, "Mago"),

    LIVRO("Livro", "", 50, "Estudante do SENAI");

    private String name;
    private String ammo;
    private Integer damage;
    private String playerClass;


    private PlayerWeapons(String name, String ammo, Integer damage, String playerClass) {
        this.name = name;
        this.ammo = ammo;
        this.damage = damage;
        this.playerClass = playerClass;
    }

    public String toString() {
        String saida = (this.ammo == "") ? "%s %s" : "%s e %s";
        return String.format(saida, this.name, this.ammo);
    }

    public String getName() {
        return name;
    }

    public String getAmmo() {
        return ammo;
    }

    public Integer getDamage() {
        return damage;
    }

    public String getPlayerClass() {
        return playerClass;
    }

}

