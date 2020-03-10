package youtube.com.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class OS extends Base {
	
/*===============================================
 * Get value of an Environment Variable.	
 */	
	public static String getEnvironmentVariables(String sEnvVar) throws IOException {
		String v= System.getenv(sEnvVar);
		if(v.equals("")) {
			TestNotify.warning("The '" + sEnvVar + "' environment veriable is undefined.");
			v= "ENV_VAR_UNDEFINED";
		}
		return v;
	}
/*===============================================
 * Run a command line.	
 */			
	public static Process runCommandInCommandPrompt(String command) throws IOException {
		Process p = null;
        try {  
          p = Runtime.getRuntime().exec("cmd /c " + command);
        } 
        catch (Exception e) { 
            TestNotify.fatal("There is something wrong in the command."); 
            e.printStackTrace(); 
        }
		return p; 
    }
	
/*===============================================
 * Write output of command prompt to file.	
 */		
	public static void getContentOfCommandPrompt(String command, String file) throws IOException {
	    StringBuffer output = new StringBuffer();
	    Process p;
	    try {
	    	p = runCommandInCommandPrompt(command);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line = "";
	        while ((line = reader.readLine()) != null) {
	            output.append(line + "\n");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    String content = output.toString();
	    FileOutputStream fop = null;
	    File f = new File(file);
	    try {
		    fop = new FileOutputStream(f);
		    if (!f.exists()) {
				f.createNewFile();
		    }
		    byte[] contentInBytes = content.getBytes();
		    fop.write(contentInBytes);
			fop.flush();
			fop.close();
	    } 
	    catch (IOException e) {
	    	e.printStackTrace();
	    } 
	    finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
	    }
    }
	
/*===============================================
 * Kill a task by using command line.	
 */
	public static void killTask(String taskName) throws IOException {
        try {  
        	runCommandInCommandPrompt("Taskkill /IM " + taskName + " /F" );
        } 
        catch (Exception e) { 
            TestNotify.fatal("There is something wrong in the command."); 
            e.printStackTrace(); 
        }
	}
	
/*===============================================
 * Get computer name.	
 */	
	public static String getComputerName() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostName();
	}
	
/*===============================================
 * Get system information.	
 */	
	public static void getSystemInformation() throws IOException {
		try {
		String sFile = prop.getProperty("TEMPORARY_FILE_DIR") + "\\systeminfo.txt";
		File fFile = new File(sFile);
		if(fFile.exists()) {
			Files.deleteAFileInFolder(sFile);
		}
		getContentOfCommandPrompt("systeminfo", sFile);
		TestNotify.info("Please check the system information in file [" + sFile + "].");
		}
		catch (Exception e) {
			TestNotify.fatal(e.getMessage());
		}
	}
}
