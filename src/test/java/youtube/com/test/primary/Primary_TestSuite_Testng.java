package youtube.com.test.primary;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import youtube.com.common.Base;

public class Primary_TestSuite_Testng extends Base {
	String[] args = null;
	@BeforeClass
	public void BeforeClass() throws IOException {
		startTest("Primary Test");
	}
	
	@AfterClass
	public void AfterClass() throws IOException {
		endTest();
	}
	
	@Test
	public void PrimaryTest1() throws IllegalArgumentException, IllegalAccessException, IOException, InterruptedException, AWTException {
		PRIMARY_TC_001.main(args);
	}
	
	@Test
	public void PrimaryTest2() throws IllegalArgumentException, IllegalAccessException, IOException, InterruptedException, AWTException {
		PRIMARY_TC_002.main(args);
	}
}
