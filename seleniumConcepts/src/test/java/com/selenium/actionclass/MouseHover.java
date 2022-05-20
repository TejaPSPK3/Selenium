package com.selenium.actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover
{

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driverMH = new EdgeDriver();
		driverMH.manage().window().maximize();
		driverMH.get("https://opensource-demo.orangehrmlive.com/");
		driverMH.findElement(By.id("txtUsername")).sendKeys("Admin");
		driverMH.findElement(By.id("txtPassword")).sendKeys("admin123",Keys.ENTER);
		Actions action = new Actions(driverMH);
		action.moveToElement(driverMH.findElement(By.id("menu_admin_viewAdminModule")))
		.moveToElement(driverMH.findElement(By.id("menu_admin_Qualifications")))
		.moveToElement(driverMH.findElement(By.id("menu_admin_viewLanguages")))
		.click()
		.perform();
		driverMH.findElement(By.id("checkAll")).click();
		driverMH.findElement(By.id("btnDel")).click();
		driverMH.findElement(By.id("btnAdd")).click();
		driverMH.findElement(By.name("language[name]")).sendKeys("English");
		driverMH.findElement(By.id("btnSave")).click();
		Thread.sleep(5000);
		driverMH.findElement(By.id("btnAdd")).click();
		driverMH.findElement(By.name("language[name]")).sendKeys("Telugu");
		driverMH.findElement(By.id("btnSave")).click();
		Thread.sleep(5000);
		driverMH.findElement(By.id("btnAdd")).click();
		driverMH.findElement(By.name("language[name]")).sendKeys("Hindi");
		driverMH.findElement(By.id("btnSave")).click();
		
		Thread.sleep(5000);
		driverMH.quit();
	}

}
