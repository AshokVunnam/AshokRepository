package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	By username=By.name("email");
	By password=By.xpath("//input[@id='user_password']");
	By login=By.xpath("//input[@type='submit']");
	By forgotPasswd=By.cssSelector("[href*='index.php']");
	
	public LoginPage (WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement username() {
		return driver.findElement(username);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement login() {
		return driver.findElement(login);
	}
	
	public ForgotPassword forgotPassword() {
		ForgotPassword fp=new ForgotPassword(driver);
		driver.findElement(forgotPasswd).click();
		return fp;
		
	}

}
