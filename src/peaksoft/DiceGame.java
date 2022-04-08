package peaksoft;

import java.util.Random;

public class DiceGame {
    public static void main(String[] args) {
        DiceGame computer = new DiceGame();
        DiceGame user = new DiceGame();

        int computerWins = 0;
        int userWins = 0;
        System.out.printf("%1s%20s%s%20s\n","Round","User Round","Computer Round","who Won");
        System.out.println();
        for (int i = 0; i < 10; i++) {
            int userRound = user.getFace();
            int computerRound = computer.getFace();
            if (userRound > computerRound){
                userWins++;
            }
            if (computerRound > userRound){
                computerWins++;
            }
            if (computerRound == userRound){
                userWins = 0;
                computerWins = 0;
            }
            System.out.printf("%1s%20s%s%26s\n", String.valueOf(i),userRound,computerRound,whoWon(userRound,computerRound));

        }
        System.out.println("User wins: "+ userWins);
        System.out.println("Computer wins: "+ computerWins);
        System.out.println("Grand winner is: "+ whoWon(computerWins,userWins));
    }
    static String output = " ";
    public static String whoWon(int usr,int c){
        if (usr >c){
            output = "User Wins!";
        }
        if (c > usr){
            output = "Computer Wins!";
        }
        if (usr == c){
            output = "TIE!";
        }
        return output;
    }
    public int getFace(){
        Random random = new Random();
        int num = random.nextInt(6-1)+1;
        return num;
    }
    public static int getChance(int max1, int max2) {
        Random rnd = new Random();
        int n = rnd.nextInt(max2) + 1;
        if (n > max1) {
            return max2;
        } else {
            return max1;
        }
    }
}
