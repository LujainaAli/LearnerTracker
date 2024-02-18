package learnertracker.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import learnertracker.pages.HomePage;

public class TrainerPage {

	
WebDriver driver;
	
	
	
	@FindBy (xpath = "//button[@type='button' and @class='mb-3 btn btn-success']") public WebElement addlearner ;
	@FindBy (xpath = "//input[@id='learnerid']") public WebElement learnerID;
	@FindBy (xpath = "//input[@id='name']") public WebElement learnerName;
	@FindBy (xpath = "//select[@name='course']") public WebElement course;
	@FindBy (xpath = "//select[@name='project']") public WebElement project;
	@FindBy (xpath = "//select[@name='batch']") public WebElement batch ;
	@FindBy (xpath = "//select[@name='cstatus']") public WebElement course_status;
	@FindBy (xpath = "//button[text()='Submit']")public WebElement submit;
	@FindBy (xpath= "//ion-icon[@name='cloud-upload']") public WebElement bulk_add;
	@FindBy(xpath ="//input[@type='file' and @accept='.csv']") public WebElement choose_file;
	@FindBy      (xpath="//button[@type='submit']")public WebElement submit_file;
	
	public TrainerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String messgBox() {
	String msg = driver.findElement(By.xpath("//h2[text()='Data added successfully..!']")).getText();
	return msg ;
}
	public String successMsg() {
		
		String msg1 = driver.findElement(By.xpath("//div[@class='swal2-html-container']")).getText();
		return msg1 ;
	}
	
	
	
	
	
	
	
	
	
}
