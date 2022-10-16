package com.steampowered.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Singleton {
	
	public static WebDriver driver;
	
	public static void Driver() throws InterruptedException {
		
		if(driver == null) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Finish\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(options);
			
			Thread.sleep(1000);
		}
		
		driver.manage().window().maximize();
		driver.get("https://store.steampowered.com/");
	}
	
	public static void quit() {
		driver.quit();
	}
}


