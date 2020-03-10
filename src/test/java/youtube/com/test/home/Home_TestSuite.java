package youtube.com.test.home;

import java.awt.AWTException;
import java.io.IOException;

import youtube.com.common.Base;

public class Home_TestSuite extends Base {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, IOException, InterruptedException, AWTException {
		HOME_TC_001.main(args);
		HOME_TC_002.main(args);
	}

}
