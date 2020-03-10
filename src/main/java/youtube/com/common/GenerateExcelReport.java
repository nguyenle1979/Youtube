package youtube.com.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import youtube.com.common.Base;

public class GenerateExcelReport extends Base {
	public static void main(String[] args) throws IOException {
		loadConfigurationFile();
		String t = prop.getProperty("EXCEL_REPORT_DIR");
		if(t.isEmpty()) {
			TestNotify.warning("Please set excel report folder in config file.");
		}
		else {
			System.out.println("Generating Excel report...");
			Properties prop=new Properties();
			FileInputStream fis= new FileInputStream("config.properties");
			prop.load(fis);
	        //Date object
			Date date= new Date();
	        //getTime() returns current time in milliseconds
			long time = date.getTime();
	        //Passed the milliseconds to constructor of Timestamp class 
			Timestamp ts = new Timestamp(time);
			
			String t1 = t + "\\Test_Report_" + ts.toString().replace(":","_").replace(".","_");
			File excelFile = new File(t1.substring(0,t1.length() - 4) +".xlsx");
			FileOutputStream out = new FileOutputStream(excelFile);
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Test result report");
	
			File file = new File(prop.getProperty("TEMPORARY_FILE_DIR") + "\\report.txt");
			List<String> lines = FileUtils.readLines(file);
			Iterator<String> i = lines.iterator();
	        int rownum=0;
	        int cellnum = 0;
	
	        while (i.hasNext()) {
	        	Row row = sheet.createRow(rownum++);
	            Cell cell = row.createCell(cellnum);
	            String temp = (String) i.next();
	            String ascii1 = "[0;32m";
	            String ascii2 = "[0m";
	            temp = temp.replace(ascii1, "").replace(ascii2, "");
	
	            CellStyle style = workbook.createCellStyle();
	            Font font = workbook.createFont();
	            String res="";
	            int index = temp.indexOf(" ");
	            if (index > -1) { // Check if there is more than one word.
	            	res= temp.substring(0, index).trim(); // Extract first word.
	            } 
	            else {
	            	res= temp; // Text is the first word itself.
	            }
	            switch(res) {
	            	case "Passed:":
	            		font.setColor(IndexedColors.GREEN.getIndex());
	            		break;
	            	case "Failed:":
	            		font.setColor(IndexedColors.RED.getIndex());
	            		break;
	            	case "Warning:":
	            		font.setColor(IndexedColors.YELLOW.getIndex());
	            		break;
	            	case "Info:":
	            		font.setColor(IndexedColors.BLUE.getIndex());
	            		break;
	            	case "Fatal:":
	            		font.setColor(IndexedColors.RED.getIndex());
	            		break;
	            	default:
	            		font.setColor(IndexedColors.GREEN.getIndex());
	            		break;
	            }
	
	            style.setFont(font);
	            cell.setCellValue(temp);
	            cell.setCellStyle(style);
	        	
	        }
	        workbook.write(out);
	        out.close();
	        workbook.close();
	        System.out.println("The report is generated successfully.");
		}
	}
}