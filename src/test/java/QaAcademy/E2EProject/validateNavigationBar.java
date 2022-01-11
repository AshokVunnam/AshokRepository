package QaAcademy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resource.base;

public class validateNavigationBar extends base{
	
	public WebDriver driver;
	
	private static Logger log=LogManager.getLogger(validateNavigationBar.class.getClass());
	
	@BeforeTest
	public void initialize() throws IOException {
	driver=initializeDriver();
	//driver.get("https://qaclickacademy.com/");
	driver.get(prop.getProperty("url"));
	log.info("Navigated to Url Successfully");
	System.out.println("Navigated Successfully");
	System.out.println("Navigated Successfully2");
	System.out.println("Navigated Successfully3");
	System.out.println("Navigated Successfully4");
	System.out.println("Navigated Successfully5");
	System.out.println("Navigated Successfully6");
	
	}
	
	@Test
	public void navigationBar() throws IOException {
		LandingPage lp=new LandingPage(driver);
		Assert.assertTrue(lp.contact().isDisplayed());
		log.info("Element is displayed successfully");
		
	}
	
	@Test
	public void navigationBar2() throws IOException {
		LandingPage lp=new LandingPage(driver);
		Assert.assertTrue(lp.contact().isDisplayed());
		log.info("Element is displayed successfully");
		
	}
	
	@Test
	public void navigationBar3() throws IOException {
		LandingPage lp=new LandingPage(driver);
		Assert.assertTrue(lp.contact().isDisplayed());
		log.info("Element is displayed successfully");
		
	}
	
	@Test
	public void navigationBar4() throws IOException {
		LandingPage lp=new LandingPage(driver);
		Assert.assertTrue(lp.contact().isDisplayed());
		log.info("Element is displayed successfully");
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
