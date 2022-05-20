package com.selenium.waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadTimeOut {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driverW = new EdgeDriver();
		driverW.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driverW.manage().window().maximize();
		driverW.navigate().to("https://www.youtube.com/watch?v=PZXw8GlV5-o");
		
		driverW.quit();

	}

}
