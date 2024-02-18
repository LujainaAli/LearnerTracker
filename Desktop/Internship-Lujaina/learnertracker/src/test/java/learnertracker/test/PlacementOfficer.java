package learnertracker.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationconstants.page.AutoConst;
import learnertracker.pages.HomePage;
import learnertracker.pages.PlacementOfficerPage;

public class PlacementOfficer extends TestBase {

	PlacementOfficerPage PO;
	HomePage hp = new HomePage(driver);

	@Test // login with valid credentials//

	public void testcase1() {

		hp.username.sendKeys(AutoConst.plac_username);
		hp.password.sendKeys(AutoConst.plac_pass);
		hp.Login_button.click();
		PO = new PlacementOfficerPage(driver);
		String msg = PO.dashboard();
		Assert.assertEquals(msg, AutoConst.learner_dashboard);

	}

	@Test // login with invalid credentials//

	public void testcase2() {

		hp.username.sendKeys(AutoConst.plac_username);
		hp.password.sendKeys(AutoConst.inval_pass);
		hp.Login_button.click();
		String msg1 = hp.login_msg();
		Assert.assertEquals(msg1, AutoConst.login_failed);
	}

	@Test // update status of learner as placed//

	public void testcase3() {

		
		hp.username.sendKeys(AutoConst.plac_username);
		hp.password.sendKeys(AutoConst.plac_pass);
		hp.Login_button.click();
		PO = new PlacementOfficerPage(driver);
		PO.update_button();
		PO.place_status();
		PO.submit.click();
		String pl = PO.plc();
		Assert.assertEquals(pl, "Placed");
	}

	@Test                       // update status of learner as Job Seeking//

	public void testcase4() {

		
		hp.username.sendKeys(AutoConst.plac_username);
		hp.password.sendKeys(AutoConst.plac_pass);
		hp.Login_button.click();
		PO = new PlacementOfficerPage(driver);
		PO.update_button();
		PO.place_status();
		PO.submit.click();
		String pl = PO.jobSeek();
		Assert.assertEquals(pl,AutoConst.job_seek);
	
	
	}
	
	@Test // update status of learner as Not Intereseted//
public void testcase5() {

		hp.username.sendKeys(AutoConst.plac_username);
		hp.password.sendKeys(AutoConst.plac_pass);
		hp.Login_button.click();
		PO = new PlacementOfficerPage(driver);
		PO.update_button();
		PO.place_status();
		PO.submit.click();
		String pl = PO.nt_interested();
		Assert.assertEquals(pl,AutoConst.not_interst);
		
	}
	
	
	
}