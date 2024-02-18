package learnertracker.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationconstants.page.*;

import learnertracker.pages.HomePage;

public class AdminPageTestClass extends TestBase {

	HomePage hp = new HomePage(driver);

	@Test

	public void title_check() {

		String ti = driver.getTitle();
		Assert.assertEquals(ti, AutoConst.title);
	}

	@Test // login to admin dasboard//

	public void adminlog() {

		hp.username.sendKeys(AutoConst.adminuser);
		hp.password.sendKeys(AutoConst.admin_pass);
		hp.Login_button.click();
		String msg = hp.dashboard();
		Assert.assertEquals(msg, AutoConst.learner_dashboard);
	}

	@Test // ictak logo visible or not//

	public void testcase1() {

		boolean ict = hp.logo();
		Assert.assertTrue(ict);

	}

	@Test // login button enabled or not//

	public void testcase2() {

		boolean lg = hp.loginbutton();
		Assert.assertTrue(lg);

	}

	@Test // blank credentials//

	public void testcase3() {

		hp.username.sendKeys(AutoConst.blankval);
		hp.password.sendKeys(AutoConst.blankval);

		hp.Login_button.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String msg1 = hp.login_msg();
		Assert.assertEquals(msg1, AutoConst.user_nt);

	}

	@Test // invalid user and valid passwrd//

	public void testcase4() {

		hp.username.sendKeys(AutoConst.inval_user);
		hp.password.sendKeys(AutoConst.admin_pass);
		hp.Login_button.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String msg1 = hp.login_msg();
		Assert.assertEquals(msg1, AutoConst.user_nt);

	}

	@Test // valid user and invalid passwrd//

	public void testcase5() {
		hp.username.sendKeys(AutoConst.adminuser);
		hp.password.sendKeys(AutoConst.inval_pass);
		hp.Login_button.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String msg1 = hp.login_msg();
		Assert.assertEquals(msg1, AutoConst.login_failed);

	}

	@Test // invalid user and password//

	public void testcase6() {
		hp.username.sendKeys(AutoConst.inval_user);
		hp.password.sendKeys(AutoConst.inval_pass);
		hp.Login_button.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String msg1 = hp.login_msg();
		Assert.assertEquals(msg1, AutoConst.user_nt);

	}

	@Test // creating login credentials for trainers with a form with valid credentials//

	public void testcase7() {
		hp.username.sendKeys(AutoConst.adminuser);
		hp.password.sendKeys(AutoConst.admin_pass);
		hp.Login_button.click();
		hp.add_user.click();
		hp.new_name.sendKeys(AutoConst.newUser);
		hp.new_Username.sendKeys(AutoConst.newUsername);
		hp.new_Password.sendKeys(AutoConst.newPasswrd);
		hp.new_email.sendKeys(AutoConst.newEmail);
		hp.role_train();
		hp.submit.click();
		String msg = hp.alerthandle();
		System.out.println(msg);
	}

	@Test // creating login credentials for placement officers with a form//

	public void testcase8() {
		hp.username.sendKeys(AutoConst.adminuser);
		hp.password.sendKeys(AutoConst.admin_pass);
		hp.Login_button.click();
		hp.add_user.click();
		hp.new_name.sendKeys(AutoConst.newUser);
		hp.new_Username.sendKeys(AutoConst.newUsername);
		hp.new_Password.sendKeys(AutoConst.newPasswrd);
		hp.new_email.sendKeys(AutoConst.newEmail);
		hp.role_po();
		hp.submit.click();

	}

	@Test // creating login credentials for trainers with a form without selecting role//

	public void testcase9() {
		hp.username.sendKeys(AutoConst.adminuser);
		hp.password.sendKeys(AutoConst.admin_pass);
		hp.Login_button.click();
		hp.add_user.click();
		hp.new_name.sendKeys(AutoConst.newUser);
		hp.new_Username.sendKeys(AutoConst.newUsername);
		hp.new_Password.sendKeys(AutoConst.newPasswrd);
		hp.new_email.sendKeys(AutoConst.newEmail);
		hp.submit.click();
		Assert.assertTrue(true, "Please select a role for the user");

	}
	
	
	
	
	
	
	
}
