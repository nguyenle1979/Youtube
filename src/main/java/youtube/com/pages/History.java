package youtube.com.pages;

import java.io.IOException;

import youtube.com.common.Base;

public class History extends Base {
	
/*===============================================
 * Open History Page.	
 */
	public static void openHistoryPage() throws InterruptedException, IOException {
		Home.clickMainMenuItem("History");
		snooze(2000);
	}
	
/*===============================================
 * Select History type.	
 */
	public static void selectHistoryType(String option) throws IOException {
		clickMenuItem(byHistoryTypeRadioButton_History, option);
	}
	
/*===============================================
 * Verify Selected History Type.	
 */
	
	public static void verifySelectedHistoryType(String option, Boolean bExpStatus) throws IllegalArgumentException, IllegalAccessException, IOException {
		verifySelectedStatus(byHistoryTypeRadioButton_History, option, bExpStatus);
	}
	
/*===============================================
 * Set a text in Search Watch History.	
 */	
	public static void setTextToSearchWatchHistory(String textString) throws IOException {
		setTextToObject(textString, bySearchWatchHistoryInput_History);
	}

}
