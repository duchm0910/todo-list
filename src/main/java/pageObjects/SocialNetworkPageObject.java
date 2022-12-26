package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.SocialNetworkPageUI;

import java.util.Iterator;
import java.util.Set;

public class SocialNetworkPageObject extends BasePage {
	WebDriver driver;

	public SocialNetworkPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void loginGithubWithAuthorize(WebDriver driver, String email, String pwd) {
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindowIDs = driver.getWindowHandles();
		Iterator<String> iterator = allWindowIDs.iterator();
		while (iterator.hasNext()) {
			String childWindow = iterator.next();
			if (!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				sendKeytoLoginfield(driver, email, pwd);
				clickOnAuthorize();

			}
		}
		driver.switchTo().window(mainWindow);
	}

	public void loginGithubWithOutAuthorize(WebDriver driver, String email, String pwd) {
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindowIDs = driver.getWindowHandles();
		Iterator<String> iterator = allWindowIDs.iterator();

		while (iterator.hasNext()) {
			String childWindow = iterator.next();
			if (!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				sendKeytoLoginfield(driver, email, pwd);
			}
		}
		driver.switchTo().window(mainWindow);
	}

	public void sendKeytoLoginfield(WebDriver driver, String email, String pwd) {
		waitForElementVisible(driver, SocialNetworkPageUI.GITHUB_EMAIL, email);
		sendKeyToElement(driver, SocialNetworkPageUI.GITHUB_EMAIL, email);

		waitForElementVisible(driver, SocialNetworkPageUI.GITHUB_PASSWORD, pwd);
		sendKeyToElement(driver, SocialNetworkPageUI.GITHUB_PASSWORD, pwd);

		waitForElementClickable(driver, SocialNetworkPageUI.GITHUB_LOGIN_BTN);
		clickToElement(driver, SocialNetworkPageUI.GITHUB_LOGIN_BTN);
		sleepInSecond(2);

	}

	public void clickOnAuthorize() {
		waitForElementClickable(driver, SocialNetworkPageUI.GITHUB_AUTHORIZE_BTN);
		clickToElement(driver, SocialNetworkPageUI.GITHUB_AUTHORIZE_BTN);
	}

}
