package Enums;

import java.util.Arrays;
import java.util.List;

public enum PlayerGenders {
    MASCULINO("Masculino",20, Arrays.asList("Guerreiro", "Arqueiro")),
    FEMININO("Feminino", 20, Arrays.asList("Mago", "Estudante do SENAI"));

    private final String genderName;
    private final int powerUpPoints;
    private final List<String> powerUpClasses;

    PlayerGenders(String genderName, int powerUpPoints, List<String> powerUpClasses) {
        this.genderName = genderName;
        this.powerUpPoints = powerUpPoints;
        this.powerUpClasses = powerUpClasses;
    }

    public String getGenderName() {
        return genderName;
    }

    public int getPowerUpPoints() {
        return powerUpPoints;
    }

    public List<String> getPowerUpClasses() {
        return powerUpClasses;
    }
}
