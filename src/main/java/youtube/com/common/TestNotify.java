package youtube.com.common;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

public class TestNotify extends Base{
	
	public static final String RESET = "\033[0m";  // Text Reset
	public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
	
	public static void pass(String log)	{
		System.out.println(GREEN + "Passed: " + log + RESET);
		if(!extentReportsPath.isEmpty()) {
			test.log(LogStatus.PASS, log);
		}
	}
	
	public static void fail(String log) throws IOException	{
		System.out.println(RED + "Failed: " + log + RESET);
		if(!extentReportsPath.isEmpty()) {
			test.log(LogStatus.FAIL, log, test.addScreenCapture(takeFailedScreenShot()));
		}
	}
	
	public static void warning(String log) throws IOException {
		System.out.println(YELLOW + "Warning: " + log + RESET);
		if(!extentReportsPath.isEmpty()) {
			test.log(LogStatus.WARNING, log, test.addScreenCapture(takeFailedScreenShot()));
		}
	}
	
	public static void info(String log)	{
		System.out.println(BLUE + "Info: " + log + RESET);
		if(!extentReportsPath.isEmpty()) {
			test.log(LogStatus.INFO, log);
		}
	}

	public static void fatal(String log) throws IOException {
		System.out.println(RED + "Fatal: " + log + RESET);
		if(!extentReportsPath.isEmpty()) {
			test.log(LogStatus.FATAL, log, test.addScreenCapture(takeFailedScreenShot()));
		}
	}
	
	public static void log(String log)	{
		System.out.println(GREEN + log + RESET);
		if(!extentReportsPath.isEmpty()) {
			test.setDescription(log);
		}
	}
}
