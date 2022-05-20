package com.selenium.waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driverWI = new ChromeDriver();
		driverWI.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driverWI.manage().window().maximize();
		driverWI.get("https://www.youtube.com/channel/UC59K-uG2A5ogwIrHw4bmlEg");
		driverWI.findElement(By.id("thumbnail")).click(); //This is search for 5 sec, if element find within 5sec then ok
		                                                  //or else it gives an execption
		
		
		driverWI.quit();

	}

}
