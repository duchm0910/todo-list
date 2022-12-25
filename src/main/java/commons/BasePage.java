package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BasePage {
	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		String highlightStyle = "border: 2px solid red; border-style: dashed;";
		jsExecutor.executeScript("arguments[0].setAttribute(argument[1], argument[2]", element, "style", highlightStyle);
		try {
			sleepInSecond(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsExecutor.executeScript("arguments[0].setAttribute(argument[1], argument[2]", element, "style", originalStyle);
	}
	public String getDynamicLocator(String locator, String...params){
		return String.format(locator,(Object[])params );
	}

	public By getByXpath(String locator){
		return By.xpath(locator);
	}
	public WebElement getElement(WebDriver driver, String locator){
		return driver.findElement(getByXpath(locator));
	}

	public void clickToElement(WebDriver driver, String locator){
		getElement(driver,locator).click();
	}

	public void clickToElement(WebDriver driver, String locator,String...params){
		locator = getDynamicLocator(locator,params);
		getElement(driver,locator).click();
	}

	public void sendKeyToElement(WebDriver driver, String locator,String values){
		getElement(driver,locator).clear();
		getElement(driver,locator).sendKeys(values);
	}
	public void sendKeyToElement(WebDriver driver, String locator,String values,String...params){
		locator = getDynamicLocator(locator,params);
		getElement(driver,locator).clear();
		getElement(driver,locator).sendKeys(values);
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, params))));
	}

	public void switchToChildWindow(WebDriver driver) {
		String parentID = driver.getWindowHandle();
		Set<String> allWindowIDs = driver.getWindowHandles();
		Iterator<String> iterator = allWindowIDs.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!parentID.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
			}
		}
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	protected String randomString() {

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// create random string builder
		StringBuilder sb = new StringBuilder();

		Random random = new Random();

		int length = 7;

		for (int i = 0; i < length; i++) {

			int index = random.nextInt(alphabet.length());


			char randomChar = alphabet.charAt(index);

			sb.append(randomChar);
		}

		String randomString = sb.toString();
		return randomString;
	}
	private JavascriptExecutor jsExecutor;
	private WebDriverWait explicitWait;
	private long shortTimeout = GlobalContants.SHORT_TIMEOUT;
	private long longTimeout = GlobalContants.LONG_TIMEOUT;
}
