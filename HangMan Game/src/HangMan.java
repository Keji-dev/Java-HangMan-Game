import java.util.Scanner;

public class HangMan {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String secretWord = "house";
        int maxTries = 10;
        int tries = 0;
        boolean guessedWord = false;

        char[] guessedLetters = new char[secretWord.length()];

        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        while (!guessedWord && tries < maxTries) {

            System.out.println("Guess the word: " + String.valueOf(guessedLetters) + " with " + secretWord.length() + " letters");
            System.out.println("Write a letter, please");
            char letter = scan.next().toLowerCase().charAt(0);

            boolean correctLetter = false;

            for (int i = 0; i < secretWord.length(); i++) {

                if (secretWord.charAt(i) == letter) {
                    guessedLetters[i] = letter;
                    correctLetter = true;
                }
            }

            if (!correctLetter) {
                tries++;
                System.out.println("Wrong! You have " + (maxTries - tries) + " tries left, try again");
            }

            if(String.valueOf(guessedLetters).equals(correctLetter)) {
                guessedWord = true;
                System.out.println("Congrats! You have guessed the secret word: " + secretWord);
            }

        }

        if (!guessedWord) {
            System.out.println("Game over, you have no tries left!");
        }

        scan.close();
    }
}
