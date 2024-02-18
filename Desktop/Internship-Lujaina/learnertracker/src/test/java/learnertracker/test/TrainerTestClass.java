package learnertracker.test;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationconstants.page.AutoConst;
import learnertracker.pages.HomePage;
import learnertracker.pages.TrainerPage;

public class TrainerTestClass extends TestBase {

	HomePage hp = new HomePage(driver);
	TrainerPage tp;
	

	@Test // verifying trainer username and password//

	public void testcase1() {
		hp.username.sendKeys(AutoConst.trainer_usname);
		hp.password.sendKeys(AutoConst.trainer_passwd);
		hp.Login_button.click();
		String url2 = driver.getCurrentUrl();
		Assert.assertEquals(url2, AutoConst.url_trainerpage);
	}

	@Test // verifying trainer credential with valid username and invalid password//

	public void testcase2() {
		hp.username.sendKeys(AutoConst.trainer_usname);
		hp.password.sendKeys(AutoConst.inval_pass);
		hp.Login_button.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String msg1 = hp.login_msg();
		Assert.assertEquals(msg1, AutoConst.login_failed);
	}

	@Test // invalid trainer username and valid passwrd//

	public void testcase4() {

		hp.username.sendKeys(AutoConst.inval_user);
		hp.password.sendKeys(AutoConst.trainer_passwd);
		hp.Login_button.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String msg1 = hp.login_msg();
		Assert.assertEquals(msg1, AutoConst.user_nt);

	}

	@Test                    // add "FSD" candidate to dashboard//
	public void testcase5() {
		hp.username.sendKeys(AutoConst.trainer_usname);
		hp.password.sendKeys(AutoConst.trainer_passwd);
		hp.Login_button.click();
		tp = new TrainerPage(driver);
		tp.addlearner.click();
		tp.learnerID.sendKeys(AutoConst.learner_id);
		tp.learnerName.sendKeys(AutoConst.name_learner);
		tp.course.sendKeys(AutoConst.course_ST);
		tp.project.sendKeys(AutoConst.project_ICTAK);
		tp.batch.sendKeys(AutoConst.batch);
		tp.course_status.sendKeys(AutoConst.course_status);
		tp.submit.click();
		String msg = tp.successMsg();
		Assert.assertEquals(msg, AutoConst.success_updated);
	}

	@Test                   // upload learners to dashboard//

	public void testcase6() throws IOException {
		hp.username.sendKeys(AutoConst.trainer_usname);
		hp.password.sendKeys(AutoConst.trainer_passwd);
		hp.Login_button.click();
		tp = new TrainerPage(driver);
		tp.bulk_add.click();
		tp.choose_file.sendKeys("C:\\Users\\user\\Downloads\\Learner.csv");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		tp.submit_file.click();
		String msg = tp.messgBox();
		Assert.assertEquals(msg, "Data added successfully..!");

	}

	@Test                 // update course status//

	public void testcase7() {

		hp.username.sendKeys(AutoConst.trainer_usname);
		hp.password.sendKeys(AutoConst.trainer_passwd);
		hp.Login_button.click();
		tp = new TrainerPage(driver);
		tp.addlearner.click();
		tp.learnerID.sendKeys(AutoConst.learner_id);
		tp.learnerName.sendKeys(AutoConst.name_learner);
		tp.course.sendKeys(AutoConst.course_ST);
		tp.project.sendKeys(AutoConst.project_ICTAK);
		tp.batch.sendKeys(AutoConst.batch);
		tp.course_status.sendKeys(AutoConst.course_status);
		tp.submit.click();
		String msg = tp.successMsg();
		Assert.assertEquals(msg, AutoConst.success_updated);
	}

	@Test
	
	public void testcase8() {
		hp.username.sendKeys(AutoConst.trainer_usname);
		hp.password.sendKeys(AutoConst.trainer_passwd);
		hp.Login_button.click();
		tp = new TrainerPage(driver);
		tp.addlearner.click();
		tp.learnerID.sendKeys(AutoConst.learner_id);
		tp.learnerName.sendKeys(AutoConst.name_learner);
		tp.course.sendKeys(AutoConst.course_ST);
		tp.project.sendKeys("KDISC");
		tp.batch.sendKeys(AutoConst.batch);
		tp.course_status.sendKeys(AutoConst.course_status);
		tp.submit.click();
		String msg = tp.successMsg();
		Assert.assertEquals(msg, AutoConst.success_updated);
		
		
	}
}
