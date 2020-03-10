package youtube.com.pages;

import java.io.IOException;

import youtube.com.common.Base;

public class Subscriptions extends Base {

/*===============================================
 * Open Subscriptions Page.	
 */
	public static void openSubscriptionsPage() throws InterruptedException, IOException {
		Home.clickMainMenuItem("Subscriptions");
		snooze(2000);
	}
		
}
