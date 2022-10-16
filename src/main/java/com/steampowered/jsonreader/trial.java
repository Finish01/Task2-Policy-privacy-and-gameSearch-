package com.steampowered.jsonreader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.steampowered.base.Singleton;
import com.steampowered.privacy.pageobjects.GetLanguages;

public class trial {
	
	public List<String> listOfLanguages(){
		
		List<WebElement> languagesWebElement = Singleton.driver.findElements(By.xpath("//div[@id='languages']//a"));
		
		List<String> languagesToString = new ArrayList<String>();
		
		for(WebElement singleLanguage : languagesWebElement) {
			String language = singleLanguage.getAttribute("href"); 
			
			String[] spl=language.split("/");
			
			languagesToString.add(spl[4].substring(0,1).toUpperCase() + spl[4].substring(1).toLowerCase());
		}
		return languagesToString;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub
		Singleton.Driver();
		WebDriver driver = Singleton.driver;
		
		trial env = new trial();
		System.out.println(env.listOfLanguages());
		

		
		
		driver.quit();
	}

}
