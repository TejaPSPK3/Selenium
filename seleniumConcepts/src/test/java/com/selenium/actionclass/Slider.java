package com.selenium.actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driverSA = new ChromeDriver();
		driverSA.get("https://jqueryui.com/slider/");
		driverSA.switchTo().frame(0);
		WebElement slid = driverSA.findElement(By.id("slider"));
		Actions action = new Actions(driverSA);
		action.moveToElement(slid).dragAndDropBy(slid, 99, 0).perform();
		Thread.sleep(2000);
		driverSA.quit();

	}

}
