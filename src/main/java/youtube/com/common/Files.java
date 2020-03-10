package youtube.com.common;


import java.io.File;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;


import org.apache.commons.io.FileUtils;


public class Files extends Base {

/*===============================================
 * Delete a file in folder.	
 */		
	public static void deleteAFileInFolder(String sFilePath) throws IOException, InterruptedException {
		File fFile = new File(sFilePath); 
        
        if(fFile.delete()) { 
            TestNotify.pass(GenLogTC() + "File deleted successfully"); 
        } 
        else { 
            TestNotify.fail(GenLogTC() + "Cannot delete the file. Please check file path and permission."); 
        } 
	}
	
/*===============================================
 * Delete all files in folder.	
 */		
	public static void deleteAllFilesInFolder(String sFolder) throws IOException {
		try {
		File fFile = new File(sFolder);
		FileUtils.cleanDirectory(fFile);
		}
		catch (Exception e) {
			TestNotify.fatal(GenLogTC() + "Cannot delete files. Please check file path and permission.");
		}
	}

/*===============================================
 * Copy file to folder.	
 */		
	public static void copyFiletoFolder(String sFile, String sFolder) throws InterruptedException, IOException {
		try {
			File srcFile = new File(sFile);
			File desFolder = new File(sFolder);
			FileUtils.copyFileToDirectory(srcFile, desFolder);
			TestNotify.pass(GenLogTC() + ("The copying process is completed successully.")); 
		}
		catch (Exception e) {
			TestNotify.fatal(GenLogTC() + "Cannot copy file. Please check the permission to write on destination folder.");
		}
	}
	
	
	
/*===============================================
 * Copy folder to folder.	
 */		
	public static void copyFoldertoFolder(String sSourceFolder, String sDestinationFolder) throws IOException {
		try {
			File srcFolder = new File(sSourceFolder);
			File desFolder = new File(sDestinationFolder);
			FileUtils.copyDirectory(srcFolder, desFolder);
			TestNotify.pass(GenLogTC() + ("The copying process is completed successully.")); 
		}
		catch (Exception e) {
			TestNotify.fatal(GenLogTC() + "Cannot copy folder. Please check the permission to write on destination folder.");
		}
	}
		
/*===============================================
 * Search a string in a text file.	
 */	
	public static boolean searchStringInTextFile(String sSearchString, String sFile) throws IOException {
		File fFile= new File(sFile);
		String content = FileUtils.readFileToString(fFile, StandardCharsets.UTF_8);
		if (content.contains(sSearchString)) {
			return true;
		}
		else {
			return false;
		}
	}
	
/*===============================================
 * Trim slash at the end of file path.	
 */	
	public static String trimSlashInFilePath(String sFilePath) {
		while(sFilePath.endsWith("\\")) {
			int l=sFilePath.length();
			sFilePath = sFilePath.substring(0, l-1);
		}
		return sFilePath;
	}
	
/*===============================================
 * Verify existent status of a file.	
 */		
	public static void verifyExistentStatusOfFile(String sFile, Boolean bExpStatus) throws IOException {
		File fFile= new File(sFile);
		if (bExpStatus)	{
			if (fFile.exists())	{
				TestNotify.pass(GenLogTC() + " The file [" + sFile + "] exist.");
			}
			else {
				TestNotify.fail(GenLogTC() + " The file [" + sFile + "] is not exist.");
			}
		}
		if (!bExpStatus) {
			if (fFile.exists())	{
				TestNotify.fail(GenLogTC() + " The The file [" + sFile + "] exist.");
			}
			else {
				TestNotify.pass(GenLogTC() + " The file [" + sFile + "] is not exist.");
			}
		}
	}
	
/*===============================================
 * Get File Size in Byte.	
 */		
	public static long getFileSize(String sFile) {
		File fFile= new File(sFile);
		return fFile.length();
	}
	
/*===============================================
 * Get the extension of a file.	
 */		
	public static String getFileExtension(String sFile) {
		int iDot = sFile.lastIndexOf(".");
		int iSlash = sFile.lastIndexOf("/");
		if(iDot>iSlash) {
			String r = sFile.substring(iDot+1);
			return r;
		}
		else {
			return "";
		}
	}
	
/*===============================================
 * Compare 2 files.	
 */		
	public static void compareFiles(String sFile1, String sFile2, Boolean bExpStatus) throws IOException, InterruptedException {
		String sResultFile = prop.getProperty("TEMPORARY_FILE_DIR") + "\\result.txt";
		Files.deleteAFileInFolder(sResultFile);
		OS.getContentOfCommandPrompt("fc " + sFile1 + " " + sFile2, sResultFile);
		Boolean r= searchStringInTextFile("no differences encountered", sResultFile);
		if(bExpStatus) {
			if(r) {
				TestNotify.pass(GenLogTC() +"There is no differences in files");
			}
			else {
				TestNotify.fail(GenLogTC() +"There is differences in files");
			}
		}
		if(!bExpStatus) {
			if(r) {
				TestNotify.fail(GenLogTC() +"There is no differences in files");
			}
			else {
				TestNotify.pass(GenLogTC() +"There is differences in files");
			}
		}	
	}
	
/*===============================================
 * Rename a file.	
 */
	public static void renameFile(String sFilePath, String newName) throws IOException {
		try {
			File fFile = new File(sFilePath);
			File fNewFile = new File(fFile.getAbsoluteFile().getParent() + "\\" + newName);
			fFile.renameTo(fNewFile);
		}
		catch (Exception e) {
			TestNotify.fatal("Cannot rename file. Please check the file path.");
		}
	}
	
/*===============================================
 * Convert path of file and folder to Java path.	
 */		
	public static String convertToJavaPath(String sPath) {
		return Paths.get(sPath).toAbsolutePath().toString().replace("\\", "\\\\");
	}
	
/*===============================================
 * Create new directory.	
 */		
	public static void createNewDir(String sPath) {
		File file = new File(sPath);
		if(!file.exists()) {
			Boolean b= file.mkdir();
			if(b) {
				TestNotify.log("Directory created successfully.");
			}
			else {
				TestNotify.log("Cannot create specified directory." );
			}
		}
	}

}

