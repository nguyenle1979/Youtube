package youtube.com.pages;

import java.io.IOException;

import youtube.com.common.Base;
import youtube.com.common.TestNotify;

public class SearchResult extends Base {

/*===============================================
 * Click a random video on Search Result page.	
 */	
	public static void clickRandomVideo() throws IOException {
		clickRandomObject(byListingVideoTitle_SR);
	}
	
/*===============================================
 * Verify title of video on Search Result page.	
 */	
	public static void verifyTitleOfListingVideo(String textString, int index) throws IOException {
		String currentTitle = getTextFromAnObjectInTheList(byListingVideoTitle_SR, index);

		if(currentTitle.toLowerCase().contains(textString.toLowerCase()) && currentTitle!="") {
			TestNotify.pass(GenLogTC() + "There is a string [" +  textString + "] in the video title of Search Result");
		}
		else {
			TestNotify.fail(GenLogTC() + "Cannot find string [" +  textString + "] in the video title of Search Result");
		}
	}
}
