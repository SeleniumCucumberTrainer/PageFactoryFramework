package FirstMavenPackage.FacebookAutomationProject.CorePackage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import Util.Xls_Reader;

public class BaseTest {
	
	static public WebDriver driver;
	static public Properties config;
	static public Properties ObjectRepo;
	static public FileInputStream fis ;
	static public FileInputStream locator ;
	//static public Xls_Reader excel;
	
	static public Logger log;
	
	
	@BeforeMethod
	public void init() throws IOException{
		
		String Userpath = System.getProperty("user.dir");
		
		// excel = new Util.Xls_Reader(Userpath+"\\Data\\TestData.xlsx");
		 
		 log = Logger.getLogger("devpinoyLogger");
		
		config = new Properties(); 
		ObjectRepo = new Properties(); 
		
		System.out.println(Userpath);
		
		fis = new FileInputStream(Userpath+"\\src\\main\\java\\Config\\config.properties");
		
		config.load(fis);
		
		String browserValue = config.getProperty("browser");
		
		System.out.println(browserValue);
		
		if(browserValue.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver", Userpath+"\\src\\main\\java\\Driver\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			
			log.debug("Opening Firefox browser.....");
			
		}
		
		else if(browserValue.equalsIgnoreCase("Chrome")){
			
			System.setProperty("webdriver.chrome.driver", Userpath+"\\src\\main\\java\\Driver\\chromedriver.exe");
		
		    driver = new ChromeDriver();
		    
		    log.debug("Opening Chrome browser.....");
		
		}
		
		else if(browserValue.equalsIgnoreCase("ie")){
			
			System.setProperty("webdriver.ie.driver", Userpath+"\\src\\main\\java\\Driver\\IEDriverServer.exe");
			
		    driver = new InternetExplorerDriver();
		    
		    log.debug("Opening IE browser.....");
		
		}
		
		String url = config.getProperty("url");
		
		driver.manage().window().maximize();
		
		log.debug("Maximizing browser.....");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		log.debug("Waiting for page to load");
		
		driver.get(url);
		
		log.debug("Opening "+url);
				
	}
	
	
	@AfterMethod
	public void closeBrowser(){
		
		driver.quit();
		
	}
	
	
	

}
