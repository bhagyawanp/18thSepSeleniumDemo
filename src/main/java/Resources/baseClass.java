package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

//This will help us to write the browser related code 
public class baseClass {

	 public static WebDriver driver;
	 public Properties pro;
	 
	 public static String EmailAddress = GenerateRandomEmailId();

	 public void InitializeDriver() throws IOException {

	  FileInputStream fis = new FileInputStream(
	  
	  System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");

	  pro = new Properties();

	  pro.load(fis);

	  String BrowserName = pro.getProperty("browser");

	  if (BrowserName.equalsIgnoreCase("chrome")) {

	   driver = new ChromeDriver();
	  }

	  else if (BrowserName.equalsIgnoreCase("firefox")) {

	   driver = new FirefoxDriver();
	  }

	  else if (BrowserName.equalsIgnoreCase("edge")) {

	   driver = new EdgeDriver();
	  }

	  else {
	   System.out.println("Please Choose the correct Browser");
	  }

	 }
	 public static String GenerateRandomEmailId() {
	  return "dotest"+System.currentTimeMillis()+"@gmail.com";
	 }
	 
	 @BeforeMethod
	 public void BrowserLaunchEveryTestCase() throws IOException {
	  InitializeDriver();
	  String url = pro.getProperty("url");
	  driver.get(url);

	 }
	 
	 @AfterMethod
	 public void BrowserCloseEveryTestCase() {
	  
	  //driver.quit();
	 }
	
	 
	 
	 @BeforeSuite
	 public void setupReport() {
	  
	       extentReportManager.setup();
	 }
	
	 
	 
	 @AfterSuite
	 public void endReporttest() {
		 extentReportManager.endReport();
	 }
	
	  
		// To take the screenshot and store in one folder-
		public static String screenShot(WebDriver driver, String filename) {
			String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			// 20241218083700

			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "\\Screenshots\\" + filename + "_" + date + ".png";
			try { // VerifyRresgiertaionWithValiData_20241218083700.png
				FileUtils.copyFile(source, new File(destination));
			} catch (Exception e) {
				e.getMessage();
			}
			return destination;
		}

}
