/*
 * StringBreakerTest.java
 * Object Orient Programming Assignment 1
 * ICS3U1
 * Jacob Pamintuan & Vanessa Mac
 * November 21, 2019
 * The stringBreakerproject package contains the files for the StringBreaker application.
 */

package sBProjectReturn;

import java.util.Scanner;

/**
 * The StringBreakerTest class contains the client code for the StringBreaker
 * application.
 */

public class StringBreakerTest {

	public static void main(String[] args) {

		int numLetters, numGuesses, numCorrectPosition, numCorrectLetters = 0, index = 0;
		boolean same = false;
		String guess;

		StringBreakerPlayer player = new StringBreakerPlayer();

		Scanner input = new Scanner(System.in);

		do {
			System.out.print("How many letters? (ENTER 3, 4, OR 5): ");
			numLetters = input.nextInt();
		} while (player.validateLength(numLetters) == false);

		StringBreakerGame game = new StringBreakerGame(numLetters);
		System.out.println(game.getSecretWord());

		do {
			System.out.print("How many guesses? ");
			numGuesses = input.nextInt();
		} while (player.validateGuesses(numGuesses) == false);

		for (int i = 0; i < numGuesses; i++) {
			index = i;

			do {
				guess = player.makeGuess();
			} while (player.validateUserGuess(guess) == false);

			game.calculateNumCorrectPosition(guess);
			numCorrectPosition = game.getNumCorrectPosition();
			System.out.println("Number of letters in the correct position: " + numCorrectPosition);

			game.calculateNumCorrectLetters(guess);
			numCorrectLetters = game.getNumCorrectLetters();
			System.out.println("Number of correct letters: " + numCorrectLetters);

			if (game.displayFinalResults(numCorrectPosition, numLetters)) {
				same = true;
				break;
			}
		}
		input.close();

		if (same) {
			System.out.println("You win!");
			System.out.println("It took you " + (index + 1) + " guess(es)");
		} else {
			System.out.println("Better luck next time!");
			System.out.println("The secret word was: " + game.getSecretWord());
		}

	}
}
