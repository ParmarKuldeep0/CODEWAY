package CODEWAY.Task_01;
import  java.util.Random;
import java.util.Scanner;

public class NumberGame {
    Scanner sc = new Scanner(System.in);

//user well guess number
    int EASY_LEVEL_TURNS = 10;
    int HARD_LEVEL_TURNS = 5;
    int userPoints = 0;
//suggestion correct , too high, too low
    public int check_answer(int guess, int answer, int turns) {
        if (guess == answer) {
            System.out.println("You got it! The answer was " + answer);
            userPoints++;
            System.out.println("Your total points: " + userPoints);
            return 0;
        } else if (guess > answer) {
            System.out.println("Too high.");
        } else {
            System.out.println("Too low.");
        }

        return turns - 1;
    }
    //    user have 10 guess in easy mode in hard mode he have 5 guess
    public  int set_difficulty(){

        System.out.println("Choose a difficulty level Type  'Easy' or 'Hard': ");
        String level = sc.nextLine();
        if( level.equalsIgnoreCase("easy")){
            return  EASY_LEVEL_TURNS;
        }else if(level.equalsIgnoreCase("hard")) {
            return HARD_LEVEL_TURNS;
        }else {
            System.out.println("Invalid input. Please type 'Easy' or 'Hard'.");
        }
        return set_difficulty();
    }
//    choose random number between 1 to 100
public void game() {
    int rounds = 3; // Set the number of rounds
    int currentRound = 0;

    do {
        currentRound++;
        System.out.println("Round " + currentRound);

        System.out.println("Welcome to the Number Guess Game!");
        System.out.println("I'm thinking of a number between 1 to 100");
        Random rd = new Random();
        int answer = rd.nextInt(100) + 1;
        int turns = set_difficulty();
        int guess = 0;
        boolean guessedCorrectly = false;

        while (turns > 0) {
            System.out.println("You have " + turns + " attempts remaining to guess the number.");
            System.out.println("Make a guess: ");
            guess = Integer.parseInt(sc.nextLine());
            turns = check_answer(guess, answer, turns);

            if (turns == 0) {
                System.out.println("The correct answer was: " + answer);
            } else if (turns > 0 && guess == answer) {
                guessedCorrectly = true;
                break;
            } else {
                System.out.println("Guess again");
            }
        }

        if (guessedCorrectly) {
            userPoints++;
            System.out.println("Round " + currentRound + " over. You got it! Your total points: " + userPoints);
        } else {
            System.out.println("Round " + currentRound + " over. Your total points: " + userPoints);
        }

        // Check if there are more rounds to play
        if (currentRound < rounds) {
            System.out.println("Do you want to play the next round? Type 'y' for yes, 'n' for no: ");
            String playNextRound = sc.nextLine();
            if (!playNextRound.equalsIgnoreCase("y")) {
                break; // Exit the loop if the user doesn't want to play the next round
            }
        }

    } while (currentRound < rounds);

    System.out.println("Game over. Your final score: " + userPoints);
    System.out.println("Do you want to play again? Type 'y' for yes, 'n' for no: ");
    String playAgain = sc.nextLine();

    if (playAgain.equalsIgnoreCase("y")) {
        resetGame(); // Reset the game if the user wants to play again
        game();
    }

    sc.close();
}
    private void resetGame() {
        userPoints = 0;
    }
}
