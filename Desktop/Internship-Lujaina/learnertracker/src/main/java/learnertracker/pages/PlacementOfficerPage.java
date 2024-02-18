package learnertracker.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PlacementOfficerPage {

WebDriver driver;
	
	public PlacementOfficerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy (xpath = "//button[text()='Submit']") public WebElement submit;
	
	public String dashboard() {
		String msg2 = driver.findElement(By.xpath("//a[text()='LearnerTracker']")).getText();
		return msg2;
	}
	
	public void update_button() {
		WebElement update = driver.findElement(By.xpath("//button[@class='btn btn-success btn btn-primary']"));
		update.click();
		}
	
	public void place_status() {
		
		Select select = new Select(driver.findElement(By.xpath("//select[@name='pstatus']")));
		select.selectByVisibleText("Placed");

	}
	public String plc() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView","Placed");
		return "Placed";
 
	}
	
public String jobSeek() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView","Job Seeking");
		return "Job Seeking";
	
}
public String nt_interested() {
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView","Not Interested");
	return "Not Interested";

}







}

