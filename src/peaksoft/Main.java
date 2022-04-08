package peaksoft;

import peaksoft.dice.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        game();
    }

    public static void newGames() {
        int newGame = scanner.nextInt();
        switch (newGame) {
            case 1 -> game();
            case 2 -> System.out.println("Game over");
        }
    }

    public static void game() {
        List<Integer> userGuessedNumber = new ArrayList<>();
        List<Integer> computerGuessedNumber = new ArrayList<>();
        List<Integer> computerRollsRandomNumber = new ArrayList<>();
        List<Integer> userRollsRandomNumber = new ArrayList<>();
        List<Integer> scoreOfUser = new ArrayList<>();
        List<Integer> scoreOfComputer = new ArrayList<>();


        Sides cubeService = new User();
        Sides cubeService1 = new Computer();
        int counter = 2;
        int round = 0;
        System.out.println("---       Strat game       ---");
        do {
            System.out.println();
            System.out.print("Predict amount of points (2..12) : ");
            int guessNumberUser = scanner.nextInt(); //7
            System.out.println("""
                    
                    Cheat - 1
                    Don't cheat - 2""");
            int toCheatOrNotToCheat = scanner.nextInt(); //1
            int userRandomRoll = cubeService.dice();
            boolean guessedOrNotGuessed = true;
            if (toCheatOrNotToCheat == 1) {
                int chance = random.nextInt(1,  counter + 1);
                int chance1 = random.nextInt(1, counter + 1);
                guessedOrNotGuessed = false;
                //Round 1: 1 chance out of 2 (50% to 50%) Round 2: 1 chance out of 4 (one to 4) Round 3: 1 chance out of 6 (one out of six)
                System.out.println("Two random numbers matched or not? " + chance + " = " + chance1);
                if (chance == chance1) {
                    userRandomRoll = guessNumberUser;
                    guessedOrNotGuessed = true;
                }
            }
            userGuessedNumber.add(guessNumberUser);
            System.out.println("\nUser rolls the dices...");
            userRollsRandomNumber.add(userRandomRoll);
            int scoreUser = userRandomRoll - (Math.abs(userRandomRoll - guessNumberUser) * 2);
            int overwriteUserScore;
            if (!guessedOrNotGuessed) {
                System.out.println("NotToCheat - 10 points ");
                overwriteUserScore = scoreUser - 10;
            } else {
                overwriteUserScore = scoreUser;
            }
            scoreOfUser.add(overwriteUserScore);
            int guessNumberComputer = random.nextInt(2, 13);
            computerGuessedNumber.add(guessNumberComputer);
            System.out.printf("""
                    On the dice fell %d points
                    Result is %d - abs(%d - %d) * 2: %d
                                
                    Computer predicted %d points
                    Computer rolls the dices
                    """, userGuessedNumber, userRandomRoll, userRandomRoll, guessNumberUser, overwriteUserScore, guessNumberComputer);
            int computerRollsRandomly = cubeService1.dice();
            if (!guessedOrNotGuessed) {
                int chance = random.nextInt(1,  counter + 1);
                int chance1 = random.nextInt(1, counter + 1);
                System.out.println("Two random numbers matched or not? " + chance + " - " + chance1);
                if (chance == chance1) {
                    computerRollsRandomNumber = computerGuessedNumber;
                }
            }
            computerRollsRandomNumber.add(computerRollsRandomly);
            int scoreComputer = computerRollsRandomly - (Math.abs(computerRollsRandomly - guessNumberComputer) * 2);
            scoreOfComputer.add(scoreComputer);
            System.out.printf("""
                    On the dice fell %d points
                    Result is %d - abs(%d - %d) * 2: %d""", computerRollsRandomNumber, computerRollsRandomNumber, computerRollsRandomNumber, computerGuessedNumber, scoreComputer);
            if (scoreUser > scoreComputer) {
                int score = scoreUser - scoreComputer;
                System.out.printf("""
                                                
                        User wins %d points more
                        Congratulations!
                        """, score);
            } else {
                int score = scoreComputer - scoreUser;
                System.out.printf("""
                                                
                        Computer wins %d points more
                        Congratulations!
                                                
                        """, score);
            }
            int currentScore = Math.abs(scoreComputer - scoreUser);
            System.out.printf("""
                    ---------- Current score ----------
                    User       %d points
                    Computer   %d points
                    """, scoreUser, scoreComputer);
            if (scoreUser > scoreComputer) {
                System.out.printf("""
                                                
                        Users is ahead by %d points!
                        -----------------------------------""", currentScore);
            }
            round++;
            counter += 2;
        } while (round < 3);
        System.out.println("""
                                
                -------------- Finish game --------------
                                
                 Round |         User   |   Computer
                -------+----------------+----------------""");
        int counter1 = 0;
        for (int i = 0; i < 3; i++) {
            counter++;
            System.out.printf("""
                                   | Predicted   %d  | Predicted  %d
                            - %d - | Dice        %d  | Dice       %d
                                   | Result      %d  | Result     %d
                            -------+-----------------+----------------
                            """, userGuessedNumber.get(i), computerGuessedNumber.get(i),
                    counter, userRollsRandomNumber.get(i), computerRollsRandomNumber.get(i), scoreOfUser.get(i), scoreOfComputer.get(i));
        }
        int userPoints = 0;
        int computerPoints = 0;
        for (int i = 0; i < 3; i++) {
            userPoints += scoreOfUser.get(i);
            computerPoints += scoreOfComputer.get(i);
        }
        System.out.printf("""
                Total  | Points      %d | Points      %d
                """, userPoints, computerPoints);
        int totalPoints = Math.abs(computerPoints - userPoints);
        if (userPoints > computerPoints) {
            System.out.printf("""
                    User wins %d points more. Congratulations!""", totalPoints);
        } else {
            System.out.printf("""
                    Computer wins %d points more. Congratulations!""", totalPoints);
        }
        System.out.println("""
                                
                Continue game?
                yes - 1
                no - 2""");
        newGames();
    }
}