package scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestInvalidLogin extends BaseTest
{
	//enter username
	
	@Test
	public void testInvalidLogin()
	{
		
		//enter the username
		LoginPage lp= new LoginPage(driver);
				
		int rowCount = Lib.getRowCount("InvalidLogin");
		for(int i=1;i<=rowCount;i++)
		{
					
			
			String username = Lib.getCellValue("InvalidLogin", i, 0);
			lp.setUsername(username);
				
			//enter the password
				
			String password = Lib.getCellValue("InvalidLogin", i, 1);
			lp.setPassword(password);
				
			//click on login button
				
			lp.clickLogin();
			
			SoftAssert s=new SoftAssert();
			s.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
			s.assertAll();
		
		}
	}
	

}
