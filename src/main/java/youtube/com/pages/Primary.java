package youtube.com.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import youtube.com.common.Base;
import youtube.com.common.TestNotify;

public class Primary extends Base {

/*===============================================
 * Active main video.	
 */		
	public static void activeMainVideo() throws IOException {
		clickObjectCoordinates(byMainVideoContainer_Primary, 0, 180);
	}

	
/*===============================================
 * Click Stop button.	
 */		
	public static void clickStopButton() throws IOException {
		clickObject(byPauseButton_Primary);
	}	

/*===============================================
 * Click Play button.
 */		
	public static void clickPlayButton() throws IOException {
		clickObject(byPlayButton_Primary);
	}	

/*===============================================
 * Click Next button.	
 */		
	public static void clickNextButton() throws IOException {
		clickObject(byNextButton_Primary);
	}

/*===============================================
 * Click Fullscreen button.	
 */		
	public static void clickFullScreenButton() throws IOException {
		clickObject(byFullScreenButton_Primary);
	}
		
	
/*===============================================
 * Click Subtitles button.	
 */		
	public static void clickSubtitlesButton() throws InterruptedException, IOException {
		clickObject(bySubtitlesButton_Primary);
		snooze(1000);
	}	

/*===============================================
 * Click Video  Settings Button.	
 */		
	public static void clickVideoSettingsButton() throws InterruptedException, IOException {
		clickObject(bySettingsButton_Primary);
		snooze(1000);
	}
	
/*===============================================
 * Click Video Settings Menu Item.	
 */		
	public static void clickVideoSettingsMenuItem(String option) throws InterruptedException, IOException {
		clickMenuItem(bySettingsMenuItem_Primary, option);
		snooze(1000);
	}
	
/*===============================================
 * Click Sort By Button.	
 */		
	public static void clickSortByButton() throws InterruptedException, IOException {
		clickObject(bySortByButton_Primary);
		snooze(1000);
	}
	
/*===============================================
 * Click Sort By Menu Item.	
 */		
	public static void clickSortByMenuItem(String option) throws InterruptedException, IOException {
		clickMenuItem(bySortByMenuItem_Primary, option);
		snooze(1000);
	}
	
/*===============================================
 * Click Reply Comment Button.	
 */		
	public static void clickReplyCommentButton(int iIndex) throws InterruptedException, IOException {
		clickObjectInAList(byReplyCommentButton_Primary, iIndex);
		snooze(1000);
	}
	
/*===============================================
 * Click View Reply Button.	
 */		
	public static void clickViewReplyButton(int iIndex) throws InterruptedException, IOException	{
		clickObjectInAList(byViewReplyButton_Primary, iIndex);
		snooze(1000);
	}	
	
/*===============================================
 * Click Hide Reply Button.	
 */		
	public static void clickHideReplyButton(int iIndex) throws InterruptedException, IOException	{
		clickObjectInAList(byHideReplyButton_Primary, iIndex);
		snooze(1000);
	}	
/*===============================================
 * Get number of Like of playing video.	
 */		
	public static int getNumberOfLikeOfPlayingVideo() {
		String a =  driver.findElement(byLikeButton_Primary).getAttribute("aria-label");
		String number = a.substring(0,a.length() - 6).replace(",", "");
		return Integer.parseInt(number);
	}

/*===============================================
 * Get number of Dislike of playing video.	
 */		
	public static int getNumberOfDislikeOfPlayingVideo() {
		String a =  driver.findElement(byDislikeButton_Primary).getAttribute("aria-label");
		String number = a.substring(0,a.length() - 9).replace(",", "");
		return Integer.parseInt(number);
	}	

/*===============================================
 * Get number of Comment of playing video.	
 */		
	public static int getNumberOfCommentOfPlayingVideo() {
		String a =  getTextFromAnObject(byNumberOfComment_Primary);
		String number = a.substring(0,a.length() - 9).replace(",", "").replace(",", "");
		return Integer.parseInt(number);
	}	
	
/*===============================================
 * Get content of a comment of playing video.	
 */		
	public static String getContentOfACommentOfPlayingVideo(int iIndex)	{
		return  getTextFromAnObjectInTheList(byCommentContentText_Primary, iIndex);
	}	

/*===============================================
 * Get number of Like of a comment.	
 */		
	public static int getNumberOfLikeOfAComment(int index) {
		int iLike = 0;
		String a =  driver.findElements(byLikeCommentButton_Primary).get(index).getAttribute("aria-label");
		if(a.contains("person")) {
			iLike=1;
		}
		else {
			String number = a.substring(29,a.length() - 13).replace(",", "");
			iLike= Integer.parseInt(number);
		}
		return iLike;
	}	
	
/*===============================================
 * Get number of Like of a reply.	
 */		
	public static int getNumberOfLikeOfAReply(int index) {
		int iLike = 0;
		String a =  driver.findElements(byLikeReplyButton_Primary).get(index).getAttribute("aria-label");
		if(a.contains("person")) {
			iLike=1;
		}
		else {
			String number = a.substring(27,a.length() - 13).replace(",", "");
			iLike= Integer.parseInt(number);
		}
		return iLike;
	}	
	
/*===============================================
 * Get number of  View of playing video.	
 */		
	public static int getNumberOfViewOfPlayingVideo() {
		String a =  getTextFromAnObject(byViewCount_Primary);
		String number = a.substring(0,a.length() - 6).replace(",", "");
		int r= Integer.parseInt(number);
		return r;
	}	
	
/*===============================================
 * Get name of YouTube channel of playing video.	
 */		
	public static String getChannelNameOfPlayingVideo()	{
		return getTextFromAnObject(byChannelName_Primary);
	}	

/*===============================================
 * Get number of subscriber of the channel.	
 */		
	public static String getChannelNumberOfSubscriber() throws IOException	{
		String a = "";
		String r = "";
		try	{
			a =  getTextFromAnObject(byNumberOfSubscriber_Primary);
			r = a.substring(0,a.length() - 12);
		}
		catch (Exception e)	{
			TestNotify.warning(GenLogTC()+ "No information about subscriber in this channel.");
		}
		return r;
	}	
	
/*===============================================
 * Get title of playing video.	
 */		
	public static String getTitleOfPlayingVideo() {
		return getTextFromAnObjectInTheList(byVideoTitle_Primary, 0);
	}	

/*===============================================
 * Get title of Up Next video.	
 */		
	public static String getTitleOfUpNextVideo() {
		return getTextFromAnObjectInTheList(byUpNextVideoTitle_Primary, 0);
	}	
	
/*===============================================
 * Verify title of playing video.	
 */	
	public static void verifyTitleOfPlayingVideo(String videoTitle) throws IOException	{
		String currentTitle = getTextFromAnObjectInTheList(byVideoTitle_Primary, 0);
		if(currentTitle.equals(""))	{
			TestNotify.fatal(GenLogTC() + "There is no playing video.");
		}
		else {
			if(currentTitle.equals(videoTitle) && currentTitle!="")	{
				TestNotify.pass(GenLogTC() + "The playing video has a correct title [" + videoTitle + "].");
			}
			else {
				TestNotify.fail(GenLogTC() + "The playing video does not have a correct title [" + videoTitle + "].");
			}
		}
	}

/*===============================================
 * Detect Ads	
 */
	public static void detectAds() throws InterruptedException, IOException	{
		WebDriverWait wait = new WebDriverWait(driver, 32);
		Boolean adsText = getExistentStatus(byAdsText_Primary);
		while(adsText.equals(true))	{	
			snooze(1000);
			String t = getTextFromAnObject(byAdsReviewText_Primary);
			Boolean b = t.contains("will");
			if(b.equals(true)) {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(byAdsText_Primary));
				break;
			}
			else {
				wait.until(ExpectedConditions.visibilityOfElementLocated(bySkipAdButton_Primary));
				clickObject(bySkipAdButton_Primary);
				break;
			}
		}
	}
		
/*===============================================
 * Detect PopUp	
 */		
	public static void detectPopUp() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Boolean isExist = getExistentStatus(byPromotion_PopUp);
		while (isExist) {
			if(getExistentStatus(byOkButton_PopUp)) {
				clickObject(byOkButton_PopUp);
				snooze(1000);
				break;
			}
			else if(getExistentStatus(byNoThanksButton_PopUp)) {
				clickObject(byNoThanksButton_PopUp);
				snooze(1000);
				break;
			}
		}
	}	

/*===============================================
 * Active Save PlayList button in play list.	
 */		
	public static void activeSavePlayListButton(Boolean bExpVal) throws InterruptedException, IllegalArgumentException, IllegalAccessException, IOException {
		activeButtonObject(bySavePlayListButton_Primary, bExpVal);
	}
	
/*===============================================
 * Active Loop PlayList button in play list.	
 */		
	public static void activeLoopPlayListButton(Boolean bExpVal) throws InterruptedException, IllegalArgumentException, IllegalAccessException, IOException {
		activeButtonObject(byLoopPlayListButton_Primary, bExpVal);
	}

/*===============================================
 * Active Shuffle PlayList button in play list.	
 */		
	public static void activeShufflePlayListButton(Boolean bExpVal) throws InterruptedException, IllegalArgumentException, IllegalAccessException, IOException {
		activeButtonObject(byShufflePlayListButton_Primary, bExpVal);
	}	
	
/*===============================================
 * Open a video in play list.	
 */		
	public static void openAVideoInPlayList(String sTitle) throws InterruptedException, IllegalArgumentException, IllegalAccessException, IOException {
		clickObjectTitle(byPlayListVideo_Primary, sTitle);
	}	
		

	
/*===============================================
 * Verify fullscreen
 */
	public static void verifyFullScreen(Boolean bExpVal) throws IOException {
		double[] displayRes = getDisplayResolution();
		int[] objectSize = getObjectSize(byMainVideoContainer_Primary);
		if(bExpVal) {
			if(objectSize[0]>=displayRes[0]-10 && objectSize[1]>=displayRes[1]-10) {
				TestNotify.pass(GenLogTC() + "The video is playing in fullscreen mode.");
			}
			else {
				TestNotify.fail(GenLogTC() + "The video is not playing in fullscreen mode.");
			}
		}
		else {
			if(objectSize[0]>=displayRes[0]-10 && objectSize[1]>=displayRes[1]-10) {
				TestNotify.fail(GenLogTC() + "The video is playing in fullscreen mode.");
			}
			else {
				TestNotify.pass(GenLogTC() + "The video is not playing in fullscreen mode.");
			}
		}
	}
}
