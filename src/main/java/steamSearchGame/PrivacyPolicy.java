package steamSearchGame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivacyPolicy {
	
	WebDriver driver; 
	
	private By policyPage = By.xpath("//div[@id='footer_text']//div[2]//a[1]");
	
	private By clickLanguages = By.xpath("//span[@id='language_pulldown']");
	
	public PrivacyPolicy(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToPolicy() {
		driver.findElement(policyPage).click();
	}
	
	public void clickLanguages() {
		driver.findElement(clickLanguages).click();
	}	
}