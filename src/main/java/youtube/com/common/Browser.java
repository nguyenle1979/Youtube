package youtube.com.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;



public class Browser extends Base {
	
/*===========================================================================
 * Get tab name of current tab.	
/*===========================================================================*/
	public static String getTabName() {
		return driver.getTitle();
	}
	
/*===========================================================================
 * Get Url of current tab.	
/*===========================================================================*/
	public static String getUrl() {
		return driver.getCurrentUrl();
	}
	
/*===========================================================================
 * Verify tab name of current tab.
/*===========================================================================*/
	public static void verifyTabName(String tabName) throws IOException {
		String currentTabName = getTabName();
		if (currentTabName.contains(tabName)) {
			TestNotify.pass(GenLogTC() + "The tab [" + tabName + "] is opened successfully.");
		}
		else {
			TestNotify.fail(GenLogTC() + "The tab [" + tabName + "] is not opened.");
		}
	}
	
/*===========================================================================
 * Maximize Window. 	
/*===========================================================================*/
	public static void maximizeWindow()	{
		driver.manage().window().maximize();
	}
	
/*===========================================================================
 * set Fullscreen Window. 	
/*===========================================================================*/
	public static void fullscreenWindow()	{
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_F11);
			robot.keyRelease(KeyEvent.VK_F11);

	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
	}
			
/*===========================================================================
 * Minimize Window.
/*===========================================================================*/
	public static void minimizeWindow()	{
		driver.manage().window().setPosition(new Point(0, 3000));
		TestNotify.pass(GenLogTC() + "Current Window is maximized.");
	}
	
/*===========================================================================
 * Resize Window. 	
/*===========================================================================*/
	public static void resizeWindow(int iWidth, int iHeight) {
		driver.manage().window().setPosition(new Point(100, 100));
		Dimension d = new Dimension(iWidth,iHeight);
		driver.manage().window().setSize(d);
		TestNotify.pass(GenLogTC() + "Current Window has been resized.");
	}
	
/*===========================================================================
 * Move Window to new position.
/*===========================================================================*/
	public static void moveWindow(int iX, int iY) {
		driver.manage().window().setPosition(new Point(iX, iY));
		TestNotify.pass(GenLogTC() + "Current Window has been moved to expected position.");
	}
		
/*===========================================================================
 * Create new tab. 	
/*===========================================================================*/
	public static void createNewTab(int n) throws InterruptedException {
		for(int i=0; i<n; i++) {
			((JavascriptExecutor)driver).executeScript("window.open();");
		}
		snooze(2000);
	}
	
/*===========================================================================
 * Create new window. 	
/*===========================================================================*/
	public static void createNewWindow(int n) throws InterruptedException {
		try {
			Robot robot = new Robot();
			for(int i=0; i<n; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_N);
				
			robot.keyRelease(KeyEvent.VK_N);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			}
	    }
	    catch (AWTException e) {
	    	e.printStackTrace();
	    }
		snooze(2000);
	}
	
/*===========================================================================
 * Get number of window tab.
/*===========================================================================*/
	public static Integer getNumberOfWindowTab() {
		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 return tabs.size();
	}
	
/*===========================================================================
 * Switch to a tab.
/*===========================================================================*/
	public static void switchToWindowTab(String windowTabName) throws InterruptedException, IOException {
		int n = getNumberOfWindowTab();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		for (int i=0; i<=n;i++) {
			if(i==n) {
				TestNotify.fatal("Cannot find tab [" + windowTabName + "].");
				break;
			}
			else {
				driver.switchTo().window(tabs.get(i));
				if(getTabName().contains(windowTabName)) {
					TestNotify.pass("Switched to tab [" + windowTabName + "] successfully.");
					break;
				}
			}
		}

	}
	
/*===========================================================================
 * Close current Window.
/*===========================================================================*/
	public static void closeCurrentWindow()	{
		driver.close();
		TestNotify.pass(GenLogTC() + "The current window is closed.");
	}
	
/*===========================================================================
 * Close all Windows.
/*===========================================================================*/
	public static void closeAllWindows() {
		driver.quit();
		TestNotify.pass(GenLogTC() + "The browser is closed.");
	}

	/*===========================================================================
	 * Close all Windows by Exceptions.
	/*===========================================================================*/
		public static void closeAllWindowsByExceptions() {
			driver.quit();
			TestNotify.log(GenLogTC() + "The browser is closed by exception.");
		}
/*===========================================================================
 * Click Back Button on Browser.
/*===========================================================================*/	
	public static void clickBackButtonOnBrowser() {
		driver.navigate().back();
	}
	
/*===========================================================================
 * Click Forward Button on Browser.
/*===========================================================================*/	
	public static void clickForwardButtonOnBrowser() {
		driver.navigate().forward();
	}	
	
/*===========================================================================
 * Click Refresh Button on Browser.
/*===========================================================================*/	
	public static void clickRefreshButtonOnBrowser() {
		driver.navigate().refresh();
	}
	
/*===========================================================================
 * Open Url on a window tab
/*===========================================================================*/	
	public static void setURLForWindowTab(String sWindowTabName, String sUrl) throws InterruptedException, IOException {
		switchToWindowTab(sWindowTabName);
		driver.navigate().to(sUrl);
	}
	
/*===========================================================================
 * Verify Url of current tab.
/*===========================================================================*/
	public static void verifyUrl(String sExpVal) throws IOException {
		String sCurrentUrl =getUrl();
		if (sCurrentUrl.contains(sExpVal)) {
			TestNotify.pass(GenLogTC() + "The Url contains [" + sExpVal + "] as expected.");
		}
		else {
			TestNotify.fail(GenLogTC() + "The Url does not contain [" + sExpVal + "] as expected.");
		}
	}
/*===========================================================================
 * Scroll a page.
/*===========================================================================*/	
	public static void scrollPage(int iHPixel, int iVPixel) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(" + iHPixel +","+ iVPixel + ")");
	}
	
}
