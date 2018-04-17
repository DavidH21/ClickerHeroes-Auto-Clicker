package clickerheroes;

import java.util.Scanner;

import clickerheroes.macro.Macro;

/** Class where Clicker Heroes is used to run program */
public class ClickerHeroes {
	private Scanner input; // To get user input
	private Macro macro; // To run the Macro class to run many of the automation for Clicker Heroes

	/** Initialize ClickerHeroes' object fields */
	public ClickerHeroes() {
		input = new Scanner(System.in); // Get input from user via standard input
		macro = new Macro(); // Macros to automate 
	}

	/** Method used to run the program. The hub, if you will. */
	public void run() {
		introduction(); // Display introduction

		menu(); // The hub of the program. Where the heart of the program starts and ends

	}

	/** Display the menu, and run the choices */
	private void menu() {
		boolean quitProgram = false; // Flag to end Program Loop

		// Program Loop
		while (!quitProgram) {
			// Display options to pick from
			System.out.println("End Program - 0");
			System.out.println("Requirements - 1");
			System.out.println("Instructions - 2");
			System.out.println("Level Heroes - 3");
			System.out.println("Level Ancients - 4");

			// Get user input to decide which case to use 
			int option = input.nextInt();
			System.out.println(); // Blank line 

			// Cases that correspond with the options
			switch (option) {
			case 0: {
				System.out.println("Program End");
				quitProgram = true;
			}
				break;
			case 1:
				requirements(); // Display requirements to run the program
				break;
			case 2:
				instruction(); // Display how to use the program
				break;
			case 3:
				levelHeroes(); // Level heroes
				break;
			case 4:
				macro.levelAncientActiveBuild(); // Level ancients using the Kepow calculator 
				break;
			default: {
				// User gave an option that wasn't listed
				System.out.println("INVALID INPUT - " + option);
			}
			}

		}
	}

	/**
	 * Gets user to input a valid number to return. A valid number is 0 or higher
	 */
	private int getValidOption() {
		boolean validNumber = false;
		int option = -1; // holds the valid option

		// Test until input is 0 or positive number (valid number)
		do {
			String inputTest = input.next(); // Get user input
			input.nextLine(); // Eat remaining token 

			// If a 0 or positive number then true, else invalid
			if (inputTest.matches("\\d+")) {
				option = Integer.parseInt(inputTest);
				validNumber = true;
			} else {
				System.out.println("INVALID INPUT - " + inputTest + ". Positive Numbers Only");
			}
		} while (!validNumber); // Exit once a valid number is found (0 or higher)

		return option; // A validated number inputed from the user that is 0 or higher 
	}

	/**
	 * Level heroes automatically up to Frostleaf. Must know the strongest hero seen
	 * after the first kill otherwise clicks would be incorrect.
	 */
	private void levelHeroes() {
		// Option to choose from
		System.out.println("What is the strongest hero seen after first kill?");
		System.out.println(); // Blank line
		System.out.println("Quit - 0");
		System.out.println("Dread Knight - 1");
		System.out.println("Atlas - 2");
		System.out.println("Terra - 3");
		System.out.println("Phthalo - 4");
		System.out.println("Didensy - 5");
		System.out.println("Lilin - 6");
		System.out.println("Cadmia - 7");
		System.out.println("Alabaster - 8");
		System.out.println("Astraea - 9");
		System.out.println("Chiron - 10");
		System.out.println("Moloch - 11");
		System.out.println("Bomber Max - 12");
		System.out.println("Gog - 13");
		System.out.println("Wepwawet - 14");
		System.out.println("Tsuchi - 15");
		System.out.println("Skogur - 16");
		System.out.println(); // Blank line

		int heroOption = getValidOption(); // Get a valid option from user

		// Select highest hero available in order to level heroes
		switch (heroOption) {
		case 0: {
			System.out.println("Quit - Hero Leveling Section");
		}
			break;
		case 1:
			macro.levelHeroesDreadKnight(); // Level all the heroes needed when Dread Knight is the strongest hero
			break;
		case 2:
			macro.levelHeroesAtlas();
			break;
		case 3:
			macro.levelHeroesTerra();
			break;
		case 4:
			macro.levelHeroesPhthalo();
			break;
		case 5:
			macro.levelHeroesDidensy();
			break;
		case 6:
			macro.levelHeroesLilin();
			break;
		case 7:
			macro.levelHeroesCadmia();
			break;
		case 8:
			macro.levelHeroesAlabaster();
			break;
		case 9:
			macro.levelHeroesAstraea();
			break;
		case 10:
			macro.levelHeroesChiron();
			break;
		case 11:
			macro.levelHeroesMoloch();
			break;
		case 12:
			macro.levelHeroesBomberMax();
			break;
		case 13:
			macro.levelHeroesGog();
		case 14:
			macro.levelHeroesWepwawet();
			break;
		case 15:
			macro.levelHeroesTsuchi();
			break;
		case 16:
			macro.levelHeroesSkogur();
		default: {
			System.out.println("Invalid - " + heroOption + " is not a valid option");
		}
		}
	}

	/** Introduction for user */
	private void introduction() {
		System.out.println("Welcome to Clicker Heroes Automation");
		System.out.println(); // Blank line

		System.out.println("Please read the Requirements and Instructions! (Highly Recommended)");
		System.out.println(); // Blank line

	}

	/** Requirements for user */
	private void requirements() {
		System.out.println("Requirements:");
		System.out.println("- Must be Windows 7");
		System.out.println("- Must use Firefox [58.0.1 Version Tested] Other browsers not tested");
		System.out.println("- Must have Clicker Heroes on Full Screen");
		System.out.println("- Must be a 20 inch monitor");
		System.out.println("- Must be 1600 x 900");
		System.out.println("- Mouse scroll must be on Windows default of 3.");
		System.out.println(); // Blank line
	}

	/** Instructions for user */
	private void instruction() {

		System.out.println("Instructions:");
		System.out.println("- Moving the mouse while automation going on will the END PROGRAM");
		System.out.println("- Drag Clicker Heroes as the first icon on the Windows 7 taskbar");
		System.out.println("- Drag Firefox as the second icon on the taskbar");
		System.out.println(
				"- Manually put the save file information on https://kepow.org/clickerheroes/ (Calculator) [2018/01/29 Version Tested]");
		System.out.println("- https://kepow.org/clickerheroes/ Must be the current browser tab");
		System.out.println("- Must be in the Ancients Tab (NOT on Outsiders or Other) in Kepow Calculator");
		System.out.println(); // Blank line
	}

}
