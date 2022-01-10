package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By signIn=By.xpath("//a[contains(@href,'sign_in')]");
	private By title=By.xpath("//section[@id='content']/div/div[1]");
	private By contact=By.xpath("//a[text()='Contact']");
	private By header=By.cssSelector("div[class*='video-banner'] h3");
	
	
	//By contact=By.linkText("Contact");
	//By title=By.linkText("Featured Courses");
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public LoginPage login() {
		driver.findElement(signIn).click();
		LoginPage lop=new LoginPage(driver);
		return lop;
		
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement contact() {
		return driver.findElement(contact);
	}
	
	public WebElement getHeader() {
		return driver.findElement(header);
	}

}
