package com.steampowered.privacy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccessToPolicy {
	
	WebDriver driver; 
	
	private By policyPage = By.xpath("//div[@id='footer_text']//div[2]//a[1]");
	
	public AccessToPolicy(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToPolicy() {
		driver.findElement(policyPage).click();
	}
}