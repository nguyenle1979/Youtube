package youtube.com.pages;

import java.io.IOException;

import youtube.com.common.Base;

public class Library extends Base {

/*===============================================
 * Open Library Page.	
 */
	public static void openLibraryPage() throws InterruptedException, IOException {
		Home.clickMainMenuItem("Library");
		snooze(2000);
	}
		
}
