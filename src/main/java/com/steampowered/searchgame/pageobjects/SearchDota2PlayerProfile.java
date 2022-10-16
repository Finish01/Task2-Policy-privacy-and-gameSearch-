package com.steampowered.searchgame.pageobjects;

import org.openqa.selenium.By;

import com.steampowered.base.Singleton;

public class SearchDota2PlayerProfile {
	
		By SearchBoxPath = By.xpath("//input[@id='store_nav_search_term']");
		By SearchButtonPath = By.xpath("//a[@id='store_search_link']//img");
		
		
		
		
		public void SearchSecondGame(String title) throws InterruptedException {
			
			Singleton.driver.findElement(SearchBoxPath).sendKeys(title);
			
			Singleton.driver.findElement(SearchButtonPath).click(); 
			Thread.sleep(1000);
			
		}
		
}


