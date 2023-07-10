import java.util.Scanner;
import java.util.Random;

public class Ass02_Craps {
    public static void main(String[] args) {

        Random rnd = new Random();

        Scanner in = new Scanner(System.in);

        int dice1;
        int dice2;
        int crapsRoll;

        String continueYN = "";

        String trash = "";
        boolean done = false;

        boolean gameOver = false;
        boolean gameContinue = true;


        do {

            dice1 = rnd.nextInt(6) + 1;
            dice2 = rnd.nextInt(6) + 1;
            crapsRoll = dice1 + dice2;

            System.out.println("\nThe first die is: " + dice1 + ", the second die is: " + dice2 + ", and the sum is: " + crapsRoll);

            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                System.out.println("You crapped out and lost!\n");
            }
            else if (crapsRoll == 7 || crapsRoll == 11) {
                System.out.println("You won with a natural!\n");
            }
            else {

                System.out.println("The sum of " + crapsRoll + " is now the point");
                System.out.println("");
                int point = crapsRoll;

                while (!gameOver) {
                    dice1 = rnd.nextInt(6) + 1;
                    dice2 = rnd.nextInt(6) + 1;
                    crapsRoll = dice1 + dice2;

                    System.out.println("The first die is: " + dice1 + ", the second die is: " + dice2 + ", and the sum is: " + crapsRoll);

                    if (crapsRoll == point) {
                        System.out.println("You made the point of " + point + " and won!");
                        gameOver = true;
                    } else if (crapsRoll == 7) {
                        System.out.println("You got a seven and lost!");
                        gameOver = true;
                    } else {
                        System.out.println("You are trying for a point");
                    }

                    System.out.println("");
                }

            }

            do {

                System.out.print("Do you want to play again [Y/N]: ");

                if (in.hasNext()) {
                    continueYN = in.nextLine();

                    if (continueYN.equalsIgnoreCase("Y") || continueYN.equalsIgnoreCase("N")) {

                        done = true;

                        if (continueYN.equalsIgnoreCase("N"))
                            gameContinue = false;

                    } else {
                        System.out.println("\nYou said your choice was: " + continueYN);
                        System.out.println("You have to choose a valid option [Y/N]\n");
                    }
                } else {
                    trash = in.nextLine();
                    System.out.println("\nYou said your choice was: " + trash);
                    System.out.println("You have to choose a valid option [Y/N]\n");

                }
            }
            while (!done);

            gameOver = false;
            done = false;
        }

        while (gameContinue);
    }
}