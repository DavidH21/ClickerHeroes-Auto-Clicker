package clickerheroes.macro;

import java.awt.event.KeyEvent;
import robot.KeyboardMouse;

/**Has all the macros to automate Clicker Heroes*/
public class Macro {
	private KeyboardMouse input;

	public Macro() {
		input = new KeyboardMouse();
	}

	private final int AESTHETIC_DELAY = 100;

	/**
	 * Switch to Clicker Heroes by clicking the first icon on the Windows 7 taskbar.
	 * Clicker Heroes MUST be the first icon.
	 */
	private void switchToClickerHeroes() {
		input.mouseMove(90, 880); // Move to first icon on taskbar
		input.mouseClick(1);
		input.delay(500); // Needed to slow things down to work
	}

	/**
	 * Used to kill the first mob for gold to level heroes
	 */
	private void getInitialGoldToLevelHeroes() {
		int startPosition = 1060; // Starting position of x-coordinates
		int endPosition = 1400; // Where to end mouse. x-coordinates

		input.mouseMove(startPosition, 600); // Starting position
		input.mouseClick(1);
		input.delay(1000); // Let gold fall down before being collected

		// Move across coins to collect gold faster
		int amountOfpixels = endPosition - startPosition; // Amount of pixels to move the mouse across x-coordinates by
		// Each i represents one pixel
		for (int i = 0; i < amountOfpixels; i += 75) {
			input.mouseMove(startPosition + i, 600);
		}

	}

	/** Click the hero tab to see the list of heroes */
	private void clickHeroTab() {
		// Move to Hero Tab 
		input.mouseMove(60, 135);
		input.mouseClick(2); // 2 clicks in case there is a fish blocking hero tab
		input.delay(1700); // CH lag. Must wait for things to load
	}

	/** Click the ancient tab to see the list of ancients */
	private void clickAncientTab() {
		// Go to Ancient tab
		input.mouseMove(345, 135);
		input.mouseClick(2); // 2 clicks in case there is a fish blocking her tab
		input.delay(1000);
	}

	/** Move to the beginning of the hero or ancient list */
	private void scrollToStart() {
		// Go to the beginning of the list 
		input.mouseScroll(-20);
	}

	/**
	 * Level Ancient by copying ancient's level text box on Kepow calculator
	 * [2017/11/18 Version]. Must have focus on an ancient level text box in Firefox
	 * [58.0.1 Version].
	 * 
	 * @param xCoordinate
	 *            X-Coordinates of the ancient level box to click
	 * @param yCoordinates
	 *            Y-Coordinates of the ancient level box to click
	 * @param isLevelingArgaiv
	 *            Is the current ancient to level Argaiv? The first Ancient has
	 *            pre-tasks to help facilitate the leveling of other ancients
	 *            because of CH's weird quirks
	 */
	private void levelAncient(int xCoordinate, int yCoordinates, boolean isLevelingArgaiv) {
		// Use the Kepow calculator to level ancients
		input.keyAltTab(); // Go to calculator on Firefox [58.0.1 Version]
		input.delay(400); // Aesthetic delay

		input.keyTab(); // Move to next ancient level text box
		input.delay(200); // Aesthetic delay

		input.keyControlC(); // Copy ancient level
		input.delay(300); // Aesthetic delay		

		input.keyAltTab(); // Go back to CH
		input.delay(400); // Aesthetic delay		

		// Click anywhere in ancient list to be able to use V. (CH's weird quirk)
		if (isLevelingArgaiv) {
			input.mouseMove(390, 425);
			input.mouseClick(1);
			input.delay(400); // Aesthetic delay

		}

		input.mouseMove(xCoordinate, yCoordinates); // Move to Ancient level box
		input.delay(400); // Aesthetic delay

		keyVMouseClick(); // V + Click to custom level
		input.delay(400); // Aesthetic delay

		input.keyControlV(); // Paste level
		input.delay(400); // Aesthetic delay

		input.keyEnter(); // Type Enter to confirm level		
	}

	/**
	 * Level Ancient using Firefox browser [58.0.1 Version] the Kepow calculator on
	 * https://kepow.org/clickerheroes/ [2017/11/18 Version].
	 */
	public void levelAncientActiveBuild() {
		// Go to Firefox. Firefox must be the second icon on Windows 7 taskbar
		goToFirefox();
		input.delay(700); // Let Firefox load a second

		// Press F11 to make Firefox full screen to get rid of all extra headers
		input.keyF11();
		input.delay(2000); // Wait for Firefox browser to hide headers

		input.mouseMove(80, 425); // Click on random blank spot in Firefox to release any focus on text box
		input.mouseClick(1);

		input.delay(400); // Aesthetic delay

		input.keyHome(); // Go to the top of the page in Firefox

		input.delay(800); // Wait for browser to scroll to home

		input.mouseMove(460, 625); // Click on radio button "Active"
		input.mouseClick(1);

		//TODO Adjust delay to make it faster but not too fast Delay needed to for ancient list to load
		input.delay(2000); // Wait for ancient list to load	

		// Move focus to starting position, Hero Souls' text box level.
		input.mouseMove(875, 300);
		input.mouseClick(1);
		input.delay(400); // Aesthetic delay

		input.keyF11(); // No longer need to be in full screen
		input.delay(400); // Aesthetic delay

		// Go to Clicker Heroes. CH Must be the first icon on Windows 7 taskbar
		switchToClickerHeroes();

		input.delay(400); // Aesthetic delay

		// Go to Ancient tab
		clickAncientTab();

		// Set scroll bar to beginning of list
		scrollToStart();
		input.delay(700); // Aesthetic delay

		// Argaiv
		levelAncient(130, 430, true);
		input.delay(400); // Aesthetic delay

		// Atman
		levelAncient(130, 630, false);
		input.delay(400); // Aesthetic delay

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Aesthetic delay

		// Berserker
		levelAncient(130, 350, false);
		input.delay(400); // Aesthetic delay
		// Bhaal
		levelAncient(130, 550, false);
		input.delay(400); // Aesthetic delay
		// Bubos
		levelAncient(130, 750, false);
		input.delay(400); // Aesthetic delay

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Aesthetic delay

		// Chawedo	
		levelAncient(130, 470, false);
		input.delay(400); // Aesthetic delay
		// Chronos
		levelAncient(130, 670, false);
		input.delay(400); // Aesthetic delay

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Aesthetic delay

		// Dogcog
		levelAncient(130, 380, false);
		input.delay(400); // Aesthetic delay
		// Dora
		levelAncient(130, 580, false);
		input.delay(400); // Aesthetic delay
		// Energon
		levelAncient(130, 780, false);
		input.delay(400); // Aesthetic delay

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Aesthetic delay

		// Fortuna
		levelAncient(130, 450, false);
		input.delay(400); // Aesthetic delay
		// Fragsworth
		levelAncient(130, 650, false);
		input.delay(400); // Aesthetic delay

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Aesthetic delay

		// Hecatoncheir
		levelAncient(130, 365, false);
		input.delay(400); // Aesthetic delay
		// Juggernaut
		levelAncient(130, 565, false);
		input.delay(400); // Aesthetic delay
		// Kleptos
		levelAncient(130, 765, false);
		input.delay(400); // Aesthetic delay

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Aesthetic delay

		// Kumawakamaru
		levelAncient(130, 480, false);
		input.delay(400); // Aesthetic delay

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Aesthetic delay

		// Mammon
		levelAncient(130, 395, false);
		input.delay(400); // Aesthetic delay
		// Mimzee
		levelAncient(130, 595, false);
		input.delay(400); // Aesthetic delay
		// Morgulis
		levelAncient(130, 795, false);
		input.delay(400); // Aesthetic delay

		// Scroll
		input.mouseScroll(3);
		input.delay(400); // Aesthetic delay

		// Pluto
		levelAncient(130, 470, false);
		input.delay(400); // Aesthetic delay
		// Revolc
		levelAncient(130, 670, false);
		input.delay(400); // Aesthetic delay

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Aesthetic delay

		// Sniperino
		levelAncient(130, 530, false);
		input.delay(400); // Aesthetic delay
		// Vaagur
		levelAncient(130, 730, false);

	}

	/**
	 * Automatically level all heroes up to Frostleaf and useful heroes up to
	 * Tsuchi. Strongest hero is Skogur.
	 */
	public void levelHeroesSkogur() {
		// Click on CH icon on taskbar
		switchToClickerHeroes();
		input.delay(AESTHETIC_DELAY); // Aesthetic delay 100ms

		// Move to Hero Tab 
		clickHeroTab();
		input.delay(400); // Wait for CH lag to be gone

		// Kill first mob to get initial gold to level heroes
		getInitialGoldToLevelHeroes();
		input.delay(400); // Wait for heroes to load

		// Move to beginning of hero list 
		scrollToStart();
		input.delay(600); // Wait until scrolled all the way up

		//Level heroes
		// Cid, the Helpful Adventurer 
		levelHero(130, 320, 100); // Level hero by 100
		levelHero(130, 320, 100);
		// Treebeast
		levelHero(130, 470, 100);
		// Ivan, the Drunken Brawler
		levelHero(130, 620, 100);
		levelHero(130, 620, 100);
		// Brittany, Beach Princess
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Wandering Fisherman
		levelHero(130, 520, 100);
		// Betty Clicker
		levelHero(130, 670, 100);
		// The Masked Samurai
		levelHero(130, 820, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Leon
		levelHero(130, 560, 100);
		// The Great Forest Seer
		levelHero(130, 710, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Alexa, Assassin
		levelHero(130, 450, 100);
		// Natalia, Ice Apprentice
		levelHero(130, 600, 100);
		// Mercedes, Duchess of Blades
		levelHero(130, 750, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Bobby, Bounty Hunter
		levelHero(130, 490, 100);
		// Broyle Lindeoven, Fire Mage
		levelHero(130, 640, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Sir George II, King's Guard
		levelHero(130, 320, 100);
		// King Midas
		levelHero(130, 470, 100);
		levelHero(130, 470, 100);
		// Referi Jerator, Ice Wizard
		levelHero(130, 620, 100);
		levelHero(130, 620, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		//Abaddon
		levelHero(130, 360, 100);
		// Ma Zhu
		levelHero(130, 510, 100);
		// Amenhotep
		levelHero(130, 660, 100);
		levelHero(130, 660, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay		

		// Beastlord
		levelHero(130, 410, 100);
		// Athena, Goddess of War
		levelHero(130, 560, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Aphrodite, Goddess of Love
		levelHero(130, 300, 100);
		levelHero(130, 300, 100);
		// Shinatobe, Wind Deity
		levelHero(130, 450, 100);
		// Grant, The General
		levelHero(130, 600, 100);
		// Frostleaf
		levelHero(130, 750, 100);

		// Scroll
		input.mouseScroll(5);
		input.delay(400); // Scroll delay

		// Bomber Max
		levelHero(130, 520, 100);
		// Gog
		levelHero(130, 670, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Tsuchi
		levelHeroMax(130, 570, 100); // Level hero by the MAX ammount (10,000)

		// Click Buy Available Upgrades button
		clickBuyAvailableUpgrades();
		input.delay(AESTHETIC_DELAY);
	}

	/**
	 * Automatically level all heroes up to Frostleaf and useful heroes up to
	 * Wepwawet. Strongest hero is Tsuchi.
	 */
	public void levelHeroesTsuchi() {
		// Click on CH icon on taskbar
		switchToClickerHeroes();
		input.delay(AESTHETIC_DELAY); // Aesthetic delay 100ms

		// Move to Hero Tab 
		clickHeroTab();
		input.delay(400); // Wait for CH lag to be gone

		// Kill first mob to get initial gold to level heroes
		getInitialGoldToLevelHeroes();
		input.delay(400); // Wait for heroes to load

		// Move to beginning of hero list 
		scrollToStart();
		input.delay(600); // Wait until scrolled all the way up

		//Level heroes
		// Cid, the Helpful Adventurer 
		levelHero(130, 320, 100); // Level hero by 100
		levelHero(130, 320, 100);
		// Treebeast
		levelHero(130, 470, 100);
		// Ivan, the Drunken Brawler
		levelHero(130, 620, 100);
		levelHero(130, 620, 100);
		// Brittany, Beach Princess
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Wandering Fisherman
		levelHero(130, 520, 100);
		// Betty Clicker
		levelHero(130, 670, 100);
		// The Masked Samurai
		levelHero(130, 820, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Leon
		levelHero(130, 580, 100);
		// The Great Forest Seer
		levelHero(130, 730, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Alexa, Assassin
		levelHero(130, 480, 100);
		// Natalia, Ice Apprentice
		levelHero(130, 630, 100);
		// Mercedes, Duchess of Blades
		levelHero(130, 780, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Bobby, Bounty Hunter
		levelHero(130, 540, 100);
		// Broyle Lindeoven, Fire Mage
		levelHero(130, 690, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Sir George II, King's Guard
		levelHero(130, 380, 100);
		// King Midas
		levelHero(130, 530, 100);
		levelHero(130, 530, 100);
		// Referi Jerator, Ice Wizard
		levelHero(130, 680, 100);
		levelHero(130, 680, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		//Abaddon
		levelHero(130, 430, 100);
		// Ma Zhu
		levelHero(130, 580, 100);
		// Amenhotep
		levelHero(130, 730, 100);
		levelHero(130, 730, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay		

		// Beastlord
		levelHero(130, 490, 100);
		// Athena, Goddess of War
		levelHero(130, 640, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Aphrodite, Goddess of Love
		levelHero(130, 390, 100);
		levelHero(130, 390, 100);
		// Shinatobe, Wind Deity
		levelHero(130, 540, 100);
		// Grant, The General
		levelHero(130, 680, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Frostleaf
		levelHero(130, 450, 100);

		// Scroll
		input.mouseScroll(4);
		input.delay(400); // Scroll delay

		// Bomber Max
		levelHero(130, 660, 100);
		// Gog
		levelHero(130, 810, 100);

		// Click Buy Available Upgrades button
		clickBuyAvailableUpgrades();
		input.delay(AESTHETIC_DELAY);
	}

	/**
	 * Automatically level all heroes up to Frostleaf and useful heroes up to Gog.
	 * Strongest hero is Wepwawet.
	 */
	public void levelHeroesWepwawet() {
		// Click on CH icon on taskbar
		switchToClickerHeroes();
		input.delay(AESTHETIC_DELAY); // Aesthetic delay 100ms

		// Move to Hero Tab 
		clickHeroTab();
		input.delay(400); // Wait for CH lag to be gone

		// Kill first mob to get initial gold to level heroes
		getInitialGoldToLevelHeroes();
		input.delay(400); // Wait for heroes to load

		// Move to beginning of hero list 
		scrollToStart();
		input.delay(600); // Wait until scrolled all the way up

		//Level heroes
		// Cid, the Helpful Adventurer 
		levelHero(130, 320, 100); // Level hero by 100
		levelHero(130, 320, 100);
		// Treebeast
		levelHero(130, 470, 100);
		// Ivan, the Drunken Brawler
		levelHero(130, 620, 100);
		levelHero(130, 620, 100);
		// Brittany, Beach Princess
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Wandering Fisherman
		levelHero(130, 530, 100);
		// Betty Clicker
		levelHero(130, 680, 100);
		// The Masked Samurai
		levelHero(130, 830, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Leon
		levelHero(130, 600, 100);
		// The Great Forest Seer
		levelHero(130, 750, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Alexa, Assassin
		levelHero(130, 510, 100);
		// Natalia, Ice Apprentice
		levelHero(130, 660, 100);
		// Mercedes, Duchess of Blades
		levelHero(130, 810, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Bobby, Bounty Hunter
		levelHero(130, 570, 100);
		// Broyle Lindeoven, Fire Mage
		levelHero(130, 720, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Sir George II, King's Guard
		levelHero(130, 430, 100);
		// King Midas
		levelHero(130, 580, 100);
		levelHero(130, 580, 100);
		// Referi Jerator, Ice Wizard
		levelHero(130, 730, 100);
		levelHero(130, 730, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		//Abaddon
		levelHero(130, 500, 100);
		// Ma Zhu
		levelHero(130, 650, 100);
		// Amenhotep
		levelHero(130, 800, 100);
		levelHero(130, 800, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay		

		// Beastlord
		levelHero(130, 570, 100);
		// Athena, Goddess of War
		levelHero(130, 720, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Aphrodite, Goddess of Love
		levelHero(130, 480, 100);
		levelHero(130, 480, 100);
		// Shinatobe, Wind Deity
		levelHero(130, 630, 100);
		// Grant, The General
		levelHero(130, 780, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Frostleaf
		levelHero(130, 540, 100);

		// Scroll
		input.mouseScroll(5);
		input.delay(400); // Scroll delay

		// Bomber Max
		levelHero(130, 410, 100);
		// Gog
		levelHero(130, 560, 100);

		// Click Buy Available Upgrades button
		clickBuyAvailableUpgrades();
		input.delay(AESTHETIC_DELAY);
	}

	/**
	 * Automatically level all heroes up to Frostleaf and useful heroes up to Bomber
	 * Max. Strongest hero is Gog.
	 */
	public void levelHeroesGog() {
		// Click on CH icon on taskbar
		switchToClickerHeroes();
		input.delay(AESTHETIC_DELAY); // Aesthetic delay 100ms

		// Move to Hero Tab 
		clickHeroTab();
		input.delay(400); // Wait for CH lag to be gone

		// Kill first mob to get initial gold to level heroes
		getInitialGoldToLevelHeroes();
		input.delay(400); // Wait for heroes to load

		// Move to beginning of hero list 
		scrollToStart();
		input.delay(600); // Wait until scrolled all the way up

		//Level heroes
		// Cid, the Helpful Adventurer 
		levelHero(130, 320, 100); // Level hero by 100
		levelHero(130, 320, 100);
		// Treebeast
		levelHero(130, 470, 100);
		// Ivan, the Drunken Brawler
		levelHero(130, 620, 100);
		levelHero(130, 620, 100);
		// Brittany, Beach Princess
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Wandering Fisherman
		levelHero(130, 540, 100);
		// Betty Clicker
		levelHero(130, 690, 100);
		// The Masked Samurai
		levelHero(130, 840, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Leon
		levelHero(130, 620, 100);
		// The Great Forest Seer
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Alexa, Assassin
		levelHero(130, 540, 100);
		// Natalia, Ice Apprentice
		levelHero(130, 690, 100);
		// Mercedes, Duchess of Blades
		levelHero(130, 840, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Bobby, Bounty Hunter
		levelHero(130, 620, 100);
		// Broyle Lindeoven, Fire Mage
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Sir George II, King's Guard
		levelHero(130, 490, 100);
		// King Midas
		levelHero(130, 640, 100);
		levelHero(130, 640, 100);
		// Referi Jerator, Ice Wizard
		levelHero(130, 790, 100);
		levelHero(130, 790, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		//Abaddon
		levelHero(130, 560, 100);
		// Ma Zhu
		levelHero(130, 710, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay		

		// Amenhotep
		levelHero(130, 490, 100);
		levelHero(130, 490, 100);
		// Beastlord
		levelHero(130, 640, 100);
		// Athena, Goddess of War
		levelHero(130, 790, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Aphrodite, Goddess of Love
		levelHero(130, 560, 100);
		levelHero(130, 560, 100);
		// Shinatobe, Wind Deity
		levelHero(130, 710, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Grant, The General
		levelHero(130, 490, 100);
		// Frostleaf
		levelHero(130, 640, 100);

		// Scroll
		input.mouseScroll(5);
		input.delay(400); // Scroll delay

		// Bomber Max
		levelHero(130, 560, 100);

		// Click Buy Available Upgrades button
		clickBuyAvailableUpgrades();
		input.delay(AESTHETIC_DELAY);
	}

	/**
	 * Automatically level all heroes up to Frostleaf. Strongest hero is Bomber Max
	 */
	public void levelHeroesBomberMax() {
		// Click on CH icon on taskbar
		switchToClickerHeroes();
		input.delay(AESTHETIC_DELAY); // Aesthetic delay 100ms

		// Move to Hero Tab 
		clickHeroTab();
		input.delay(400); // Wait for CH lag to be gone

		// Kill first mob to get initial gold to level heroes
		getInitialGoldToLevelHeroes();
		input.delay(400); // Wait for heroes to load

		// Move to beginning of hero list 
		scrollToStart();
		input.delay(600); // Wait until scrolled all the way up

		//Level heroes
		// Cid, the Helpful Adventurer 
		levelHero(130, 320, 100); // Level hero by 100
		levelHero(130, 320, 100);
		// Treebeast
		levelHero(130, 470, 100);
		// Ivan, the Drunken Brawler
		levelHero(130, 620, 100);
		levelHero(130, 620, 100);
		// Brittany, Beach Princess
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Wandering Fisherman
		levelHero(130, 560, 100);
		// Betty Clicker
		levelHero(130, 710, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Masked Samurai
		levelHero(130, 490, 100);
		// Leon
		levelHero(130, 640, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Great Forest Seer
		levelHero(130, 430, 100);
		// Alexa, Assassin
		levelHero(130, 580, 100);
		// Natalia, Ice Apprentice
		levelHero(130, 730, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Mercedes, Duchess of Blades
		levelHero(130, 520, 100);
		// Bobby, Bounty Hunter
		levelHero(130, 670, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Broyle Lindeoven, Fire Mage
		levelHero(130, 390, 100);
		// Sir George II, King's Guard
		levelHero(130, 540, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// King Midas
		levelHero(130, 330, 100);
		levelHero(130, 330, 100);
		// Referi Jerator, Ice Wizard
		levelHero(130, 480, 100);
		levelHero(130, 480, 100);
		//Abaddon
		levelHero(130, 630, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay		

		// Ma Zhu
		levelHero(130, 410, 100);
		// Amenhotep
		levelHero(130, 560, 100);
		levelHero(130, 560, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Beastlord
		levelHero(130, 350, 100);
		// Athena, Goddess of War
		levelHero(130, 500, 100);
		// Aphrodite, Goddess of Love
		levelHero(130, 650, 100);
		levelHero(130, 650, 100);
		// Shinatobe, Wind Deity
		levelHero(130, 800, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Grant, The General
		levelHero(130, 590, 100);
		// Frostleaf
		levelHero(130, 740, 100);

		// Click Buy Available Upgrades button
		clickBuyAvailableUpgrades();
		input.delay(AESTHETIC_DELAY);
	}

	/** Automatically level all heroes up to Frostleaf. Strongest hero is Moloch */
	public void levelHeroesMoloch() {
		// Click on CH icon on taskbar
		switchToClickerHeroes();
		input.delay(AESTHETIC_DELAY); // Aesthetic delay 100ms

		// Move to Hero Tab 
		clickHeroTab();
		input.delay(400); // Wait for CH lag to be gone

		// Kill first mob to get initial gold to level heroes
		getInitialGoldToLevelHeroes();
		input.delay(400); // Wait for heroes to load

		// Move to beginning of hero list 
		scrollToStart();
		input.delay(600); // Wait until scrolled all the way up

		//Level heroes
		// Cid, the Helpful Adventurer 
		levelHero(130, 320, 100); // Level hero by 100
		levelHero(130, 320, 100);
		// Treebeast
		levelHero(130, 470, 100);
		// Ivan, the Drunken Brawler
		levelHero(130, 620, 100);
		levelHero(130, 620, 100);
		// Brittany, Beach Princess
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Wandering Fisherman
		levelHero(130, 570, 100);
		// Betty Clicker
		levelHero(130, 720, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Masked Samurai
		levelHero(130, 510, 100);
		// Leon
		levelHero(130, 660, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Great Forest Seer
		levelHero(130, 460, 100);
		// Alexa, Assassin
		levelHero(130, 610, 100);
		// Natalia, Ice Apprentice
		levelHero(130, 760, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Mercedes, Duchess of Blades
		levelHero(130, 560, 100);
		// Bobby, Bounty Hunter
		levelHero(130, 710, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Broyle Lindeoven, Fire Mage
		levelHero(130, 450, 100);
		// Sir George II, King's Guard
		levelHero(130, 600, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// King Midas
		levelHero(130, 390, 100);
		levelHero(130, 390, 100);
		// Referi Jerator, Ice Wizard
		levelHero(130, 540, 100);
		levelHero(130, 540, 100);
		//Abaddon
		levelHero(130, 690, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay		

		// Ma Zhu
		levelHero(130, 490, 100);
		// Amenhotep
		levelHero(130, 640, 100);
		levelHero(130, 640, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Beastlord
		levelHero(130, 440, 100);
		// Athena, Goddess of War
		levelHero(130, 590, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Aphrodite, Goddess of Love
		levelHero(130, 380, 100);
		levelHero(130, 380, 100);
		// Shinatobe, Wind Deity
		levelHero(130, 530, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Grant, The General
		levelHero(130, 320, 100);
		// Frostleaf
		levelHero(130, 470, 100);

		// Click Buy Available Upgrades button
		clickBuyAvailableUpgrades();
		input.delay(AESTHETIC_DELAY);
	}

	/** Automatically level all heroes up to Frostleaf. Strongest hero is Chiron */
	public void levelHeroesChiron() {
		// Click on CH icon on taskbar
		switchToClickerHeroes();
		input.delay(AESTHETIC_DELAY); // Aesthetic delay 100ms

		// Move to Hero Tab 
		clickHeroTab();
		input.delay(400); // Wait for CH lag to be gone

		// Kill first mob to get initial gold to level heroes
		getInitialGoldToLevelHeroes();
		input.delay(400); // Wait for heroes to load

		// Move to beginning of hero list 
		scrollToStart();
		input.delay(600); // Wait until scrolled all the way up

		//Level heroes
		// Cid, the Helpful Adventurer 
		levelHero(130, 320, 100); // Level hero by 100
		levelHero(130, 320, 100);
		// Treebeast
		levelHero(130, 470, 100);
		// Ivan, the Drunken Brawler
		levelHero(130, 620, 100);
		levelHero(130, 620, 100);
		// Brittany, Beach Princess
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Wandering Fisherman
		levelHero(130, 580, 100);
		// Betty Clicker
		levelHero(130, 730, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Masked Samurai
		levelHero(130, 530, 100);
		// Leon
		levelHero(130, 680, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Great Forest Seer
		levelHero(130, 490, 100);
		// Alexa, Assassin
		levelHero(130, 640, 100);
		// Natalia, Ice Apprentice
		levelHero(130, 790, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Mercedes, Duchess of Blades
		levelHero(130, 590, 100);
		// Bobby, Bounty Hunter
		levelHero(130, 740, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Broyle Lindeoven, Fire Mage
		levelHero(130, 500, 100);
		// Sir George II, King's Guard
		levelHero(130, 650, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// King Midas
		levelHero(130, 460, 100);
		levelHero(130, 460, 100);
		// Referi Jerator, Ice Wizard
		levelHero(130, 610, 100);
		levelHero(130, 610, 100);
		//Abaddon
		levelHero(130, 760, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay		

		// Ma Zhu
		levelHero(130, 570, 100);
		// Amenhotep
		levelHero(130, 720, 100);
		levelHero(130, 720, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Beastlord
		levelHero(130, 520, 100);
		// Athena, Goddess of War
		levelHero(130, 670, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Aphrodite, Goddess of Love
		levelHero(130, 470, 100);
		levelHero(130, 470, 100);
		// Shinatobe, Wind Deity
		levelHero(130, 620, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Grant, The General
		levelHero(130, 440, 100);
		// Frostleaf
		levelHero(130, 590, 100);

		// Click Buy Available Upgrades button
		clickBuyAvailableUpgrades();
		input.delay(AESTHETIC_DELAY);
	}

	/** Automatically level all heroes up to Frostleaf. Strongest hero is Astraea */
	public void levelHeroesAstraea() {
		// Click on CH icon on taskbar
		switchToClickerHeroes();
		input.delay(AESTHETIC_DELAY); // Aesthetic delay 100ms

		// Move to Hero Tab 
		clickHeroTab();
		input.delay(400); // Wait for CH lag to be gone

		// Kill first mob to get initial gold to level heroes
		getInitialGoldToLevelHeroes();
		input.delay(400); // Wait for heroes to load

		// Move to beginning of hero list 
		scrollToStart();
		input.delay(600); // Wait until scrolled all the way up

		//Level heroes
		// Cid, the Helpful Adventurer 
		levelHero(130, 320, 100); // Level hero by 100
		levelHero(130, 320, 100);
		// Treebeast
		levelHero(130, 470, 100);
		// Ivan, the Drunken Brawler
		levelHero(130, 620, 100);
		levelHero(130, 620, 100);
		// Brittany, Beach Princess
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Wandering Fisherman
		levelHero(130, 590, 100);
		// Betty Clicker
		levelHero(130, 740, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Masked Samurai
		levelHero(130, 550, 100);
		// Leon
		levelHero(130, 700, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Great Forest Seer
		levelHero(130, 510, 100);
		// Alexa, Assassin
		levelHero(130, 660, 100);
		// Natalia, Ice Apprentice
		levelHero(130, 810, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Mercedes, Duchess of Blades
		levelHero(130, 630, 100);
		// Bobby, Bounty Hunter
		levelHero(130, 780, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Broyle Lindeoven, Fire Mage
		levelHero(130, 560, 100);
		// Sir George II, King's Guard
		levelHero(130, 710, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// King Midas
		levelHero(130, 530, 100);
		levelHero(130, 530, 100);
		// Referi Jerator, Ice Wizard
		levelHero(130, 680, 100);
		levelHero(130, 680, 100);
		//Abaddon
		levelHero(130, 830, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay		

		// Ma Zhu
		levelHero(130, 310, 100);
		// Amenhotep
		levelHero(130, 460, 100);
		levelHero(130, 460, 100);
		// Beastlord
		levelHero(130, 610, 100);
		// Athena, Goddess of War
		levelHero(130, 760, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Aphrodite, Goddess of Love
		levelHero(130, 570, 100);
		levelHero(130, 570, 100);
		// Shinatobe, Wind Deity
		levelHero(130, 720, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Grant, The General
		levelHero(130, 540, 100);
		// Frostleaf
		levelHero(130, 690, 100);

		// Click Buy Available Upgrades button
		clickBuyAvailableUpgrades();
		input.delay(AESTHETIC_DELAY);
	}

	/**
	 * Automatically level all heroes up to Frostleaf. Strongest hero is Alabaster
	 */
	public void levelHeroesAlabaster() {
		// Click on CH icon on taskbar
		switchToClickerHeroes();
		input.delay(AESTHETIC_DELAY); // Aesthetic delay 100ms

		// Move to Hero Tab 
		clickHeroTab();
		input.delay(400); // Wait for CH lag to be gone

		// Kill first mob to get initial gold to level heroes
		getInitialGoldToLevelHeroes();
		input.delay(400); // Wait for heroes to load

		// Move to beginning of hero list 
		scrollToStart();
		input.delay(600); // Wait until scrolled all the way up

		//Level heroes
		// Cid, the Helpful Adventurer 
		levelHero(130, 320, 100); // Level hero by 100
		levelHero(130, 320, 100);
		// Treebeast
		levelHero(130, 470, 100);
		// Ivan, the Drunken Brawler
		levelHero(130, 620, 100);
		levelHero(130, 620, 100);
		// Brittany, Beach Princess
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Wandering Fisherman
		levelHero(130, 600, 100);
		// Betty Clicker
		levelHero(130, 750, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Masked Samurai
		levelHero(130, 570, 100);
		// Leon
		levelHero(130, 720, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Great Forest Seer
		levelHero(130, 560, 100);
		// Alexa, Assassin
		levelHero(130, 710, 100);
		// Natalia, Ice Apprentice
		levelHero(130, 860, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Mercedes, Duchess of Blades
		levelHero(130, 300, 100);
		// Bobby, Bounty Hunter
		levelHero(130, 450, 100);
		// Broyle Lindeoven, Fire Mage
		levelHero(130, 600, 100);
		// Sir George II, King's Guard
		levelHero(130, 750, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// King Midas
		levelHero(130, 590, 100);
		levelHero(130, 590, 100);
		// Referi Jerator, Ice Wizard
		levelHero(130, 740, 100);
		levelHero(130, 740, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay		

		//Abaddon
		levelHero(130, 570, 100);
		// Ma Zhu
		levelHero(130, 720, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Amenhotep
		levelHero(130, 540, 100);
		levelHero(130, 540, 100);
		// Beastlord
		levelHero(130, 690, 100);
		// Athena, Goddess of War
		levelHero(130, 840, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Aphrodite, Goddess of Love
		levelHero(130, 350, 100);
		levelHero(130, 350, 100);
		// Shinatobe, Wind Deity
		levelHero(130, 500, 100);
		// Grant, The General
		levelHero(130, 650, 100);
		// Frostleaf
		levelHero(130, 800, 100);

		// Click Buy Available Upgrades button
		clickBuyAvailableUpgrades();
		input.delay(AESTHETIC_DELAY);
	}

	/** Automatically level all heroes up to Frostleaf. Strongest hero is Cadmia */
	public void levelHeroesCadmia() {
		// Click on CH icon on taskbar
		switchToClickerHeroes();
		input.delay(AESTHETIC_DELAY); // Aesthetic delay 100ms

		// Move to Hero Tab 
		clickHeroTab();
		input.delay(400); // Wait for CH lag to be gone

		// Kill first mob to get initial gold to level heroes
		getInitialGoldToLevelHeroes();
		input.delay(400); // Wait for heroes to load

		// Move to beginning of hero list 
		scrollToStart();
		input.delay(600); // Wait until scrolled all the way up

		//Level heroes
		// Cid, the Helpful Adventurer 
		levelHero(130, 320, 100); // Level hero by 100
		levelHero(130, 320, 100);
		// Treebeast
		levelHero(130, 470, 100);
		// Ivan, the Drunken Brawler
		levelHero(130, 620, 100);
		levelHero(130, 620, 100);
		// Brittany, Beach Princess
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Wandering Fisherman
		levelHero(130, 610, 100);
		// Betty Clicker
		levelHero(130, 760, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Masked Samurai
		levelHero(130, 600, 100);
		// Leon
		levelHero(130, 750, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// The Great Forest Seer
		levelHero(130, 590, 100);
		// Alexa, Assassin
		levelHero(130, 740, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Natalia, Ice Apprentice
		levelHero(130, 570, 100);
		// Mercedes, Duchess of Blades
		levelHero(130, 720, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Bobby, Bounty Hunter
		levelHero(130, 520, 100);
		// Broyle Lindeoven, Fire Mage
		levelHero(130, 670, 100);
		// Sir George II, King's Guard
		levelHero(130, 820, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// King Midas
		levelHero(130, 340, 100);
		levelHero(130, 340, 100);
		// Referi Jerator, Ice Wizard
		levelHero(130, 490, 100);
		levelHero(130, 490, 100);
		//Abaddon
		levelHero(130, 640, 100);
		// Ma Zhu
		levelHero(130, 790, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Amenhotep
		levelHero(130, 310, 100);
		levelHero(130, 310, 100);
		// Beastlord
		levelHero(130, 460, 100);
		// Athena, Goddess of War
		levelHero(130, 610, 100);
		// Aphrodite, Goddess of Love
		levelHero(130, 760, 100);
		levelHero(130, 760, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Shinatobe, Wind Deity
		levelHero(130, 600, 100);
		// Grant, The General
		levelHero(130, 750, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Frostleaf
		levelHero(130, 590, 100);

		// Click Buy Available Upgrades button
		clickBuyAvailableUpgrades();
		input.delay(AESTHETIC_DELAY);
	}

	/** Automatically level all heroes up to Frostleaf. Strongest hero is Lilin */
	public void levelHeroesLilin() {
		// Click on CH icon on taskbar
		switchToClickerHeroes();
		input.delay(AESTHETIC_DELAY); // Aesthetic delay 100ms

		// Move to Hero Tab 
		clickHeroTab();
		input.delay(400); // Wait for CH lag to be gone

		// Kill first mob to get initial gold to level heroes
		getInitialGoldToLevelHeroes();
		input.delay(400); // Wait for heroes to load

		// Move to beginning of hero list 
		scrollToStart();
		input.delay(600); // Wait until scrolled all the way up

		//Level heroes
		// Cid, the Helpful Adventurer 
		levelHero(130, 320, 100); // Level hero by 100
		levelHero(130, 320, 100);
		// Treebeast
		levelHero(130, 470, 100);
		// Ivan, the Drunken Brawler
		levelHero(130, 620, 100);
		levelHero(130, 620, 100);
		// Brittany, Beach Princess
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// The Wandering Fisherman
		levelHero(130, 310, 100);
		// Betty Clicker
		levelHero(130, 460, 100);
		// The Masked Samurai
		levelHero(130, 610, 100);
		// Leon
		levelHero(130, 760, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// The Great Forest Seer
		levelHero(130, 310, 100);
		// Alexa, Assassin
		levelHero(130, 460, 100);
		// Natalia, Ice Apprentice
		levelHero(130, 610, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Mercedes, Duchess of Blades
		levelHero(130, 420, 100);
		// Bobby, Bounty Hunter
		levelHero(130, 570, 100);
		// Broyle Lindeoven, Fire Mage
		levelHero(130, 720, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Sir George II, King's Guard
		levelHero(130, 570, 100);
		// King Midas
		levelHero(130, 720, 100);
		levelHero(130, 720, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Referi Jerator, Ice Wizard
		levelHero(130, 560, 100);
		levelHero(130, 560, 100);
		//Abaddon
		levelHero(130, 710, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Ma Zhu
		levelHero(130, 560, 100);
		// Amenhotep
		levelHero(130, 710, 100);
		levelHero(130, 710, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Beastlord
		levelHero(130, 560, 100);
		// Athena, Goddess of War
		levelHero(130, 710, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Aphrodite, Goddess of Love
		levelHero(130, 560, 100);
		levelHero(130, 560, 100);
		// Shinatobe, Wind Deity
		levelHero(130, 710, 100);

		// Scroll
		input.mouseScroll(1);
		input.delay(400); // Scroll delay

		// Grant, The General
		levelHero(130, 560, 100);
		// Frostleaf
		levelHero(130, 710, 100);

		// Click Buy Available Upgrades button
		clickBuyAvailableUpgrades();
		input.delay(AESTHETIC_DELAY);
	}

	/** Automatically level all heroes up to Frostleaf. Strongest hero is Didensy */
	public void levelHeroesDidensy() {
		// Click on CH icon on taskbar
		switchToClickerHeroes();
		input.delay(AESTHETIC_DELAY); // Aesthetic delay 100ms

		// Move to Hero Tab 
		clickHeroTab();
		input.delay(400); // Wait for CH lag to be gone

		// Kill first mob to get initial gold to level heroes
		getInitialGoldToLevelHeroes();
		input.delay(400); // Wait for heroes to load

		// Move to beginning of hero list 
		scrollToStart();
		input.delay(600); // Wait until scrolled all the way up

		//Level heroes
		// Cid, the Helpful Adventurer 
		levelHero(130, 320, 100); // Level hero by 100
		levelHero(130, 320, 100);
		// Treebeast
		levelHero(130, 470, 100);
		// Ivan, the Drunken Brawler
		levelHero(130, 620, 100);
		levelHero(130, 620, 100);
		// Brittany, Beach Princess
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// The Wandering Fisherman
		levelHero(130, 340, 100);
		// Betty Clicker
		levelHero(130, 490, 100);
		// The Masked Samurai
		levelHero(130, 640, 100);
		// Leon
		levelHero(130, 790, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// The Great Forest Seer
		levelHero(130, 360, 100);
		// Alexa, Assassin
		levelHero(130, 510, 100);
		// Natalia, Ice Apprentice
		levelHero(130, 660, 100);
		// Mercedes, Duchess of Blades
		levelHero(130, 810, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Bobby, Bounty Hunter
		levelHero(130, 330, 100);
		// Broyle Lindeoven, Fire Mage
		levelHero(130, 480, 100);
		// Sir George II, King's Guard
		levelHero(130, 630, 100);
		// King Midas
		levelHero(130, 780, 100);
		levelHero(130, 780, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Referi Jerator, Ice Wizard
		levelHero(130, 350, 100);
		levelHero(130, 350, 100);
		//Abaddon
		levelHero(130, 500, 100);
		// Ma Zhu
		levelHero(130, 650, 100);
		// Amenhotep
		levelHero(130, 800, 100);
		levelHero(130, 800, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Beastlord
		levelHero(130, 370, 100);
		// Athena, Goddess of War
		levelHero(130, 520, 100);
		// Aphrodite, Goddess of Love
		levelHero(130, 670, 100);
		levelHero(130, 670, 100);
		// Shinatobe, Wind Deity
		levelHero(130, 820, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Grant, The General
		levelHero(130, 380, 100);
		// Frostleaf
		levelHero(130, 520, 100);

		// Click Buy Available Upgrades button
		clickBuyAvailableUpgrades();
		input.delay(AESTHETIC_DELAY);
	}

	/** Automatically level all heroes up to Frostleaf. Strongest hero is Phthalo */
	public void levelHeroesPhthalo() {
		// Click on CH icon on taskbar
		switchToClickerHeroes();
		input.delay(AESTHETIC_DELAY); // Aesthetic delay 100ms

		// Move to Hero Tab 
		clickHeroTab();
		input.delay(400); // Wait for CH lag to be gone

		// Kill first mob to get initial gold to level heroes
		getInitialGoldToLevelHeroes();
		input.delay(400); // Wait for heroes to load

		// Move to beginning of hero list 
		scrollToStart();
		input.delay(600); // Wait until scrolled all the way up

		//Level heroes
		// Cid, the Helpful Adventurer 
		levelHero(130, 320, 100); // Level hero by 100
		levelHero(130, 320, 100);
		// Treebeast
		levelHero(130, 470, 100);
		// Ivan, the Drunken Brawler
		levelHero(130, 620, 100);
		levelHero(130, 620, 100);
		// Brittany, Beach Princess
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// The Wandering Fisherman
		levelHero(130, 360, 100);
		// Betty Clicker
		levelHero(130, 510, 100);
		// The Masked Samurai
		levelHero(130, 660, 100);
		// Leon
		levelHero(130, 810, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// The Great Forest Seer
		levelHero(130, 400, 100);
		// Alexa, Assassin
		levelHero(130, 550, 100);
		// Natalia, Ice Apprentice
		levelHero(130, 700, 100);
		// Mercedes, Duchess of Blades
		levelHero(130, 850, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Bobby, Bounty Hunter
		levelHero(130, 400, 100);
		// Broyle Lindeoven, Fire Mage
		levelHero(130, 550, 100);
		// Sir George II, King's Guard
		levelHero(130, 700, 100);
		// King Midas
		levelHero(130, 850, 100);
		levelHero(130, 850, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Referi Jerator, Ice Wizard
		levelHero(130, 440, 100);
		levelHero(130, 440, 100);
		//Abaddon
		levelHero(130, 590, 100);
		// Ma Zhu
		levelHero(130, 740, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Amenhotep
		levelHero(130, 320, 100);
		levelHero(130, 320, 100);
		// Beastlord
		levelHero(130, 470, 100);
		// Athena, Goddess of War
		levelHero(130, 620, 100);
		// Aphrodite, Goddess of Love
		levelHero(130, 770, 100);
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Shinatobe, Wind Deity
		levelHero(130, 350, 100);
		// Grant, The General
		levelHero(130, 500, 100);
		// Frostleaf
		levelHero(130, 650, 100);

		// Click Buy Available Upgrades button
		clickBuyAvailableUpgrades();
		input.delay(AESTHETIC_DELAY);
	}

	/** Automatically level all heroes up to Frostleaf. Strongest hero is Terra */
	public void levelHeroesTerra() {
		// Click on CH icon on taskbar
		switchToClickerHeroes();
		input.delay(AESTHETIC_DELAY); // Aesthetic delay 100ms

		// Move to Hero Tab 
		clickHeroTab();
		input.delay(400); // Wait for CH lag to be gone

		// Kill first mob to get initial gold to level heroes
		getInitialGoldToLevelHeroes();
		input.delay(400); // Wait for heroes to load

		// Move to beginning of hero list 
		scrollToStart();
		input.delay(600); // Wait until scrolled all the way up

		//Level heroes
		// Cid, the Helpful Adventurer 
		levelHero(130, 320, 100); // Level hero by 100
		levelHero(130, 320, 100);
		// Treebeast
		levelHero(130, 470, 100);
		// Ivan, the Drunken Brawler
		levelHero(130, 620, 100);
		levelHero(130, 620, 100);
		// Brittany, Beach Princess
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// The Wandering Fisherman
		levelHero(130, 380, 100);
		// Betty Clicker
		levelHero(130, 530, 100);
		// The Masked Samurai
		levelHero(130, 680, 100);
		// Leon
		levelHero(130, 830, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// The Great Forest Seer
		levelHero(130, 440, 100);
		// Alexa, Assassin
		levelHero(130, 590, 100);
		// Natalia, Ice Apprentice
		levelHero(130, 740, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Mercedes, Duchess of Blades
		levelHero(130, 310, 100);
		// Bobby, Bounty Hunter
		levelHero(130, 460, 100);
		// Broyle Lindeoven, Fire Mage
		levelHero(130, 610, 100);
		// Sir George II, King's Guard
		levelHero(130, 760, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// King Midas
		levelHero(130, 360, 100);
		levelHero(130, 360, 100);
		// Referi Jerator, Ice Wizard
		levelHero(130, 510, 100);
		levelHero(130, 510, 100);
		//Abaddon
		levelHero(130, 660, 100);
		// Ma Zhu
		levelHero(130, 810, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Amenhotep
		levelHero(130, 430, 100);
		levelHero(130, 430, 100);
		// Beastlord
		levelHero(130, 580, 100);
		// Athena, Goddess of War
		levelHero(130, 730, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Aphrodite, Goddess of Love
		levelHero(130, 340, 100);
		levelHero(130, 340, 100);
		// Shinatobe, Wind Deity
		levelHero(130, 490, 100);
		// Grant, The General
		levelHero(130, 640, 100);
		// Frostleaf
		levelHero(130, 790, 100);

		// Click Buy Available Upgrades button
		clickBuyAvailableUpgrades();
		input.delay(AESTHETIC_DELAY);
	}

	/** Automatically level all heroes up to Frostleaf. Strongest hero is Atlas */
	public void levelHeroesAtlas() {
		// Click on CH icon on taskbar
		switchToClickerHeroes();
		input.delay(AESTHETIC_DELAY); // Aesthetic delay 100ms

		// Move to Hero Tab 
		clickHeroTab();
		input.delay(400); // Wait for CH lag to be gone

		// Kill first mob to get initial gold to level heroes
		getInitialGoldToLevelHeroes();
		input.delay(400); // Wait for heroes to load

		// Move to beginning of hero list 
		scrollToStart();
		input.delay(600); // Wait until scrolled all the way up

		//Level heroes
		// Cid, the Helpful Adventurer 
		levelHero(130, 320, 100); // Level hero by 100
		levelHero(130, 320, 100); // Level twice
		// Treebeast
		levelHero(130, 470, 100);
		// Ivan, the Drunken Brawler
		levelHero(130, 620, 100);
		levelHero(130, 620, 100);
		// Brittany, Beach Princess
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// The Wandering Fisherman
		levelHero(130, 400, 100);
		// Betty Clicker
		levelHero(130, 550, 100);
		// The Masked Samurai
		levelHero(130, 700, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Leon
		levelHero(130, 330, 100);
		// The Great Forest Seer
		levelHero(130, 480, 100);
		// Alexa, Assassin
		levelHero(130, 630, 100);
		// Natalia, Ice Apprentice
		levelHero(130, 780, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Mercedes, Duchess of Blades
		levelHero(130, 370, 100);
		// Bobby, Bounty Hunter
		levelHero(130, 520, 100);
		// Broyle Lindeoven, Fire Mage
		levelHero(130, 670, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Sir George II, King's Guard
		levelHero(130, 300, 100);
		// King Midas
		levelHero(130, 450, 100);
		levelHero(130, 450, 100);
		// Referi Jerator, Ice Wizard
		levelHero(130, 600, 100);
		levelHero(130, 600, 100);
		//Abaddon
		levelHero(130, 750, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Ma Zhu
		levelHero(130, 390, 100);
		// Amenhotep
		levelHero(130, 540, 100);
		levelHero(130, 540, 100);
		// Beastlord
		levelHero(130, 690, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Athena, Goddess of War
		levelHero(130, 320, 100);
		// Aphrodite, Goddess of Love
		levelHero(130, 470, 100);
		levelHero(130, 470, 100);
		// Shinatobe, Wind Deity
		levelHero(130, 620, 100);
		// Grant, The General
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Frostleaf
		levelHero(130, 390, 100);

		// Click Buy Available Upgrades button
		clickBuyAvailableUpgrades();
		input.delay(AESTHETIC_DELAY);
	}

	/**
	 * Automatically level all heroes up to Frostleaf. Strongest hero is Dread
	 * Knight
	 */
	public void levelHeroesDreadKnight() {
		// Click on CH icon on taskbar
		switchToClickerHeroes();
		input.delay(AESTHETIC_DELAY); // Aesthetic delay 100ms

		// Move to Hero Tab 
		clickHeroTab();
		input.delay(400); // Wait for CH lag to be gone

		// Kill first mob to get initial gold to level heroes
		getInitialGoldToLevelHeroes();
		input.delay(400); // Wait for heroes to load

		// Move to beginning of hero list 
		scrollToStart();
		input.delay(600); // Wait until scrolled all the way up

		//Level heroes
		// Cid, the Helpful Adventurer 
		levelHero(130, 320, 100); // Level hero by 100
		levelHero(130, 320, 100); // Level twice
		// Treebeast
		levelHero(130, 470, 100);
		// Ivan, the Drunken Brawler
		levelHero(130, 620, 100);
		levelHero(130, 620, 100);
		// Brittany, Beach Princess
		levelHero(130, 770, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// The Wandering Fisherman
		levelHero(130, 420, 100);
		// Betty Clicker
		levelHero(130, 570, 100);
		// The Masked Samurai
		levelHero(130, 720, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Leon
		levelHero(130, 370, 100);
		// The Great Forest Seer
		levelHero(130, 520, 100);
		// Alexa, Assassin
		levelHero(130, 670, 100);
		// Natalia, Ice Apprentice
		levelHero(130, 820, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Mercedes, Duchess of Blades
		levelHero(130, 440, 100);
		// Bobby, Bounty Hunter
		levelHero(130, 590, 100);
		// Broyle Lindeoven, Fire Mage
		levelHero(130, 740, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Sir George II, King's Guard
		levelHero(130, 390, 100);
		// King Midas
		levelHero(130, 540, 100);
		levelHero(130, 540, 100);
		// Referi Jerator, Ice Wizard
		levelHero(130, 680, 100);
		levelHero(130, 680, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		//Abaddon
		levelHero(130, 340, 100);
		// Ma Zhu
		levelHero(130, 490, 100);
		// Amenhotep
		levelHero(130, 640, 100);
		levelHero(130, 640, 100);
		// Beastlord
		levelHero(130, 790, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Athena, Goddess of War
		levelHero(130, 440, 100);
		// Aphrodite, Goddess of Love
		levelHero(130, 590, 100);
		levelHero(130, 590, 100);
		// Shinatobe, Wind Deity
		levelHero(130, 740, 100);

		// Scroll
		input.mouseScroll(2);
		input.delay(400); // Scroll delay

		// Grant, The General
		levelHero(130, 390, 100);
		// Frostleaf
		levelHero(130, 540, 100);

		// Click Buy Available Upgrades button
		clickBuyAvailableUpgrades();
		input.delay(AESTHETIC_DELAY);
	}

	/**
	 * Click the "Buy Available Upgrades" button in the hero tab by scrolling all
	 * the way to the bottom
	 */
	private void clickBuyAvailableUpgrades() {

		// Scroll all the way to the bottom
		input.mouseScroll(-1); // Scroll up to prevent occasions with hidden "Buy Available Upgrades" button
		input.delay(100); // Aesthetic delay
		input.mouseScroll(10); // Scroll all the way to the bottom. 10 is a random number we chose.

		input.delay(400); // Wait for scrolling to end

		// Move to click "Buy Available Upgrades" button in hero tab
		input.mouseMove(515, 775);
		input.mouseClick(1);
	}

	/**
	 * Adds MAX levels (10,000) to a hero. Needs mouse to be already placed on a
	 * hero level box
	 */
	private void AddMAXLevels() {
		input.getRobot().keyPress(KeyEvent.VK_Q); // Press Q Key
		input.mouseClick(1);
		input.getRobot().keyRelease(KeyEvent.VK_Q); // Release Q Key
	}

	/**
	 * Levels a hero by MAX levels
	 * 
	 * @param xCoordinate
	 *            - Horizontal position
	 * @param ycoordinate
	 *            - Vertical position
	 * @param delay
	 *            - Aesthetic delay to slow things down
	 */
	private void levelHeroMax(int xCoordinate, int ycoordinate, int delay) {
		input.mouseMove(xCoordinate, ycoordinate); // Moves mouse to a hero's level box
		AddMAXLevels(); // Level hero by MAX (10,000)
		input.delay(delay); // Aesthetic delay
	}

	/**
	 * Adds 100 levels to a hero. Needs mouse to be already placed on a hero level
	 * box
	 */
	private void Add100Levels() {
		input.getRobot().keyPress(KeyEvent.VK_CONTROL); // Press Control key
		input.mouseClick(1);
		input.getRobot().keyRelease(KeyEvent.VK_CONTROL); // Release Control key
	}

	/**
	 * Levels a hero by 100 levels
	 * 
	 * @param xCoordinate
	 *            - Horizontal position
	 * @param ycoordinate
	 *            - Vertical position
	 * @param delay
	 *            - Aesthetic delay to slow things down
	 */
	private void levelHero(int xCoordinate, int ycoordinate, int delay) {
		input.mouseMove(xCoordinate, ycoordinate); // Moves mouse to a hero's level box
		Add100Levels(); // Level hero by 100
		input.delay(delay); // Aesthetic delay
	}

	/**
	 * Used to enter a specific number to level Ancient by pressing V and clicking
	 * and releasing mouse button 1 then releasing V
	 */
	private void keyVMouseClick() {
		// Press V, click, then release V.
		input.getRobot().keyPress(KeyEvent.VK_V);
		input.mouseClick(1);
		input.getRobot().keyRelease(KeyEvent.VK_V);
	}

	/**
	 * Go to Firefox application by clicking Firefox as the SECOND icon on the
	 * Windows 7 taskbar
	 */
	private void goToFirefox() {
		input.mouseMove(145, 875); // Move to Firefox icon on Windows taskbar
		input.mouseClick(1); // Focus on Firefox
	}
}
