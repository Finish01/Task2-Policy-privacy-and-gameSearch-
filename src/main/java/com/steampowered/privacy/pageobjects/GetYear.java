package com.steampowered.privacy.pageobjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.steampowered.base.Singleton;

public class GetYear {
	
	String year;
	
	public String currentYear() {
		
		System.out.println(Singleton.driver.getTitle());
		List<WebElement> getYearWebElement = Singleton.driver.findElements(By.xpath("//div[@id='newsColumn']//i[contains(text(), 'Дата изменения')]"));
		
		
		for(WebElement getYear : getYearWebElement){
			String getText = getYear.getText();
			String[] spl = getText.split(" ");
			year = spl[5];
		}
		return year;	
	}
	
}
