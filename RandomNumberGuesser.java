/*
 * Class: CMSC203
 * Instructor: Robert Alexander
 * 
 * Description: 	The program receives the user's guess and report if the guess
 * 				is the random number that was generated. The program narrows down 
 * 				the choices according to the user's previous guesses, and continue
 * 				to prompt to enter a guess until the guess is correct.
 * 
 * Due: MM/DD/YYYY (<10/01/2020>)
 * 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: ____Auguste Basile Romeo Kiendrebeogo______
 */

import java.util.*;

public class RandomNumberGuesser {

	/* Define a Scanner class for keyboard input and a
	 * String variable for user input for program iterations
	 */
	static Scanner stdin = new Scanner(System.in);
	static String userChoice;

	public static void main(String[] args) {

		/* Let the user guess the random number generated. If the user enters
		 * an invalid entry, display an error message and allow the user to
		 * re-enter data until it is valid (only valid for the first user input)
		 */
		do {
			// Variables
			int lowGuess = 1;
			int highGuess = 100;
			int nextGuess;
			int randNum;			
			
			// Reset count and generate a random number
			RNG.resetCount();
			randNum = RNG.rand();
			// System.out.println(randNum);

			// Display program header and ask for user input. Validate input.
			System.out.println("\t\tRANDOM NUMBER GUESSER\n");
			System.out.println("This application receives a guess and report if "
					+ "your \nguess is the random number that was generated.\n\n"
					+ "Enter your first guess");
			nextGuess = stdin.nextInt();
			stdin.nextLine(); // Consume next line character (Enter key or \n)
			
			// Make sure valid input is returned to the variable nextGuess
			nextGuess = guessInputValidation(nextGuess, lowGuess, highGuess);

			// Display guesses' count number
			System.out.println("Number of guesses is "+ RNG.getCount());
			
			do {
				if (nextGuess == randNum) {} // Do nothing at this point if user's guess is correct

				else if (nextGuess < randNum) {
					System.out.println("Your guess is too low");
					lowGuess = nextGuess; // Assign user's guess to lowGuess
					System.out.println("Enter your next guess between " 
							+ lowGuess +	" and " + highGuess);
					nextGuess = stdin.nextInt();
					stdin.nextLine(); // Consume next line character (Enter key or \n)
					nextGuess = guessInputValidation(nextGuess, lowGuess, highGuess);
					System.out.println("Number of guesses is "+ RNG.getCount()); // Get incremented guess'count
				}
				
				else {
					System.out.println("Your guess is too high");
					highGuess = nextGuess; // Assign user's guess to highGuess
					System.out.println("Enter your next guess between " + 
							lowGuess +	" and " + highGuess);
					nextGuess = stdin.nextInt();
					stdin.nextLine(); // Consume next line character (Enter key or \n)
					nextGuess = guessInputValidation(nextGuess, lowGuess, highGuess);
					System.out.println("Number of guesses is "+ RNG.getCount()); // Get incremented guess'count
				}
				
			} while (nextGuess != randNum); // Iterate program until correct guess is made
			
			/* If the user makes a right guess, display a congratulations message and
			 * get user choice to try another round
			 */
			if (nextGuess == randNum) {
				System.out.println("Congratulations, you guessed correctly");
				userChoice = repeatProgram();
				stdin.nextLine(); // Consume next line character (Enter key or \n)
			}

		} while (userChoice.equalsIgnoreCase("yes")); // Iterate the program if user chooses "yes"
		
		/* If the user wants to stop the program, display a 
		 *  closing program message and the programmer's name
		 */
		System.out.println("Thanks for playing...");
		System.out.println("\nProgrammer's name: Auguste Kiendrebeogo"
				+ "\nCMSC203 Fall 2020 MONTGOMERY COLLEGE\n");
	}

	/**
	 * Method that checks if the user made a valid input. Loop until the input
	 * is valid and return this value
	 * @param nextGuess: user input
	 * @param lowGuess: lowest guess the user can make
	 * @param highGuess: highest guess the user can make
	 * @return nextGuess (int): user valid input
	 */
	public static int guessInputValidation(int nextGuess, int lowGuess, int highGuess) {
		
		while (!RNG.inputValidation(nextGuess, lowGuess, highGuess)) {
			nextGuess = stdin.nextInt();
		}
		
		return nextGuess;
	}
	
	/**
	 * Method that asks and gets the user input for another iteration of the program
	 * @return choice (String): "yes" or "no"
	 */
	public static String repeatProgram() {

		// Variable that takes user input choice
		String choice = null;

		// Ask input from user
		System.out.println("Try again? (yes or no)");
		choice = stdin.nextLine();
		while (!choice.equals("yes") && !choice.equals("no")) {
			System.out.println("Please enter 'yes' or 'no'\n"
					+ "Try again? (yes or no)");
			choice = stdin.nextLine();
		}
		
		// Return user input
		if (choice.equalsIgnoreCase("yes"))
			return "yes";
		else
			return "no";

	}

}
