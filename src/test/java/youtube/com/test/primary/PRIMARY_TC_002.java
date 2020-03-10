package youtube.com.test.primary;


import java.awt.AWTException;
import java.io.IOException;


import youtube.com.pages.Primary;
import youtube.com.common.Shortcut;
import youtube.com.common.Base;
import youtube.com.common.Browser;
import youtube.com.pages.Home;


public class PRIMARY_TC_002 extends Base {
	
	public static String t1="";
	public static String t2="";
	public static void main(String[] args) throws IOException, InterruptedException, IllegalArgumentException, IllegalAccessException, AWTException {
		loadConfigurationFile();
		int iMaxTries = Integer.parseInt(prop.getProperty("RETRY"));

		while(!bSuccess && iNumberofRetry<=iMaxTries) {
			try {
			sTC_ID = "PRIMARY_TC_002";
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
		t1= Primary.getTitleOfPlayingVideo();
		t2=Primary.getTitleOfUpNextVideo();
		endStep();
	}
	
	public static void Step_03() throws InterruptedException, IOException, IllegalArgumentException, IllegalAccessException	{
		iStep++;
		beginStep();
		
		//Step 03: Press "End" from keyboard.
		Primary.activeMainVideo();
		snooze(2000);
		Shortcut.press_End();
		
		//System skips to the end of playing video.
		//After a few second, next video in the list is played.
		snooze(10000);
		Primary.verifyTitleOfPlayingVideo(t2);
		
		endStep();
	}
	
	public static void Step_04() throws InterruptedException, IllegalArgumentException, IllegalAccessException, IOException	{
		iStep++;
		beginStep();
		//Step 04: Click "Settings" button. Set the Quality is "480p" for the playing video.
		Primary.detectAds();

		
		Primary.activeMainVideo();
		Primary.clickVideoSettingsButton();
		Primary.clickVideoSettingsMenuItem("Quality");
		Primary.clickVideoSettingsMenuItem("480p");
		
		//System plays the video in 480p.

		
		endStep();
	}
	
	public static void Step_05() throws InterruptedException, IllegalArgumentException, IllegalAccessException, IOException	{
		iStep++;
		beginStep();

		//Step 05: Click "Settings" button. Set the Playback peed is "0.5" for the playing video.
		Primary.clickVideoSettingsButton();
		Primary.clickVideoSettingsMenuItem("Playback speed");
		Primary.clickVideoSettingsMenuItem("0.5");
		
		//System plays the video in half speed.
		
		endStep();
	}
	
	public static void Step_06() throws InterruptedException, IOException {
		iStep++;
		beginStep();
		
		//Step 06: Click "Back" button on the web browser.
		Browser.clickBackButtonOnBrowser();
		snooze(2000);
		
		//System comeback to previous page, showing the previous video.
		Primary.verifyTitleOfPlayingVideo(t1);

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

