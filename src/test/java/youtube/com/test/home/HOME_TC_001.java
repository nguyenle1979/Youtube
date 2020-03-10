package youtube.com.test.home;

import java.awt.AWTException;
import java.io.IOException;

import youtube.com.common.Base;
import youtube.com.common.Browser;
import youtube.com.pages.Home;
import youtube.com.pages.SearchResult;

public class HOME_TC_001 extends Base {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, IOException, InterruptedException, AWTException {
		loadConfigurationFile();
		int iMaxTries = Integer.parseInt(prop.getProperty("RETRY"));

		while(!bSuccess && iNumberofRetry<=iMaxTries) {
			try {
				sTC_ID = "HOME_TC_001";
				iStep = 0;
			
				Step_01();
				Step_02();
				Step_03();
				Step_04();
				
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
		snooze(1000);

		endStep();
	}
	
	public static void Step_02() throws IOException, InterruptedException, IllegalArgumentException, IllegalAccessException, AWTException {
		iStep++;
		beginStep();
		
		//Step 02: Click "Search" button.
		Home.clickSearchButton();
		
		//Page is refreshed showing new video.
		Browser.verifyTabName("YouTube");
		takeScreenShot(GenLogTC() + ".jpg");
		snooze(1000);
		screenShotComaparision(GenLogTC() + ".jpg", "HOME_TC_001 (step 1) .jpg", GenLogTC() + "diff.jpg", false);
		
		endStep();
	}
	
	public static void Step_03() throws IOException, InterruptedException, IllegalArgumentException, IllegalAccessException	{
		iStep++;
		beginStep();
		
		//Step 03: Input a search string to "Search" text box "computer". Click "Search" button.
		Home.setSearchText("computer");
		Home.clickSearchButton();

		//System show search result page with videos contains "computer" in name.
		SearchResult.verifyTitleOfListingVideo("computer", 0);
		
		endStep();
	}
	
	public static void Step_04() throws IOException, InterruptedException, IllegalArgumentException, IllegalAccessException	{
		iStep++;
		beginStep();
		
		//Step 04: Close the browser.
		Browser.closeAllWindows();

		//The browser is closed.
		
		
		endStep();

	}
}
