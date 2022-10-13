package steamSearchGame;

import java.util.Iterator;
import java.util.Set;

import validatingSearchPage.SearchBoxPage;

public class childWindow {
	
	public String childWindowMethod() {
		
		Set<String> windows = Singleton.driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		
		String childWindow = null;
		
		while(window.hasNext())
		{

			String child_window= window.next();

			if(!Singleton.driver.getWindowHandle().equals(child_window))
			{
				childWindow = child_window;
			}
		}
		return childWindow;
	}
}
