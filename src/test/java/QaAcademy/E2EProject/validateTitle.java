package QaAcademy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import pageObjects.LandingPage;
import resource.ExtentReportNG;
import resource.base;

public class validateTitle extends base{
	
	
	public WebDriver driver;
	LandingPage lp;
	private static Logger log=LogManager.getLogger(validateTitle.class.getClass());
	
	@BeforeTest
	public void initialize() throws IOException {
	driver=initializeDriver();
	//driver.get("https://qaclickacademy.com/");
	driver.get(prop.getProperty("url"));
	log.info("Url is accessed successfully");
	}
	
	@Test
	public void titleValidator() throws IOException {
		
		LandingPage lp=new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(),"FEATURED COURSES");
		log.info("Title is validated successfully");
	
	}
	
	@Test
	public void headerValidator() {
		
		Assert.assertEquals(lp.getHeader().getText(), "An Academy to learn Everything about Testing");
		log.info("Header is validated successfully");
		
	}
	
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
