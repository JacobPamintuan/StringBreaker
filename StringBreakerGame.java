/*
 * StringBreakerGame.java
 * Object Orient Programming Assignment 1
 * ICS3U1
 * Jacob Pamintuan & Vanessa Mac
 * November 21, 2019
 * The stringBreakerproject package contains the files for the StringBreaker application.
 */

package sBProjectReturn;

import java.lang.Math;

/**
 * The StringBreakerGame class contains the background code for the
 * StringBreaker application. The methods in the StringBreakerGame class are
 * instantiated in the client code as the game object.
 */

public class StringBreakerGame {

	public static final int A = 1, B = 2, C = 3, D = 4, E = 5;
	public static String correctWord = "";
	public static int length, numGuesses, correctLetter, correctPosition;

	/**
	 * Constructor pre: none post: A default secret word is created with a specific
	 * length and number of guesses.
	 */
	public StringBreakerGame() {
		correctWord = "ABCDE";
		length = 5;
		numGuesses = 10;
	}

	/**
	 * Constructor pre: none //does it need a pre-condition post: A random secret
	 * word is created with a specific length and number of guesses.
	 */
	public StringBreakerGame(int letters) {
		correctWord = "";
		length = letters;
		int randLetter;
		for (int i = 0; i < length; i++) {
			randLetter = (int) ((E - A + 1) * Math.random() + A);
			switch (randLetter) {
			case A:
				correctWord += "A";
				break;
			case B:
				correctWord += "B";
				break;
			case C:
				correctWord += "C";
				break;
			case D:
				correctWord += "D";
				break;
			case E:
				correctWord += "E";
				break;
			}
		}
	}

	/**
	 * Returns secret word. pre: none post: Returns the secret/correct word.
	 */
	public String getSecretWord() {
		return (correctWord);
	}

	/**
	 * Displays number of correct letters in the correct position. pre: none post:
	 * Returns the number of correct letters in the correct position.
	 */
	public void calculateNumCorrectPosition(String input) {
		input = input.toUpperCase();
		char letterGuess, letterWord;
		correctPosition = 0;

		for (int i = 0; i < length; i++) {
			letterGuess = input.charAt(i);
			letterWord = correctWord.charAt(i);
			if (letterGuess == letterWord) {
				correctPosition++;
			}
		}
	}

	public int getNumCorrectPosition() {
		return (correctPosition);
	}

	/**
	 * Displays number of correct letters. pre: none post: Returns the number of
	 * correct letters.
	 */
	public void calculateNumCorrectLetters(String input) {
		correctLetter = 0;
		input = input.toUpperCase();

		char c, g;
		int letterA = 0, letterB = 0, letterC = 0, letterD = 0, letterE = 0;

		for (int i = 0; i < length; i++) {
			g = input.charAt(i);
			for (int j = 0; j < length; j++) {
				c = correctWord.charAt(j);
				if (g == 'A' && g == c && letterA == 0) {
					correctLetter++;
					letterA = 1;
				} else if (g == 'B' && g == c && letterB == 0) {
					correctLetter++;
					letterB = 1;
				} else if (g == 'C' && g == c && letterC == 0) {
					correctLetter++;
					letterC = 1;
				} else if (g == 'D' && g == c && letterD == 0) {
					correctLetter++;
					letterD = 1;
				} else if (g == 'E' && g == c && letterE == 0) {
					correctLetter++;
					letterE = 1;
				}
			}
		}

	}

	public int getNumCorrectLetters() {
		return (correctLetter);
	}

	/**
	 * Displays final results. pre: none post: Returns true if number of tries is
	 * less than maximum number of guesses or false if otherwise.
	 */
	public boolean displayFinalResults(int a, int b) {
		if (a == b) {
			return (true);
		} else {
			return (false);
		}
	}
}