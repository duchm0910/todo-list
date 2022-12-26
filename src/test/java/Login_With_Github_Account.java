import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.SocialNetworkPageObject;
import integrate.TestLinkIntegration;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class Login_With_Github_Account extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	SocialNetworkPageObject socialNetworkPage;
	HomePageObject homePage;
	String loginWith = "github";
	String email = "duc.hoang@inapps.net"; // Provide github email here
	String pwd = "Hoangminhduc1993";// Provide github password here

	String result = null;


	//	String listName = randomString();
	@Parameters({"browser", "url"})
	@BeforeClass
	public void initBrowser(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
	}

//		@Test
	public void TC_01_Login_With_Github_Account_With_Authorize() {
		log.info("Click login with Github button");
		loginPage = new LoginPageObject(driver);
		socialNetworkPage = loginPage.clickToLoginWithGithub(driver, loginWith);

		log.info("Input Email and Pwd GitHub With Authorize accept");
		socialNetworkPage.loginGithubWithAuthorize(driver, email, pwd);
		homePage = new HomePageObject(driver);

		log.info("Create A list 10 times");
		homePage.createANewList();
		homePage.getAlllist();

		log.info("Logout");
		loginPage = homePage.clickToLogout();

		log.info("Login With Github again");
		socialNetworkPage = loginPage.clickToLoginWithGithub(driver, loginWith);
		homePage = new HomePageObject(driver);

		log.info("Delete item 5 to 10");
		homePage.deleteSpecificList();
	}

	@Test
	public void TC_02_Login_With_Github_Account_WithOut_Authorize()throws TestLinkAPIException {
		log.info("Click login with Github button");
		loginPage = new LoginPageObject(driver);
		socialNetworkPage = loginPage.clickToLoginWithGithub(driver, loginWith);

		log.info("Input Email and Pwd GitHub");
		socialNetworkPage.loginGithubWithOutAuthorize(driver, email, pwd);
		homePage = new HomePageObject(driver);

		log.info("Create A list 10 times");
		homePage.createANewList();

		log.info("Logout");
		loginPage = homePage.clickToLogout();

		log.info("Login With Github again");
		socialNetworkPage = loginPage.clickToLoginWithGithub(driver, loginWith);
		homePage = new HomePageObject(driver);

		log.info("Delete item 5 to 10");
		homePage.deleteSpecificList();

/*		log.info("Delete item All");
		homePage.deleteAlllist();*/
		result = TestLinkAPIResults.TEST_PASSED;
		System.out.println("Updating TestCase Execution Status in TestLink");
		TestLinkIntegration.updateResult(null,TestLinkAPIResults.TEST_PASSED);
	}

	@AfterClass
	public void close()  {
//		driver.quit();
	}
}
