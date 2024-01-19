import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private MorseCode translator;

    public Menu() {
        scanner = new Scanner(System.in);
        translator = new MorseCode();
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Traduzir texto para Morse");
            System.out.println("2 - Traduzir Morse para texto");
            System.out.println("3 - Jogo");
            System.out.println("4 - Sair");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha

            switch (choice) {
                case 1:
                    translateTextToMorse();
                    break;
                case 2:
                    translateMorseToText();
                    break;
                case 3:
                    displayGameMenu();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    
    }
    public void displayGameMenu() {
        while (true) {
            System.out.println("\nEscolha um jogo:");
            System.out.println("1 - Traduzir letra aleatória para Morse");
            System.out.println("2 - Descodificar código Morse aleatório");
            System.out.println("3 - Voltar ao menu principal");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha

            switch (choice) {
                case 1:
                    playTranslateLetterToMorse();
                    break;
                case 2:
                    playDecodeMorseCode();
                    break;
                case 3:
                    return; // Retorna para o menu principal
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void translateTextToMorse() {
        System.out.println("Digite o texto:");
        String text = scanner.nextLine();
        System.out.println("Código Morse: " + MorseCode.toMorse(text));
    }

    private void translateMorseToText() {
        System.out.println("Digite o código Morse:");
        String morse = scanner.nextLine();
        System.out.println("Texto: " + MorseCode.fromMorse(morse));
    }

    private void playTranslateLetterToMorse() {
        char randomLetter = MorseCode.getRandomLetter();
        System.out.println("Traduza esta letra para Morse: " + randomLetter);
        String userAnswer = scanner.nextLine();
        String correctAnswer = MorseCode.toMorse(Character.toString(randomLetter)).trim();

        if (userAnswer.equals(correctAnswer)) {
            System.out.println("Correto!");
        } else {
            System.out.println("Errado! A resposta correta era: " + correctAnswer);
        }
    }

    private void playDecodeMorseCode() {
        String randomMorseCode = MorseCode.getRandomMorseCode();
        System.out.println("Decodifique este código Morse: " + randomMorseCode);
        String userAnswer = scanner.nextLine();
        String correctAnswer = MorseCode.fromMorse(randomMorseCode);

        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Correto!");
        } else {
            System.out.println("Errado! A resposta correta era: " + correctAnswer);
        }
    }



}
