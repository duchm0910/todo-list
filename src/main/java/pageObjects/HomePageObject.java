package pageObjects;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.HomePageUI;

import java.util.List;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver){
		this.driver = driver;
	}

	public void createANewList(){

		for (int i = 0; i < 10; i++) {
			waitForElementVisible(driver, HomePageUI.LIST_NAME_TEXTBOX);
			sendKeyToElement(driver, HomePageUI.LIST_NAME_TEXTBOX, randomString());
			waitForElementClickable(driver, HomePageUI.ADD_LIST_BTN);
			clickToElement(driver, HomePageUI.ADD_LIST_BTN);
		}
	}

	public LoginPageObject clickToLogout(){
		sleepInSecond(3);
		waitForElementClickable(driver,HomePageUI.SIGN_OUT_BTN);
		clickToElement(driver,HomePageUI.SIGN_OUT_BTN);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public void getAlllist(){
		List<WebElement> allListElement = getElements(driver,HomePageUI.LIST_GRP);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		if(allListElement.size()!= 0){
			System.out.println(allListElement.size());
			for(WebElement inputElement: allListElement)    {
				System.out.println(inputElement.getText());
			}
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
	}

	public void deleteAlllist(){
		List<WebElement> allListElement = getElements(driver,HomePageUI.LIST_GRP);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		if(allListElement.size()!= 0){
			System.out.println(allListElement.size());
			for(int i=allListElement.size();i<=allListElement.size();){
				String index = Integer.toString(i+1);
				waitForElementClickable(driver,HomePageUI.DEL_BTN,index);
				clickToElement(driver,HomePageUI.DEL_BTN,index);

			}
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
	}

	public void deleteSpecificList(){

		for (int i = 11; i >6 ; i--) {
			String index = Integer.toString(i-1);
			waitForElementClickable(driver,HomePageUI.DEL_BTN,index);
			clickToElement(driver,HomePageUI.DEL_BTN,index);

		}
	}
}
