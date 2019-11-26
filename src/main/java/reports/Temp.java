package reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Temp {

	
	public static String screenShotFolderPath;
	public static String reportPath ="C:\\report\\";
	public static void main(String[] args) {
		String fileName = "Report.html";
		Date d = new Date();
		String folderName=d.toString().replace(":","_");	
		//new File("C:\\report\\").mkdirs();
		ExtentReports rep = ExtentManager.getInstance("C:\\report\\");
		ExtentTest test = rep.createTest("TestA");
		test.log(Status.INFO,"Starting test A");
		test.log(Status.INFO,"Executing");
		test.log(Status.FAIL,"failed");
		/*//directory of the report folder
		new File(reportPath+folderName+"//screenShots").mkdirs();
		reportPath = reportPath+folderName+"//";
		screenShotFolderPath = reportPath+"screenshots//";
		System.out.println(screenShotFolderPath);*/
		
		rep.flush();
		
		
		
		
	}
}
