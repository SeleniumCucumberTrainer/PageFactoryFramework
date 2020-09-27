package FirstMavenPackage.FacebookAutomationProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FacebookLoginPage {
	
	public WebDriver driver;
	
	@FindBy(id="email")
	public WebElement UserId;
	@FindBy(id="pass")
	public WebElement Password;
	@FindBy(id="login")
	public WebElement LoginButton;
	@FindBy(xpath="//a[contains(text(),'Forgotten account?')")
	public WebElement ForgetPassword;
	@FindBy(xpath="//div[text()='Log in to Facebook']")
	public WebElement LoginFailed;
	@FindBy(xpath="//a[@data-testid='open-registration-form-button']")
	public WebElement createNewAct;
	
	
	
	public FacebookLoginPage(WebDriver driver1){
		
		driver = driver1;	
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void FacebookLogin(){
		
		UserId.sendKeys("seleniumbesttrainer@gmail.com");
		Password.sendKeys("itcm@123");
		LoginButton.click();
		
	}
	
	public void verifyFacebookLoginWithInvalidCred(){
		
        String actualText = LoginFailed.getText();
		Assert.assertEquals("Log in to Facebook", actualText);
			
	}
	

}
