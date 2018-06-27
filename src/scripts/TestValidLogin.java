package scripts;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestValidLogin extends BaseTest
{
	@Test
	public void testValidLogin()
	{
		//enter the username
		LoginPage lp= new LoginPage(driver);
		
		String username = Lib.getCellValue("ValidLogin", 1, 0);
		lp.setUsername(username);
		
		//enter the password
		
		String password = Lib.getCellValue("ValidLogin", 1, 1);
		lp.setPassword(password);
		
		//click on login button
		
		lp.clickLogin();
		
				
		//Explicit wait condition
		WebDriverWait wait=new WebDriverWait(driver, 10);
		Boolean isTitleDisplayed = wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		if(isTitleDisplayed)
		{
				SoftAssert s=new SoftAssert();
				s.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
				s.assertAll();
		}
	}

}
