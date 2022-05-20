package com.selenium.actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driverDD = new ChromeDriver();
		driverDD.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		WebElement sourc = driverDD.findElement(By.id("box6"));
		WebElement target = driverDD.findElement(By.id("box106"));
		
		Actions action = new Actions(driverDD);
		action.clickAndHold(sourc).moveToElement(target).release().perform();
		
		// OR
		
		WebElement sourc2 = driverDD.findElement(By.id("box5"));
		WebElement target2 = driverDD.findElement(By.id("box105"));
	
		action.dragAndDrop(sourc2, target2).perform();
		
		Thread.sleep(2000);
		driverDD.quit();
		
	}

}
