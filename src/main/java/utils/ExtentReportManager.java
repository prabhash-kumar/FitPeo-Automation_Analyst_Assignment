package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	private static ExtentReports extent;

	public static ExtentReports createInstance(String fileName) {
		ExtentSparkReporter ExtenthtmlReporter = new ExtentSparkReporter(fileName);

		ExtenthtmlReporter.config().setTheme(Theme.STANDARD);
		ExtenthtmlReporter.config().setDocumentTitle("FitPeo - Automation Analyst Assignment");
		ExtenthtmlReporter.config().setReportName("FitPeo : Automation Test Results");

		extent = new ExtentReports();
		extent.attachReporter(ExtenthtmlReporter);
		extent.setSystemInfo("Automaton Tester Engineer", "Prabhash Kumar");

		return extent;
	}

}
