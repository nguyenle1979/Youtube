package youtube.com.test.home;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import youtube.com.common.Base;

public class Home_TestSuite_Testng extends Base {
	String[] args = null;
	@BeforeClass
	public void BeforeTest() throws IOException {
		startTest("Home Test");
	}
	
	@AfterClass
	public void AfterTest() throws IOException {
		endTest();
	}
	
	@Test
	public void HomeTest1() throws IllegalArgumentException, IllegalAccessException, IOException, InterruptedException, AWTException {
		HOME_TC_001.main(args);
	}
	
	@Test
	public void HomeTest2() throws IllegalArgumentException, IllegalAccessException, IOException, InterruptedException, AWTException {
		HOME_TC_002.main(args);
	}
}
