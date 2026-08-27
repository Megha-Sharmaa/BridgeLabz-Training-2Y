package com.gla.String.Level3;
import java.util.Scanner;
public class DeckOfCards {
    public static String[] initializeDeck(String[] suits, String[] ranks) {

        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int index = 0;

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }

        return deck;
    }


    public static String[] shuffleDeck(String[] deck) {

        int n = deck.length;

        for (int i = 0; i < n; i++) {

            int randomCardNumber = i + (int) (Math.random() * (n - i));

            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }

        return deck;
    }


    public static String[][] distributeCards(String[] deck, int n, int x) {

        if (n % x != 0) {
            return null;
        }

        int cardsPerPlayer = n / x;

        String[][] players = new String[x][cardsPerPlayer];

        int index = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[index];
                index++;
            }
        }

        return players;
    }


    public static void printPlayers(String[][] players) {

        for (int i = 0; i < players.length; i++) {

            System.out.println("Player " + (i + 1) + " cards:");

            for (int j = 0; j < players[i].length; j++) {
                System.out.println(players[i][j]);
            }

            System.out.println();
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        String[] ranks = {"2", "3", "4", "5", "6", "7", "8",
                "9", "10", "Jack", "Queen", "King", "Ace"};

        int numOfCards = suits.length * ranks.length;

        String[] deck = initializeDeck(suits, ranks);

        deck = shuffleDeck(deck);

        System.out.print("Enter number of players: ");
        int x = sc.nextInt();

        String[][] players = distributeCards(deck, numOfCards, x);

        if (players != null) {
            printPlayers(players);
        } else {
            System.out.println("Cards cannot be distributed equally among players");
        }

        sc.close();
    }

}
