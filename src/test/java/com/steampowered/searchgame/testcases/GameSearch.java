package com.steampowered.searchgame.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.steampowered.base.Singleton;
import com.steampowered.jsonreader.DataStore;
import com.steampowered.jsonreader.JSONReader;
import com.steampowered.jsonreader.JSONWriter;
import com.steampowered.searchgame.pageobjects.SaveInfo;
import com.steampowered.searchgame.pageobjects.SearchBoxPage;
import com.steampowered.searchgame.pageobjects.SearchDota2PlayerProfile;

public class GameSearch {

	@BeforeClass
	public static void launchBrowser() throws InterruptedException {
		Singleton.Driver();
		SearchBoxPage search = new SearchBoxPage();
		search.SearchDota2();
	}
	
	@Test(priority=1)
	public void verifyAccessToSearchPage() throws InterruptedException {
		
		String expectedTitle2 = "Поиск Steam";
		String actualTitle2 = Singleton.driver.getTitle();
		Assert.assertEquals("Main page is not displayed",expectedTitle2, actualTitle2);
		
	}
	
	@Test (priority=2)
	public void verifySearchBox() throws InterruptedException {
		
		By PathToSearchBox = By.xpath("//div[@class='searchbar_left']//input[@id='term']");
		String actualBoxText = Singleton.driver.findElement(PathToSearchBox).getAttribute("value");
		String expectedBoxText = "Dota 2";
		
		Assert.assertEquals( "It doesn't match to 'Dota 2'" ,expectedBoxText, actualBoxText);
		
	}
	
	@Test (priority=3)
	public void verifyFirstResult() throws InterruptedException {

		By PathToFirstResult = By.xpath("//div[@id='search_resultsRows']//a[1]//div[@class='responsive_search_name_combined']//div[1]//span[1]");
		String actualText = Singleton.driver.findElement(PathToFirstResult).getText();
		String expectedText = "Dota 2";
		
		Assert.assertEquals("First name doesn't match!", expectedText, actualText);
	}

	@Test (priority=4)
	public void saveInfoFirst() throws IOException{
		SaveInfo.DataOfFirst();
		JSONWriter writer = new JSONWriter(SaveInfo.name, SaveInfo.platforms, SaveInfo.releaseDate, SaveInfo.summary, SaveInfo.price);
		writer.Write();
	}
	
	@Test (priority=5)
	public void saveInfoSecond(){
		SaveInfo.DataOfSecond();
		JSONWriter writer = new JSONWriter(SaveInfo.name, SaveInfo.platforms, SaveInfo.releaseDate, SaveInfo.summary, SaveInfo.price);
		writer.Write();
	}
	
	@Test (priority=6)
	public void verifySecondResult() throws FileNotFoundException, IOException, ParseException, InterruptedException {
		
		SearchDota2PlayerProfile game = new SearchDota2PlayerProfile();
		String expectedGame = "Dota 2 Player Profiles";
		game.SearchSecondGame(expectedGame);
		
		By link = By.xpath("//input[@id='term']");
		String actualGame = Singleton.driver.findElement(link).getAttribute("value");
		
		Assert.assertEquals("Games didn't match", expectedGame, actualGame);
		
	}
	
	@Test(priority=7)
	public void verifyDetails() {
		
		JSONReader reader = new JSONReader();
		reader.getJSONData("./games.json");
		JSONArray obj = (JSONArray) DataStore.getJsonObject();
		
		System.out.println(obj);
		

		

	}
	
	
	@AfterClass
	public static void closeBrowser(){
		Singleton.quit();
	}
	
}
