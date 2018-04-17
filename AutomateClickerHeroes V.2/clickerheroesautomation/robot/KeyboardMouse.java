package robot;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/** Mouse clicks and key presses needed for Clicker Heroes using the Robot class*/
public class KeyboardMouse {
	private static Robot robot; // Declare Robot variable to use keyboard and mouse automation
	// Initialize robot
	static {
		// AWTException will only be thrown if Robot Class's constructor doesn't work
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			System.out.println("Problem with constructing Robot Class in KeyboardMouse");

		}
	}

	// Keyboard ****************************************************************************************************************************************
	/** Type F11 key */
	public void keyF11() {
		// Press F11 and release F11 key
		robot.keyPress(KeyEvent.VK_F11);
		robot.keyRelease(KeyEvent.VK_F11);
	}

	/** Type Tab key */
	public void keyTab() {
		// Press Tab key and release Tab key
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	/** Type Home key */
	public void keyHome() {
		// Press Home key and release Home key
		robot.keyPress(KeyEvent.VK_HOME);
		robot.keyRelease(KeyEvent.VK_HOME);
	}

	/** Type Enter key */
	public void keyEnter() {
		// Press Enter key and release Enter key
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	/** Type Control + V key for shortcut to paste */
	public void keyControlV() {
		// Press Control and V key then release Control and V key
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
	}

	/** Type Alt + Tab key to switch between active applications */
	public void keyAltTab() {
		// Press Alt and Tab key then release Alt and Tab key
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.delay(100);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	/** Type Control + C key for shortcut to copy */
	public void keyControlC() {
		// Press Control and C then release Control and C key
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
	}

	//	/**
	//	 * Type Windows + D key to go to Windows Desktop
	//	 */
	//	public void keyWindowsD() {
	//		//Press Windows and D then release Windows and D key
	//		robot.keyPress(KeyEvent.VK_WINDOWS);
	//		robot.keyPress(KeyEvent.VK_D);
	//		robot.keyRelease(KeyEvent.VK_WINDOWS);
	//		robot.keyRelease(KeyEvent.VK_D);
	//	}

	// Mouse *******************************************************************************************************************************************
	/** Automatically left click a mouse X amount */
	public void mouseClick(int amount) {
		// Click X amount of times
		for (int i = 0; i < amount; i++) {
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		}
	}

	/**
	 * Scroll x amount using mouse wheel (third button)
	 * 
	 * @param amountOfScrolls
	 *            Negative number scrolls up, positive number scrolls down
	 */
	public void mouseScroll(int amountOfScrolls) {

		// Scroll x amount of times
		robot.mouseWheel(amountOfScrolls);
	}

	/**
	 * Move mouse to screen coordinates. Calls System.exit(0) when mouse has
	 * deviated from intended coordinates
	 * 
	 * @param xCoordinate
	 *            Vertical coordinates on the monitor
	 * @param yCoordinate
	 *            Horizontal coordinates on the monitor
	 */
	public void mouseMove(int xCoordinate, int yCoordinate) {
		robot.mouseMove(xCoordinate, yCoordinate);

		delay(100); // Give time for mouse to be moved if user wants to exit

		// Check if user has moved mouse to end program
		Point p = MouseInfo.getPointerInfo().getLocation();
		if ((int) p.getX() != xCoordinate || (int) p.getY() != yCoordinate) {
			System.out.println("ERROR - Mouse Movement Detected. Close Program");
			System.exit(0);
		}
	}

	/**
	 * Delay program by milliseconds. Between 0 and 60,000 milliseconds inclusive.
	 * 
	 * @param ms
	 *            Milliseconds to delay
	 */
	public void delay(int ms) {
		robot.delay(ms);
	}

	/** Return Robot object variable */
	public Robot getRobot() {
		return robot;
	}
}
