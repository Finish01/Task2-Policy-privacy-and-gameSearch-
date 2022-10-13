package writingToJSON;


import org.openqa.selenium.By;

import steamSearchGame.Singleton;

public class AccessingToData {
	
	public String name; 
	public int platforms; 
	public String releaseDate; 
	public String summary; 
	public String price;
	
	public void DataOfFirst() {
		
		name = Singleton.driver.findElement(By.xpath("//div[@id='search_resultsRows']//a[1]//div[@class='responsive_search_name_combined']//div[1]//span[1]")).getText();
		
		platforms = Singleton.driver.findElements(By.xpath("//div[@id='search_resultsRows']//a[1]//div[@class='responsive_search_name_combined']//div[1]//div[1]//span")).size();
		
		releaseDate = Singleton.driver.findElement(By.xpath("//div[@id='search_resultsRows']//a[1]//div[@class='responsive_search_name_combined']//div[2]")).getText();
		
		summary = Singleton.driver.findElement(By.xpath("//div[@id='search_resultsRows']//a[1]//div[@class='responsive_search_name_combined']//div[3]//span")).getAttribute("data-tooltip-html");
		
		price = Singleton.driver.findElement(By.xpath("//div[@id='search_resultsRows']//a[1]//div[@class='responsive_search_name_combined']//div[4]//div[2]")).getText();
		
	}

	public void DataOfSecond() {
		
		name = Singleton.driver.findElement(By.xpath("//div[@id='search_resultsRows']//a[2]//div[@class='responsive_search_name_combined']//div[1]//span[1]")).getText();

		platforms = Singleton.driver.findElements(By.xpath("//div[@id='search_resultsRows']//a[2]//div[@class='responsive_search_name_combined']//div[1]//div[1]//span")).size();
		
		releaseDate = Singleton.driver.findElement(By.xpath("//div[@id='search_resultsRows']//a[2]//div[@class='responsive_search_name_combined']//div[2]")).getText();
		
		summary = Singleton.driver.findElement(By.xpath("//div[@id='search_resultsRows']//a[2]//div[@class='responsive_search_name_combined']//div[3]//span")).getAttribute("data-tooltip-html");
		
		price = Singleton.driver.findElement(By.xpath("//div[@id='search_resultsRows']//a[2]//div[@class='responsive_search_name_combined']//div[4]//div[2]")).getText();

		
	}
}
