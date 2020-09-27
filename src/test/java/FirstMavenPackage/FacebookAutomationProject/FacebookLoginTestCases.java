package FirstMavenPackage.FacebookAutomationProject;

import org.testng.annotations.Test;

import FirstMavenPackage.FacebookAutomationProject.CorePackage.BaseTest;
import FirstMavenPackage.FacebookAutomationProject.Pages.FacebookLoginPage;

public class FacebookLoginTestCases extends BaseTest{
	
	
    @Test
	public static void TC01_VerifyInvalidCredLogin(){
    	
    	FacebookLoginPage FBloginPage = new FacebookLoginPage(driver);
    	FBloginPage.FacebookLogin();
    	FBloginPage.verifyFacebookLoginWithInvalidCred();
		
	}
	
}
