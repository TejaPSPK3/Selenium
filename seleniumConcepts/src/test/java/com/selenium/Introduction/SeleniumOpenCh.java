package com.selenium.Introduction;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumOpenCh {

	public static void main(String[] args) {
		//System.setProperty("Webdriver.chrome.deiver", "./drivers/chromedriber.exe");
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		driver.get("https://www.youtube.com/channel/UC59K-uG2A5ogwIrHw4bmlEg");
		
		//For close the Edge browser
		//driver.close();
	}

}