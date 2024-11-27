package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;

import config.ConfigReader;
import utils.DriverManager;
import utils.ExtentReportManager;

public class BaseTest {
	protected WebDriver driver;
	protected ExtentReports extent;

	@BeforeSuite
	public void setupReport() {
		extent = ExtentReportManager.createInstance("AutomationTestReport.html");
	}

	@BeforeClass
	public void setUp() {
		extent.createTest("Navigate to the FitPeo Homepage");
		String baseUrl = ConfigReader.getProperty("baseUrl");
		String browser = ConfigReader.getProperty("browser");
		driver = DriverManager.initializeDriver(browser);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@AfterSuite
	public void tearDownReport() {
		extent.flush();
	}
}
