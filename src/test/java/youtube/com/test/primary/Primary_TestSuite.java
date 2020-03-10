package youtube.com.test.primary;

import java.awt.AWTException;
import java.io.IOException;


import youtube.com.common.Base;

public class Primary_TestSuite extends Base {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, IOException, InterruptedException, AWTException {
		PRIMARY_TC_001.main(args);
		PRIMARY_TC_002.main(args);
	}

}
