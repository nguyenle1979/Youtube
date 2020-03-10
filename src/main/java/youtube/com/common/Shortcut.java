package youtube.com.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Shortcut extends Base{

/*===========================================================================
 * Pause/Play the playing video.
/*===========================================================================*/
	public static void press_K() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_K);
			robot.keyRelease(KeyEvent.VK_K);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}
	
/*===========================================================================
 * Turn up volume 5%
/*===========================================================================*/
	public static void press_Up() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_UP);
			robot.keyRelease(KeyEvent.VK_UP);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}
	
/*===========================================================================
 * Turn down volume 5%
/*===========================================================================*/
	public static void press_Down() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}
	
/*===========================================================================
 * Mute/unmute volume
/*===========================================================================*/
	public static void press_M() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_M);
			robot.keyRelease(KeyEvent.VK_M);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}
	
/*===========================================================================
 * Move backward 5 sec
/*===========================================================================*/
	public static void press_Left() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_LEFT);
			robot.keyRelease(KeyEvent.VK_LEFT);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}
	
/*===========================================================================
 * Move forward 5 sec
/*===========================================================================*/
	public static void press_Right() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyRelease(KeyEvent.VK_RIGHT);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}
	
/*===========================================================================
 * Move forward 10 sec
/*===========================================================================*/
	public static void press_L() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_L);
			robot.keyRelease(KeyEvent.VK_L);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}
	
/*===========================================================================
 * Move backward 10 sec
/*===========================================================================*/
	public static void press_J() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_J);
			robot.keyRelease(KeyEvent.VK_J);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}
	
/*===========================================================================
 * Restart the video
/*===========================================================================*/
	public static void press_0() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_0);
			robot.keyRelease(KeyEvent.VK_0);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}
	
/*===========================================================================
 * Skip to the end
/*===========================================================================*/
	public static void press_End() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_END);
			robot.keyRelease(KeyEvent.VK_END);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}
	
/*===========================================================================
 * Enter or exit full screen
/*===========================================================================*/
	public static void press_F() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_F);
			robot.keyRelease(KeyEvent.VK_F);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}	
	
/*===========================================================================
 * Exit full screen
/*===========================================================================*/
	public static void press_Esc() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}	
	
/*===========================================================================
 * Move to next video (only in playlist)
/*===========================================================================*/
	public static void press_Ctrl_Right() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_RIGHT);
			
			robot.keyRelease(KeyEvent.VK_RIGHT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}	
	
/*===========================================================================
 * Move to previous video (only in playlist)
/*===========================================================================*/
	public static void press_Ctrl_Left() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_LEFT);
			
			robot.keyRelease(KeyEvent.VK_LEFT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}	
	
/*===========================================================================
 * Move forward in player control buttons
/*===========================================================================*/
	public static void press_Tab() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}	
	
/*===========================================================================
 * Move backward in player control buttons
/*===========================================================================*/
	public static void press_Shift_Tab() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_TAB);
			
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_SHIFT);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}	
	
/*===========================================================================
 * Execute select player control button
/*===========================================================================*/
	public static void press_Enter() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}	
	
/*===========================================================================
 * Turn on/off CC (closed captions)
/*===========================================================================*/
	public static void press_C() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_C);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}	
	
/*===========================================================================
 * Increase CC font size when it’s turned on
/*===========================================================================*/
	public static void press_Plus() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PLUS);
			robot.keyRelease(KeyEvent.VK_PLUS);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}	
	
/*===========================================================================
 * Decrease CC font size when it’s turned on
/*===========================================================================*/
	public static void press_Minus() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}	
	
/*===========================================================================
 * Change CC background color
/*===========================================================================*/
	public static void press_B() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_B);
			robot.keyRelease(KeyEvent.VK_B);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}	
	
/*===========================================================================
 * Increase play speed
/*===========================================================================*/
	public static void press_GREATER() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_GREATER);
			robot.keyRelease(KeyEvent.VK_GREATER);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}	
	
/*===========================================================================
 * Decrease play speed
/*===========================================================================*/
	public static void press_Less() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_LESS);
			robot.keyRelease(KeyEvent.VK_LESS);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}	
	
/*===========================================================================
 * Play previously played video
/*===========================================================================*/
	public static void press_Shift_P() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_P);
			
			robot.keyRelease(KeyEvent.VK_P);
			robot.keyRelease(KeyEvent.VK_SHIFT);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}	
	
/*===========================================================================
 * Play next video in recommendation/playlist
/*===========================================================================*/
	public static void press_Shift_N() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_N);
			
			robot.keyRelease(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_SHIFT);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}
	
/*===========================================================================
 * Place text cursor in search field to start typing
/*===========================================================================*/
	public static void press_Slash() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_SLASH);
			robot.keyRelease(KeyEvent.VK_SLASH);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}	
	
/*===========================================================================
 * Move backward per frame when video is paused
/*===========================================================================*/
	public static void press_Comma() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_COMMA);
			robot.keyRelease(KeyEvent.VK_COMMA);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}	
	
/*===========================================================================
 * Move forward per frame when video is paused
/*===========================================================================*/
	public static void press_Period() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PERIOD);
			robot.keyRelease(KeyEvent.VK_PERIOD);
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}	
}
