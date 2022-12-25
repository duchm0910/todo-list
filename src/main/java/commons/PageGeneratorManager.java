package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.SocialNetworkPageObject;

public class PageGeneratorManager {
	private  static LoginPageObject loginPage;
	private  static HomePageObject homePage;
	private  static SocialNetworkPageObject socialNetworkPage;

	private PageGeneratorManager(){

	}
	public static LoginPageObject getLoginPage(WebDriver driver){
		if(loginPage == null){
			loginPage = new LoginPageObject(driver);
		}
		return loginPage;
	}

	public static HomePageObject getHomePage(WebDriver driver){
		if(homePage == null){
			homePage = new HomePageObject(driver);
		}
		return homePage;
	}

	public static SocialNetworkPageObject getSocialNetworkPage(WebDriver driver){
		if(socialNetworkPage == null){
			socialNetworkPage = new SocialNetworkPageObject(driver);
		}
		return socialNetworkPage;
	}

}
