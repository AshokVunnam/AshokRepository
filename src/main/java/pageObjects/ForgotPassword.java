package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
	WebDriver driver;
	public ForgotPassword(WebDriver driver) {
		this.driver=driver;
		
	}
	
	
	By email=By.xpath("//input[@id='user_email']");
	By sendMe=By.cssSelector("input[name='commit']");
	
	public WebElement email() {
		return driver.findElement(email);
	}
	
	public WebElement sendMe() {
		return driver.findElement(sendMe);
	}
	
	public String validationMsg() {
		String msg=driver.findElement(email).getAttribute("validationMessage");
		System.out.println(msg);
		return msg;
		
	}

}
