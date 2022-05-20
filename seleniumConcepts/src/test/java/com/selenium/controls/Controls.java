package com.selenium.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Controls {

	//In this we control the links, buttons, radio buttons, check boxes.
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driverC = new ChromeDriver();
		driverC.get("https://trytestingthis.netlify.app/");
		driverC.manage().window().maximize();
		//text boxes
		driverC.findElement(By.id("fname")).sendKeys("Tejas");
		Thread.sleep(2000);
		driverC.findElement(By.id("lname")).sendKeys("Kambham");
		Thread.sleep(2000);
		//Radio buttons
		driverC.findElement(By.id("male")).click();
		Thread.sleep(2000);
		//Check boxes
		driverC.findElement(By.name("option1")).click();
		Thread.sleep(2000);
		//Relative locators
		WebElement elemC = driverC.findElement(By.tagName("h6"));
		driverC.findElement(RelativeLocator.with(By.tagName("button")).below(elemC)).click();
		Thread.sleep(3000);
		driverC.quit();

	}

}
