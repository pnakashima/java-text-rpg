package DungeonsAndDevs;

import java.util.List;
import java.util.Scanner;

// Esta classe contém os métodos para leitura de entradas do usuário e impressão de textos na tela

public class TextInterface {
    private String title;
    private List<String> menu;
    private List<String> menuValues;
    private static final String LINEBREAK = "\n";

    public TextInterface(String title, List<String> menu, List<String> menuValues) {
        this.title = title;
        this.menu = menu;
        this.menuValues = menuValues;
    }

    public TextInterface(String title, List<String> menu) {
        this.title = title;
        this.menu = menu;
    }

    // Método para leitura de escolha do usuário
    public static int readInt(int options) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        while (input < 1 || input > options) {
            System.out.println("\nDigite sua escolha:");
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                input = 0;
                System.out.println("\nDigite um número entre as opções!");
            }
        }
        return input;
    }

    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printTitle(String title) {
        printSeparator(80);
        System.out.println(title);
        printSeparator(80);
    }

    public static void enterToContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }

    public static int confirmChoice(String choice) {
        printTitle("Sua escolha é: " + choice.toUpperCase() + ".\nDeseja continuar?");
        System.out.println("1 - Sim!");
        System.out.println("2 - Não, quero trocar de escolha.");
        return readInt(2);
    }

    public void printMenu() {
        int i = 0;
        for (String item : this.menu) {
            i++;
            System.out.println(i + " - " + item); // imprime a opção, com o índice
        }
    }

    // Método para leitura, confirmação e verificação da escolha do usuário
    public int playerChoice() {
        int choice = 0;
        while (choice == 0) {
            printTitle(this.title);
            printMenu();
            choice = readInt(this.menu.size());
            if (this.menuValues != null && (confirmChoice(this.menuValues.get(choice - 1)) == 2)) {
                choice = 0;
                clearConsole();
            } else if (this.menuValues == null && (confirmChoice(this.menu.get(choice - 1)) == 2)){
                choice = 0;
                clearConsole();
            }
        }
        return choice;
    }

    public static void printText(String text) {
        System.out.println(wrap(text, 80));
    }

    public static String wrap(String string, int lineLength) {
        StringBuilder b = new StringBuilder();
        for (String line : string.split(LINEBREAK)) {
            b.append(wrapLine(line, lineLength));
        }
        return b.toString();
    }

    private static String wrapLine(String line, int lineLength) {
        if (line.length() == 0) return LINEBREAK;
        if (line.length() <= lineLength) return line + LINEBREAK;
        String[] words = line.split(" ");
        StringBuilder allLines = new StringBuilder();
        StringBuilder trimmedLine = new StringBuilder();
        for (String word : words) {
            if (trimmedLine.length() + 1 + word.length() <= lineLength)
                trimmedLine.append(word).append(" ");
            else {
                allLines.append(trimmedLine).append(LINEBREAK);
                trimmedLine = new StringBuilder();
                trimmedLine.append(word).append(" ");
            }
        }
        if (trimmedLine.length() > 0) {
            allLines.append(trimmedLine);
        }
        allLines.append(LINEBREAK);
        return allLines.toString();
    }

}
