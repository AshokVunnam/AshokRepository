package QaAcademy.E2EProject;

import static org.testng.Assert.assertEquals;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resource.base;

public class HomePage extends base{
	
	public WebDriver driver;
	
	private static Logger log=LogManager.getLogger(HomePage.class.getClass());
	@BeforeTest
	public void initialize() throws IOException {
	driver=initializeDriver();
	//driver.get("https://qaclickacademy.com/");
	log.info("Broweser is opened successfully");
	}
	
	
	@Test(dataProvider = "getData")
	public void basePagaNavigation(String userName,String password, String text) throws IOException {
		
		driver.get(prop.getProperty("url"));
		LandingPage lp=new LandingPage(driver);
		driver.manage().window().maximize();
		log.info("Broswer window Maximised");
		LoginPage lop=lp.login();
		//LoginPage lop=new LoginPage(driver);
		log.info("Enterd LoginPage");
		lop.username().sendKeys(userName);
		lop.password().sendKeys(password);
		log.info(text);
		lop.login().click();
		ForgotPassword fp=lop.forgotPassword();
		fp.email().sendKeys("dffhdfh");;
		fp.sendMe().click();
		System.out.println(fp.validationMsg());
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data=new Object[2][3];
		data[0][0]="restricted@ncr.com";
		data[0][1]="1234589";
		data[0][2]="restricted User";
		
		data[1][0]="Non-restricted@ncr.com";
		data[1][1]="34374";
		data[1][2]="Nonrestricted User";
		
		return data;
	}
	
	@AfterTest
	public void closed() {
		driver.close();
	}
	

}
