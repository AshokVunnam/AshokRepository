package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	private static Logger log=LogManager.getLogger(base.class.getName());
	
	public WebDriver initializeDriver() throws IOException {
		prop=new Properties();
		//FileInputStream fis=new FileInputStream("C:\\Users\\Labuser\\eclipse-workspace\\E2EProject\\src\\main\\java\\resource\\Data.properties");
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\Data.properties");
		prop.load(fis);
		
		
		String browser=System.getProperty("browser");
		//String browser=prop.getProperty("Browser");
		if(browser.contains("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Labuser\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resource\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browser.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
		}else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resource\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resourcemsedgedriver.exe");
			driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Implicit wait for 10 seconds");
		
		return driver;
	}
	
	public String getScreenShotFilePath(String TestcaseName, WebDriver driver) throws IOException {
		TakesScreenshot TS=(TakesScreenshot)driver;
		File source=TS.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+TestcaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
		
	}

}
