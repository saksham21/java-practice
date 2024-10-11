package game;

import java.io.InputStream;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameService game = new GameService();
        System.out.println("Welcome to Rock-Paper-Scissors!");
        System.out.print("Player 1, enter your choice (rock, paper, scissors): ");
        String player1Choice = scanner.nextLine().toLowerCase();

        System.out.print("Player 2, enter your choice (rock, paper, scissors): ");
        String player2Choice = scanner.nextLine().toLowerCase();

        String result = game.determineWinner(player1Choice, player2Choice);
        System.out.println(result);

        scanner.close();
    }
}
