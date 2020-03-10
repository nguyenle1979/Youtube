package youtube.com.test.home;

import java.awt.AWTException;
import java.io.IOException;

import youtube.com.common.Base;
import youtube.com.common.Browser;
import youtube.com.pages.History;
import youtube.com.pages.Home;
import youtube.com.pages.Library;
import youtube.com.pages.Subscriptions;
import youtube.com.pages.Trending;

public class HOME_TC_002 extends Base {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, IOException, InterruptedException, AWTException {
		loadConfigurationFile();
		int iMaxTries = Integer.parseInt(prop.getProperty("RETRY"));
		
		while(!bSuccess && iNumberofRetry<=iMaxTries) {
			try {
				sTC_ID = "HOME_TC_002";
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
		takeScreenShot(GenLogTC() + ".jpg");

		endStep();
	}
	
	public static void Step_02() throws IOException, InterruptedException, IllegalArgumentException, IllegalAccessException, AWTException {
		iStep++;
		beginStep();
		
		//Step 02: Click "Home" on the main menu on the left.
		Home.openHomePage();
		
		//Page is refreshed showing new video.
		Browser.verifyTabName("YouTube");
		takeScreenShot(GenLogTC() + ".jpg");
		snooze(2000);
		screenShotComaparision(GenLogTC() + ".jpg", "HOME_TC_002 (step 1) .jpg", GenLogTC() + "diff.jpg", false);
		
		endStep();
	}
	
	public static void Step_03() throws IOException, InterruptedException, IllegalArgumentException, IllegalAccessException	{
		iStep++;
		beginStep();
		
		//Step 03: Click "Trending" on the main menu.
		Trending.openTrendingPage();
		//"Trending" page is opened.
		Browser.verifyTabName("Trending");
		
		endStep();
	}
	
	public static void Step_04() throws IOException, InterruptedException, IllegalArgumentException, IllegalAccessException	{
		iStep++;
		beginStep();
		
		//Step 03: Click "Subscriptions" on the main menu.
		Subscriptions.openSubscriptionsPage();
		//"Subscriptions" page is opened.
		Browser.verifyTabName("Subscriptions");
		
		endStep();
	}
	
	public static void Step_05() throws IOException, InterruptedException, IllegalArgumentException, IllegalAccessException	{
		iStep++;
		beginStep();
		
		//Step 03: Click "Library" on the main menu.
		Library.openLibraryPage();
		//"Library" page is opened.
		Browser.verifyTabName("Library");
		
		endStep();
	}
	
	public static void Step_06() throws IOException, InterruptedException, IllegalArgumentException, IllegalAccessException	{
		iStep++;
		beginStep();
		
		//Step 03: Click "History" on the main menu.
		History.openHistoryPage();
		//"History" page is opened.
		Browser.verifyUrl("history");
		
		endStep();
	}
	
	public static void Step_07() throws IOException, InterruptedException, IllegalArgumentException, IllegalAccessException	{
		iStep++;
		beginStep();
		
		//Step 04: Close the browser.
		//The browser is closed.
		Browser.closeAllWindows();
		
		endStep();
	}
}
