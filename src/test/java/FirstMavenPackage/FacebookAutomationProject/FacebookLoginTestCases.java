package FirstMavenPackage.FacebookAutomationProject;

import org.testng.annotations.Test;

import FirstMavenPackage.FacebookAutomationProject.CorePackage.BaseTest;
import FirstMavenPackage.FacebookAutomationProject.Pages.FacebookLoginPage;

public class FacebookLoginTestCases extends BaseTest{
	
	
    
	public static void main(String[] a){
    	
    	FacebookLoginPage FBloginPage = new FacebookLoginPage(driver);
    	FBloginPage.FacebookLogin();
    	FBloginPage.verifyFacebookLoginWithInvalidCred();
		
	}
	
}
