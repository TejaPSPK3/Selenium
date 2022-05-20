package com.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBoxHandle2 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		WebDriver driverT2 = new EdgeDriver();
		driverT2.get("https://github.com/login");
		Thread.sleep(2000);
		WebElement uname = driverT2.findElement(By.name("login"));
		if(uname.isDisplayed())
		{
			if(uname.isEnabled())
			{
				uname.sendKeys("TejaPSPK3");
				Thread.sleep(2000);
			}
			else
				System.out.println("UserName Text Box is not enabled");
		}
		else
			System.out.println("UserName Text Box is not Displayed");
		//
		WebElement passw = driverT2.findElement(By.name("commit"));
		if(passw.isDisplayed())
		{
			driverT2.findElement(RelativeLocator.with(By.tagName("input")).above(passw)).sendKeys("Sruthi@124",Keys.ENTER);
			/*if(passw.isEnabled())
			{
				passw.sendKeys("Sruthi@124",Keys.ENTER);
				Thread.sleep(2000);
			}
			else
				System.out.println("Password Text Box is not enabled");
				*/
		}
		else
			System.out.println("Password Text Box is not Displayed");
		
		Thread.sleep(3000);
		driverT2.quit();
		
	}
	
}
