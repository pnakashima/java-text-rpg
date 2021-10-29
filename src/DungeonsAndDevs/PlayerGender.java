package DungeonsAndDevs;

import java.util.List;

public class PlayerGender {
    private String genderName;
    private int powerUpPoints;
    private List<String> powerUpClasses;

    public PlayerGender(String genderName, int powerUpPoints, List<String> powerUpClasses) {
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
