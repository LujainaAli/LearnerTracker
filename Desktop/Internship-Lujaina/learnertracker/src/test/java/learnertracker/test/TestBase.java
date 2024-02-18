package learnertracker.test;


import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	
	public WebDriver driver;
	
//	public static	Properties prop = new Properties();
	
	
	@BeforeMethod
	public void setup() {
	
 driver = new EdgeDriver();
//		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
//		prop.load(ip);
//		if (prop.getProperty("browser").equalsIgnoreCase("chrome"))
//			driver = new ChromeDriver();
//		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
//			driver=new FirefoxDriver();
//		else if(prop.getProperty("browser").equalsIgnoreCase("edge"))
//			driver=new EdgeDriver();

        driver.get("https://learnertracker.netlify.app/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	}
	@AfterClass
	
	public void aftrmth() {
		
		driver.quit();
	}
	
	
}
