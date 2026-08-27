package com.gla.String.Level2;
import java.util.Scanner;
public class RockPaper {
    public static String computerChoice() {

        int choice = (int) (Math.random() * 3);

        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        }

        return "Scissors";
    }

    public static String findWinner(String user, String computer) {

        if (user.equals(computer)) {
            return "Draw";
        }

        if (user.equals("Rock") && computer.equals("Scissors") ||
                user.equals("Paper") && computer.equals("Rock") ||
                user.equals("Scissors") && computer.equals("Paper")) {
            return "Player";
        }

        return "Computer";
    }

    public static String[][] calculateStats(int playerWins,
                                            int computerWins,
                                            int draws,
                                            int games) {

        double playerPercentage =
                (playerWins * 100.0) / games;

        double computerPercentage =
                (computerWins * 100.0) / games;

        String[][] result = new String[3][3];

        result[0][0] = "Player";
        result[0][1] = String.valueOf(playerWins);
        result[0][2] = String.format("%.2f%%", playerPercentage);

        result[1][0] = "Computer";
        result[1][1] = String.valueOf(computerWins);
        result[1][2] = String.format("%.2f%%", computerPercentage);

        result[2][0] = "Draw";
        result[2][1] = String.valueOf(draws);
        result[2][2] = String.format("%.2f%%",
                (draws * 100.0) / games);

        return result;
    }

    public static void displayResults(String[][] games,
                                      String[][] stats) {

        System.out.println("\nGame Results");
        System.out.println("Game\tPlayer\tComputer\tWinner");

        for (int i = 0; i < games.length; i++) {
            System.out.println(
                    games[i][0] + "\t" +
                            games[i][1] + "\t" +
                            games[i][2] + "\t\t" +
                            games[i][3]
            );
        }

        System.out.println("\nStatistics");
        System.out.println("Player\tWins\tPercentage");

        for (int i = 0; i < stats.length; i++) {
            System.out.println(
                    stats[i][0] + "\t" +
                            stats[i][1] + "\t" +
                            stats[i][2]
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int numberOfGames = sc.nextInt();

        String[][] games = new String[numberOfGames][4];

        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;

        for (int i = 0; i < numberOfGames; i++) {

            System.out.print("Enter Rock, Paper or Scissors: ");
            String user = sc.next();

            user = user.substring(0, 1).toUpperCase()
                    + user.substring(1).toLowerCase();

            String computer = computerChoice();
            String winner = findWinner(user, computer);

            if (winner.equals("Player")) {
                playerWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            } else {
                draws++;
            }

            games[i][0] = String.valueOf(i + 1);
            games[i][1] = user;
            games[i][2] = computer;
            games[i][3] = winner;
        }

        String[][] stats =
                calculateStats(playerWins, computerWins,
                        draws, numberOfGames);

        displayResults(games, stats);

        sc.close();
    }
}
