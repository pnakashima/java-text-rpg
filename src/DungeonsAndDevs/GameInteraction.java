package DungeonsAndDevs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//import org.apache.commons.lang.WordUtils;

public class GameInteraction {
    public String title;
    public List<String> intro;
    public List<String> menu;
    public List<String> menuValues;
    public List<String> optionTexts;
    public List<Integer> optionAttributes;

    public GameInteraction() {
    }


    public GameInteraction(String title, List<String> menu, List<String> menuValues) {
        this.title = title;
        this.menu = menu;
        this.menuValues = menuValues;
    }

    public void printTitle() {
        System.out.println(this.title);
    }

    public void printMenu() {
        int i = 0;
        for (String item : this.menu) {
            i++;
            System.out.println(i + " - " + item); // imprime a opção, com o índice
        }
    }

    public String playerChoice() {
        String choice ="";
        while (choice=="") {
            Game.clearConsole();
            Game.printHeading(this.title);
            printMenu();
            int choices = this.menu.size();
            int index = Game.readInt(choices);
            choice = this.menuValues.get(index-1);
            if (Game.confirmChoice(choice) == 2)
                choice = "";
        }
        return choice;
    }


    public List<Integer> getOptionAttributes() {

        return optionAttributes;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getIntro() {
        return intro;
    }

    public List<String> getMenu() {
        return menu;
    }


    public List<String> getOptionTexts() {
        return optionTexts;
    }

}
