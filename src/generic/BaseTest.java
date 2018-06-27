package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant
{
	public static WebDriver driver;
	static
	{
		//Set the path
		System.setProperty(GECKO_KEY,GECKO_VALUE);
		System.setProperty(CHROME_KEY,CHROME_VALUE);
	}
	@BeforeMethod
	public void openApllication()
	{
		//Launch the Browser
		driver = new FirefoxDriver();
		
		//Enter the url
		String url = Lib.getPropertyValue("URL");
		driver.get(url);
		
		//set the implicit time wait
		String timeOut = Lib.getPropertyValue("ITO");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(timeOut), TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeApllication(ITestResult res)
	{
		String testMethodName = res.getName();
		if(ITestResult.FAILURE==res.getStatus())
		{
			Lib.takesScreenshot(driver,testMethodName);
		}
		
		driver.close();
	}
}
