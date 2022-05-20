package com.selenium.dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelectionDropdown {

	public static void main(String[] args) throws Exception {
		WebDriverManager.edgedriver().setup();
		WebDriver driverMSD = new EdgeDriver();
		driverMSD.get("https://trytestingthis.netlify.app/");
		Thread.sleep(3000);
		driverMSD.manage().window().maximize();
		Thread.sleep(4000);
		WebElement elemMSD = driverMSD.findElement(By.id("owc"));
		Select selectMSD = new Select(elemMSD);
		List<WebElement> alloptions = selectMSD.getOptions();
		for(WebElement allopts : alloptions)
		{
			System.out.println(allopts.getText());
		}
		selectMSD.selectByIndex(3);               //For Option 3
		Thread.sleep(3000);
		selectMSD.selectByValue("option 1");      //For Option 1
		Thread.sleep(3000);
		selectMSD.selectByVisibleText("Option 2");   //For Option 2
		Thread.sleep(5000);
		selectMSD.deselectByIndex(2);                 //For Deselect Option 2
		Thread.sleep(4000);
		System.out.println("*************************************************");
		List<WebElement> selectedOptions = selectMSD.getAllSelectedOptions();
		for(WebElement selcOp : selectedOptions)
		{
			System.out.println(selcOp.getText());
		}
		driverMSD.quit();
	}

}
