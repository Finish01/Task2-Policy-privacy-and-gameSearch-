package search.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import steamSearchGame.Singleton;
import validatingDota2PlayerProfile.SearchDota2PlayerProfile;
import validatingSearchPage.SearchBoxPage;

public class GameSearch {

	@BeforeClass
	public static void launchBrowser() throws InterruptedException {
		Singleton.Driver();
		SearchBoxPage page2 = new SearchBoxPage();
		page2.SearchDota2();
	}
	
	@Test
	public void verifyOpenPage() throws InterruptedException {
		
		String expectedTitle2 = "Поиск Steam";
		String actualTitle2 = Singleton.driver.getTitle();
		Assert.assertEquals("Main page is not displayed",expectedTitle2, actualTitle2);
		
	}
	
	@Test 
	public void verifySearchBox() throws InterruptedException {
		
		By PathToSearchBox = By.xpath("//div[@class='searchbar_left']//input[@id='term']");
		String actualBoxText = Singleton.driver.findElement(PathToSearchBox).getAttribute("value");
		String expectedBoxText = "Dota 2";
		
		Assert.assertEquals( "It doesn't match to 'Dota 2'" ,expectedBoxText, actualBoxText);
		
	}
	
	@Test 
	public void verifyFirstResult() throws InterruptedException {

		By PathToFirstResult = By.xpath("//div[@id='search_resultsRows']//a[1]//div[@class='responsive_search_name_combined']//div[1]//span[1]");
		String actualText = Singleton.driver.findElement(PathToFirstResult).getText();
		String expectedText = "Dota 2";
		
		Assert.assertEquals("First name doesn't match!", expectedText, actualText);
	}
	
	
	@Test 
	public void verifySecondResult() throws FileNotFoundException, IOException, ParseException, InterruptedException {
		
		SearchDota2PlayerProfile game = new SearchDota2PlayerProfile();
		String title = "Dota 2 Player Profiles";
		game.SearchSecondGame(title);
		
		By link = By.xpath("//input[@id='term']");
		String actualGame = Singleton.driver.findElement(link).getAttribute("value");
		String expectedGame = "Dota 2 Player Profiles";
		
		Assert.assertEquals("Games didn't match", expectedGame, actualGame);
		
	}
	
	
	@AfterClass
	public static void closeBrowser(){
		Singleton.quit();
	}
	
}
