package youtube.com.test.primary;


import java.awt.AWTException;
import java.io.IOException;
import youtube.com.pages.Primary;
import youtube.com.common.Shortcut;
import youtube.com.common.Base;
import youtube.com.common.Browser;
import youtube.com.common.Files;
import youtube.com.pages.Home;


public class PRIMARY_TC_001 extends Base {
	
	public static void main(String[] args) throws IOException, InterruptedException, IllegalArgumentException, IllegalAccessException, AWTException {
		loadConfigurationFile();
		int iMaxTries = Integer.parseInt(prop.getProperty("RETRY"));

		while(!bSuccess && iNumberofRetry<=iMaxTries) {
			try {
				sTC_ID = "PRIMARY_TC_001";
				iStep = 0;
				Step_01();
				Step_02();
				Step_03();
				Step_04();
				Step_05();
				Step_06();
				Step_07();
			
				bSuccess = true;
			}
			catch (Exception ex) {
				exceptionHandle(ex);
			}
		}
		resetTest();
	}

	public static void Step_01() throws IOException, InterruptedException, IllegalArgumentException, IllegalAccessException, AWTException {
		iStep++;
		beginStep();
		
		//Step 01: Open Youtube homepage.
		openURL("https://www.youtube.com");
		
		//Youtube home page is opened showing a list of Recommended video.
		Browser.verifyTabName("YouTube");
		snooze(1000);

		endStep();
	}
	
	public static void Step_02() throws InterruptedException, IllegalArgumentException, IllegalAccessException, IOException	{
		iStep++;
		beginStep();
		
		//Step 02: Click a random video in Home page to open it.
		Home.clickRandomVideo();
	
		//System opens a new page to play the video.
		Primary.detectAds();
		Primary.detectPopUp();
		
		verifyExistentStatus(byMainVideoContainer_Primary, true);
		
		endStep();
	}
	
	public static void Step_03() throws InterruptedException, IOException, IllegalArgumentException, IllegalAccessException	{
		iStep++;
		beginStep();
		
		//Step 03: Press K from keyboard.
		Shortcut.press_K();
		
		//System pauses the video.
		snooze(1000);
		getScreenShotOfAnObject(byMainVideoContainer_Primary);
		snooze(2000);
		Files.renameFile(prop.getProperty("SCREENSHOT_DIR") + "\\" + "byMainVideoContainer_Primary.jpg", "byMainVideoContainer_Primary_exp.jpg");
		snooze(3000);
		getScreenShotOfAnObject(byMainVideoContainer_Primary);
		snooze(2000);
		screenShotComaparision("byMainVideoContainer_Primary.jpg", "byMainVideoContainer_Primary_exp.jpg", "byMainVideoContainer_Primary_diff.jpg", true);
		
		endStep();
	}
	
	public static void Step_04() throws InterruptedException, IllegalArgumentException, IllegalAccessException, IOException	{
		iStep++;
		beginStep();
		//Step 04: Press K again.
		Shortcut.press_K();
		
		//System continues playing the video.
		snooze(2000);
		Files.deleteAFileInFolder(prop.getProperty("SCREENSHOT_DIR") + "\\byMainVideoContainer_Primary.jpg");
		snooze(1000);
		getScreenShotOfAnObject(byMainVideoContainer_Primary);
		snooze(2000);
		screenShotComaparision("byMainVideoContainer_Primary.jpg", "byMainVideoContainer_Primary_exp.jpg", "byMainVideoContainer_Primary_diff.jpg", false);
		
		endStep();
	}
	
	public static void Step_05() throws InterruptedException, IllegalArgumentException, IllegalAccessException, IOException	{
		iStep++;
		beginStep();

		//Step 05: Click "Fullscreen" button.
		Primary.clickFullScreenButton();
		snooze(10000);
		
		//System plays the video in fullscreen mode.
		Primary.verifyFullScreen(true);
		
		endStep();
	}
	
	public static void Step_06() throws InterruptedException, IOException {
		iStep++;
		beginStep();
		
		//Step 06: Click "F" from keyboard.
		Shortcut.press_F();
		snooze(2000);
		
		//System exits the fullscreen mode.
		Primary.verifyFullScreen(false);

		endStep();
	}

	public static void Step_07() {
		iStep++;
		beginStep();
		
		//Step 07: Close the browser.
		//The browser is closed.
		Browser.closeAllWindows();
		
		endStep();
	}
}

