package youtube.com.pages;


import java.io.IOException;
import youtube.com.common.Base;


public class Trending extends Base {

/*===============================================
 * Open Trending Page.	
 */
	public static void openTrendingPage() throws InterruptedException, IOException {
		Home.clickMainMenuItem("Trending");
		snooze(2000);
	}
	
/*===============================================
 * Get list of all videos in Trending Page.	
 */
	
	public static void getListofVideoTrendingPage() throws IOException, InterruptedException {
		getListOfVideoOnPage(byVideoTitle_Trending, prop.getProperty("TEMPORARY_FILE_DIR")+ "\\ListOfVideoTrendingPage.txt");
	}
	
/*===============================================
 * Open a video in Trending list.	
 */		
	public static void openAVideoInTrendingList(String sTitle) throws InterruptedException, IllegalArgumentException, IllegalAccessException, IOException {
		clickObjectTitle(byVideoTitle_Trending, sTitle);
	}	
			
}
