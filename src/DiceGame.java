import java.util.Scanner;

class DiceGame {
    private static final int minValueOnTheDice = 1;
    private static final int maxValueOnTheDice= 6;
    private static final int numberOfGameRound = 5;
    private static final int maxNumberOfThrows = 10;
    private static final int firstThrow = 1;
    private static final int winningSum_5 = 5;
    private static final int winningSum_7 = 7;
    private static final int winningSum_11 = 11;
    private static final int lostSum_2 = 2;
    private static final int lostSum_12 = 12;

    private void isValueOfTheThrowCorrect (int valueOfTheThrow) throws IllegalArgumentException {
        if (valueOfTheThrow < minValueOnTheDice || valueOfTheThrow > maxValueOnTheDice)
            throw new IllegalArgumentException("Value of the dice out of range! The allowed range is (1-6).");
    }

    private float gameRound (Player player) {
        int numberOfTheThrow = 1;
        int firstDice, secondDice;
        float sumOfPointsOnDices = 0f, sumOfPlayerPoints = 0f;
        Scanner throwOfThePlayer = new Scanner(System.in);
        while (numberOfTheThrow <= maxNumberOfThrows) {
            System.out.println("\nPlayer " + player.getNameOfPlayer() + ", enter the value on the first dice (1-6).");
            firstDice = throwOfThePlayer.nextInt();
            try {
                isValueOfTheThrowCorrect(firstDice);
            } catch (Exception e) {
                System.out.println("\nValue out of range. Please, enter the number of points on the first dice one more time  (1-6).");
                firstDice = throwOfThePlayer.nextInt();
            }
            System.out.println("\nPlayer " + player.getNameOfPlayer() + ", enter the value on the second dice (1-6).");
            secondDice = throwOfThePlayer.nextInt();
            try {
                isValueOfTheThrowCorrect(secondDice);
            } catch (Exception e) {
                System.out.println("\nValue out of range. Please, enter the number of points on the first dice one more time  (1-6).");
                secondDice = throwOfThePlayer.nextInt();
            }
            sumOfPointsOnDices = firstDice + secondDice;
            System.out.println("\nPlayer " + player.getNameOfPlayer() + ":\nValue on the first dice: " + firstDice + "\nValue on the second dice: " + secondDice);
            System.out.println("Sum of the player's points in this throw: " + sumOfPointsOnDices);

            if (((numberOfTheThrow == firstThrow) && (sumOfPointsOnDices == winningSum_7)) || (sumOfPointsOnDices == winningSum_11)) {
                System.out.println("\nPlayer " + player.getNameOfPlayer() + " wins the round.");
                break;
            } else if (((numberOfTheThrow == firstThrow) && (sumOfPointsOnDices == lostSum_2)) || (sumOfPointsOnDices == lostSum_12)) {
                System.out.println("\nPlayer " + player.getNameOfPlayer() + " loses the round.");
                sumOfPlayerPoints += 120.0;
                break;
            } else if (sumOfPointsOnDices == winningSum_5) {
                System.out.println("\nPlayer " + player.getNameOfPlayer() + " wins the round.");
                break;
            } else {
                sumOfPlayerPoints += sumOfPointsOnDices / numberOfTheThrow;
            }
            numberOfTheThrow++;
        }
        return  sumOfPlayerPoints;
    }

    public void startGame() {
        Player player1 = new Player("First");
        Player player2 = new Player("Second");
        float sumOfPlayer1Points = 0f, sumOfPlayer2Points = 0f;
        int numberOfRound = 1;
        while (numberOfRound <= numberOfGameRound) {
            System.out.println("\nRound: " + numberOfRound);
            sumOfPlayer1Points += gameRound(player1);
            sumOfPlayer2Points += gameRound(player2);
            System.out.println("\nSummary after round: ");
            System.out.println("Player " + player1.getNameOfPlayer() + " has " + sumOfPlayer1Points + " points.");
            System.out.println("Player " + player2.getNameOfPlayer() + " has " + sumOfPlayer2Points + " points.");
            numberOfRound++;
        }
        System.out.println("\nEnd results: ");
        System.out.println("Sum of " + player1.getNameOfPlayer() + " player points: " + sumOfPlayer1Points + ".");
        System.out.println("Sum of " + player2.getNameOfPlayer() + " player points: " + sumOfPlayer2Points + ".");

        if (sumOfPlayer1Points < sumOfPlayer2Points)
            System.out.println("\n" + player1.getNameOfPlayer() + " player has won!");
        else if (sumOfPlayer1Points == sumOfPlayer2Points)
            System.out.println("\nIt is a draw!");
        else
            System.out.println("\n" + player2.getNameOfPlayer() + " player has won!");
    }
}
