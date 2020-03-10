package youtube.com.pages;

import java.io.IOException;

import youtube.com.common.Base;

public class Home extends Base {

/*===============================================
 * Click Main Menu Item.	
 */		
	public static void clickMainMenuItem(String option) throws InterruptedException, IOException	{
		clickMenuItem(byYTMenuEntry_Menu, option);
	}
	
/*===============================================
 * Open Home Page.	
 */
	public static void openHomePage() throws InterruptedException, IOException {
		Home.clickMainMenuItem("Home");
		snooze(2000);
	}
	
/*===============================================
 * Click Search Button on Home page.	
 */	
	public static void clickSearchButton() throws InterruptedException, IOException {
		clickObject(bySearchButton_Home);
		snooze(3000);
	}

/*===============================================
 * Set a text in Search TextBox.	
 */	
	public static void setSearchText(String textString) throws IOException	{
		setTextToObject(textString, bySearchTextBox_Home);
	}

/*===============================================
 * Click a random video on Home page.	
 */		
	public static void clickRandomVideo() throws IOException {
		clickRandomObject(byListingVideoThumb_Home);
	}
}
