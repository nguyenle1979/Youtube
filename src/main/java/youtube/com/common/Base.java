package youtube.com.common;

import java.io.FileInputStream;
import java.io.IOException;


import java.lang.reflect.Field;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;

import java.awt.Rectangle;
import java.awt.Toolkit;

import java.awt.image.BufferedImage;
import java.io.File;

public class Base extends ObjectMap {
	public static WebDriver driver=null;
	public static WebElement element ;
	public static String STEP_SEPARATOR = 
			"-------------------------------------------------------------------------------------------------------";
	public static String sTC_ID = null;
	public static Integer iStep = null;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String extentReportsPath = "";
	
	public static Properties prop=new Properties();
	public static int iNumberofRetry=0;
	public static Boolean bSuccess = false;
/*=================================================
 * 	Open a web page
 */
	public static void openURL(String url) throws IOException, InterruptedException	{
		loadConfigurationFile();
		if(prop.getProperty("BROWSER").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("WEBDRIVER_DIR") + "\\geckodriver.exe");
			driver=new FirefoxDriver();

		}
		else if (prop.getProperty("BROWSER").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("WEBDRIVER_DIR") + "\\chromedriver.exe");
			System.setProperty("webdriver.chrome.logfile", prop.getProperty("LOGFILE_DIR") + "\\test.log");
			Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
			System.setProperty("webdriver.chrome.silentOutput", "true");
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
			// options.addArguments("--start-maximized");
			//options.addArguments("force-device-scale-factor=0.50");
			//options.addArguments("high-dpi-support=0.50");
			driver=new ChromeDriver(options);
		}
		else {
			System.setProperty("webdriver.ie.driver", prop.getProperty("WEBDRIVER_DIR") + "\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		int waitingTime = Integer.parseInt(prop.getProperty("WAITTIME"));
		driver.manage().timeouts().implicitlyWait(waitingTime, TimeUnit.SECONDS);
		driver.get(url);

		Browser.maximizeWindow();
	}

/*=================================================
 * Load Configuration file.
 */		
	public static void loadConfigurationFile() throws IOException {
		FileInputStream fis= new FileInputStream("config.properties");
		prop.load(fis);
	}

/*=================================================
 * Exception Handle.
 */		
	public static void exceptionHandle(Exception e) throws IOException {
		Browser.closeAllWindowsByExceptions();
		TestNotify.fatal(GenLogTC() + e.getMessage());
		bSuccess = false;
		iNumberofRetry++;
	}
	
/*=================================================
 * Reset Test.
 */		
	public static void resetTest() {
		bSuccess = false;
		iNumberofRetry = 0;
	}	
	
/*=================================================
 * 	Start a Test when exporting extentReports
 */
    public static void startTest(String testName) throws IOException {
    	loadConfigurationFile();
 		extentReportsPath = prop.getProperty("EXTENT_REPORT_DIR");
		if(!extentReportsPath.isEmpty()) {
			Date date= new Date();
			long time = date.getTime();
			Timestamp ts = new Timestamp(time);
			String t1 = "ExtentReport_" + ts.toString().replace(":","_").replace(".","_");
			String t2 = t1.substring(0,t1.length() - 4);
			report = new ExtentReports(extentReportsPath + "\\" + t2 + ".html");
			test = report.startTest(testName);
		}
    }
    
/*=================================================
 * 	End a Test when exporting extentReports
 */
    public static void endTest() {
    	if(!extentReportsPath.isEmpty()) {
    	report.endTest(test);
    	report.flush();
    	}
    }
	
/*=================================================
 * Begin a Step.
 */		
	public static void beginStep() {
		TestNotify.log(STEP_SEPARATOR);
	    TestNotify.log(GenLogTC() + "is being tested ...");
	}

/*=================================================
 * End a Step.
 */		
	public static void endStep() {
		TestNotify.log(GenLogTC() + "has been tested.");
	}
		
/*=================================================
 * 	Snooze
 */	
	public static void snooze(int miliseconds) throws InterruptedException {
		Thread.sleep(miliseconds);
	}
	
/*=================================================
 * 	Generate Test Case ID and Step Number
 */
	public static String GenLogTC()	{
		return sTC_ID + " (step " + iStep + ") " ;
	}

	
	public static void LogFailDescription(String sJiraID) throws IOException {
		TestNotify.warning (GenLogTC() + "There is a submitted defect on Jira for this test case: " + sJiraID);
	}
/*=================================================
 * Return a random number between 2 number.	
 */		
	public static int getRandomNumber(int min, int max) throws IOException {
		if (min >= max) {
			TestNotify.fatal("Max must be greater than Min");
		}

		return (int)(Math.random() * ((max - min) + 1)) + min;
	}
	
/*=================================================
 * Click an object	
 */
	public static void clickObject(By byObj) throws IOException {
		try {
			WebElement object = driver.findElement(byObj);
			Actions builder = new Actions(driver);
			builder.click(object).build().perform();
		}
		catch(Exception e) {
			TestNotify.fatal(GenLogTC() + e.getMessage());
		}	
	}

/*=================================================
 * Click an object at X Y coordinates
 */
	public static void clickObjectCoordinates(By byObj, int X, int Y) throws IOException {
		try {
			WebElement object = driver.findElement(byObj);
			Actions builder = new Actions(driver);
			builder.moveToElement(object, X, Y).click().build().perform();
		}
		catch(Exception e) {
			TestNotify.fatal(GenLogTC() + e.getMessage());
		}	
	}

/*=================================================
 * Click an object in a list	
 */
	public static void clickObjectInAList(By byObj, int iIndex) throws IOException	{
		try {
			WebElement object = driver.findElements(byObj).get(iIndex);
			Actions builder = new Actions(driver);
			builder.click(object).build().perform();
		}
		catch(Exception e) {
			TestNotify.fatal(GenLogTC() + e.getMessage());
		}	
	}

	
/*=================================================
 * Hover mouse to an object.	
 */
	public static void hoverMouseToObject(By byObj) {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(byObj)).build().perform();
	}
	
/*=================================================
 * Double click an object.	
 */
	public static void doubleClickObject(By byObj) {
		Actions builder = new Actions(driver);
		builder.doubleClick(driver.findElement(byObj)).build().perform();
	}
	
/*=================================================
 * Right click an object.	
 */
	public static void rightClickObject(By byObj) {
		Actions builder = new Actions(driver);
		builder.contextClick(driver.findElement(byObj)).build().perform();
	}	
/*=================================================
 * Click a menu item	
 */
	public static void clickMenuItem(By byObj, String text) throws IOException	{
		try {
			int  n = countNumberOfObjectOnPage(byObj);
			for (int i=0;i<=n;i++) {	
				if(i==n) {
					TestNotify.warning(GenLogTC() + "Cannot find item [" + text + "].");
				}
				else {
					String t=getTextFromAnObjectInTheList(byObj, i); 
					if (t.equals(text))	{
						WebElement e = driver.findElements(byObj).get(i);
						Actions builder = new Actions(driver);
						builder.click(e).build().perform();
						
						break;
					}
				}
			}
		}
		catch(Exception e) {
			TestNotify.fatal(GenLogTC() + e.getMessage());
		}
	}

/*=================================================
 * Get Enabled Status of an Object	
 */	
	public static Boolean getEnabledStatus(By byObj) {
		return driver.findElement(byObj).isEnabled();
	}

/*=================================================
 * Get the existent status of an Object	
 */	
	public static Boolean getExistentStatus(By byObj) {
		Boolean existentStatus = false;
		try {
			driver.findElement(byObj);
			existentStatus = true;
		}
		catch(NoSuchElementException e) {
			existentStatus = false;
		}
		return existentStatus;
	}

/*=================================================
 * Get the displayed status of an Object	
 */	
	public static Boolean getDisplayedStatus(By byObj) {
		return driver.findElement(byObj).isDisplayed();
	}	

/*=================================================
 * Get the selected status of an Object	
 */	
	public static String getSelectedStatusOfObject(By byObj, String sOption) throws IllegalArgumentException, IllegalAccessException {
		 String s= getXpathString(byObj) + "[.//*[text()='" + sOption +"']]";
		 return driver.findElement(By.xpath(s)).getAttribute("aria-checked");
	}	
	
/*=================================================
 * Verify Displayed Status of an Object	
 */	
	public static void verifyDisplayedStatus(By byObj, Boolean status) throws IllegalArgumentException, IllegalAccessException, IOException	{
		Boolean currentStatus = getDisplayedStatus(byObj);
		String sObjName = getObjectName(byObj);
		if (status.equals(true)) {
			if (currentStatus.equals(true))	{
				TestNotify.pass(GenLogTC() + " The object [" + sObjName + "] is Displayed.");
			}
			else {
				TestNotify.fail(GenLogTC() + " The object [" + sObjName + "] is not Displayed.");
			}
		}
		if (status.equals(false)) {
			if (currentStatus.equals(true))	{
				TestNotify.fail(GenLogTC() + " The object [" + sObjName + "] is Displayed.");
			}
			else {
				TestNotify.pass(GenLogTC() + " The object [" + sObjName + "] is not Displayed.");
			}
		}
	}	
	
/*=================================================
 * Verify Selected Status of an Object	
 */	
	public static void verifySelectedStatus(By byObj, String sOption, Boolean status) throws IllegalArgumentException, IllegalAccessException, IOException {
		String currentStatus = getSelectedStatusOfObject(byObj, sOption);
		if (status.equals(true)) {
			if (currentStatus.equals("true")) {
				TestNotify.pass(GenLogTC() + " The object [" + sOption + "] is Selected.");
			}
			else {
				TestNotify.fail(GenLogTC() + " The object [" + sOption + "] is not Selected.");
			}
		}
		if (status.equals(false)) {
			if (currentStatus.equals("true")) {
				TestNotify.fail(GenLogTC() + " The object [" + sOption + "] is Selected.");
			}
			else {
				TestNotify.pass(GenLogTC() + " The object [" + sOption + "] is not Selected.");
			}
		}
	}	
	
			
/*=================================================
 * Verify Existent Status of an Object	
 */	
	public static void verifyExistentStatus(By byObj, Boolean status) throws IllegalArgumentException, IllegalAccessException, IOException {
		Boolean currentStatus = getExistentStatus(byObj);
		String sObjName = getObjectName(byObj);
		if (status.equals(true)) {
			if (currentStatus.equals(true))	{
				TestNotify.pass(GenLogTC() + " The object [" + sObjName + "] Exist.");
			}
			else {
				TestNotify.fail(GenLogTC() + " The object [" + sObjName + "] is not Exist.");
			}
		}
		if (status.equals(false)) {
			if (currentStatus.equals(true))	{
				TestNotify.fail(GenLogTC() + " The object [" + sObjName + "] is Exist.");
			}
			else {
				TestNotify.pass(GenLogTC() + " The object [" + sObjName + "] is not Exist.");
			}
		}
	}
		
	
	
/*=================================================
 * Verify Enabled Status of an Object	
 */	
	public static void verifyEnabledStatus(By byObj, Boolean status) throws IllegalArgumentException, IllegalAccessException, IOException {
		Boolean currentStatus = getEnabledStatus(byObj);
		String sObjName = getObjectName(byObj);
		if (status.equals(true)) {
			if (currentStatus.equals(true)) {
				TestNotify.pass(GenLogTC() + " The object [" + sObjName + "] is Enabled.");
			}
			else {
				TestNotify.fail(GenLogTC() + " The object [" + sObjName + "] is not Enabled.");
			}
		}
		if (status.equals(false)) {
			if (currentStatus.equals(true))	{
				TestNotify.fail(GenLogTC() + " The object [" + sObjName + "] is not Disabled.");
			}
			else {
				TestNotify.pass(GenLogTC() + " The object [" + sObjName + "] is Disabled.");
			}
		}
	}
	
/*=================================================
 * Input a Text String to an Object	
 */		
	public static void setTextToObject(String sTextString, By byObj) throws IOException {
		try {
			driver.findElement(byObj).sendKeys(sTextString);
		}
		catch(Exception e) {
			TestNotify.fatal( GenLogTC() + e.getMessage() );
		}
	}

/*=================================================
 * Verify Text of  an Object	
 */		
	public static void verifyTextInObject(String sTextString, By byObj) throws IOException {
		String currentText = driver.findElement(byObj).getAttribute("value");
		if (currentText.equals(sTextString)) {
			TestNotify.pass(GenLogTC() + "The Text String [" + sTextString + "] is set.");
		}
		else {
			TestNotify.fail(GenLogTC() + "The Text String [" + sTextString + "] is not set.");
		}
	}
	
/*=================================================
 * Get URL of current page	
 */
	public static String getCurrentURL() {
		return driver.getCurrentUrl();
	}	

/*=================================================
 * Verify URL of current page	
 */
	public static void verifyURLOfCurrentPage(String expectedURL) throws IOException {
		String currentURL = getCurrentURL();
		if(currentURL.equals(expectedURL)) {
			TestNotify.pass(GenLogTC() + "The URL of the current page [" + expectedURL + "] is verified successfully." );
		}
		else {
			TestNotify.fail(GenLogTC() + "The URL of the current page is not [" +  expectedURL + "].");
		}
	}		
	
/*=================================================
 * Click a random object
 */
	public static void clickRandomObject(By byObj) throws IOException {
		//int t = countNumberOfObjectOnPage(byObj);
		int r = getRandomNumber(1, 10);
		try {
			WebElement object = driver.findElements(byObj).get(r);
			Actions builder = new Actions(driver);
			builder.click(object).build().perform();

		}
		catch(Exception e) {
			TestNotify.fatal( GenLogTC() + e.getMessage() );
		}	
	}

/*===============================================
 * Count number of object on page	
 */	
	public static Integer countNumberOfObjectOnPage(By byObj) throws IOException {
		int n = 0;
		try {
			n = driver.findElements(byObj).size();
		}
		catch(Exception e) {
			TestNotify.fatal(GenLogTC() + e.getMessage());
		}
		return n;
	}
	
/*===============================================
 * Get text from an object in a list.	
 */		
	public static String getTextFromAnObjectInTheList(By byObj, int index) {
		String text = "";
		try	{
			text =  driver.findElements(byObj).get(index).getText();
		}
		catch (Exception e)	{
			text = "";
		}
		return text;
	}

/*===============================================
 * Get text from an object.	
 */		
	public static String getTextFromAnObject(By byObj) {
		return  driver.findElement(byObj).getText();
	}	

/*===============================================
 * Get title from an object in a list.	
 */		
	public static String getTitleFromAnObjectInTheList(By byObj, int index)	{
		String text = "";
		try	{
			text =  driver.findElements(byObj).get(index).getAttribute("title");
		}
		catch (Exception e)	{
			text = "";
		}
		return text;
	}

/*===============================================
 * Take screenshot of current screen.	
 */		
	public static void takeScreenShot(String sFileName) throws IOException {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		String fileWithPath = (prop.getProperty("SCREENSHOT_DIR") + "\\"+ sFileName);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
/*===============================================
 * Take screenshot of current screen for failed test.	
 */		
	public static String takeFailedScreenShot() throws IOException {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String fileWithPath = (prop.getProperty("FAILEDSCREENSHOT_DIR") + "\\"+ GenLogTC() + dateName + ".jpg");
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
		String absPath = Paths.get(fileWithPath).toAbsolutePath().toString();
		return absPath;
	}

/*===============================================
 * Get screenshot of an object.	
 */	
	
	public static void getScreenShotOfAnObject(By byObj) throws InterruptedException, IOException, IllegalArgumentException, IllegalAccessException	{
		 
        //Search for drop down
        element = driver.findElement(byObj);
 
        // Take screen shot of whole web page
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 
        // Calculate the width and height of the drop down element
        Point p = element.getLocation();
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
 
        // Create Rectangle of same width as of drop down Web Element
        Rectangle rect = new Rectangle(width, height);
 
        BufferedImage img = null;
        img = ImageIO.read(screenShot);
 
        //Crop Image of drop down web element from the screen shot
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
 
        // write cropped image into File Object
        ImageIO.write(dest, "png", screenShot);
        String objName = getObjectName(byObj);
        //Copy Image into particular directory
        FileUtils.copyFile(screenShot,
                new File(prop.getProperty("SCREENSHOT_DIR") + "\\"+ objName + ".jpg"));
    }
/*===============================================
 * Compare screen shot of two object.	
 */		
	public static void screenShotComaparision(String sScreenShot1, String sScreenShot2, String sScreenShotDiff, Boolean bExpVal) throws IOException {
		String imgActual = (prop.getProperty("SCREENSHOT_DIR") + "\\"+ sScreenShot1);
		String imgExpected = (prop.getProperty("SCREENSHOT_DIR") + "\\"+ sScreenShot2);
		String imgOutputDifferences = (prop.getProperty("SCREENSHOT_DIR") + "\\"+ sScreenShotDiff);
	
		ImageComparison imageComparison = new ImageComparison(10,10,0.05);

		if(bExpVal) {
			if(imageComparison.fuzzyEqual(imgActual,imgExpected,imgOutputDifferences)) {
				TestNotify.pass(GenLogTC() + "Screen Shot are fuzzy-equal.");
			}
			else {	
				TestNotify.fail(GenLogTC() + "Screen Shot are not fuzzy-equal.");
			}
		}
		else {
			if(imageComparison.fuzzyEqual(imgActual,imgExpected,imgOutputDifferences)) {
				TestNotify.fail(GenLogTC() + "Screen Shot are fuzzy-equal.");
			}
			else {	
				TestNotify.pass(GenLogTC() + "Screen Shot are not fuzzy-equal.");
			}
		}
    }
	
		
/*===============================================
 * Get name of an object in Object Map.	
 */		
	public static String getObjectName(By byObj) throws IllegalArgumentException, IllegalAccessException {
		ObjectMap objm = new ObjectMap();
		Field[]x=objm.getClass().getDeclaredFields();
		int n = objm.getClass().getDeclaredFields().length;
		String t="";
		for(int i=0; i<n; i++) {
			if (x[i].get(byObj).equals(byObj)) {
				t=x[i].getName();
			}
		}
		return t;
	}

/*===============================================
 * Get xpath string of an object in Object Map.	
 */		
	public static String getXpathString(By byObj) throws IllegalArgumentException, IllegalAccessException {
		ObjectMap objm = new ObjectMap();
		Field[]x=objm.getClass().getDeclaredFields();
		int n = objm.getClass().getDeclaredFields().length;
		String t="";
		String s="";
		for(int i=0; i<n; i++) {
			if (x[i].get(byObj).equals(byObj)) {
				t=x[i].get(byObj).toString();
				s =t.substring(10);
			}
		}
		return s;
	}
	
/*===============================================
 * Get list of all videos on a Page.	
 */
	
	public static void getListOfVideoOnPage(By byObj, String sFilePath) throws IOException, InterruptedException {
		int n = countNumberOfObjectOnPage(byObj);
		String s = "";
		for (int i=0; i<n; i++) {
			s = s + getTextFromAnObjectInTheList(byObj, i) + "\n";
		}
		Files.deleteAFileInFolder(sFilePath);
		FileUtils.writeStringToFile(new File(sFilePath), s);
		
	}
	
/*===============================================
 * Get list of all videos in Play List.	
 */
	
	public static void getListOfVideoInPlayList(By byObj, String sFilePath) throws IOException, InterruptedException {
		int n = countNumberOfObjectOnPage(byObj);
		String s = "";
		for (int i=0; i<n; i++) {
			s = s + getTitleFromAnObjectInTheList(byObj, i) + "\n";
		}
		Files.deleteAFileInFolder(sFilePath);
		FileUtils.writeStringToFile(new File(sFilePath), s);
		
	}
		

	
/*===============================================
 * Get object tooltip.	
 */
	public static String getToolTipOfObject(By byObj) throws IllegalArgumentException, IllegalAccessException, InterruptedException, IOException {
		String tooltip = "";
		String t1 = driver.findElement(byObj).getAttribute("tooltip-text");
		if(t1!=null) {
			tooltip = t1;
		}
		else {
			hoverMouseToObject(byObj);
			snooze(1000);
			if(getExistentStatus(byToolTip_Object)) {
				String t2 = driver.findElement(byToolTip_Object).getText();
				tooltip = t2;
			}
			else {
				String objectName = getObjectName(byObj);
				tooltip = "";
				TestNotify.warning(GenLogTC() + "There is no tooltip for the object [" + objectName +"].");
			}
		}	
		return tooltip;
	}
	
/*===============================================
 * Verify tooltip of object.	
 */
	public static void verifyToolTipOfObject(By byObj, String sExpToolTip) throws IllegalArgumentException, IllegalAccessException, InterruptedException, IOException {
		String t = getToolTipOfObject(byObj);
		if(t.equals(sExpToolTip)) {
			TestNotify.pass(GenLogTC() + "The tooltip [" + sExpToolTip + "] is verified successfully.");
		}
		else {
			TestNotify.fail(GenLogTC() + "The tooltip is [" + t + "] does not match with expected tooltip [" + sExpToolTip + "].");
		}
	}
	
/*===============================================
 * Active button object.	
 */
	
	public static void activeButtonObject(By byObj, Boolean bExpVal) throws IllegalArgumentException, IllegalAccessException, IOException {
		clickObject(byObj);
		String sObjName = getObjectName(byObj);
		String sActivated = driver.findElement(byObj).getAttribute("aria-pressed");
		if (bExpVal.equals(true)) {
			if (sActivated.equals("true")) {
				TestNotify.pass(GenLogTC() + " The object [" + sObjName + "] is activated.");
			}
			else {
				TestNotify.fail(GenLogTC() + " The object [" + sObjName + "] is not activated.");
			}
		}
		if (bExpVal.equals(false)) {
			if (sActivated.equals("true")) {
				TestNotify.fail(GenLogTC() + " The object [" + sObjName + "] is activated.");
			}
			else {
				TestNotify.pass(GenLogTC() + " The object [" + sObjName + "] is not activated.");
			}
		}
	}
	
/*===============================================
 * Get display resolution
 */
	public static double[] getDisplayResolution() {
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		double[] displayRes = {width, height};
		return displayRes;
	}

/*===============================================
 * Get object size
 */
	public static int[] getObjectSize(By byObj) {
		element = driver.findElement(byObj);
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();
		int[] size = {width, height};
		return size;
	}	
	
/*===============================================
 * Click object title.	
 */
	public static void clickObjectTitle(By byObj, String sTitle) throws IOException {
		try {
			int i=0;
			int  n = countNumberOfObjectOnPage(byObj);
			while (i<n) {	
				String title=getTitleFromAnObjectInTheList(byObj, i);
				String text=getTextFromAnObjectInTheList(byObj, i);
				if (title.contains(sTitle)||text.contains(sTitle))	{
					clickObjectInAList(byObj, i);
					break;
				}
				else {
					i++;
				}
			}
			
			if(i==n) {
				TestNotify.warning("Cannot find object [" + sTitle + "].");
			}
		}
		catch(Exception e) {
			TestNotify.fatal(GenLogTC() + e.getMessage());
		}
	}
}
