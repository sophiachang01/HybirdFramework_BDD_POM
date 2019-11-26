package reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;
	public static String screenShotFolderPath;
	// c://report+folderName+screenshots

	public static ExtentReports getInstance(String reportPath) {
		if (extent == null) {
			// generate report Folder
			String fileName = "Report.html";
			Date d = new Date();
			String folderName = d.toString().replace(":", "_");

			// directory of the report folder
			new File(reportPath + folderName + "//screenShots").mkdirs();
			reportPath = reportPath + folderName + "//";
			screenShotFolderPath = reportPath + "screenshots//";
			System.out.println(screenShotFolderPath);
			createInstance(reportPath + fileName);

		}
		return extent;
	}

	public static ExtentReports createInstance(String fileName) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Reports");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Reports - Automation Testing");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		return extent;

	}

}
