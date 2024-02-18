package learnertracker.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import sun.net.www.MessageHeader;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@id='username']") public WebElement username;
	@FindBy(xpath= "//input[@id='password']") public WebElement password ;
	@FindBy(xpath= "//button[text()='Login']") public WebElement Login_button;
	@FindBy(xpath = "//img[@alt='logo']") public WebElement logoIcon;
    @FindBy(xpath =	"//button[@class='mb-3 btn btn-success']") public WebElement add_user ; 
    @FindBy (xpath = "//input[@id='name']") public WebElement new_name ;
    @FindBy (xpath = "//input[@id='email']") public WebElement new_email ;
    @FindBy (xpath = "//input[@id='username']") public WebElement new_Username ;
    @FindBy (xpath = "//input[@id='password']") public WebElement new_Password ;
    @FindBy (xpath = "//button[text()='Submit']") public WebElement submit;
    @FindBy (xpath = "//select[@name='roleInputs']") public WebElement role;
    
    public String dashboard() {
		String msg2 = driver.findElement(By.xpath("//a[text()='LearnerTracker']")).getText();
		return msg2;
	}
    
    
    
	public boolean logo() {
		
boolean vis = logoIcon.isDisplayed();
return vis ;		
	}
	
public boolean loginbutton() {
	
	boolean log = Login_button.isEnabled();
	return log;
}
	
public   String login_msg() {

String msg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
return msg;
	

}
 public void role_train() {
	 
	 Select objSelect = new Select(role);
	 objSelect.selectByVisibleText("Training Head");
 }

public void role_po() {
	 
	 Select objSelect = new Select(role);
	 objSelect.selectByVisibleText("Placement Officer");
 }

public String alerthandle() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
	wait.until(ExpectedConditions.alertIsPresent());

	Alert alert = driver.switchTo().alert();
	String alertText = alert.getText();
	return alertText;
}

}
	

