package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//declare the elements	
	@FindBy(id="username")
	WebElement un;
	
	@FindBy(name="pwd")
	WebElement pwd;
	
	@FindBy(xpath="//*[.='Login ']")
	WebElement loginButton;
	
	//initialize the elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilize the elements
	public void setUsername(String username)
	{
		un.sendKeys(username);
		
	}
	
	public void setPassword(String password)
	{
		
		pwd.sendKeys(password);
		
	}
	
	public void clickLogin()
	{
		
		loginButton.click();
	}
	
	
}
