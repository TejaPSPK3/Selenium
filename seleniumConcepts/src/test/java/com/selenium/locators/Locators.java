package com.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static void main(String[] args) throws Exception {
		
	//in Selenium to find the element in the browser, we use locators
		WebDriverManager.edgedriver().setup();
		WebDriver driverL = new EdgeDriver();
		driverL.navigate().to("https://github.com/login");
		highlight(driverL, driverL.findElement(By.id("login_field")));
		Thread.sleep(3000);
		highlight(driverL, driverL.findElement(By.name("password")));
		Thread.sleep(3000);
		highlight(driverL, driverL.findElement(By.className("header-logo")));
		Thread.sleep(3000);
		highlight(driverL, driverL.findElement(By.linkText("Forgot password?")));
		Thread.sleep(3000);
		highlight(driverL, driverL.findElement(By.partialLinkText("Create an ")));
		Thread.sleep(3000);
		highlight(driverL, driverL.findElement(By.tagName("h1")));
		Thread.sleep(3000);
		
		
	}
	public static void highlight(WebDriver driverLH, WebElement element)
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driverLH;
		js.executeScript("arguments[0].setAttribute('style','border:2px solid red;background:yellow')", element);
	}


}
