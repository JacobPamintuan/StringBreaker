/*
 * StringBreakerPlayer.java
 * Object Orient Programming Assignment 1
 * ICS3U1
 * Jacob Pamintuan & Vanessa Mac
 * November 21, 2019
 * The stringBreakerproject package contains the files for the StringBreaker application.
 */

package sBProjectReturn;

import java.util.Scanner;

/**
 * The StringBreakerGame class contains the background code for the
 * StringBreaker application. The methods in the StringBreakerPlayer class are
 * instantiated in the client code as the player object.
 */

public class StringBreakerPlayer {

	final char A = 'A', B = 'B', C = 'C', D = 'D', E = 'E';

	public static int length, numGuesses;
	public static String playerGuess;

	/**
	 * Constructor pre: none post: Set default length, numGuesses, and playerGuess
	 */
	public StringBreakerPlayer() {
		length = 0;
		playerGuess = "";
		numGuesses = 0;
	}

	/**
	 * Prompts and returns the player's guess. pre: none post: Returns the
	 * playerGuess.
	 */
	public String makeGuess() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your guess (no spaces): ");
		playerGuess = input.next();

		return (playerGuess);
	}

	/**
	 * Validate whether or not the length is valid (3,4, or 5) pre: none post:
	 * Returns true if accepted value is a valid length or false if otherwise.
	 */
	public boolean validateLength(int num) {
		length = num;

		if (length < 3 || length > 5) {
			return (false);
		} else {
			return (true);
		}
	}

	/**
	 * Validate whether or not the number of guesses is a positive value greater
	 * than or equal to 1. pre: none post: Returns true if accepted value is a
	 * number of guesses or false if otherwise.
	 */
	public boolean validateGuesses(int num) {
		numGuesses = num;
		if (numGuesses < 1) {
			System.out.println("ERROR: Please enter a valid number");
			return (false);
		} else {
			return (true);
		}
	}

	/**
	 * Validate whether or not the userGuess contains on letters from A to E. pre:
	 * none post: Returns true if accepted string contains only A to E, false if
	 * otherwise.
	 */
	public boolean validateUserGuess(String input) {
		char l;
		final char A = 'A', B = 'B', C = 'C', D = 'D', E = 'E';
		input = input.toUpperCase();
		if (input.length() != length) {
			System.out.println("ERROR: Please enter a valid string (DID NOT COUNT AS TURN)");
			return (false);
		} else {
			for (int i = 0; i < length; i++) {
				l = input.charAt(i);
				if (l != A && l != B && l != C && l != D && l != E) {
					System.out.println("ERROR: Please enter a valid string (DID NOT COUNT AS TURN)");
					return (false);
				}
			}
			return (true);
		}
	}
}