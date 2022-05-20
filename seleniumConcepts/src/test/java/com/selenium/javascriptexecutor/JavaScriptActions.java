package com.selenium.javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptActions {

	//Flashing
	public static void flashingAnElement(WebElement element,WebDriver driver) throws Exception
	{
		for(int i=0;i<10;i++)
		{
			change("#000000",element,driver);
			Thread.sleep(100);
			change("#00FF00",element,driver);
			Thread.sleep(100);
		}
	}
		public static void change(String str,WebElement ele,WebDriver dri)
		{
			JavascriptExecutor js = (JavascriptExecutor)dri;
			js.executeScript("arguments[0].style.backgroundColor='"+str+"'", ele);
		}
	
	//Drawing a border
	public static void drawBorder(WebElement elementb,WebDriver driver) throws Exception 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border = '2px solid red'",elementb);
		Thread.sleep(1000);
	}
	
	//Capture Tiltle of page
	public static void captureTitle(WebDriver driver) 
	{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String str = js.executeScript("return document.title").toString();
			System.out.println(str);
	}
	
	//Clicking an element
	public static void clicking(WebElement elementC,WebDriver driver) throws Exception 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", elementC);
		Thread.sleep(2000);
		driver.navigate().back();
	}	
	
	//Generate alert info
	public static void genAlert(String mesage,WebDriver driver) throws Exception 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+mesage+"')");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.navigate().back();
	}
	
	//Refreshing page
	public static void refreshPage(WebDriver driver) throws Exception 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
		Thread.sleep(2000);
	}
	
	//Scrolling page
	public static void scrolling(WebElement elementScroll,WebDriver driver) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",elementScroll);
	}
	
}
