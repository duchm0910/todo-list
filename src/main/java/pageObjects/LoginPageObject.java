package pageObjects;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver){
		this.driver = driver;
	}

	public SocialNetworkPageObject clickToLoginWithGithub(WebDriver driver, String signupWith){
		waitForElementVisible(driver, LoginPageUI.SOCIAL_LOGIN,signupWith);
		clickToElement(driver, LoginPageUI.SOCIAL_LOGIN,signupWith);
		return PageGeneratorManager.getSocialNetworkPage(driver);
	}
}
