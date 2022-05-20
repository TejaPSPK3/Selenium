package com.selenium.alertsorpopups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driverA = new ChromeDriver();
		driverA.manage().window().maximize();
		driverA.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		Thread.sleep(2000);
		//Alert Box
		System.out.println("*****************ALERT BOX****************");
		System.out.println(driverA.findElement(By.id("output")).getText());    //O/P before clicking
		driverA.findElement(By.id("alertBox")).click();
		System.out.println(driverA.switchTo().alert().getText());
		Thread.sleep(3000);
		driverA.switchTo().alert().accept();
		System.out.println(driverA.findElement(By.id("output")).getText());  //O/P after clicking
		System.out.println("******************************************");
		
		//Confirm Box
		System.out.println("***************CONFIRM BOX****************");
		driverA.findElement(By.id("confirmBox")).click();
		System.out.println(driverA.switchTo().alert().getText());
		Thread.sleep(3000);
		driverA.switchTo().alert().accept();
		System.out.println(driverA.findElement(By.id("output")).getText());  //O/P after clicking
		driverA.findElement(By.id("confirmBox")).click();
		Thread.sleep(3000);
		System.out.println(driverA.switchTo().alert().getText());
		driverA.switchTo().alert().dismiss();
		System.out.println(driverA.findElement(By.id("output")).getText());
		System.out.println("******************************************");
		
		//Prompt Box
		System.out.println("****************PROMPT BOX****************");
		driverA.findElement(By.id("promptBox")).click();
		System.out.println(driverA.switchTo().alert().getText());
		Thread.sleep(3000);
		driverA.switchTo().alert().sendKeys("Teja controls");
		Thread.sleep(3000);
		driverA.switchTo().alert().accept();
		System.out.println(driverA.findElement(By.id("output")).getText());  
		System.out.println("******************************************");
		
		Thread.sleep(2000);
		driverA.quit();
	}

}
