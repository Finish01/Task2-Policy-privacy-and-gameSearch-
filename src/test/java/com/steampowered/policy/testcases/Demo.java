package com.steampowered.policy.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.json.simple.JSONArray;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.steampowered.base.Singleton;
import com.steampowered.jsonreader.DataStore;
import com.steampowered.jsonreader.JSONReader;
import com.steampowered.privacy.pageobjects.AccessToPolicy;
import com.steampowered.privacy.pageobjects.GetYear;
import com.steampowered.privacy.pageobjects.GetLanguages;
import com.steampowered.privacy.pageobjects.childWindow;

public class Demo {
	
	@BeforeClass
	public static void launchBrowser() throws InterruptedException {
		Singleton.Driver();
	}
	
	@Test(priority=0)
	public void verifyAccessToMainPage() throws InterruptedException {
		String expectedTitle = "Добро пожаловать в Steam";
		String actualTitle = Singleton.driver.getTitle();
		Assert.assertEquals("Main page is not displayed",expectedTitle, actualTitle);
	}
	
	@Test(priority=1)
	  public void verifyPolicyTitle() throws InterruptedException {
	    
	    AccessToPolicy policy = new AccessToPolicy(Singleton.driver);
	    policy.clickToPolicy();
	    
	    childWindow window = new childWindow();
	    String childWindow = window.childWindowMethod();
	    Singleton.driver = Singleton.driver.switchTo().window(childWindow);
	    
	    String expectedTitle = "Соглашение политики конфиденциальности";
	    String actualTitle = Singleton.driver.getTitle();

	    Assert.assertEquals("Privacy page is not displayed!", expectedTitle, actualTitle);
	  }

	 @Test(priority=3)
	  public void verifyLanguages() {
		
	    GetLanguages languages = new GetLanguages();
	    List<String> expectedList = languages.listOfLanguages(); 
	    
	    JSONReader reader = new JSONReader();
	    reader.getJSONData("./testData.json");
	    JSONArray actualList = (JSONArray) DataStore.getJsonObject("languages");
	    
	    Assert.assertEquals("List is not the same!", expectedList, actualList);
	  }
	 
	  @Test(priority=4)
	  public void verifyYear() {
	    GetYear year = new GetYear();
	    String actualYear = year.currentYear();
	    
	    String expectedYear = "2022";
	
	    Assert.assertEquals("They are not equal", expectedYear, actualYear);
	  }
	  
	
	@AfterClass
	public static void closeBrowser(){
		Singleton.quit();
	}

}

