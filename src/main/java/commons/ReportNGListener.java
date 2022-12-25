package commons;

import commons.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportNGListener implements ITestListener {
	String projectLocation = System.getProperty("user.dir") + "\\screenshotReportNG\\";
	WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("---------- " + result.getName() + " FAILED test ----------");
		System.setProperty("org.uncommons.reportng.escape-output", "false");

		Object testClass = result.getInstance();
		WebDriver webDriver = ((BaseTest) testClass).getWebDriver();

		String screenshotPath = captureScreenshot(webDriver, result.getName());
		Reporter.getCurrentTestResult();
		Reporter.log("<br><a target=\"_blank\" href=\"file:///" + screenshotPath + "\" "+ "height='100' width='150' >" + "<img src=\"file:///" + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
		Reporter.setCurrentTestResult(null);
	}
	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

	public String captureScreenshot (WebDriver driver, String screenshotName){
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenPath = projectLocation + screenshotName +"_"+formatter.format(calendar.getTime())+".png";
			FileUtils.copyFile(source, new File(screenPath));
			return screenPath;
		}catch (IOException e) {
			System.out.println("Exception while taking screenshot: "+ e.getMessage());
			return e.getMessage();
		}
	}
}