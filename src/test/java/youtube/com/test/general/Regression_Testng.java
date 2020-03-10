package youtube.com.test.general;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import youtube.com.common.Base;
import youtube.com.test.home.Home_TestSuite;
import youtube.com.test.primary.Primary_TestSuite;


public class Regression_Testng extends Base {
	String[] args = null;
	@BeforeClass
	public void BeforeClass() throws IOException {
		startTest("Regression Test");
	}
	
	@AfterClass
	public void AfterClass() throws IOException {
		endTest();
	}
	@Test
	public void RegressionTest() throws IllegalArgumentException, IllegalAccessException,InterruptedException, AWTException, IOException {
		Home_TestSuite.main(args);
		Primary_TestSuite.main(args);
	}
}
