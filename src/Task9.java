import java.util.Random;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        int gameType;
        int guessAmount;
        String secretNumber;

        gameInstructions();
        gameType = chosenGameType();
        guessAmount = numberOfGuesses(gameType);
        secretNumber = secretNumberLottery();
        playerGuessSuccess(secretNumber, guessAmount, gameType);
    }

    public static void gameInstructions(){
        System.out.println("In this game you have to guess a secret number that made of 4 digits.\n\n" +
                "Instruction 1: your guess must contain only digits in the range of 1 to 6 including 1 and 6.\n\n" +
                "Instruction 2: do not guess the same digit more than once in the same guess, every time you ignore that rul you will be fined by two guesses opportunities.\n\n" +
                "Instruction 3: you have 4 game options-\noption 1 (easy game): 20 guess opportunities\noption 2 (mid level game): 15 guess opportunities\noption 3 (hard game): 10 guess opportunities\noption 4 (random game): you will get between 5-25 opportunities\n\n" +
                "Instruction 4: if you choose option 1 - 3 you will be able to see how many guesses opportunities left for you after every guess, in option 4 you will not be able to see how many guesses left for you\n\n" +
                "Instruction 5: after every guess you will get a feedback for your last guess accuracy, partial guess mean you guess right digit in the wrong place, full guess mean you have guess right digit in the right place.\nfor winning the game you have to guess all the 4 digits in the right place\ngood luck!\n");
    }

    public static int chosenGameType(){
        int gameType;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter your game choice: \n");
            gameType = scanner.nextInt();

        }while (gameType > 4 || gameType < 1);

        return gameType;
    }

    public static String secretNumberLottery(){
        int lotteryNumber;

        String secretNumber;

        do {
            Random number = new Random();
            lotteryNumber = number.nextInt(6667);
            secretNumber = Integer.toString(lotteryNumber);

        }while ((isDuplicateDigit(secretNumber)) || !isValidDigitsRange(secretNumber) || secretNumber.length() != 4);

        return secretNumber;
    }

    public static String playerGuess(){
        String playerGuess;

        do {
            System.out.println("Enter your guess: ");
            Scanner scanner = new Scanner(System.in);
            playerGuess = scanner.nextLine();

        }while (playerGuess.length() != 4 || !isValidDigitsRange(playerGuess));

        return playerGuess;
    }

    public static boolean isValidDigitsRange(String testedNumber){
        boolean isValidRange = true;

        for (int i = 0; testedNumber.length() > i; i++) {
            if ((int) testedNumber.charAt(i) > 54 || (int) testedNumber.charAt(i) < 49) { //I used ascii values,1 - 6  in ascii : 49-54
                isValidRange = false;
                break;
            }
        }
        return isValidRange;
    }

    public static int numberOfGuesses(int gameType){
        int guessAmount = 0;

        Random random = new Random();

        switch (gameType) {
            case 1:
                guessAmount = 20;
                break;

            case 2:
                guessAmount = 15;
                break;

            case 3:
                guessAmount = 10;
                break;

            case 4:
                guessAmount = random.nextInt(20) + 6;
                break;
        }
        return guessAmount;
    }

    public static boolean isSeeGuessesLeft(int gameType){
        boolean isSeeingGuessesLeft = true;
        if (gameType == 4){
            isSeeingGuessesLeft = false;
        }
        return isSeeingGuessesLeft;
    }

    public static boolean isDuplicateDigit(String testedNumber){
        boolean isDuplicateDigit = false;
        int i;
        int m;
        for (i = 0; testedNumber.length() > i; i++){
            for (m = 0; testedNumber.length() > m; m++){
                if (testedNumber.charAt(i) == testedNumber.charAt(m) && m != i){
                    isDuplicateDigit = true;
                    break;
                }
            }
        }
        return isDuplicateDigit;
    }

    public static void playerGuessSuccess(String secretNumber, int guessAmount, int gameType){
        int  fullGuess = 0;
        int partialGuess = 0;
        boolean isPartialGuess;
        boolean isWin = false;

        while (guessAmount > 0 && !isWin){
            String playerGuess = playerGuess();

            for (int c = 0; playerGuess.length() > c; c++){
                if (playerGuess.charAt(c) == secretNumber.charAt(c)){
                    fullGuess = fullGuess + 1;
                }
            }

            for (int m = 0; playerGuess.length() > m; m++){
                isPartialGuess = false;
                for (int t = 0; playerGuess.length() > t; t++){
                    if (secretNumber.charAt(m) == playerGuess.charAt(t)){
                        isPartialGuess = true;
                        break;
                    }
                }
                if ((playerGuess.charAt(m) != secretNumber.charAt(m)) && isPartialGuess){
                    partialGuess = partialGuess + 1;
                }
            }

            System.out.println("Full guesses: " + fullGuess);
            System.out.println("Partial guesses: " + partialGuess);

            if (fullGuess == 4){
                isWin = true;
            }
            partialGuess = 0;
            fullGuess = 0;


            if (isDuplicateDigit(playerGuess)){
                guessAmount = guessAmount -2;
                System.out.println("You have been fined because your last guess contain duplicate digits");
            }
            guessAmount = guessAmount -1;

            if (isSeeGuessesLeft(gameType) && guessAmount > 0 && !isWin){ // The reasons why guessAmount have to be bigger than 0: 1) That means the player run out of tries and fail guessing the secret number and end of game message will appear anyway. 2) not right to print the player negative number in case he guesses the same digit more than once while he got 2 or fewer guesses left
                System.out.println("guesses left: "+ guessAmount);
            }

        }
        if (isWin){
            System.out.println("You won! the secret number is indeed: " + secretNumber);
        }
        else {
            System.out.println("You failed guessing the secret number, the secret number is: " + secretNumber);
        }
    }
}