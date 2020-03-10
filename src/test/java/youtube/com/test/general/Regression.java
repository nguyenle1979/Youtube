package youtube.com.test.general;

import java.awt.AWTException;
import java.io.IOException;

import youtube.com.common.Base;
import youtube.com.test.home.Home_TestSuite;
import youtube.com.test.primary.Primary_TestSuite;

public class Regression extends Base {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, IOException, InterruptedException, AWTException {
		startTest("Regression Test");
		Home_TestSuite.main(args);
		Primary_TestSuite.main(args);
		endTest();
	}

}
