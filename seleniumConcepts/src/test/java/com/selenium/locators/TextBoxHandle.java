package com.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBoxHandle {

	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		WebDriver driverT = new EdgeDriver();
		driverT.navigate().to("https://github.com/login");
		//Username box handle
		WebElement elemText = driverT.findElement(By.id("login_field"));
		if(elemText.isDisplayed())
		{
			if(elemText.isEnabled())
			{
				elemText.sendKeys("Tejas ");
				Thread.sleep(3000);
				String strT = elemText.getAttribute("value");
				System.out.println(strT);
				elemText.sendKeys("Kambham");
				Thread.sleep(3000);
				String str2T = elemText.getAttribute("value");
				System.out.println(str2T);
				elemText.clear();
			}
			else
				System.out.println("Username Text box is not enabled");
		}
		else
			System.out.println("Username Text box is not displayed");
		
		//Password TextBox handle
		WebElement elemText2 = driverT.findElement(By.id("password"));
		if(elemText2.isDisplayed())
		{
			if(elemText2.isEnabled())
			{
				elemText2.sendKeys("Tejas Kambham");
				Thread.sleep(3000);
				String strT2 = elemText2.getAttribute("value");
				System.out.println(strT2);
				elemText2.clear();
			}
			else
				System.out.println("Password Text box is not enabled");
		}
		else
			System.out.println("Password Text box is not displayed");
		
		Thread.sleep(3000);
		driverT.quit();

	}

}
