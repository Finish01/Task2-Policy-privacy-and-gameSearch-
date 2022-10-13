package steamSearchGame;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GetYear {
	
	public String currentYear() {
		
		String year = null;
		
		List<WebElement> getYearWebElement = Singleton.driver.findElements(By.xpath("//div[@id='newsColumn']//i[contains(text(), 'Дата изменения')]"));
		
		
		for(WebElement getYear : getYearWebElement){
			String getText = getYear.getText();
			String[] spl = getText.split(" ");
			year = spl[5];
		}
		return year;	
	}
	
}
