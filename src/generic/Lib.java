package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hwpf.usermodel.DateAndTime;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.SystemClock;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Lib implements IAutoConstant 
{
	public static Workbook wb;
	public static String getPropertyValue(String propertyName)
	{
		String propertyValue="";
		Properties prop=new Properties();
		try 
		{
			prop.load(new FileInputStream(CONFIG_PATH));
			propertyValue = prop.getProperty(propertyName);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
		
		return propertyValue;
	}
	
	public static String getCellValue(String sheetName,int rowNum, int colNum)
	{
		String cellValue="";
		
		try
		{
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			cellValue=wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).toString();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
		
		return cellValue;
		
	}

	
	public static int getRowCount(String sheetName)
	{
		int rowCount=0;
		
		try
		{
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			rowCount=wb.getSheet(sheetName).getLastRowNum();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return rowCount;
	}
	
	@AfterMethod
	public static void takesScreenshot(WebDriver driver, String testMathodName)
	{
		/*
		
		Date date=new Date();
		String date1 = date.toString();
		String currentDateTime = date1.replaceAll(":", "_");
		
		*/
		String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File(SNAPSHOT_PATH+testMathodName+"_"+currentDateTime+".png");
		
		try 
		{
			FileUtils.copyFile(srcFile, destFile);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
}
