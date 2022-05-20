package com.selenium.javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutor {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/");
		driver.manage().window().maximize();
		
		//Flashing
		WebElement elementflash = driver.findElement(By.id("user_email"));
		JavaScriptActions.flashingAnElement(elementflash, driver);
		
		//Drawing a border
		WebElement elementdraw = driver.findElement(By.xpath("//input[@type=\"text\"]"));
		JavaScriptActions.drawBorder(elementdraw, driver);
		
		//Capture Tiltle of page
		JavaScriptActions.captureTitle(driver);
		
		//Clicking an element
		WebElement elementclick = driver.findElement(By.partialLinkText("Sign in"));
		JavaScriptActions.clicking(elementclick, driver);
		
		//Generate alert info
		WebElement elementalert = driver.findElement(By.partialLinkText("Sign in"));
		elementalert.click();
		String message = "You clicked sign in button...created by teja";
		JavaScriptActions.genAlert(message,driver);
		
		//Refreshing page
		JavaScriptActions.refreshPage(driver);
		
		//Scrolling page
		WebElement elementscrol = driver.findElement(By.xpath("//*[@id=\"home-automate\"]/div/div[1]/div[4]/div[1]/h3/span"));
		JavaScriptActions.scrolling(elementscrol, driver);

	}

}
