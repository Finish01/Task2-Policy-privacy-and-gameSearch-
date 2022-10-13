package steamSearchGame;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GetLanguages {
	
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
}
